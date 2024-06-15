package sh.com.pe.ExpenseManagement.service;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import sh.com.pe.ExpenseManagement.configuration.Mapper;
import sh.com.pe.ExpenseManagement.dto.Categorias_gastoDto;
import sh.com.pe.ExpenseManagement.model.Categorias_gasto;
import sh.com.pe.ExpenseManagement.repository.Categorias_gastoRepository;

/**
 *
 * @author shmen
 */
@Service
public class Categorias_gastoServiceImpl extends Mapper<Categorias_gasto, Categorias_gastoDto> implements Categorias_gastoService {

    private final Categorias_gastoRepository Categorias_gastoRepository;

    public Categorias_gastoServiceImpl(Categorias_gastoRepository Categorias_gastoRepository, ModelMapper modelMapper) {
        super(modelMapper);
        this.Categorias_gastoRepository = Categorias_gastoRepository;
    }

    @Override
    public Categorias_gastoDto create(Categorias_gastoDto dto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Categorias_gastoDto> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Categorias_gastoDto findById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Categorias_gastoDto update(String id, Categorias_gastoDto dto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Categorias_gastoDto delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
