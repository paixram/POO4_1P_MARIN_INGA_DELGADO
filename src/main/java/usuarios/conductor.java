/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios;
import Vehiculo.Vehiculo;
/**
 *
 * @author Luizzz
 */
public class Conductor extends Usuario {
    
    public Conductor(String numCedula, String nombres, String apellidos, String user, String contrasenia, String numCelular, char tipoUsuario) {
        super(numCedula, nombres, apellidos, user, contrasenia, numCelular, tipoUsuario);
    
    }
    private String numLicencia;
    private String estado;
    private Vehiculo vehiculo;

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
