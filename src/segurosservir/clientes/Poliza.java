/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segurosservir.clientes;

/**
 *
 * @author Felipe
 */
public class Poliza {
    
    private double prima;
    private int documento;
    private double cuotaMensual;
    private double montoAsegurado;
    private int tiempoAsegurado;

    public Poliza() {
    }

    @Override
    public String toString(){
        return "Cliente con cedula:" + this.documento + " , debe pagar una prima de: $\n"
                + this.cuotaMensual +" y tiene un monto asegurado de: "+ this.montoAsegurado +"\n"
                + "para una prima total de: "+ this.prima + " a un tiempo de: " + this.tiempoAsegurado;
    }
    public double getPrima() {
        return prima;
    }

    public void setPrima(double prima) {
        this.prima = prima;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public double getCuotaMensual() {
        return cuotaMensual;
    }

    public void setCuotaMensual(double cuotaMensual) {
        this.cuotaMensual = cuotaMensual;
    }

    public double getMontoAsegurado() {
        return montoAsegurado;
    }

    public void setMontoAsegurado(double montoAsegurado) {
        this.montoAsegurado = montoAsegurado;
    }

    public int getTiempoAsegurado() {
        return tiempoAsegurado;
    }

    public void setTiempoAsegurado(int tiempoAsegurado) {
        this.tiempoAsegurado = tiempoAsegurado;
    }
}
