package sh.com.pe.ExpenseManagement.controller;

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
import org.springframework.web.bind.annotation.RestController;
import sh.com.pe.ExpenseManagement.dto.Categorias_gastoDto;
import sh.com.pe.ExpenseManagement.service.Categorias_gastoService;

/**
 *
 * @author shmen
 */
@RestController
@RequestMapping("/api/v1/categorias_gasto")
public class Categorias_gastoController {

    private final Categorias_gastoService categorias_gastoService;

    public Categorias_gastoController(Categorias_gastoService categorias_gastoService) {
        this.categorias_gastoService = categorias_gastoService;
    }

    @PostMapping
    public ResponseEntity<Categorias_gastoDto> crearCategoria_gasto(
            @RequestBody Categorias_gastoDto dto) {
        return new ResponseEntity<>(categorias_gastoService.create(dto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Categorias_gastoDto>> listarCategorias_gasto() {
        return new ResponseEntity<>(categorias_gastoService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categorias_gastoDto> buscarCategoria_gastoPorId(
            @PathVariable(value = "id") Integer id) {
        return new ResponseEntity<>(categorias_gastoService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categorias_gastoDto> actualizarCategoria_gasto(
            @PathVariable(value = "id") Integer id,
            @RequestBody Categorias_gastoDto dto) {
        return new ResponseEntity<>(categorias_gastoService.update(id, dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarCategoria_gasto(
            @PathVariable(value = "id") Integer id) {
        categorias_gastoService.delete(id);
        return new ResponseEntity<>("Eliminación exitosa de la categoria_gasto", HttpStatus.OK);
    }

}
