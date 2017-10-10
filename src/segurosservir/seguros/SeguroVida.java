/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segurosservir.seguros;

/**
 *
 * @author Felipe Cadavid y Jeison Velasquez
 */
public interface SeguroVida {
    
    public boolean validarViabilidad();
    
    public double calculaCostoPrima(double montoAsegurar, int tiempoSeguro);
    
    public double calcularMensual(double prima);
    
    
    
    
    
}
