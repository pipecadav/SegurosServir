/*
 * Esta clase permite crear una poliza Total Mixta, donde el cliente 
 * asegurado paga una prima neta única para un tiempo futuro en años n
 * El asegurado recibe la poliza despues de n años 
 */
package segurosservir.seguros;

import tablasdereferencia.*;

/**
 * Clase Plan Facil
 * @author Felipe Cadavid y Jeison Velasquez
 * @since 08-10-2017
 */
public class PlanFacil implements SeguroVida{
    
    private double prima;
    static final int EXPECTATIVAVIDA = 78;
    
    /**
     * Valida los requisitos del asegurado, debe ser mayor o igual a 22 años
     * Debe ser como mínimo 10 años menor que la expectativa de vida
     * @param edad Recibe la edad del cliente como parámetro
     * @return Devuelve verdadero o falso
     */
    @Override
    public boolean validarViabilidad(int edad) {
           return (((EXPECTATIVAVIDA - edad) >10) && (edad >= 22));
       }
  

    /**
     * Ejecuta la función Ax = Monto*(Dxn/Dx)
     * @param montoAsegurar Cantidad a asegurar
     * @param tiempoSeguro Tiempo futuro
     * @param edad Recibe la edad del cliente como parámetro
     * @return Retorna el valor de la prima
     */
    @Override
    public double calculaCostoPrima(double montoAsegurar, int tiempoSeguro, int edad) {
        double dxn = 0.0;
        double dxny = 0.0;
        TablasDeReferencia.inicializarTabla();
        for(int i = 0; i < TablasDeReferencia.valores.size(); i++){
            if(edad == TablasDeReferencia.valores.get(i).getEdad()){
                dxn = TablasDeReferencia.valores.get(i).getDx();
                dxny = TablasDeReferencia.valores.get(i+tiempoSeguro).getDx();
                i = TablasDeReferencia.valores.size();
            }
        }
        prima = montoAsegurar*(dxny/dxn);
        return prima;
    }

    /**
     * Difiere la prima en cuotas de 60 meses independiente del tiempo futuro
     * @param prima Recibe el valor neto de la prima
     * @return Retorna el valor a pagar mensual
     */
    @Override
    public double calcularMensual(double prima) {
        return (prima/60);
    }

    public double getPrima() {
        return prima;
    }

    public void setPrima(double prima) {
        this.prima = prima;
    }
    
    
}
