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
import java.util.Scanner;
import utils.Archivo;


import java.util.Scanner;
import utils.*;
import Usuario.Cliente;
import Usuario.Conductor;
import java.io.File;
/**
 * La clase `Sistema` representa el sistema principal que gestiona usuarios, servicios y vehículos.
 * Proporciona métodos para validar el acceso, mostrar menús y realizar operaciones en el sistema.
 * 
 * @author José Miguel
 */
public class Sistema {
  static ArrayList<Usuario> usuarios;
  static ArrayList<Servicio> servicios;
  static ArrayList<Vehiculo> vehiculos;
    /**
   * Método principal que inicia el sistema.
   * 
   * @param args Argumentos de la línea de comandos (no se utilizan).
   */
    public static void main(String[] args) {
        usuarios = new ArrayList<>();
        servicios = new ArrayList<>();
        vehiculos = new ArrayList<>();
        
        // Path dinamico en MyPath
        Archivo.setupDB();
        
        //HashMap<String, ArrayList<Object>> where = Archivo.CreateQuery(new Object[]{"cedula", "0945698598"});
        //Archivo.FindBy("C:\\Users\\Luizzz\\Documents\\NetBeansProjects\\POO4_1P_MARIN_INGA_DELGADO\\src\\main\\java\\Database\\Conductores.txt", where, Servicio.class);
    

        validarAcceso();
    }
    //metodos de acceso
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

    /**
   * Constructor de la clase `Sistema`.
   * 
   * @param usuarios Lista de usuarios en el sistema.
   * @param servicios Lista de servicios en el sistema.
   * @param vehiculos Lista de vehículos en el sistema.
   */
    public Sistema(ArrayList<Usuario> usuarios,ArrayList<Servicio> servicios,ArrayList<Vehiculo> vehiculos) {
        this.usuarios=usuarios;
        this.vehiculos=vehiculos;
        this.servicios=servicios;
        
    }

    
    /**
   * Método que valida el acceso al sistema mediante la entrada de usuario y contraseña.
   */
    static void validarAcceso(){
        System.out.println("+++++++++++++++++++++++++++++++++++");
        System.out.println("      BIENVENIDO AL SISTEMA");
        System.out.println("+++++++++++++++++++++++++++++++++++");
        
        
        
        Scanner sc= new Scanner(System.in);
        System.out.print("USUARIO: ");
        String usuario = sc.nextLine();
        System.out.print("CONTRASEÑA: ");
        String contraseña = sc.nextLine();

        
        
        // BUSCAR EL USUARIO
        HashMap<String, ArrayList<Object>> where = Archivo.CreateQuery(new Object[]{"user", usuario});
        ArrayList<String> user_cred = Archivo.FindBy(Archivo.MyPath + "Usuarios.txt", where);
        

        //System.out.println(user_cred);
        if(user_cred.isEmpty()) {
            System.out.println("No existe usuario llamado: " + usuario);
            return;
        } 
        
        String password = ((String)user_cred.get(0)).split(",")[4];
        

        if(!contraseña.equals(password)) {
            System.out.println("Contraseña no es valida!");
            return;
        }
        
        // cedula
        String cedula = ((String)user_cred.get(0)).split(",")[0];
      
        // Tener el tipo de cliente
        
        TipoUsuario tu = TipoUsuario.valueOf(((String)user_cred.get(0)).split(",")[6]);
        
        if(tu == TipoUsuario.C) {
            System.out.println("Es cliente");
            HashMap<String, ArrayList<Object>> clausule = Archivo.CreateQuery(new Object[]{"numCedula", cedula});
            ArrayList<String> cliente_cred = Archivo.FindBy(Archivo.MyPath + "Clientes.txt", clausule);

            
            String[] data_cliente = (cliente_cred.get(0)).split(",");
            Cliente cliente = new Cliente(Integer.parseInt(data_cliente[0]), data_cliente[1], ((String)user_cred.get(0)).split(",")[0], ((String)user_cred.get(0)).split(",")[1], ((String)user_cred.get(0)).split(",")[2], ((String)user_cred.get(0)).split(",")[3], ((String)user_cred.get(0)).split(",")[4],
                ((String)user_cred.get(0)).split(",")[5], tu);
            mostrarMenuCliente(cliente);
            
        }else if(tu == TipoUsuario.R) {
            System.out.println("Es conductor");
            
            HashMap<String, ArrayList<Object>> clausule = Archivo.CreateQuery(new Object[]{"cedula", cedula});
            ArrayList<String> conductor_cred = Archivo.FindBy(Archivo.MyPath + "Conductores.txt", clausule);
            
            String[] data_conductor = (conductor_cred.get(0)).split(",");
            
            // Vehiculo
            
            HashMap<String, ArrayList<Object>> clausule_dos = Archivo.CreateQuery(new Object[]{"codigoVehiculo", Integer.parseInt(data_conductor[2])});
            ArrayList<String> vehiculo_cred = Archivo.FindBy(Archivo.MyPath + "Vehiculos.txt", clausule_dos);
            
            String[] data_vehiculo = (vehiculo_cred.get(0)).split(",");
            
            Vehiculo vac = new Vehiculo(Integer.parseInt(data_vehiculo[0]), data_vehiculo[1], data_vehiculo[2], data_vehiculo[3], TipoVehiculo.valueOf(data_vehiculo[4]));
            
            Conductor cd = new Conductor(data_conductor[0], EstadoConductor.valueOf(data_conductor[1]), vac, ((String)user_cred.get(0)).split(",")[0], ((String)user_cred.get(0)).split(",")[1],((String)user_cred.get(0)).split(",")[2], ((String)user_cred.get(0)).split(",")[3], ((String)user_cred.get(0)).split(",")[4], ((String)user_cred.get(0)).split(",")[5], TipoUsuario.valueOf(((String)user_cred.get(0)).split(",")[6]));
            
            mostrarMenuConductor(cd);
        }
        
        
    }
    
    

    /**
   * Muestra el menú para un conductor y gestiona las opciones seleccionadas.
   * 
   * @param r Conductor para el cual se muestra el menú.
   */ 
    static void mostrarMenuConductor(Conductor r) {
        while(true){
            System.out.println("/*******************************************Menu Conductor*******************************************\\");
            System.out.println("1. Consultar Servicio Asignado");
            System.out.println("2. Datos de su vehiculo");
            Scanner sc = new Scanner(System.in);
            System.out.println("Elija una opcion: ");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    //consultar servicio
                    r.consultarServicios();
                    break;
                case 2:
                    //datos de su vehiculo
                    Conductor.verificarDatVehiculos(r);
                    break;

                default:
                    System.out.println("Opción no válida, vuelva a intentar");
            }
        }
    }
    /**
   * Muestra el menú para un cliente y gestiona las opciones seleccionadas.
   * 
   * @param c Cliente para el cual se muestra el menú.
   */
    static void mostrarMenuCliente(Cliente c){
        while(true){
            System.out.println("/*******************************************Menu Cliente*******************************************\\");
            System.out.println("1. Solicitar servicio de taxi");
            System.out.println("2. Solicitar entrega de encomienda");
            System.out.println("3. Consultar servicios");
            Scanner sc = new Scanner(System.in);
            System.out.println("Elija una opcion: ");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    //solicitarServicioTaxi();
                    c.solicitarServicioTaxi();
                    break;
                case 2:
                    //solicitarServicioEncomienda();
                    c.solicitarServicioEncomienda();
                    break;
                case 3:
                    c.consultarServicios();
                    break;

                default:
                    System.out.println("Opción no válida, vuelva a intentar");
            }     
        }
    }
}


      
