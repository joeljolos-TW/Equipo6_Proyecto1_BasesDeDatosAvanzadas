/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fachada;

import DTO.DTOFiltroBusqueda;
import DTO.Empleado.DTORegistrarEmpleado;
import DTO.Empleado.DTOTablaSubordinados;
import Dominio.EmpleadoDominio;
import Negocio.EmpleadoNegocio;
import Negocio.IEmpleadoNegocio;
import Negocio.NegocioException;
import Persistencia.Conexion;
import Persistencia.DAO.DAOEmpleado;
import Persistencia.DAO.IDAOEmpleado;
import Persistencia.IConexion;
import java.util.List;

/**
 *
 * @author joel_
 */
public class Fachada implements IFachada {

    private IEmpleadoNegocio empleadoNegocio;

    public Fachada() {
        IConexion conexion = new Conexion();
        IDAOEmpleado empleado = new DAOEmpleado(conexion);
        this.empleadoNegocio = new EmpleadoNegocio(empleado);
    }
    
    

    @Override
    public EmpleadoDominio RegistrarEmpleado(DTORegistrarEmpleado empleado) throws NegocioException {
        EmpleadoDominio empleadoRegistrado = this.empleadoNegocio.RegistrarEmpleado(empleado);
        return empleadoRegistrado;
    }

    @Override
    public List<DTOTablaSubordinados> BuscarTablaDeSubordinados(DTOFiltroBusqueda filtro) throws NegocioException {
        List<DTOTablaSubordinados> subordinados = this.empleadoNegocio.BuscarTablaDeSubordinados(filtro);
        return subordinados;
    }

    @Override
    public EmpleadoDominio buscarPorCredenciales(String usuario, String contrasena) throws NegocioException {
        EmpleadoDominio credencial = this.empleadoNegocio.buscarPorCredenciales(usuario, contrasena);
        return credencial;
    }

}
