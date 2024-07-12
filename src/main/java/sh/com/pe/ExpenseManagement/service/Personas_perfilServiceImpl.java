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
import sh.com.pe.ExpenseManagement.dto.Personas_perfilDto;
import sh.com.pe.ExpenseManagement.dto.Personas_perfilDtoRequest;
import sh.com.pe.ExpenseManagement.exceptions.ResourceNotFoundException;
import sh.com.pe.ExpenseManagement.model.Personas_perfil;
import sh.com.pe.ExpenseManagement.pageable.PageableDataDto;
import sh.com.pe.ExpenseManagement.repository.Personas_perfilRepository;

/**
 *
 * @author shmen
 */
@Service
public class Personas_perfilServiceImpl extends Mapper<Personas_perfil, Personas_perfilDto, Personas_perfilDtoRequest> implements Personas_perfilService {

    private final Personas_perfilRepository personas_perfilRepository;

    public Personas_perfilServiceImpl(Personas_perfilRepository personas_perfilRepository, ModelMapper modelMapper) {
        super(modelMapper);
        this.personas_perfilRepository = personas_perfilRepository;
    }

    @Override
    public Personas_perfilDto create(Personas_perfilDtoRequest dto) {
        Personas_perfil persona_perfil = toEntity(dto, Personas_perfil.class);

        Personas_perfil nuevaPersona_perfil = personas_perfilRepository.save(persona_perfil);

        return toDto(nuevaPersona_perfil, Personas_perfilDto.class);
    }

    @Override
    public List<Personas_perfilDto> findAll() {
        List<Personas_perfil> personas_perfil = personas_perfilRepository.findAll();
        return personas_perfil.stream().map(persona_perfil -> toDto(persona_perfil, Personas_perfilDto.class)).collect(Collectors.toList());
    }

    @Override
    public Personas_perfilDto findById(Integer id) {
        Personas_perfil persona_perfil = personas_perfilRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Personas_perfil", "id", id.toString()));
        return toDto(persona_perfil, Personas_perfilDto.class);
    }

    @Override
    public Personas_perfilDto update(Integer id, Personas_perfilDtoRequest dto) {
        Personas_perfil persona_perfil = personas_perfilRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Personas_perfil", "id", id.toString()));

        //1ra FORMA
        //persona_perfil = toEntity(dto, Personas_perfil.class);
        //2DA FORMA
        persona_perfil.setNombres(dto.getNombres());
        persona_perfil.setApellidos(dto.getApellidos());
        persona_perfil.setGenero(dto.getGenero());
        persona_perfil.setFecha_nacimiento(dto.getFecha_nacimiento());
        persona_perfil.setFotografia(dto.getFotografia());

        Personas_perfil actualizarPersona_perfil = personas_perfilRepository.save(persona_perfil);

        return toDto(actualizarPersona_perfil, Personas_perfilDto.class);
    }

    @Override
    public void delete(Integer id) {
        Personas_perfil persona_perfil = personas_perfilRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Personas_perfil", "id", id.toString()));
        personas_perfilRepository.delete(persona_perfil);
    }

    @Override
    public PageableDataDto<Personas_perfilDto> findAllPagination(int pageNumber, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        Page<Personas_perfil> personas_perfilPage = personas_perfilRepository.findAll(pageable);

        List<Personas_perfilDto> content = personas_perfilPage.getContent().stream().map(persona_perfil -> toDto(persona_perfil, Personas_perfilDto.class)).collect(Collectors.toList());

        PageableDataDto pageableDataDto = new PageableDataDto();

        pageableDataDto.setContent(content);
        pageableDataDto.setPageNumber(personas_perfilPage.getNumber());
        pageableDataDto.setPageSize(personas_perfilPage.getSize());
        pageableDataDto.setTotalElements(personas_perfilPage.getTotalElements());
        pageableDataDto.setTotalPages(personas_perfilPage.getTotalPages());
        pageableDataDto.setFirst(personas_perfilPage.isFirst());
        pageableDataDto.setLast(personas_perfilPage.isLast());

        return pageableDataDto;
    }

}
