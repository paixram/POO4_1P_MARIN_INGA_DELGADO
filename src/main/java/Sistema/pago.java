/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistema;
import usuarios.clientes;
/**
 *
 * @author José Miguel
 */
public class pago {
    private int numeroIDPago;
    private date fechaPago;
    private int idServicio;
    private clientes cliente;
    private double valoraPagar;
    
    public pago(int numeroIDPago,date fechaPago,int idServicio,clientes cliente,double valoraPagar ){
        this.numeroIDPago=numeroIDPago;
        this.fechaPago=fechaPago;
        this.idServicio=idServicio;
        this.cliente=cliente;
        this.valoraPagar=valoraPagar;
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

    public clientes getCliente() {
        return cliente;
    }

    public double getValoraPagar() {
        return valoraPagar;
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

    public void setCliente(clientes cliente) {
        this.cliente = cliente;
    }

    public void setValoraPagar(double valoraPagar) {
        this.valoraPagar = valoraPagar;
    }
    
}