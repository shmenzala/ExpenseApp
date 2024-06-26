package sh.com.pe.ExpenseManagement.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sh.com.pe.ExpenseManagement.dto.Resumen_gastos_totalesDto;
import sh.com.pe.ExpenseManagement.model.Gastos;

/**
 *
 * @author shmen
 */
@Repository
public interface GastosRepository extends JpaRepository<Gastos, Integer> {

    @Query(value = """
                    SELECT g.tipo_gasto AS gasto, cg.nombre AS categoria, g.total AS gasto_total
                    FROM Gastos g
                    JOIN g.categorias_gasto cg
                    WHERE g.total = (SELECT MAX(g2.total) FROM Gastos g2)""",
            countQuery = """
                    SELECT COUNT(g)
                    FROM Gastos g
                    JOIN g.categorias_gasto cg
                    WHERE g.total = (SELECT MAX(g2.total) FROM Gastos g2)""")
    public List<Resumen_gastos_totalesDto> obtenerResumenGastosTotalesMaximos();
    
    @Query(value = """
                    SELECT g.tipo_gasto AS gasto, cg.nombre AS categoria, g.total AS gasto_total
                    FROM Gastos g
                    JOIN g.categorias_gasto cg
                    WHERE g.total = (SELECT MIN(g2.total) FROM Gastos g2)""",
            countQuery = """
                    SELECT COUNT(g)
                    FROM Gastos g
                    JOIN g.categorias_gasto cg
                    WHERE g.total = (SELECT MIN(g2.total) FROM Gastos g2)""")
    public List<Resumen_gastos_totalesDto> obtenerResumenGastosTotalesMinimos();

}
