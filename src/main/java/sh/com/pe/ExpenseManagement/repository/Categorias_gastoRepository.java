package sh.com.pe.ExpenseManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sh.com.pe.ExpenseManagement.model.Categorias_gasto;

/**
 *
 * @author shmen
 */
@Repository
public interface Categorias_gastoRepository extends JpaRepository<Categorias_gasto, Integer>{
    
}
