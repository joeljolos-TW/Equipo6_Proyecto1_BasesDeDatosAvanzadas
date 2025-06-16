/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia.DAO;

import DTO.DTOFiltroBusqueda;
import Persistencia.IConexion;
import Persistencia.PersistenciaException;
import Dominio.EmpleadoDominio;
import DTO.Empleado.DTORegistrarEmpleado;
import DTO.Empleado.DTOTablaSubordinados;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author joel_
 */
public class DAOEmpleado implements IDAOEmpleado {

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

    @Override
    public EmpleadoDominio RegistrarEmpleado(DTORegistrarEmpleado empleado) throws PersistenciaException {
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

    private DTOTablaSubordinados convertirTablaSubordinadosDTO(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String nombre = resultSet.getString("nombre");
        String apellidoPaterno = resultSet.getString("apellidoPaterno");
        String apellidoMaterno = resultSet.getString("apellidoMaterno");
        String usuario = resultSet.getString("usuario");
        byte estatus = resultSet.getByte("estatus");
        return new DTOTablaSubordinados(id, nombre, apellidoPaterno, apellidoMaterno, usuario, estatus);
    }

    @Override
    public List<DTOTablaSubordinados> BuscarTablaDeSubordinados(DTOFiltroBusqueda filtro)throws PersistenciaException{
        List<DTOTablaSubordinados> subordinados = new ArrayList<>();
        String query = """
        SELECT 
            A.nombre,
            A.apellidoPaterno,
            A.apellidoMaterno,
            A.usuario
        FROM empleados AS A
        INNER JOIN subordinados AS B ON A.id = B.idEmpleado
        WHERE A.estatus = 1
        LIMIT ?
        OFFSET ?;
    """;

        try (Connection conn = conexion.crearConexion(); PreparedStatement psmt = conn.prepareStatement(query)) {

            psmt.setInt(1, filtro.getLimit());
            psmt.setInt(2, filtro.getOffset());

            try (ResultSet rs = psmt.executeQuery()) {
                while (rs.next()) {
                    subordinados.add(this.convertirTablaSubordinadosDTO(rs));
                }
            }

        } catch (SQLException e) {
            // Aquí deberías lanzar una excepción personalizada o registrar el error
            e.printStackTrace();
            throw new PersistenciaException("Error al consultar subordinados: " + e.getMessage());
        }

        return subordinados;
    }

}
