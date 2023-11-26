/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Usuario;
import Servicio.Servicio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import utils.TipoUsuario;
import utils.TipoEncomiendas;
import utils.Archivo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author José Marin
 */
public class Cliente extends Usuario{
    
    Scanner sc = new Scanner(System.in);
    
    private int edad;
    private String numTarjetaCredito;
    
    public Cliente(int edad, String numTarjetaCredito, String numCedula, String nombres, String apellidos, String user, String contrasenia, String numCelular, TipoUsuario tipoDeUsuario) {
        super(numCedula, nombres, apellidos, user, contrasenia, numCelular, tipoDeUsuario);
        this.edad = edad;
        this.numTarjetaCredito = numTarjetaCredito;
    }
    
    //getters
    public int getEdad(){
        return edad;
    }
    public String getNumTarjetaCredito(){
        return numTarjetaCredito;
    }
    
    //setters
    public void setEdad(int edad){
        this.edad = edad;
    }
    public void setNumTarjetaCredito(String numTarjetaCredito){
        this.numTarjetaCredito = numTarjetaCredito;
    }

    @Override
    public void consultarServicios(){
        
    }
    
    public void solicitarServicioTaxi(){
        System.out.println("Ingrese el origen: ");
        String origenS_Taxi = sc.nextLine();
        System.out.println("Ingrese el destino: ");
        String destinoS_Taxi = sc.nextLine();
        
        System.out.println("Ingrese la fecha (formato dd/MM/yyyy): ");
        String inputDate = sc.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {Date date = dateFormat.parse(inputDate);
            System.out.println("Fecha ingresada: " + date);
        }catch (ParseException e) {
            System.out.println("Formato de fecha inválido. Asegúrate de ingresar la fecha en formato dd/MM/yyyy.");
        }
        
        //CONDUCTOR LUIS
        ArrayList<String> lineasArc = Archivo.leer("conductores.txt");
        
        
        
        //calcularCosto()
                
                
        System.out.println("Ingrese el numero de personas a transportar: ");
        int numeroPersonas = sc.nextInt();
        sc.nextLine();
        
    }
    
    public void solicitarServicioEncomienda(){
        System.out.println("Ingrese el origen: ");
        String origenS_Taxi = sc.nextLine();
        System.out.println("Ingrese el destino: ");
        String destinoS_Taxi = sc.nextLine();
        
        System.out.println("Ingrese la fecha (formato dd/MM/yyyy): ");
        String inputDate = sc.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {Date date = dateFormat.parse(inputDate);
            System.out.println("Fecha ingresada: " + date);
        }catch (ParseException e) {
            System.out.println("Formato de fecha inválido. Asegúrate de ingresar la fecha en formato dd/MM/yyyy.");
        }
        
        
        System.out.println("Ingrese el tipo de encomienda: ");
        String tipoEncomienda = sc.nextLine();
        TipoEncomiendas.valueOf(tipoEncomienda);
        
        System.out.println("Ingrese la cantidad de productos: ");
        int cantidadProductos = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Ingrese el peso de la encomienda: ");
        double peso = sc.nextDouble();
        sc.nextLine();
        
        
    }
    
    public void pagarServicio(){
    
    }
    
    
}
