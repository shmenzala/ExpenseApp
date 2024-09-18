package sh.com.pe.ExpenseManagement.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sh.com.pe.ExpenseManagement.model.Usuarios;

/**
 *
 * @author shmen
 */
@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Integer> {

    public boolean existsByEmail(String email);
    
    public Optional<Usuarios> findByUsernameOrEmail(String username, String email);
    
}
