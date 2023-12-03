/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import Usuario.Usuario;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author José Marin
 */
public class Archivo {
    
    public static String MyPath;
    public static HashMap<String, ArrayList<Object>> ALLDATA = new HashMap();
    
    public static void setupDB() {
        File f = new File("");
        String dyn_work_directory = f.getAbsolutePath();
        MyPath  = dyn_work_directory + "\\Database\\";
        System.out.println(MyPath);
    }
    
    public static ArrayList<String> leer(String nombreArchivo){
        ArrayList<String> lineas = new ArrayList<>();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(nombreArchivo);
            fr = new FileReader(archivo,StandardCharsets.UTF_8);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                //System.out.println(linea);
                lineas.add(linea);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return lineas;

    }
    
    
    public static void EscribirArchivo(String nombreArchivo, String linea) {

        FileWriter fichero = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(nombreArchivo,true);
            bw = new BufferedWriter(fichero);
            bw.write(linea+"\n");


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    //fichero.close();
                    bw.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
    
    
    public static ArrayList<String> FindBy(String File, HashMap<String, ArrayList<Object>> where) {
        // leer el archivo a recuperar
        ArrayList<String> data_file_db = Archivo.leer(File);
        ArrayList<Object> s = new ArrayList();
        
        int head = 0;
        // procesar encabezado
        String[] raw_head = data_file_db.get(0).split(",");
        ArrayList<String> process_head = new ArrayList();
        process_head.addAll(Arrays.asList(raw_head)); 
        
        // Obtener indices de busqueda y asociar valores a buscar
        HashMap<HashMap<Integer, Object>, ArrayList<Object>> indices_tipo = new HashMap();
        for(Map.Entry<String, ArrayList<Object>> kv : where.entrySet()) {
            String key = kv.getKey();
            ArrayList<Object> values = kv.getValue();
            
            Integer key_index = process_head.indexOf(key);
            
            HashMap<Integer, Object> first_part = new HashMap();
            first_part.put(key_index, values.get(0).getClass());
            indices_tipo.put(first_part, values);
        }
        
        // procesar lineas y encontrar valor en los indices de busqueda y guardar el objeto del tipo deseado
        
        // verificar si se desea toda la data
        ArrayList<String> filtered = new ArrayList();
        
        if(where.equals(ALLDATA)) {
            System.out.println("[ + ] Incomming all Data");
            for(String data_lineb_line : data_file_db) {
                if(head == 0) {
                    head = 1;
                    continue;
                }
                
                filtered.add(data_lineb_line);
            }
            
            return filtered;
        }

        for(String data_linebline : data_file_db) {
            if(head == 0) {
                head = 1;
                continue;
            }
             
            // Parse lines into array
            String[] data_array = data_linebline.split(",");
            Set<String> data_checked = new HashSet<>();
            Set<String> data_pre_check = new HashSet<>();
            
            // Hacer busqueda
            int v_c_l = 0;
            for(Map.Entry<HashMap<Integer, Object>, ArrayList<Object>> it_entry : indices_tipo.entrySet()) {
                HashMap<Integer, Object> metadata = it_entry.getKey();
                ArrayList<Object> values_compare = it_entry.getValue();
                v_c_l += values_compare.size();
                
                data_pre_check = new HashSet();
                // hashamap querys
                for(Map.Entry<Integer, Object> metadata_entry : metadata.entrySet()) {
                     
                    Integer index_search = metadata_entry.getKey();
                    Object type_data = metadata_entry.getValue();
                    // Obtener la data de la db y parsear data al tipo deseado
                    //Object tipo = metadata_entry.getValue();
                    String data_get = data_array[index_search];
                
                    Object dataaa = null;
          
                    // instanceof
                    if(type_data == String.class) {
                       dataaa = String.valueOf(data_get);
                    }else if(type_data == Integer.class) {
                       dataaa = Integer.valueOf(data_get);
                    }else if(type_data == Double.class) {
                       dataaa = Double.valueOf(data_get);
                    }else if(type_data == TipoServicio.class) {
                       dataaa = TipoServicio.valueOf(data_get);
                    }else if(type_data == TipoUsuario.class) {
                       dataaa = TipoUsuario.valueOf(data_get);
                    }else if(type_data == TipoVehiculo.class) {
                       dataaa = TipoVehiculo.valueOf(data_get);
                    }else if(type_data == FormasPago.class) {
                       dataaa = FormasPago.valueOf(data_get);
                    }else if(type_data == EstadoConductor.class) {
                       dataaa = EstadoConductor.valueOf(data_get);
                    }
                     
                    // recorrer la lista de valores y comparar con OR
                    
                    for(Object values_conditionals : values_compare) {
                        if(dataaa.equals(values_conditionals)) {
                            // si es igual se rompe el ciclo porque no hace falta buscar mas y se agrega a un set para comprobar los demas valores
                            // comprobar si set esta vacio
                            if(data_checked.isEmpty()) {
                                data_checked.add(data_linebline);
                            }else{
                                //data_pre_check = new HashSet();
                                data_pre_check.add(data_linebline);
                                 
                            }
                             
                            break;
                        }else{
                            data_checked.add("");
                        }
                         
                    }
                    
                }
                
            }
            
            
            
            if(v_c_l > 1) {
                data_checked.retainAll(data_pre_check);
            }
            
            data_checked.removeIf(String::isEmpty);
            
            
            
            if(data_checked.size() == 1) {
                
                for (String elemento : data_checked) {
                    filtered.add(elemento);
                }
            }
           
        }
        
        return filtered;
    }
    
    
    public static HashMap<String, ArrayList<Object>> CreateQuery(Object[]... values) {
        
        // Map
        HashMap<String, ArrayList<Object>> mapvalue = new HashMap<>();
        
        for(Object[] d : values) {
            String field = (String)d[0];
            mapvalue.put(field, new ArrayList());
            //System.out.println(values.length - 1);
            // put data into object pattern value
            for(int i = 1; i <= (d.length - 1); i++) {
                mapvalue.get(field).add(d[i]);
            }
            
        }
        
        
        return mapvalue;
    }
    
    
}
