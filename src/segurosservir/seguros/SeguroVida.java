/*
 * Esta es la interfaz de todos los seguros que se vayan a vender. 
 * Toda póliza debe validad la viabilidad; calcular el costo de la prima
 * y calcular la tarifa mensual
 */
package segurosservir.seguros;

/**
 * Inferfaz de Seguros de vida
 * @author Felipe Cadavid y Jeison Velasquez
 * @since 08-10-2017
 */
public interface SeguroVida {
    
    /**
     * Todo seguro de vida debe validar una viabilidad
     * @return - devuelve true si es viable, o false si no lo es
     */
    public boolean validarViabilidad(int edad);
    
    /**
     * Todo plan debe llevar un monto a asegurar
     * Debe tener un tiempo para el pago del seguro
     * Y todos deben calcular el costo de la prima
     * @param montoAsegurar La cantidad a asegurar entra como parámetro
     * @param tiempoSeguro El plazo de tiempo de seguro entra como parametro
     * @return - devuelve el valor de neto de la prima
     */
    public double calculaCostoPrima(double montoAsegurar, int tiempoSeguro, int edad);
    
    /**
     * Todo plan debe tener la posibilidad de calcular su tarifa mensual
     * El calculo depende de las condiciones del plan
     * @param prima La prima neta entra como parámetro
     * @return - devuelve el valor de la tarifa mensual
     */
    public double calcularMensual(double prima);
    
    
    
    
    
}
