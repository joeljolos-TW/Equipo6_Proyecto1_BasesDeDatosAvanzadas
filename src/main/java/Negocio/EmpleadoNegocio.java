/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;
import DTO.DTOFiltroBusqueda;
import DTO.Empleado.DTORegistrarEmpleado;
import DTO.Empleado.DTOTablaSubordinados;
import Dominio.EmpleadoDominio;
import Persistencia.DAO.IDAOEmpleado;
import Persistencia.PersistenciaException;
import java.util.List;
/**
 *
 * @author joel_
 */
public class EmpleadoNegocio implements IEmpleadoNegocio{
    private IDAOEmpleado DAOEmpleado;
    @Override
    public EmpleadoDominio RegistrarEmpleado(DTORegistrarEmpleado empleado)throws NegocioException{
        
        try {
            this.existeNombre(empleado);
            this.existeParametroNulo(empleado);
            EmpleadoDominio empleadoRegistrado = this.DAOEmpleado.RegistrarEmpleado(empleado);
            return empleadoRegistrado;
        } catch (PersistenciaException e) {
            e.printStackTrace();
            throw new NegocioException("el empleado no puede ser Registrado");
        }
    }
    
    private void existeParametroNulo(DTORegistrarEmpleado empleado)throws NegocioException{
        if (empleado == null){
            throw new NegocioException("El Parametro es nulo");
        }
    }
    
    private void existeNombre(DTORegistrarEmpleado empleado)throws NegocioException{
        if(empleado.getNombre()==null || empleado.getNombre().trim().length()==0){
            throw new NegocioException("El nombre no es permitido");
        }
    }
    
    public List<DTOTablaSubordinados> BuscarTablaDeSubordinados(DTOFiltroBusqueda filtro)throws NegocioException{
        try {
            
            List<DTOTablaSubordinados> tablaAux=this.DAOEmpleado.BuscarTablaDeSubordinados(filtro);
            estaVacia(tablaAux);
            return tablaAux;
        } catch (PersistenciaException e) {
            throw new NegocioException("La lista de almunos está vacia");
        }
    }
    
    private void estaVacia(List<DTOTablaSubordinados>tabla)throws NegocioException{
        if(tabla.isEmpty()){
            throw new NegocioException("La Lista de alumnos está vacia");
        }
    }
}
