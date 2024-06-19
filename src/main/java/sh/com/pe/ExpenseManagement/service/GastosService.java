package sh.com.pe.ExpenseManagement.service;

import sh.com.pe.ExpenseManagement.configuration.GenericService;
import sh.com.pe.ExpenseManagement.dto.GastosDto;

/**
 *
 * @author shmen
 */
public interface GastosService extends GenericService<GastosDto>{
    
     public GastosDto create(GastosDto dto, Integer id_catgasto);
     
     public GastosDto update(Integer id, GastosDto dto, Integer id_catgasto);
    
}
