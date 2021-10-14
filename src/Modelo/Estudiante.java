/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;
import java.io.Serializable;
/**
 *
 * @author ginap
 */
public class Estudiante implements Serializable{
    private static final long serialVersionUID = 1095827248314682118L;
    long ID;
    String nombres;
    String apellidos;
    String programa;
    
    public Estudiante(){
        ID = 0;
        nombres = new String();
        apellidos = new String();
        programa = new String();
    }
    public Estudiante(long i, String nom, String ape, String prog){
        ID = i;
        nombres = nom;
        apellidos = ape;
        programa = prog;
    }
    public void setID(long i){
        ID = i;
    }
    public long getID(){
        return ID;
    }
    public void setnombres(String n){
        nombres = n;
    }
    public String getnombres(){
        return nombres;
    }
    public void setapellidos(String a){
        apellidos = a;
    }
    public String getapellidos(){
        return apellidos;
    }
    public void setprograma(String p){
        programa = p;
    }
    public String getprograma(){
        return programa;
    }
  
    @Override
    public String toString(){
        String msg = new String();
        msg = "ID: " + ID + "\n" +
              "Nombre: " + nombres + "\n" +
              "Apellido: " + apellidos + "\n" +
              "Programa: " + programa + "\n";
        return msg;
    }

}
