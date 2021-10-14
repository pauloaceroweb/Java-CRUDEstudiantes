/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crudestudiantebd;
import Modelo.*;
import Vista.*;
import java.util.ArrayList;
/**
 *
 * @author ginap
 */
public class CRUDEstudiantebd {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int opc,i;
        ArrayList <Estudiante> Lista = new ArrayList <Estudiante>(); 
        Imprimible I = new Imprimible();
        EstudianteDTO DTO = new EstudianteDTO();
        EstudianteDAOBD DAOBD = new EstudianteDAOBD();
       // DAOBinario DAOB = new DAOBinario();
        String datos_est = new String();
        Estudiante e1 = new Estudiante();
        String Tabla="Estudiante";
        //SQLite_conexion fbc = new SQLite_conexion();
        do{
            opc = I.menu();
            switch(opc){
                case 1://Crear Estudiante
                        e1= DTO.crearestudianteDTO();
                        if (DAOBD.crearestudianteDAOBD(e1, Tabla)==true)
                            I.mostrar_mensaje("Se creó el estudiante!!");
                        else
                            I.mostrar_mensaje("Ya existe un estudiante con ese ID!");
                        break;
                case 2: e1 = DTO.consultarestudianteDTO();
                        e1 = DAOBD.consultarestudianteDAOBD(e1, Tabla);
                        if (e1 == null)
                            I.mostrar_mensaje("No existe un estudiante con ese ID!");
                        else
                            I.mostrar_mensaje(e1.toString());
                        break;
                case 3: e1= DTO.actualizarestudianteDTO();
                        if (DAOBD.actualizarestudianteDAOBD(e1, Tabla)==true)
                            I.mostrar_mensaje("Se actualizó el estudiante!!");
                        else
                            I.mostrar_mensaje("No existe un estudiante con ese ID!");
                        break;
                case 4: e1= DTO.eliminarestudianteDTO();
                        if (DAOBD.eliminarestudianteDAOBD(e1, Tabla)==true)
                            I.mostrar_mensaje("Se eliminó el estudiante!!");
                        else
                            I.mostrar_mensaje("No existe un estudiante con ese ID!");
                        break;
                case 5: i = 1; //Arreglar el 5
                        while (true){
                            e1 = DAOBD.consultarposestudianteDAOBD(i++, Tabla);
                            if (e1 != null)
                                I.mostrar_mensaje(e1.toString());
                            else
                                break;
                        }
                        break;
            }
        }while(opc != 6);
        DAOBD.desconectar();
    }

}
