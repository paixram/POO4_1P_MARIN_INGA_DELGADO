/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistema;
import Usuario.Usuario;
import java.util.ArrayList;
import Vehiculo.*;
import Servicio.*;
import Usuario.*;
import java.util.HashMap;
import java.util.Scanner;
import utils.*;
/**
 *
 * @author José Miguel
 */
public class Sistema {
  static ArrayList<Usuario> usuarios;
  static ArrayList<Servicio> servicios;
  static ArrayList<Vehiculo> vehiculos;
    public static void main(String[] args) {
        usuarios = new ArrayList<>();
        servicios = new ArrayList<>();
        vehiculos = new ArrayList<>();
        
        
        HashMap<String, ArrayList<Object>> where = Archivo.CreateQuery(new Object[]{"cedula", "0549459"});
        Archivo.FindBy("C:\\Users\\Luizzz\\Documents\\NetBeansProjects\\POO4_1P_MARIN_INGA_DELGADO\\src\\main\\java\\Database\\Conductores.txt", where, Servicio.class);
    }
    public static ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public static ArrayList<Servicio> getServicios() {
        return servicios;
    }

    public static ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public static void setUsuarios(ArrayList<Usuario> usuarios) {
        Sistema.usuarios = usuarios;
    }

    public static void setServicios(ArrayList<Servicio> servicios) {
        Sistema.servicios = servicios;
    }

    public static void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        Sistema.vehiculos = vehiculos;
    }

  
    public Sistema(ArrayList<Usuario> usuarios,ArrayList<Servicio> servicios,ArrayList<Vehiculo> vehiculos) {
        this.usuarios=usuarios;
        this.vehiculos=vehiculos;
        this.servicios=servicios;
        
    }
    
    
    /*static void validarAcceso(){
        Scanner sc= new Scanner(System.in);
        System.out.print("USUARIO: ");
        String usuario = sc.nextLine();
        System.out.print("CONTRASEÑA: ");
        String contraseña = sc.nextLine();
        ArrayList<String> lineas = Archivo.leer("usuarios.txt");
        usuarios = new ArrayList<>();

        for (String linea : lineas) {
            String[] datos = linea.split(",");
            String tipoUsuario = datos[0];

            if (tipoUsuario.equals("C")) {
                // Se crea objeto cliente y se lo agrega a la lista de usuarios
                Cliente cliente = new Cliente(Integer.parseInt(datos[7]), datos[8], datos[1], datos[2], datos[3], datos[4], datos[5], datos[6], TipoUsuario.CLIENTE);
                usuarios.add(cliente);
            } else if (tipoUsuario.equals("R")) {
                // Se crea objeto conductor y se lo agrega a la lista de usuarios
                Conductor conductor = new Conductor(datos[7], EstadoConductor.valueOf(datos[8]), vehiculo, datos[1], datos[2], datos[3], datos[4], datos[5], datos[6], TipoUsuario.CONDUCTOR);
                usuarios.add(conductor);
            }

            
        }
        
        Usuario usuarioEncontrado = buscarUsuario(usuario, contraseña);
        if (usuarioEncontrado != null && usuarioEncontrado.getContraseña().equals(contraseña)) {
            System.out.println("Acceso concedido. ¡Bienvenido, " + usuarioEncontrado.getNombres() + "!");

        } else {
            System.out.println("Credenciales incorrectas. Intenta de nuevo.");
        }   
    }
    
    static Usuario buscarUsuario(String nombre, String contraseña) {
        
    }*/
    
    static void guardarDatosCliente(){
    
    }
    static void iniciarSesion(){
    
    }
    static void mostrarMenu(){
       
    
        
        System.out.println("1. Solicitar servicio de taxi");
        
        System.out.println("2. Solicitar entrega de encomienda");
        System.out.println("3. Consultar servicios");
        Scanner sc = new Scanner(System.in);
        System.out.println("Elija una opcion: ");
        int opcion = sc.nextInt();
        
        switch (opcion) {
            case 1:
                //solicitarServicioTaxi();
                break;
            case 2:
                //solicitarServicioEncomienda();
                break;
            case 3:
                //consultarServicios();
                break;
            default:
                System.out.println("Opción no válida, vuelva a intentar");
    }     
    }
}
        
       
