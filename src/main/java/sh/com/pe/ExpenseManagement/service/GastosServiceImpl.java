package sh.com.pe.ExpenseManagement.service;

import java.util.List;
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<GastosDto> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public GastosDto findById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public GastosDto update(String id, GastosDto dto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public GastosDto delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
