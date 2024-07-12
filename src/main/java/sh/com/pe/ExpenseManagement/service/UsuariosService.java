package sh.com.pe.ExpenseManagement.service;

import java.util.List;
import sh.com.pe.ExpenseManagement.configuration.GenericService;
import sh.com.pe.ExpenseManagement.dto.UsuariosDto;
import sh.com.pe.ExpenseManagement.dto.UsuariosDtoRequest;

/**
 *
 * @author shmen
 */
public interface UsuariosService extends GenericService<UsuariosDto, UsuariosDtoRequest>{
    
    public UsuariosDto create(UsuariosDtoRequest dto, List<String> rolesNombres);
    
}
