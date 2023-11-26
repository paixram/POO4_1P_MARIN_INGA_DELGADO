/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios;

/**
 *
 * @author José Marin
 */
public abstract class Usuario {
    
    protected String numCedula, nombres, apellidos, user, contrasenia, numCelular;
    private char tipoUsuario;
    
    //constructor
    public Usuario(String numCedula,String nombres,String apellidos,String user,String contrasenia,String numCelular,char tipoUsuario){
        this.numCedula = numCedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.user = user;
        this.contrasenia = contrasenia;
        this.numCelular = numCelular;
        this.tipoUsuario = tipoUsuario;
    }
    
    /*
    public void consultarServicios(){
        
    }
    */
    
    //getters
    public String getNumCedula(){
        return numCedula;
    }
    public String getNombres(){
        return nombres;
    }
    public String getApellidos(){
        return apellidos;
    }
    public String getUser(){
        return user;
    }
    public String getContrasenia(){
        return contrasenia;
    }
    public String getNumCelular(){
        return numCelular;
    }
    public char getTipoUsuario(){
        return tipoUsuario;
    }
    
    //setters
    public void setNumCedula(String numCedula){
        this.numCedula = numCedula;
    }
    public void setNombres(String nombres){
        this.nombres = nombres;
    }
    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }
    public void setUser(String user){
        this.user = user;
    }
    public void setContrasenia(String contrasenia){
        this.contrasenia = contrasenia;
    }
    public void setNumCelular(String numCelular){
        this.numCelular = numCelular;
    }
    public void setTipoUsuario(char tipoUsuario){
        this.tipoUsuario = tipoUsuario;
    }
    
    
}