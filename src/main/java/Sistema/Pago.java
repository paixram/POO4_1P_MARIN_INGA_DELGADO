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
import java.util.ArrayList;
import java.util.HashMap;
import utils.Archivo;
import utils.FormasPago;
import utils.TipoServicio;
/**
 * La clase Pago representa una transacción de pago asociada a un servicio.
 * Contiene información sobre el número de pago, fecha de pago, servicio asociado,
 * cliente que realizó el pago y el valor a pagar.
 * 
 * @author José Miguel
 */
public class Pago {

    private int numeroPago;
    private Date fechaPago;
    private Servicio servicio;
    private Cliente cliente;
    private double valorPagar;
    
    /**
     * Constructor de la clase Pago.
     *
     * @param numeroPago Número de identificación único del pago.
     * @param fechaPago Fecha en que se realizó el pago.
     * @param servicio Servicio asociado al pago.
     * @param cliente Cliente que realizó el pago.
     * @param valorPagar Valor a pagar en el servicio.
     */
    public Pago(int numeroPago,Date fechaPago,Servicio servicio,Cliente cliente,double valorPagar ){
        this.numeroPago=numeroPago;
        this.fechaPago=fechaPago;
        this.servicio=servicio;
        this.cliente=cliente;
        this.valorPagar=valorPagar;
    }
    
    //Metodos de acceso
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
    /**
     * Representación en cadena del pago.
     *
     * @return Cadena que representa los detalles del pago.
     */
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
    /**
     * Guarda los detalles del pago en un archivo.
     */
    public void guardarPago() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String fechaPagoString = dateFormat.format(fechaPago);
        String formaPagoString = String.valueOf(this.servicio.getFormaDePago());
        
        // obtener num servicio
        // obtener viaje con num servicio
        HashMap<String, ArrayList<Object>> clausule = null;
        ArrayList<String> tuple = null;
        String subtotal = null;
        if(this.servicio.getTipoServicio() == TipoServicio.T) {
            clausule = Archivo.CreateQuery(new Object[]{"numeroServicio", this.servicio.getId()});
            tuple = Archivo.FindBy(Archivo.MyPath + "Viajes.txt", clausule);
            // obtener el subtotal
            subtotal = (tuple.get(0).split(","))[3];
        }else {
            clausule = Archivo.CreateQuery(new Object[]{"numeroServicio", this.servicio.getId()});
            tuple = Archivo.FindBy(Archivo.MyPath + "Encomiendas.txt", clausule);
            Double op = Double.parseDouble(tuple.get(0).split(",")[3]) * 1.00;
            subtotal = String.valueOf(op);
            Archivo.EscribirArchivo(Archivo.MyPath + "Pagos.txt", formaPagoString);
        }
        
        
        
        String lineaPago = String.format("%d,%s,%d,%s,%s,%s,%s",
                numeroPago, fechaPagoString, this.servicio.getId(),
                formaPagoString, cliente.getNumCedula(), subtotal,this.valorPagar);
        Archivo.EscribirArchivo(Archivo.MyPath + "Pagos.txt", lineaPago);
        System.out.println("Pago guardado exitosamente.");
}
    }

