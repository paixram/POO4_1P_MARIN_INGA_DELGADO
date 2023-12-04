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
 * La clase Servicio representa un servicio de transporte genérico.
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

     /**
     * Constructor de la clase Servicio.
     *
     * @param id                Identificador del servicio.
     * @param desde             Lugar de origen del servicio.
     * @param hasta             Lugar de destino del servicio.
     * @param fecha             Fecha del servicio.
     * @param hora              Hora del servicio.
     * @param conductorAsignado Conductor asignado al servicio.
     * @param tipoServicio      Tipo de servicio.
     * @param formaDePago       Forma de pago del servicio.
     */
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
     /**
     * Calcula el costo del servicio. Este método debe ser implementado por las clases que heredan de Servicio.
     *
     * @return El costo del servicio.
     */
    public double calcularCosto() {
        System.out.println("***************************** Calculando costo *****************************");
   
        return 0.0;
    }
     /**
     * Guarda los detalles del servicio en un archivo.
     *
     * @param cedula Cédula del usuario asociado al servicio.
     */
    public void guardarServicio(String cedula) {
        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        // Convertir el objeto Date de nuevo a una cadena
        String fechaFormateada = formato.format(this.getFecha());
        
        String servicio_data = String.valueOf(this.getId()) + "," + String.valueOf(this.getTipoServicio()) + "," + String.valueOf(cedula) + "," + String.valueOf(this.conductorAsignado.getNombres()) + "," + String.valueOf(this.getDesde()) + "," + String.valueOf(this.getHasta()) + "," + fechaFormateada + "," + String.valueOf(this.hora);
        
        Archivo.EscribirArchivo(Archivo.MyPath + "Servicios.txt", servicio_data);
    }
    //metodos de acceso
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
     /**
     * Representación en cadena del servicio.
     *
     * @return Cadena que representa los detalles del servicio.
     */
    @Override
    public String toString(){
        return "Fecha: "+this.fecha+"\nHora: "+this.hora+"\nDesde: "+this.desde+
                "\nHasta: "+this.hasta+"\nConductor asignado: "+this.conductorAsignado.getNombres()+
                "\nCosto: "+this.getCosto();
    }
    
}
