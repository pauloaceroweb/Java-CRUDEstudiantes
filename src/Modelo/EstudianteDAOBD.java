/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author ginap
 */
public class EstudianteDAOBD {
    private Connection connection = null;
    private ResultSet resultSet = null;
    private Statement statement = null;
    private String db= "db_estudiantes.db";    
    private String tabla="Estudiante";
    public EstudianteDAOBD(){
        String q;
        // Realiza la conexión a la Base de Datos
        try{
          Class.forName("org.sqlite.JDBC");
         connection = DriverManager.getConnection("jdbc:sqlite:" + this.db );
         System.out.println("Ya estamos Conectados a la base de datos SQLite [ " + this.db + "]");
         q = "CREATE TABLE "+tabla+ " ("+
            "ID INTEGER NOT NULL UNIQUE," +
            "nombres TEXT(50) NOT NULL," +
            "apellidos TEXT(50) NOT NULL," +
            "programa TEXT(50) NOT NULL," +
            "PRIMARY KEY(ID)" +
            ");" ;
            System.out.println("SQL Creacion Tabla ="+q);
            PreparedStatement pstm = connection.prepareStatement(q);
            pstm.execute();
            pstm.close();
            
         }catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }    
  
       
    }


public boolean crearestudianteDAOBD(Estudiante est, String table){

        boolean res=false;
        String fields = "ID,nombres,apellidos,programa";//Nombres de campos de BD
        String values = est.getID()+",'"+est.getnombres()+"','"+est.getapellidos()+"','"+est.getprograma()+"'";
        //Se arma la consulta
        String q="INSERT INTO " + table + " (" + fields + ") VALUES (" + values + ");";
        System.out.println("SQL-CREAR:"+q);
        //se ejecuta la consulta
        try {
            PreparedStatement pstm = connection.prepareStatement(q);
            pstm.execute();
            pstm.close();
            res=true;
         }catch(SQLException e){
            System.out.println(e);
        }
      return res;
    }
 public Estudiante consultarestudianteDAOBD(Estudiante est, String table){

 
     boolean existe = false;
   // String q= "SELECT * FROM "+table+" WHERE correoinst='"+ est.getcorreoinst()+"';";
    String q= "SELECT * FROM "+table+" WHERE ID="+ est.getID()+";";
    System.out.println("SQL Consulta="+q);
    try {
      statement = connection.createStatement();
      resultSet = statement.executeQuery(q);
      //if (resultSet.next())
      while (resultSet.next())
      { 
        est.setID(resultSet.getLong("ID")); 
        est.setnombres(resultSet.getString("nombres")); 
        est.setapellidos(resultSet.getString("apellidos")); 
        est.setprograma(resultSet.getString("programa")); 
        existe = true;
      }
      if (existe == false)
        est = null;
    }catch (SQLException ex) {
        System.out.println(ex);
        est = null;
     }
    return est;
 }
 public boolean actualizarestudianteDAOBD(Estudiante est, String table){
    //    String fields = "correoper='"+est.getcorreoper()+"',"+"cel="+est.getcel()+","+"fijo="+est.getfijo()+","+"programa='"+est.getprograma()+"'";
    //    String condicion = "correoinst='"+est.getcorreoinst()+"'";
        String fields = "programa='"+est.getprograma()+"'";
        String condicion = "ID="+est.getID();
        Estudiante e1 = new Estudiante();    
        boolean res=false;
        //Se arma la consulta
        String q="UPDATE " + table + " SET "+ fields + " WHERE " + condicion+";" ;
        System.out.println("SQL ACTUALIZAR="+q);
        //se ejecuta la consulta
        e1 = consultarestudianteDAOBD(est, table);
        if (e1 != null)
         try {
            PreparedStatement pstm = connection.prepareStatement(q);
            pstm.execute();
            pstm.close();
            res=true;
         }catch(SQLException e){
            System.out.println(e);
        }
      return res;
    }   
 public boolean eliminarestudianteDAOBD(Estudiante est, String table){

        Estudiante e1 = new Estudiante();
        boolean res=false, prueba;
        //Se arma la consulta
        String condicion = "ID="+est.getID();
        String q="DELETE FROM " + table + " WHERE " + condicion+";";
        System.out.println("SQL ELIMINAR="+q);
     

        //se ejecuta la consulta
        e1 = consultarestudianteDAOBD(est, table);
        if (e1 != null)
            
        try {
            PreparedStatement pstm = connection.prepareStatement(q);
            prueba=pstm.execute();
            
            pstm.close();
            System.out.println("retorno de execute="+ prueba);
            res=true;
         }catch(SQLException e){
            System.out.println(e);
        }
      return res;
    }   
public Estudiante consultarposestudianteDAOBD(int pos, String table){
 
    int i=0;
    Estudiante est = new Estudiante();
    String q= "SELECT * FROM "+table+";";
    try {
      statement = connection.createStatement();
      resultSet = statement.executeQuery(q);
      while (resultSet.next())
      {
        est.setID(resultSet.getLong("ID")); 
        est.setnombres(resultSet.getString("nombres")); 
        est.setapellidos(resultSet.getString("apellidos")); 
        est.setprograma(resultSet.getString("programa")); 
        i++;
        if (i == pos)
            break;
      }
     }
     catch (SQLException ex) {
        System.out.println(ex);
     }
    if ( i== pos)
        return est;
    else
        return null;
 }
public void desconectar()
    {
        try {
            resultSet.close();
            statement.close();
            connection.close();
            System.out.println("Desconectado de la base de datos [ " + this.db + "]");
        }
        catch (SQLException ex) {
            System.out.println(ex);
        }
    }

}


