
package javaapplication6;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Archivos {
    
    /*
    Clase para mandar texto al archivo plano y construir el cifrado...
    */ 
    public void Metodo2(String ubicacion,String contenido){
        try {
            PrintWriter writer = new PrintWriter(ubicacion, "UTF-8");
            writer.println("Primera línea");
            writer.println("Segunda línea");
            writer.println(contenido);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String leerTxt(String direccion){
        String texto = "";
        int a = 0;
        try{
            BufferedReader bf = new BufferedReader(new FileReader (direccion));
            String temp ="";
            String bfRead;
            while((bfRead = bf.readLine()) != null){
                temp = temp + bfRead;
                a ++;
            }
            texto=temp;
        }catch(Exception e){
            System.err.println("No se encontro archivo");
        }
        
        return (texto + ","+ a);
    }
    /*File archivo = new File("texto.txt");
        
    public Archivos(){
    creararchivo();
    }
     void creararchivo(){
         try{
             if( archivo.exists()){
                 
             }else{
                 archivo.createNewFile();
             }
         }catch(Exception e ){
             System.out.println(e);
         }
     }*/   
}

