package sh.com.pe.ExpenseManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sh.com.pe.ExpenseManagement.model.Roles;

/**
 *
 * @author shmen
 */
@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer> {

}
