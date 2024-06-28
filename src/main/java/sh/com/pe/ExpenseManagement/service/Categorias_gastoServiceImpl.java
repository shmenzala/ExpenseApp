package sh.com.pe.ExpenseManagement.service;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sh.com.pe.ExpenseManagement.configuration.Mapper;
import sh.com.pe.ExpenseManagement.dto.Categorias_gastoDto;
import sh.com.pe.ExpenseManagement.dto.Categorias_gastoDtoRequest;
import sh.com.pe.ExpenseManagement.exceptions.ResourceNotFoundException;
import sh.com.pe.ExpenseManagement.model.Categorias_gasto;
import sh.com.pe.ExpenseManagement.pageable.PageableDataDto;
import sh.com.pe.ExpenseManagement.repository.Categorias_gastoRepository;

/**
 *
 * @author shmen
 */
@Service
public class Categorias_gastoServiceImpl extends Mapper<Categorias_gasto, Categorias_gastoDto, Categorias_gastoDtoRequest> implements Categorias_gastoService {

    private final Categorias_gastoRepository categorias_gastoRepository;

    public Categorias_gastoServiceImpl(Categorias_gastoRepository categorias_gastoRepository, ModelMapper modelMapper) {
        super(modelMapper);
        this.categorias_gastoRepository = categorias_gastoRepository;
    }

    @Override
    public Categorias_gastoDto create(Categorias_gastoDtoRequest dto) {
        Categorias_gasto categoria_gasto = toEntity(dto, Categorias_gasto.class);

        Categorias_gasto nuevaCategoria_gasto = categorias_gastoRepository.save(categoria_gasto);

        return toDto(nuevaCategoria_gasto, Categorias_gastoDto.class);
    }

    @Override
    public List<Categorias_gastoDto> findAll() {
        List<Categorias_gasto> categorias_gasto = categorias_gastoRepository.findAll();
        return categorias_gasto.stream().map(categoria_gasto -> toDto(categoria_gasto, Categorias_gastoDto.class)).collect(Collectors.toList());
    }

    @Override
    public Categorias_gastoDto findById(Integer id) {
        Categorias_gasto categorias_gasto = categorias_gastoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categorias_gasto", "id", id.toString()));
        return toDto(categorias_gasto, Categorias_gastoDto.class);
    }

    @Override
    public Categorias_gastoDto update(Integer id, Categorias_gastoDtoRequest dto) {
        Categorias_gasto categorias_gasto = categorias_gastoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categorias_gasto", "id", id.toString()));

        categorias_gasto.setNombre(dto.getNombre());

        Categorias_gasto actualizarCategoria_gasto = categorias_gastoRepository.save(categorias_gasto);

        return toDto(actualizarCategoria_gasto, Categorias_gastoDto.class);
    }

    @Override
    public void delete(Integer id) {
        Categorias_gasto categorias_gasto = categorias_gastoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categorias_gasto", "id", id.toString()));
        categorias_gastoRepository.delete(categorias_gasto);
    }

    @Override
    public PageableDataDto<Categorias_gastoDto> findAllPagination(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Categorias_gasto> categorias_gastosPage = categorias_gastoRepository.findAll(pageable);

        List<Categorias_gastoDto> content = categorias_gastosPage.getContent().stream().map(categoria_gasto -> toDto(categoria_gasto, Categorias_gastoDto.class)).collect(Collectors.toList());

        PageableDataDto pageableDataDto = new PageableDataDto();

        pageableDataDto.setContent(content);
        pageableDataDto.setPageNumber(categorias_gastosPage.getNumber());
        pageableDataDto.setPageSize(categorias_gastosPage.getSize());
        pageableDataDto.setTotalElements(categorias_gastosPage.getTotalElements());
        pageableDataDto.setTotalPages(categorias_gastosPage.getTotalPages());
        pageableDataDto.setLast(categorias_gastosPage.isLast());

        return pageableDataDto;

    }

}
