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
    
    public T findById(String id);
    
    public T update(String id, T dto);
    
    public T delete(String id);
    
}
