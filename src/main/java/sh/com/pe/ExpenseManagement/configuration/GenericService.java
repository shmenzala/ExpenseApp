package sh.com.pe.ExpenseManagement.configuration;

import java.util.List;
import sh.com.pe.ExpenseManagement.pageable.PageableDataDto;

/**
 *
 * @author shmen
 * @param <T> response DTO class
 * @param <T2> request DTO class
 */
public interface GenericService<T, T2> {

    public T create(T2 dto);

    public List<T> findAll();

    public T findById(Integer id);

    public T update(Integer id, T2 dto);

    public void delete(Integer id);

    public PageableDataDto<T> findAllPagination(int pageNumber, int pageSize, String sortBy, String sortDir);

}
