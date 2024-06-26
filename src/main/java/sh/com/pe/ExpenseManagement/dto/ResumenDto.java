package sh.com.pe.ExpenseManagement.dto;

import java.util.List;

/**
 *
 * @author shmen
 */
public class ResumenDto {

    private List<Resumen_gastos_totalesDto> gastos_totales_maximos;
    private List<Resumen_gastos_totalesDto> gastos_totales_minimos;

    public ResumenDto() {
    }

    public ResumenDto(List<Resumen_gastos_totalesDto> gastos_totales_maximos, List<Resumen_gastos_totalesDto> gastos_totales_minimos) {
        this.gastos_totales_maximos = gastos_totales_maximos;
        this.gastos_totales_minimos = gastos_totales_minimos;
    }

    public List<Resumen_gastos_totalesDto> getGastos_totales_maximos() {
        return gastos_totales_maximos;
    }

    public void setGastos_totales_maximos(List<Resumen_gastos_totalesDto> gastos_totales_maximos) {
        this.gastos_totales_maximos = gastos_totales_maximos;
    }

    public List<Resumen_gastos_totalesDto> getGastos_totales_minimos() {
        return gastos_totales_minimos;
    }

    public void setGastos_totales_minimos(List<Resumen_gastos_totalesDto> gastos_totales_minimos) {
        this.gastos_totales_minimos = gastos_totales_minimos;
    }

}
