/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia.DAO;
import Persistencia.IConexion;
import Persistencia.PersistenciaException;
import Dominio.EmpleadoDominio;
import java.sql.Connection;
/**
 *
 * @author joel_
 */
import java.sql.SQLException;
public class DAOEmpleado {
    private IConexion conexion;
    
    public EmpleadoDominio GuardarEmpleado() throws PersistenciaException{
        
        try(Connection conn = conexion.crearConexion()){
            
            //En construccion
            String query="""
                         INSERT INTO empleados()
                         """;
            
        }catch(SQLException e){
            e.printStackTrace();
            throw new PersistenciaException("El Empleado a guardar no es valido");
        }
        return null;
    }
}
