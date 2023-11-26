/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

import Usuario.Conductor;
import java.util.Date;
import utils.FormasPago;

/**
 *
 * @author Luizzz
 */
public class Taxi extends Servicio {
    
    public int numeroPersonas;

    public Taxi(int numeroPersonas, int id, String ruta, Date fecha, Conductor conductorAsignado, double costo, char tipoServicio, FormasPago formaDePago) {
        super(id, ruta, fecha, conductorAsignado, costo, tipoServicio, formaDePago);
        this.numeroPersonas = numeroPersonas;
    }
    
    
}
