/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistema;
import Usuario.Cliente;
/**
 *
 * @author José Miguel
 */
public class Pago {
    private int numeroIDPago;
    private date fechaPago;
    private int idServicio;
    private Cliente cliente;
    private double valorPagar;
    
    public Pago(int numeroIDPago,date fechaPago,int idServicio,Cliente cliente,double valorPagar ){
        this.numeroIDPago=numeroIDPago;
        this.fechaPago=fechaPago;
        this.idServicio=idServicio;
        this.cliente=cliente;
        this.valorPagar=valorPagar;
    }

    public int getNumeroIDPago() {
        return numeroIDPago;
    }

    public date getFechaPago() {
        return fechaPago;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getValorPagar() {
        return valorPagar;
    }

    public void setNumeroIDPago(int numeroIDPago) {
        this.numeroIDPago = numeroIDPago;
    }

    public void setFechaPago(date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setValorPagar(double valoraPagar) {
        this.valorPagar = valoraPagar;
    }
    
}
