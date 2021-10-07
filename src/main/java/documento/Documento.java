/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package documento;

import static form.AFD.doc;
import form.Archivo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author Chiko malo
 */
public class Documento {
    private String nombre;
    public Documento() {}
    public Documento(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String docExist(){
        String mensaje="";
        try{
            File archivo1 =new File (nombre);
                if(archivo1.createNewFile()){
                    mensaje="Se ha creado el archivo";
                }else{
                    mensaje="El archivo ya existe";
                }
        }catch(Exception e){
            mensaje="Eror al verificar documento";
        }
        return mensaje;
    }
    
    public String guardarDoc(JTextArea jTextArea1){
        String mensaje="";
        try{
            File archivo1 =new File (nombre);
                if(archivo1.createNewFile()){
                    mensaje="Se ha creado el archivo";
                }else{
                    mensaje="El archivo ya existe";
                }
                FileWriter escribir=new FileWriter(archivo1,true);
                escribir.write(jTextArea1.getText());
                escribir.close();
        }catch(Exception e){
            System.out.println("metodo guararDoc utilizado erroneo "+e);
        }
        return mensaje;
    }
    
    public void elim(){
        try{
            File archivo1 =new File (nombre);
            if(archivo1.delete()){
                System.out.println("archivo eliminado ");
            }else{
                System.out.println("archivo no eliminado");
            }
        }catch(Exception e){
            System.out.println("metodo elim utilizado erroneo "+e);
        }
    }
    
    public String leer(){
        JTextArea jTextArea1;
        String palabras ="";
        try{
            File archivo1 =new File (nombre);
            BufferedReader leerArchivo=new BufferedReader(new FileReader(archivo1));
            String lineaLeida="";
            while((lineaLeida = leerArchivo.readLine())!=null){
                 palabras=palabras+lineaLeida+" \n";
                /*extraerPalabras(lineaLeida,fila,columna);*/
                /*fila++;*/
            }
            
        }catch(Exception e){
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE,null,e);
            /*JOptionPane.showMessageDialog(jButton2, "Error de carga");*/
        }
        return palabras;
    }
}
