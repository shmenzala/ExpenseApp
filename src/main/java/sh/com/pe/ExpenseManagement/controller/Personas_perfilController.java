package sh.com.pe.ExpenseManagement.controller;

import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sh.com.pe.ExpenseManagement.dto.Personas_perfilDto;
import sh.com.pe.ExpenseManagement.dto.Personas_perfilDtoRequest;
import sh.com.pe.ExpenseManagement.pageable.PageableDataDto;
import sh.com.pe.ExpenseManagement.pageable.PageableValues;
import sh.com.pe.ExpenseManagement.service.Personas_perfilService;

/**
 *
 * @author shmen
 */
@RestController
@RequestMapping("/api/v1/pp")
@CrossOrigin(origins = "http://localhost:4200")
@PreAuthorize("hasRole('ADMIN')")
public class Personas_perfilController {

    private final Personas_perfilService personas_perfilService;

    public Personas_perfilController(Personas_perfilService personas_perfilService) {
        this.personas_perfilService = personas_perfilService;
    }

    @PostMapping
    public ResponseEntity<Personas_perfilDto> crearPersona_perfil(
            @Valid @RequestBody Personas_perfilDtoRequest dto) {
        return new ResponseEntity<>(personas_perfilService.create(dto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<PageableDataDto> listarPersonas_perfilesPaginados(
            @RequestParam(value = "pageNo", defaultValue = PageableValues.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = PageableValues.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = PageableValues.DEFAULT_ORDER_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = PageableValues.DEFAULT_ORDER_DIRECTION, required = false) String sortDir) {
        return new ResponseEntity<>(personas_perfilService.findAllPagination(pageNo, pageSize, sortBy, sortDir), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Personas_perfilDto>> listarPersonas_perfiles() {
        return new ResponseEntity<>(personas_perfilService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Personas_perfilDto> buscarPersona_perfilPorId(
            @PathVariable(value = "id") Integer id) {
        return new ResponseEntity<>(personas_perfilService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @PreAuthorize("(hasRole('USER') and #id == principal.id) or hasRole('ADMIN')")
    public ResponseEntity<Personas_perfilDto> actualizarPersona_perfil(
            @PathVariable(value = "id") Integer id,
            @Valid @RequestBody Personas_perfilDtoRequest dto) {
        return new ResponseEntity<>(personas_perfilService.update(id, dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPersona_perfil(
            @PathVariable(value = "id") Integer id) {
        personas_perfilService.delete(id);
        return new ResponseEntity<>("Eliminación exitosa de la categoria_gasto", HttpStatus.OK);
    }

}
