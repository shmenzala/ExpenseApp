package sh.com.pe.ExpenseManagement.configuration;

import java.util.List;

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
    
}
