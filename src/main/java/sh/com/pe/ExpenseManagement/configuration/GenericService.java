package sh.com.pe.ExpenseManagement.configuration;

import java.util.List;
import sh.com.pe.ExpenseManagement.pageable.PageableDataDto;

/**
 *
 * @author shmen
 * @param <T> clases DTO
 */
public interface GenericService<T> {

    public T create(T dto);

    public List<T> findAll();

    public T findById(Integer id);

    public T update(Integer id, T dto);

    public void delete(Integer id);

    public PageableDataDto findAllPagination(int pageNumber, int pageSize, String sortBy, String sortDir);

}
