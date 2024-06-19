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
import sh.com.pe.ExpenseManagement.dto.GastosDto;
import sh.com.pe.ExpenseManagement.service.GastosService;

/**
 *
 * @author shmen
 */
@RestController
@RequestMapping("/api/v1/gastos")
public class GastosController {

    private final GastosService gastosService;

    public GastosController(GastosService gastosService) {
        this.gastosService = gastosService;
    }

    @PostMapping("/{id_catgasto}")
    public ResponseEntity<GastosDto> crearGasto(
            @PathVariable(value = "id_catgasto") Integer id_catgasto,
            @RequestBody GastosDto dto) {
        return new ResponseEntity<>(gastosService.create(dto, id_catgasto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<GastosDto>> listarGastos() {
        return new ResponseEntity<>(gastosService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GastosDto> buscarGastoPorId(
            @PathVariable(value = "id") Integer id) {
        return new ResponseEntity<>(gastosService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}/{id_catgasto}")
    public ResponseEntity<GastosDto> actualizarGasto(
            @PathVariable(value = "id") Integer id,
            @PathVariable(value = "id_catgasto") Integer id_catgasto,
            @RequestBody GastosDto dto) {
        return new ResponseEntity<>(gastosService.update(id, dto, id_catgasto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarGasto(
            @PathVariable(value = "id") Integer id) {
        gastosService.delete(id);
        return new ResponseEntity<>("Eliminación exitosa del gasto", HttpStatus.OK);
    }

}
