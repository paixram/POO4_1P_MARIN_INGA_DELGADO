/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

import utils.FormasPago;
import java.util.Date;
import Usuario.Conductor;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import utils.TipoServicio;

import utils.Archivo;


/**
 *
 * @author Luizzz
 */
public class Servicio {
    private int id;
    private String desde;
    private String hasta;
    private Date fecha;
    private Conductor conductorAsignado;
    private double costo;
    private TipoServicio tipoServicio;
    private FormasPago formaDePago;
    private String hora;


    public Servicio(int id, String desde, String hasta, Date fecha, String hora, Conductor conductorAsignado, TipoServicio tipoServicio, FormasPago formaDePago) {

        this.id = id;
        this.desde = desde;
        this.hasta = hasta;
        this.fecha = fecha;
        this.conductorAsignado = conductorAsignado;
        this.hora = hora;
        this.tipoServicio = tipoServicio;
        this.formaDePago = formaDePago;
    }
    
    public double calcularCosto() {
        System.out.println("***************************** Calculando costo *****************************");
   
        return 0.0;
    }
    
    public void guardarServicio(String cedula) {
        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        // Convertir el objeto Date de nuevo a una cadena
        String fechaFormateada = formato.format(this.getFecha());
        
        String servicio_data = String.valueOf(this.getId()) + "," + String.valueOf(this.getTipoServicio()) + "," + String.valueOf(cedula) + "," + String.valueOf(this.conductorAsignado.getNombres()) + "," + String.valueOf(this.getDesde()) + "," + String.valueOf(this.getHasta()) + "," + fechaFormateada + "," + String.valueOf(this.hora) + "\n";
        
        Archivo.EscribirArchivo(Archivo.MyPath + "Servicios.txt", servicio_data);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDesde(String desde) {
        this.desde = desde;
    }
    
    public void setHasta(String hasta) {
        this.hasta = hasta;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setConductorAsignado(Conductor conductorAsignado) {
        this.conductorAsignado = conductorAsignado;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public void setTipoServicio(TipoServicio tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public void setFormaDePago(FormasPago formaDePago) {
        this.formaDePago = formaDePago;
    }

    public int getId() {
        return id;
    }

    public String getDesde() {
        return desde;
    }
    
    public String getHasta() {
        return hasta;
    }

    public Date getFecha() {
        return fecha;
    }
    
    public String getHora() {
        return hora;
    }

    public Conductor getConductorAsignado() {
        return conductorAsignado;
    }

    public double getCosto() {
        return costo;
    }

    public TipoServicio getTipoServicio() {
        return tipoServicio;
    }

    public FormasPago getFormaDePago() {
        return formaDePago;
    }
    
    @Override
    public String toString(){
        return "Fecha: "+this.fecha+"\nHora: "+this.hora+"\nDesde: "+this.desde+
                "\nHasta: "+this.hasta+"\nConductor asignado: "+this.conductorAsignado.getNombres()+
                "\nCosto: "+this.getCosto();
    }
    
}
