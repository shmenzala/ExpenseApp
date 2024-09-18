package sh.com.pe.ExpenseManagement.service;

import java.util.HashSet;
import java.util.Set;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sh.com.pe.ExpenseManagement.dto.JwtAuthenticationDto;
import sh.com.pe.ExpenseManagement.dto.LoginDtoRequest;
import sh.com.pe.ExpenseManagement.dto.RegisterDtoRequest;
import sh.com.pe.ExpenseManagement.exceptions.ResourceAlreadyExistsException;
import sh.com.pe.ExpenseManagement.exceptions.ResourceNotFoundException;
import sh.com.pe.ExpenseManagement.model.Personas_perfil;
import sh.com.pe.ExpenseManagement.model.Roles;
import sh.com.pe.ExpenseManagement.model.Usuarios;
import sh.com.pe.ExpenseManagement.repository.Personas_perfilRepository;
import sh.com.pe.ExpenseManagement.repository.RolesRepository;
import sh.com.pe.ExpenseManagement.repository.UsuariosRepository;
import sh.com.pe.ExpenseManagement.security.JwtTokenProvider;

/**
 *
 * @author shmen
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UsuariosRepository usuariosRepository;

    private final PasswordEncoder passwordEncoder;

    private final RolesRepository rolesRepository;

    private final Personas_perfilRepository personas_perfilRepository;

    private final JwtTokenProvider jwtTokenProvider;

    private final AuthenticationManager authenticationManager;

    public AuthenticationServiceImpl(UsuariosRepository usuariosRepository, PasswordEncoder passwordEncoder, RolesRepository rolesRepository, Personas_perfilRepository personas_perfilRepository, JwtTokenProvider jwtTokenProvider, AuthenticationManager authenticationManager) {
        this.usuariosRepository = usuariosRepository;
        this.passwordEncoder = passwordEncoder;
        this.rolesRepository = rolesRepository;
        this.personas_perfilRepository = personas_perfilRepository;
        this.jwtTokenProvider = jwtTokenProvider;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public JwtAuthenticationDto register(RegisterDtoRequest dto) {
        if (usuariosRepository.existsByEmail(dto.getEmail())) {
            throw new ResourceAlreadyExistsException("Usuario", "email", dto.getEmail());
        }

        Usuarios usuario = new Usuarios();

        String[] emailPart = dto.getEmail().split("@");
        String emailName = emailPart[0].replaceAll("[^a-zA-Z]", "");

        usuario.setUsername(emailName);
        usuario.setEmail(dto.getEmail());
        usuario.setPassword(passwordEncoder.encode(dto.getPassword()));

        Set<Roles> rolInicial = new HashSet<>();

        Roles rol = rolesRepository.findByNombre("ROLE_USER")
                .orElseThrow(() -> new ResourceNotFoundException("Roles", "nombre", "ROLE_USER"));
        rolInicial.add(rol);

        usuario.setRoles(rolInicial);

        Personas_perfil personas_perfil = new Personas_perfil();
        personas_perfil.setNombres(emailName);
        Personas_perfil nuevaPersona_perfil = personas_perfilRepository.save(personas_perfil);

        usuario.setPersonas_perfil(nuevaPersona_perfil);

        Usuarios nuevoUsuario = usuariosRepository.save(usuario);

        String token = jwtTokenProvider.generateToken(nuevoUsuario);
        
        return new JwtAuthenticationDto(token);
    }

    @Override
    public JwtAuthenticationDto authenticate(LoginDtoRequest dto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.getUsername(),
                        dto.getPassword()
                )
        );

        Usuarios usuario = usuariosRepository.findByUsernameOrEmail(dto.getUsername(), dto.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        String token = jwtTokenProvider.generateToken(usuario);
        
        return new JwtAuthenticationDto(token);
    }

}
