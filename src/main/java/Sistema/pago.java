/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistema;
import Usuario.Cliente;
import java.util.Date;
/**
 *
 * @author José Miguel
 */
public class Pago {

    private int numeroPago;
    private Date fechaPago;
    private int idServicio;
    private Cliente cliente;
    private double valorPagar;
    

    public Pago(int numeroPago,Date fechaPago,int idServicio,Cliente cliente,double valorPagar ){
        this.numeroPago=numeroPago;
        this.fechaPago=fechaPago;
        this.idServicio=idServicio;
        this.cliente=cliente;
        this.valorPagar=valorPagar;
    }
    public void guardarPago(){
        
    }

    public int getNumeroPago() {
        return numeroPago;
    }

    public Date getFechaPago() {
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

    public void setNumeroPago(int numeroPago) {
        this.numeroPago = numeroPago;
    }

    public void setFechaPago(Date fechaPago) {
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
