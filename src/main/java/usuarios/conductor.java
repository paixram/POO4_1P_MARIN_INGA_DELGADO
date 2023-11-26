/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios;
import Servicio.Servicio;
import Vehiculo.Vehiculo;

import java.util.ArrayList;
/**
 *
 * @author José Marin
 */
public class Conductor extends Usuario {
    
    private String numLicencia;
    private String estado;
    private Vehiculo vehiculo;
    private ArrayList<Servicio> servicio;

    public Conductor(String numLicencia, String estado, Vehiculo vehiculo, ArrayList<Servicio> servicio, String numCedula, String nombres, String apellidos, String user, String contrasenia, String numCelular, char tipoUsuario) {
        super(numCedula, nombres, apellidos, user, contrasenia, numCelular, tipoUsuario);
        this.numLicencia = numLicencia;
        this.estado = estado;
        this.vehiculo = vehiculo;
        this.servicio = servicio;
    }

    public String getNumLicencia() {
        return numLicencia;
    }

    public String getEstado() {
        return estado;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setNumLicencia(String numLicencia) {
        this.numLicencia = numLicencia;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    
    
}
