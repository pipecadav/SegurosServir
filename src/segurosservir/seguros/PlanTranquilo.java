/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segurosservir.seguros;

import segurosservir.clientes.Clientes;
import tablasdereferencia.*;


public class PlanTranquilo implements SeguroVida {

    Clientes persona;
    double prima;
    static final int EXPECTATIVAVIDA = 78;
    int tiempoSeguro;
    
    @Override
    public boolean validarViabilidad() {
           return (((EXPECTATIVAVIDA - persona.getEdad()) <20) && (persona.getEdad() > 22));
    }

    @Override
    public double calculaCostoPrima(double montoAsegurar, int tiempoSeguro) {
        this.tiempoSeguro = tiempoSeguro;
        double mx = 0.0;
        double mxn = 0.0;
        double dxn = 0.0;
        TablasDeReferencia.inicializarTabla();
        for(int i = 0; i < TablasDeReferencia.valores.size(); i++){
            if(persona.getEdad() == TablasDeReferencia.valores.get(i).getEdad()){
                mx = TablasDeReferencia.valores.get(i).getMx();
                mxn = TablasDeReferencia.valores.get(i+tiempoSeguro).getMx();
                dxn = TablasDeReferencia.valores.get(i+tiempoSeguro).getDx();
                i = TablasDeReferencia.valores.size();
            }
        }
        prima = montoAsegurar*((mx-mxn)/dxn);
        return prima;
    }

    @Override
    public double calcularMensual(double prima) {
        return (prima/(tiempoSeguro*12));
    }


}
