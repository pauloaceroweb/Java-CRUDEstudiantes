/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;
import java.util.Scanner;
/**
 *
 * @author ginap
 */
public class Imprimible {
    int msg_default;
    static Scanner leer = new Scanner(System.in);
    public Imprimible(){
    }
    
    public void mostrar_mensaje(String mensaje){
        System.out.println(mensaje);
    }

     public int capturar_entero(){
        
        return (leer.nextInt());
    }
    public void mostrar_entero(int N){
        System.out.print(N);
    }
    
    public void mostrar_enterolargo(long N){
        System.out.print(N);
    }
    
    public long capturar_enterolargo(){       
        return (leer.nextLong());
    }
    
    public char capturar_caracter(){
        
        return (leer.next().charAt(0));
    }
    public void mostrar_caracter(char N){
        System.out.print(N);
    }
    public String capturar_cadena(){
        
        return (leer.nextLine());
    }
    public int menu(){
        int opcion;
        mostrar_mensaje("MENU\n"+
        "1. Crear Estudiante\n"+
        "2. Consultar Estudiante\n"+ 
        "3. Actualizar Estudiante\n"+
        "4. Eliminar Estudiante\n"+
        "5. Listar Estudiantes\n"+
        "6. Salir\n"+
        "Digite la Opción:");
        opcion = capturar_entero();
        return opcion;
    }
    
    

}
