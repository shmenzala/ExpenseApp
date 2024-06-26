package sh.com.pe.ExpenseManagement.service;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import sh.com.pe.ExpenseManagement.configuration.Mapper;
import sh.com.pe.ExpenseManagement.dto.GastosDto;
import sh.com.pe.ExpenseManagement.dto.ResumenDto;
import sh.com.pe.ExpenseManagement.dto.Resumen_gastos_totalesDto;
import sh.com.pe.ExpenseManagement.model.Categorias_gasto;
import sh.com.pe.ExpenseManagement.model.Gastos;
import sh.com.pe.ExpenseManagement.repository.Categorias_gastoRepository;
import sh.com.pe.ExpenseManagement.repository.GastosRepository;

/**
 *
 * @author shmen
 */
@Service
public class GastosServiceImpl extends Mapper<Gastos, GastosDto> implements GastosService {

    private final GastosRepository gastosRepository;

    private final Categorias_gastoRepository categorias_gastoRepository;

    public GastosServiceImpl(GastosRepository gastosRepository, Categorias_gastoRepository categorias_gastoRepository, ModelMapper modelMapper) {
        super(modelMapper);
        this.gastosRepository = gastosRepository;
        this.categorias_gastoRepository = categorias_gastoRepository;
    }

    @Override
    public GastosDto create(GastosDto dto, Integer id_catgasto) {
        Categorias_gasto categorias_gasto = categorias_gastoRepository.findById(id_catgasto).orElseThrow();

        Gastos gasto = toEntity(dto, Gastos.class);

        gasto.setCategorias_gasto(categorias_gasto);
        gasto.setTotal(dto.getGasto() * dto.getCantidad());

        Gastos nuevoGasto = gastosRepository.save(gasto);

        return toDto(nuevoGasto, GastosDto.class);
    }

    @Override
    public List<GastosDto> findAll() {
        List<Gastos> gastos = gastosRepository.findAll();
        return gastos.stream().map(gasto -> toDto(gasto, GastosDto.class)).collect(Collectors.toList());
    }

    @Override
    public GastosDto findById(Integer id) {
        Gastos gasto = gastosRepository.findById(id).orElseThrow();
        return toDto(gasto, GastosDto.class);
    }

    @Override
    public GastosDto update(Integer id, GastosDto dto, Integer id_catgasto) {
        Gastos gasto = gastosRepository.findById(id).orElseThrow();

        Categorias_gasto categorias_gasto = categorias_gastoRepository.findById(id_catgasto).orElseThrow();

        gasto.setTipo_gasto(dto.getTipo_gasto());
        gasto.setCategorias_gasto(categorias_gasto);
        gasto.setGasto(dto.getGasto());
        gasto.setCantidad(dto.getCantidad());
        gasto.setTotal(dto.getGasto() * dto.getCantidad());

        Gastos actualizarGasto = gastosRepository.save(gasto);

        return toDto(actualizarGasto, GastosDto.class);
    }

    @Override
    public void delete(Integer id) {
        Gastos gasto = gastosRepository.findById(id).orElseThrow();
        gastosRepository.delete(gasto);
    }

    @Override
    public GastosDto create(GastosDto dto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public GastosDto update(Integer id, GastosDto dto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ResumenDto showSummary() {
        List<Resumen_gastos_totalesDto> mayoresDtos = gastosRepository.obtenerResumenGastosTotalesMaximos();
        List<Resumen_gastos_totalesDto> menoresDtos = gastosRepository.obtenerResumenGastosTotalesMinimos();

        ResumenDto resumenDto = new ResumenDto();

        resumenDto.setGastos_totales_maximos(mayoresDtos);
        resumenDto.setGastos_totales_minimos(menoresDtos);

        return resumenDto;
    }

}
