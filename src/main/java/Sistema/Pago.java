/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistema;
import java.text.SimpleDateFormat;
import Usuario.Cliente;
import java.util.Date;
import Servicio.Servicio;
import java.io.IOException;
import utils.Archivo;
import utils.FormasPago;
/**
 *
 * @author José Miguel
 */
public class Pago {

    private int numeroPago;
    private Date fechaPago;
    private Servicio servicio;
    private Cliente cliente;
    private double valorPagar;
    

    public Pago(int numeroPago,Date fechaPago,Servicio servicio,Cliente cliente,double valorPagar ){
        this.numeroPago=numeroPago;
        this.fechaPago=fechaPago;
        this.servicio=servicio;
        this.cliente=cliente;
        this.valorPagar=valorPagar;
    }
    

    public int getNumeroPago() {
        return numeroPago;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public Servicio getServicio() {
        return servicio;
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

    public void setIdServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setValorPagar(double valoraPagar) {
        this.valorPagar = valoraPagar;
    }
    
    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String formaPago = String.valueOf(this.servicio.getFormaDePago());
        return "Número de Pago: " + numeroPago +
                "\nFecha de Pago: " + dateFormat.format(fechaPago) +
                "\nForma de Pago: " + formaPago +
                "\nCédula del Cliente: " + cliente.getNumCedula() +
                "\nValor a Pagar: $" + valorPagar;
    
}
    public void guardarPago() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String fechaPagoString = dateFormat.format(fechaPago);
        String formaPagoString = String.valueOf(this.servicio.getFormaDePago());
        String lineaPago = String.format("%d,%s,%d,%s,%s,%.2f",
                numeroPago, fechaPagoString, servicio,
                formaPagoString, cliente.getNumCedula(), valorPagar);
        Archivo.EscribirArchivo(Archivo.MyPath + "Pagos.txt", lineaPago);
        System.out.println("Pago guardado exitosamente.");
}
    }
