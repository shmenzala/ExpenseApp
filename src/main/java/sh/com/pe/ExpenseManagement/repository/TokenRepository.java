package sh.com.pe.ExpenseManagement.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sh.com.pe.ExpenseManagement.model.Token;

/**
 *
 * @author shmen
 */
@Repository
public interface TokenRepository extends JpaRepository<Token, Integer> {

    @Query(value = """
                    SELECT t 
                    FROM Token t
                    JOIN t.usuarios u
                    WHERE u.id = :usuarioId AND (t.expired = 0 OR t.revoked = 0)""",
            countQuery = """
                    SELECT COUNT(t) 
                    FROM Token t
                    JOIN t.usuarios u
                    WHERE u.id = :usuarioId AND (t.expired = 0 OR t.revoked = 0)""")
    public List<Token> findAllValidTokensByUsuarios(@Param("usuarioId") Integer usuarioId);

    public Optional<Token> findByToken(String token);

}
