/**
 * Recibe información suelta de la vista para compactarla en objetos tipo <Estudiante> 
 * segun lo requieran las utilidades que la aplicación ofrece  
 * Crear, Actualizar, Consultar, Eliminar
 */

package Modelo;
import Vista.*;
import java.util.InputMismatchException;
/**
 *
 * @author ginap
 */
public class EstudianteDTO {
    Imprimible I = new Imprimible();
    long cc;
    String n= new String();
    String a= new String();
    String p= new String();
    
    public EstudianteDTO(){
    }

    /**
     *  captura datos de los atributos del objeto <Estudiante> empaquetandolos en el objeto y lo retorna
     *  Si en el momento de capturar datos tipo long hay error, se les asigna cero
     *  @return Retorna objeto tipo <Estudiante> con todos sus atributos diligenciados 
    */
    public Estudiante crearestudianteDTO() throws InputMismatchException{
        I.mostrar_mensaje("Datos para Crear Estudiante");
        I.mostrar_mensaje("ID:");
        try{
            cc = I.capturar_enterolargo();
        }catch(InputMismatchException e){
            cc = 0;
        }
        I.mostrar_mensaje("Nombres:");
        n = I.capturar_cadena();
        n = I.capturar_cadena();
        I.mostrar_mensaje("Apellidos:");
        a = I.capturar_cadena();
        I.mostrar_mensaje("Programa:");
        p = I.capturar_cadena();
        Estudiante est = new Estudiante(cc, n,a,p);
        return est;
    }
    public Estudiante actualizarestudianteDTO()throws InputMismatchException{
        //Solo podra modificar el programa
        I.mostrar_mensaje("Datos para Actualizar Estudiante\n");
        I.mostrar_mensaje("ID:");
        try{
            cc = I.capturar_enterolargo();
        }catch(InputMismatchException e){
            cc = 0;
        }
        I.mostrar_mensaje("Programa Nuevo:");
        p = I.capturar_cadena();
        p = I.capturar_cadena();
        
        Estudiante est = new Estudiante(cc,"","",p);
        return est;
    }
    public Estudiante consultarestudianteDTO()throws InputMismatchException{
        //Solo podra modificar el programa
        I.mostrar_mensaje("Datos para Consultar Estudiante\n");
        I.mostrar_mensaje("ID:");
        try{
            cc = I.capturar_enterolargo();
        }catch(InputMismatchException e){
            cc = 0;
        }
        Estudiante est = new Estudiante(cc,"","","");
        return est;
    }
    public Estudiante eliminarestudianteDTO()throws InputMismatchException{
        //Solo podra modificar el programa
        I.mostrar_mensaje("Datos para Eliminar Estudiante\n");
        I.mostrar_mensaje("ID:");
        try{
            cc = I.capturar_enterolargo();
        }catch(InputMismatchException e){
            cc = 0;
        }
        Estudiante est = new Estudiante(cc,"","","");
        return est;
    }

}
