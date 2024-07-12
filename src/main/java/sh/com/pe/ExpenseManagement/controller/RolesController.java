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
import sh.com.pe.ExpenseManagement.dto.RolesDto;
import sh.com.pe.ExpenseManagement.dto.RolesDtoRequest;
import sh.com.pe.ExpenseManagement.pageable.PageableDataDto;
import sh.com.pe.ExpenseManagement.pageable.PageableValues;
import sh.com.pe.ExpenseManagement.service.RolesService;

/**
 *
 * @author shmen
 */
@RestController
@RequestMapping("/api/v1/roles")
public class RolesController {

    private final RolesService rolesService;

    public RolesController(RolesService rolesService) {
        this.rolesService = rolesService;
    }

    @PostMapping()
    public ResponseEntity<RolesDto> crearRol(
            @Valid @RequestBody RolesDtoRequest dto) {
        return new ResponseEntity<>(rolesService.create(dto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<PageableDataDto> listarRolesPaginados(
            @RequestParam(value = "pageNumber", defaultValue = PageableValues.DEFAULT_PAGE_NUMBER, required = false) int pageNumber,
            @RequestParam(value = "pageSize", defaultValue = PageableValues.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = PageableValues.DEFAULT_ORDER_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = PageableValues.DEFAULT_ORDER_DIRECTION, required = false) String sortDir) {
        return new ResponseEntity<>(rolesService.findAllPagination(pageNumber, pageSize, sortBy, sortDir), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<RolesDto>> listarRoles() {
        return new ResponseEntity<>(rolesService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolesDto> buscarRolPorId(
            @PathVariable(value = "id") Integer id) {
        return new ResponseEntity<>(rolesService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RolesDto> actualizarRol(
            @PathVariable(value = "id") Integer id,
            @Valid @RequestBody RolesDtoRequest dto) {
        return new ResponseEntity<>(rolesService.update(id, dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarRol(
            @PathVariable(value = "id") Integer id) {
        rolesService.delete(id);
        return new ResponseEntity<>("Eliminación exitosa del rol", HttpStatus.OK);
    }

}
