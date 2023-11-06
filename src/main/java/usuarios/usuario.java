/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios;

/**
 *
 * @author Luizzz
 */
public class usuario {
    private String numCedula;
    private String nombres;
    private String apellidos;
    private String user;
    private String contrasenia;
    private String numCelular;
    private char tipoUsuario;

    public usuario(String numCedula, String nombres, String apellidos, String user, String contrasenia, String numCelular, char tipoUsuario) {
        this.numCedula = numCedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.user = user;
        this.contrasenia = contrasenia;
        this.numCelular = numCelular;
        this.tipoUsuario = tipoUsuario;
    }

    public String getNumCedula() {
        return numCedula;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getUser() {
        return user;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public String getNumCelular() {
        return numCelular;
    }

    public char getTipoUsuario() {
        return tipoUsuario;
    }

    public void setNumCedula(String numCedula) {
        this.numCedula = numCedula;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public void setNumCelular(String numCelular) {
        this.numCelular = numCelular;
    }

    public void setTipoUsuario(char tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
    
}
