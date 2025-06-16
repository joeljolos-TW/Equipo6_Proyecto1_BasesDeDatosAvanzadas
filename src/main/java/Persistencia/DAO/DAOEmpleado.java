/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia.DAO;

import Persistencia.IConexion;
import Persistencia.PersistenciaException;
import Dominio.EmpleadoDominio;
import DTO.Empleado.DTORegistrarEmpleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author joel_
 */
public class DAOEmpleado {

    private IConexion conexion;

    public EmpleadoDominio buscarPorIdConConexion(int id, Connection conn) throws SQLException {
        String query = """
                   SELECT
                        id,
                        nombres,
                        apellidoPaterno,
                        apellidoMaterno,
                        estaActivo,
                        estaEliminado
                   FROM alumnos
                   WHERE id = ?;
                   """;
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        EmpleadoDominio empleado = null;
        if (resultSet.next()) {
            empleado = this.convertirEmpleadoDominio(resultSet);
        }

        resultSet.close();
        preparedStatement.close();

        return empleado;
    }

    private EmpleadoDominio convertirEmpleadoDominio(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String nombre = resultSet.getString("nombres");
        String apellidoPaterno = resultSet.getString("apellidoPaterno");
        String apellidoMaterno = resultSet.getString("apellidoMaterno");
        String usuario = resultSet.getString("usuario");
        String contrasena = resultSet.getString("contrasena");
        Byte estatus = resultSet.getByte("estatus");
        return new EmpleadoDominio(id, nombre, apellidoPaterno, apellidoMaterno, usuario, contrasena, estatus);
    }

    public EmpleadoDominio GuardarEmpleado(DTORegistrarEmpleado empleado) throws PersistenciaException {
    Connection conn = null;
    try {
        conn = conexion.crearConexion();
        conn.setAutoCommit(false);

        String query = """
            INSERT INTO empleados(nombre,apellidoPaterno,apellidoMaterno,usuario,contrasena,idDepartamento)
            VALUES(?,?,?,?,?,?)
        """;

        PreparedStatement psmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        psmt.setString(1, empleado.getNombre());
        psmt.setString(2, empleado.getApellidoPaterno());
        psmt.setString(3, empleado.getApellidoMaterno());
        psmt.setString(4, empleado.getUsuario());
        psmt.setString(5, empleado.getContrasena());
        psmt.setInt(6, empleado.getIdDepartamento());

        int filasAfectadas = psmt.executeUpdate();
        if (filasAfectadas == 0) {
            conn.rollback();
            throw new PersistenciaException("No se pudo registrar al empleado");
        }

        ResultSet rs = psmt.getGeneratedKeys();
        Integer idGenerado = null;
        if (rs.next()) {
            idGenerado = rs.getInt(1);
        }

        rs.close();
        psmt.close();

        if (idGenerado == null) {
            conn.rollback();
            throw new PersistenciaException("No se pudo obtener el ID del empleado guardado");
        }

        // Ahora sí puedes usar tu método buscarPorIdConConexion con ese ID
        EmpleadoDominio empleadoBuscado = this.buscarPorIdConConexion(idGenerado, conn);

        if (empleadoBuscado == null) {
            conn.rollback();
            throw new PersistenciaException("No se encontró el empleado guardado");
        }

        conn.commit();
        return empleadoBuscado;

    } catch (SQLException ex) {
        try {
            if (conn != null) {
                conn.rollback();
            }
        } catch (SQLException rollbackEx) {
            throw new PersistenciaException("Error al hacer rollback: " + rollbackEx.getMessage());
        }
        throw new PersistenciaException("Ocurrió un error al guardar el empleado: " + ex.getMessage());
    } finally {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.setAutoCommit(true);
                conn.close();
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}

}
