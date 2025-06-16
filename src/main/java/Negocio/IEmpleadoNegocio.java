/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Negocio;

import DTO.DTOFiltroBusqueda;
import DTO.Empleado.DTORegistrarEmpleado;
import DTO.Empleado.DTOTablaSubordinados;
import Dominio.EmpleadoDominio;
import java.util.List;

/**
 *
 * @author joel_
 */
public interface IEmpleadoNegocio {
    public EmpleadoDominio RegistrarEmpleado(DTORegistrarEmpleado empleado)throws NegocioException;
    public List<DTOTablaSubordinados> BuscarTablaDeSubordinados(DTOFiltroBusqueda filtro)throws NegocioException;
}
