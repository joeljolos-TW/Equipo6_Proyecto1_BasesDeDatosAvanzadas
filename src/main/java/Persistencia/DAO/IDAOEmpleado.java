/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia.DAO;

import DTO.DTOFiltroBusqueda;
import DTO.Empleado.DTORegistrarEmpleado;
import DTO.Empleado.DTOTablaSubordinados;
import Dominio.EmpleadoDominio;
import Persistencia.PersistenciaException;
import java.util.List;

/**
 *
 * @author joel_
 */
public interface IDAOEmpleado {
    public EmpleadoDominio RegistrarEmpleado(DTORegistrarEmpleado empleado) throws PersistenciaException;
    public List<DTOTablaSubordinados> BuscarTablaDeSubordinados(DTOFiltroBusqueda filtro) throws PersistenciaException;
}
