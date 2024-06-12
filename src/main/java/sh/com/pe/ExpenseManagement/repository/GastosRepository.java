package sh.com.pe.ExpenseManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sh.com.pe.ExpenseManagement.model.Gastos;

/**
 *
 * @author shmen
 */
@Repository
public interface GastosRepository extends JpaRepository<Gastos, Integer>{
    
}
