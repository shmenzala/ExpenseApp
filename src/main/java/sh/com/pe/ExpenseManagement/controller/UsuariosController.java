package sh.com.pe.ExpenseManagement.controller;

import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sh.com.pe.ExpenseManagement.dto.UsuariosDto;
import sh.com.pe.ExpenseManagement.dto.UsuariosDtoRequest;
import sh.com.pe.ExpenseManagement.pageable.PageableDataDto;
import sh.com.pe.ExpenseManagement.pageable.PageableValues;
import sh.com.pe.ExpenseManagement.service.UsuariosService;

/**
 *
 * @author shmen
 */
@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuariosController {
    
    private final UsuariosService usuariosService;

    public UsuariosController(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    @PostMapping
    public ResponseEntity<UsuariosDto> crearUsuario(
            @Valid @RequestBody UsuariosDtoRequest dto,
            @RequestParam List<String> rolesNombres) {
        return new ResponseEntity<>(usuariosService.create(dto, rolesNombres), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<PageableDataDto> listarUsuariosPaginados(
            @RequestParam(value = "pageNumber", defaultValue = PageableValues.DEFAULT_PAGE_NUMBER, required = false) int pageNumber,
            @RequestParam(value = "pageSize", defaultValue = PageableValues.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = PageableValues.DEFAULT_ORDER_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = PageableValues.DEFAULT_ORDER_DIRECTION, required = false) String sortDir) {
        return new ResponseEntity<>(usuariosService.findAllPagination(pageNumber, pageSize, sortBy, sortDir), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UsuariosDto>> listarUsuarios() {
        return new ResponseEntity<>(usuariosService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuariosDto> buscarUsuarioPorId(
            @PathVariable(value = "id") Integer id) {
        return new ResponseEntity<>(usuariosService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuariosDto> actualizarUsuario(
            @PathVariable(value = "id") Integer id,
            @Valid @RequestBody UsuariosDtoRequest dto) {
        return new ResponseEntity<>(usuariosService.update(id, dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarUsuario(
            @PathVariable(value = "id") Integer id) {
        usuariosService.delete(id);
        return new ResponseEntity<>("Eliminación exitosa del usuario", HttpStatus.OK);
    }
    
}
