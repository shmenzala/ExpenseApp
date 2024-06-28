package sh.com.pe.ExpenseManagement.service;

import sh.com.pe.ExpenseManagement.configuration.GenericService;
import sh.com.pe.ExpenseManagement.dto.GastosDto;
import sh.com.pe.ExpenseManagement.dto.GastosDtoRequest;
import sh.com.pe.ExpenseManagement.dto.ResumenDto;

/**
 *
 * @author shmen
 */
public interface GastosService extends GenericService<GastosDto, GastosDtoRequest> {

    public ResumenDto showSummary();

    public GastosDto create(GastosDtoRequest dto, Integer id_catgasto);

    public GastosDto update(Integer id, GastosDtoRequest dto, Integer id_catgasto);

}
