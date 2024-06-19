package sh.com.pe.ExpenseManagement.service;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import sh.com.pe.ExpenseManagement.configuration.Mapper;
import sh.com.pe.ExpenseManagement.dto.Categorias_gastoDto;
import sh.com.pe.ExpenseManagement.model.Categorias_gasto;
import sh.com.pe.ExpenseManagement.repository.Categorias_gastoRepository;

/**
 *
 * @author shmen
 */
@Service
public class Categorias_gastoServiceImpl extends Mapper<Categorias_gasto, Categorias_gastoDto> implements Categorias_gastoService {

    private final Categorias_gastoRepository categorias_gastoRepository;

    public Categorias_gastoServiceImpl(Categorias_gastoRepository categorias_gastoRepository, ModelMapper modelMapper) {
        super(modelMapper);
        this.categorias_gastoRepository = categorias_gastoRepository;
    }

    @Override
    public Categorias_gastoDto create(Categorias_gastoDto dto) {
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
        Categorias_gasto categorias_gasto = categorias_gastoRepository.findById(id).orElseThrow();
        return toDto(categorias_gasto, Categorias_gastoDto.class);
    }

    @Override
    public Categorias_gastoDto update(Integer id, Categorias_gastoDto dto) {
        Categorias_gasto categorias_gasto = categorias_gastoRepository.findById(id).orElseThrow();
        
        categorias_gasto.setNombre(dto.getNombre());
        
        Categorias_gasto actualizarCategoria_gasto = categorias_gastoRepository.save(categorias_gasto);

        return toDto(actualizarCategoria_gasto, Categorias_gastoDto.class);
    }

    @Override
    public void delete(Integer id) {
        Categorias_gasto categorias_gasto = categorias_gastoRepository.findById(id).orElseThrow();
        categorias_gastoRepository.delete(categorias_gasto);
    }

}
