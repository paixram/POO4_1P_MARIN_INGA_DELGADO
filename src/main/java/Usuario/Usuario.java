/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Usuario;

import utils.TipoUsuario;

/**
 * La clase `Usuario` es una clase abstracta que sirve como base para representar a los usuarios
 * en el sistema. Contiene información común a todos los usuarios, como número de cédula, nombres,
 * apellidos, nombre de usuario, contraseña, número de celular y tipo de usuario.
 * 
 * @author José Marin
 */
public abstract class Usuario {
    
    protected String numCedula, nombres, apellidos,user, contrasenia, numCelular;
    protected TipoUsuario tipoDeUsuario;
    
    /**
     * Constructor de la clase `Usuario`.
     * 
     * @param numCedula Número de cédula del usuario.
     * @param nombres Nombres del usuario.
     * @param apellidos Apellidos del usuario.
     * @param user Nombre de usuario.
     * @param contrasenia Contraseña del usuario.
     * @param numCelular Número de celular del usuario.
     * @param tipoDeUsuario Tipo de usuario (conductor, cliente, etc.).
     */
    public Usuario(String numCedula,String nombres,String apellidos,String user, String contrasenia,String numCelular,TipoUsuario tipoDeUsuario){
        this.numCedula = numCedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.user = user;
        this.contrasenia = contrasenia;
        this.numCelular = numCelular;
        this.tipoDeUsuario = tipoDeUsuario;
    }
    
    /**
     * Método abstracto para consultar servicios. Las clases hijas deben implementar este método.
     */
    public abstract void consultarServicios();
        
    //metoods de acceso   
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
    public TipoUsuario getTipoDeUsuario(){
        return tipoDeUsuario;
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
    public void setTipoUsuario(TipoUsuario tipoDeUsuario){
        this.tipoDeUsuario = tipoDeUsuario;
    }
    
    
}