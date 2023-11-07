/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios;

/**
 *
 * @author José Miguel
 */
public class pago {
    private int numeroIDPago;
    private date fechaPago;
    private int idServicio;
    private Cliente cliente;
    private double valoraPagar;

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

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setValoraPagar(double valoraPagar) {
        this.valoraPagar = valoraPagar;
    }
    
}
