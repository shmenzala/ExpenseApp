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
import sh.com.pe.ExpenseManagement.dto.RolesDto;
import sh.com.pe.ExpenseManagement.dto.RolesDtoRequest;
import sh.com.pe.ExpenseManagement.exceptions.ResourceNotFoundException;
import sh.com.pe.ExpenseManagement.model.Roles;
import sh.com.pe.ExpenseManagement.pageable.PageableDataDto;
import sh.com.pe.ExpenseManagement.repository.RolesRepository;

/**
 *
 * @author shmen
 */
@Service
public class RolesServiceImpl extends Mapper<Roles, RolesDto, RolesDtoRequest> implements RolesService {

    private final RolesRepository rolesRepository;

    public RolesServiceImpl(RolesRepository rolesRepository, ModelMapper modelMapper) {
        super(modelMapper);
        this.rolesRepository = rolesRepository;
    }

    @Override
    public RolesDto create(RolesDtoRequest dto) {
        Roles rol = toEntity(dto, Roles.class);

        Roles nuevoRol = rolesRepository.save(rol);

        return toDto(nuevoRol, RolesDto.class);
    }

    @Override
    public List<RolesDto> findAll() {
        List<Roles> roles = rolesRepository.findAll();
        return roles.stream().map(rol -> toDto(rol, RolesDto.class)).collect(Collectors.toList());
    }

    @Override
    public RolesDto findById(Integer id) {
        Roles rol = rolesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Roles", "id", id.toString()));
        return toDto(rol, RolesDto.class);
    }

    @Override
    public RolesDto update(Integer id, RolesDtoRequest dto) {
        Roles rol = rolesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Roles", "id", id.toString()));

        rol.setNombre(dto.getNombre());

        Roles actualizarRol = rolesRepository.save(rol);

        return toDto(actualizarRol, RolesDto.class);
    }

    @Override
    public void delete(Integer id) {
        Roles rol = rolesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Roles", "id", id.toString()));
        rolesRepository.delete(rol);
    }

    @Override
    public PageableDataDto<RolesDto> findAllPagination(int pageNumber, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        Page<Roles> rolesPage = rolesRepository.findAll(pageable);

        List<RolesDto> content = rolesPage.getContent().stream().map(rol -> toDto(rol, RolesDto.class)).collect(Collectors.toList());

        PageableDataDto pageableDataDto = new PageableDataDto();

        pageableDataDto.setContent(content);
        pageableDataDto.setPageNumber(rolesPage.getNumber());
        pageableDataDto.setPageSize(rolesPage.getSize());
        pageableDataDto.setTotalElements(rolesPage.getTotalElements());
        pageableDataDto.setTotalPages(rolesPage.getTotalPages());
        pageableDataDto.setFirst(rolesPage.isFirst());
        pageableDataDto.setLast(rolesPage.isLast());

        return pageableDataDto;
    }

}
