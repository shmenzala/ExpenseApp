package sh.com.pe.ExpenseManagement.service;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import sh.com.pe.ExpenseManagement.configuration.Mapper;
import sh.com.pe.ExpenseManagement.dto.GastosDto;
import sh.com.pe.ExpenseManagement.model.Gastos;
import sh.com.pe.ExpenseManagement.repository.GastosRepository;

/**
 *
 * @author shmen
 */
@Service
public class GastosServiceImpl extends Mapper<Gastos, GastosDto> implements GastosService {

    private final GastosRepository gastosRepository;

    public GastosServiceImpl(GastosRepository gastosRepository, ModelMapper modelMapper) {
        super(modelMapper);
        this.gastosRepository = gastosRepository;
    }

    @Override
    public GastosDto create(GastosDto dto) {
        Gastos gasto = toEntity(dto, Gastos.class);

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
    public GastosDto update(Integer id, GastosDto dto) {
        Gastos gasto = gastosRepository.findById(id).orElseThrow();

        Gastos actualizarGasto = gastosRepository.save(gasto);

        return toDto(actualizarGasto, GastosDto.class);
    }

    @Override
    public void delete(Integer id) {
        Gastos gasto = gastosRepository.findById(id).orElseThrow();
        gastosRepository.delete(gasto);
    }

}
