package sh.com.pe.ExpenseManagement.service;

import sh.com.pe.ExpenseManagement.configuration.GenericService;
import sh.com.pe.ExpenseManagement.dto.GastosDto;
import sh.com.pe.ExpenseManagement.dto.GastosDtoRequest;
import sh.com.pe.ExpenseManagement.dto.ResumenDto;
import sh.com.pe.ExpenseManagement.pageable.PageableDataDto;

/**
 *
 * @author shmen
 */
public interface GastosService extends GenericService<GastosDto, GastosDtoRequest> {

    public ResumenDto showSummary();

    public GastosDto create(GastosDtoRequest dto, Integer id_catgasto, Integer id_usuario);

    public GastosDto update(Integer id, GastosDtoRequest dto, Integer id_catgasto, Integer id_usuario);
    
    public void delete(Integer id, Integer id_usuario);
    
    public PageableDataDto<GastosDto> findAllPagination(Integer id_usuario, int pageNumber, int pageSize, String sortBy, String sortDir);

}
