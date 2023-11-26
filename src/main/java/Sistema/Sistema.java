/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistema;
import Servicio.Servicio;
import Usuario.Usuario;
import java.util.ArrayList;
import Vehiculo.*;
import java.util.HashMap;
import utils.Archivo;

import Servicio.*;
import Usuario.*;
import java.util.HashMap;

import Servicio.Servicio;

import java.util.Scanner;
import utils.*;
import Usuario.Cliente;
import Usuario.Conductor;
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
        
        
        HashMap<String, ArrayList<Object>> where = Archivo.CreateQuery(new Object[]{"cedula", "0945698598"});
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

<<<<<<< HEAD
            if (tipoUsuario.equals("C")) {
                // Se crea objeto cliente y se lo agrega a la lista de usuarios
                Cliente cliente = new Cliente(Integer.parseInt(datos[7]), datos[8], datos[1], datos[2], datos[3], datos[4], datos[5], datos[6], TipoUsuario.CLIENTE);
                usuarios.add(cliente);
            } else if (tipoUsuario.equals("R")) {
                // Se crea objeto conductor y se lo agrega a la lista de usuarios
                Conductor conductor = new Conductor(datos[7], EstadoConductor.valueOf(datos[8]), vehiculo, datos[1], datos[2], datos[3], datos[4], datos[5], datos[6], TipoUsuario.CONDUCTOR);
                usuarios.add(conductor);
            }

            
=======
        if (tipoUsuario.equals("C")) {
            // Se crea objeto cliente y se lo agrega a la lista de usuarios
            Cliente cliente = new Cliente(Integer.parseInt(datos[7]), datos[8], datos[1], datos[2], datos[3], datos[4], datos[5], datos[6], TipoUsuario.cliente);
            usuarios.add(cliente);
        } else if (tipoUsuario.equals("R")) {
            // Se crea objeto conductor y se lo agrega a la lista de usuarios
            
            Conductor conductor = new Conductor(datos[7], EstadoConductor.valueOf(datos[8]), vehiculo, datos[1], datos[2], datos[3], datos[4], datos[5], datos[6], TipoUsuario.CONDUCTOR);
            usuarios.add(conductor);
>>>>>>> 5c5445f9db31475c0d9694b0891045a41c30bc98
        }
        
        Usuario usuarioEncontrado = buscarUsuario(usuario, contraseña);
        if (usuarioEncontrado != null && usuarioEncontrado.getContraseña().equals(contraseña)) {
            System.out.println("Acceso concedido. ¡Bienvenido, " + usuarioEncontrado.getNombres() + "!");
<<<<<<< HEAD

        } else {
            System.out.println("Credenciales incorrectas. Intenta de nuevo.");
        }   
    }
    
    static Usuario buscarUsuario(String nombre, String contraseña) {
        
    }

        
        } else {
            System.out.println("Credenciales incorrectas. Intenta de nuevo.");
    }        
    }
        
>>>>>>> 5c5445f9db31475c0d9694b0891045a41c30bc98
    
    static void guardarDatosCliente(){
    
    }
    static void iniciarSesion(){
    
    }
    static void mostrarMenu(){
        System.out.println("/*******************************************Menu*******************************************\\");
        System.out.println("1. Solicitar servicio de taxi");
        System.out.println("2. Solicitar entrega de encomienda");
        System.out.println("3. Consultar servicios");
        Scanner sc = new Scanner(System.in);
        System.out.println("Elija una opcion: ");
        int opcion = sc.nextInt();
        Cliente cliente = new Cliente(25, "1234567890123456", "CED123", "Nombre", "Apellido", "usuario", "contraseña",
                "1234567890", TipoUsuario.C);
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

                cliente.solicitarServicioTaxi();
                break;
            case 2:
                cliente.solicitarServicioEncomienda();
                break;
            case 3:
                cliente.consultarServicios();
                break;
            default:
                System.out.println("Opción no válida, vuelva a intentar");
    }  
        System.out.println("/*******************************************Menu Conductor*******************************************\\");
        System.out.println("1. Consultar servicio asignado");
        System.out.println("2. Datos de su vehiculo");
        int opcion2=sc.nextInt();
        Conductor conductor= new Conductor();
        switch (opcion2) {
            case 1:
                conductor.consultarServicioAsignado();
                break;
            case 2:
                conductor.mostrarDatosVehiculo();
                break;
            default:
                System.out.println("Opción no válida, vuelva a intentar");
        }*/
    }


      
       
