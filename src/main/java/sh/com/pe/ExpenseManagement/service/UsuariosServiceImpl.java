package sh.com.pe.ExpenseManagement.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sh.com.pe.ExpenseManagement.configuration.Mapper;
import sh.com.pe.ExpenseManagement.dto.UsuariosDto;
import sh.com.pe.ExpenseManagement.dto.UsuariosDtoRequest;
import sh.com.pe.ExpenseManagement.exceptions.ResourceAlreadyExistsException;
import sh.com.pe.ExpenseManagement.exceptions.ResourceNotFoundException;
import sh.com.pe.ExpenseManagement.model.Personas_perfil;
import sh.com.pe.ExpenseManagement.model.Roles;
import sh.com.pe.ExpenseManagement.model.Usuarios;
import sh.com.pe.ExpenseManagement.pageable.PageableDataDto;
import sh.com.pe.ExpenseManagement.repository.Personas_perfilRepository;
import sh.com.pe.ExpenseManagement.repository.RolesRepository;
import sh.com.pe.ExpenseManagement.repository.UsuariosRepository;

/**
 *
 * @author shmen
 */
@Service
public class UsuariosServiceImpl extends Mapper<Usuarios, UsuariosDto, UsuariosDtoRequest> implements UsuariosService {

    private final UsuariosRepository usuariosRepository;

    private final PasswordEncoder passwordEncoder;

    private final RolesRepository rolesRepository;

    private final Personas_perfilRepository personas_perfilRepository;

    public UsuariosServiceImpl(UsuariosRepository usuariosRepository, PasswordEncoder passwordEncoder, RolesRepository rolesRepository, Personas_perfilRepository personas_perfilRepository, ModelMapper modelMapper) {
        super(modelMapper);
        this.usuariosRepository = usuariosRepository;
        this.passwordEncoder = passwordEncoder;
        this.rolesRepository = rolesRepository;
        this.personas_perfilRepository = personas_perfilRepository;
    }

    @Override
    public UsuariosDto create(UsuariosDtoRequest dto, List<String> rolesNombres) {
        if (usuariosRepository.existsByEmail(dto.getEmail())) {
            throw new ResourceAlreadyExistsException("Usuario", "email", dto.getEmail());
        }

        Usuarios usuario = toEntity(dto, Usuarios.class);

        Set<Roles> rolesIniciales = new HashSet<>();

        for (int i = 0; i < rolesNombres.size(); i++) {
            String rolNombre = rolesNombres.get(i).toUpperCase();
            Roles roles = rolesRepository.findByNombre(rolNombre)
                    .orElseThrow(() -> new ResourceNotFoundException("Roles", "nombre", rolNombre));
            rolesIniciales.add(roles);
        }

        usuario.setPassword(passwordEncoder.encode(dto.getPassword()));
        usuario.setRoles(rolesIniciales);

        Personas_perfil personas_perfil = new Personas_perfil();
        personas_perfil.setNombres(dto.getUsername());
        Personas_perfil nuevaPersona_perfil = personas_perfilRepository.save(personas_perfil);

        usuario.setPersonas_perfil(nuevaPersona_perfil);

        Usuarios nuevoUsuario = usuariosRepository.save(usuario);

        return toDto(nuevoUsuario, UsuariosDto.class);
    }

    @Override
    public List<UsuariosDto> findAll() {
        List<Usuarios> usuarios = usuariosRepository.findAll();
        return usuarios.stream().map(usuario -> toDto(usuario, UsuariosDto.class)).collect(Collectors.toList());
    }

    @Override
    public UsuariosDto findById(Integer id) {
        Usuarios usuario = usuariosRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuarios", "id", id.toString()));
        return toDto(usuario, UsuariosDto.class);
    }

    @Override
    public UsuariosDto update(Integer id, UsuariosDtoRequest dto) {
        Usuarios usuario = usuariosRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuarios", "id", id.toString()));

        usuario.setUsername(dto.getUsername());
        usuario.setEmail(dto.getEmail());
        usuario.setPassword(passwordEncoder.encode(dto.getPassword()));

        Usuarios actualizarUsuario = usuariosRepository.save(usuario);

        return toDto(actualizarUsuario, UsuariosDto.class);
    }

    @Override
    public void delete(Integer id) {
        Usuarios usuario = usuariosRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuarios", "id", id.toString()));
        usuariosRepository.delete(usuario);
    }

    @Override
    public PageableDataDto<UsuariosDto> findAllPagination(int pageNumber, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        Page<Usuarios> usuariosPage = usuariosRepository.findAll(pageable);

        List<UsuariosDto> content = usuariosPage.getContent().stream().map(rol -> toDto(rol, UsuariosDto.class)).collect(Collectors.toList());

        PageableDataDto pageableDataDto = new PageableDataDto();

        pageableDataDto.setContent(content);
        pageableDataDto.setPageNumber(usuariosPage.getNumber());
        pageableDataDto.setPageSize(usuariosPage.getSize());
        pageableDataDto.setTotalElements(usuariosPage.getTotalElements());
        pageableDataDto.setTotalPages(usuariosPage.getTotalPages());
        pageableDataDto.setFirst(usuariosPage.isFirst());
        pageableDataDto.setLast(usuariosPage.isLast());

        return pageableDataDto;
    }

    @Override
    public UsuariosDto create(UsuariosDtoRequest dto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
