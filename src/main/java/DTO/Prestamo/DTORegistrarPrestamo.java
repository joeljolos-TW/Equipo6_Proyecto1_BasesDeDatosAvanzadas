/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO.Prestamo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @author joel_
 */
public class DTORegistrarPrestamo {
    private BigDecimal monto;
    private LocalDateTime fecha; // se puede poner LocalDate.now() si se genera automáticamente
    private int idTipo;
    private int idBancoEmpleado;
    private int idBancoDepartamento;
    private int idJefe;

    public DTORegistrarPrestamo() {
    }

    public DTORegistrarPrestamo(BigDecimal monto, LocalDateTime fecha, int idTipo, int idBancoEmpleado, int idBancoDepartamento, int idJefe) {
        this.monto = monto;
        this.fecha = fecha;
        this.idTipo = idTipo;
        this.idBancoEmpleado = idBancoEmpleado;
        this.idBancoDepartamento = idBancoDepartamento;
        this.idJefe = idJefe;
    }

    
    
    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public int getIdBancoEmpleado() {
        return idBancoEmpleado;
    }

    public void setIdBancoEmpleado(int idBancoEmpleado) {
        this.idBancoEmpleado = idBancoEmpleado;
    }

    public int getIdBancoDepartamento() {
        return idBancoDepartamento;
    }

    public void setIdBancoDepartamento(int idBancoDepartamento) {
        this.idBancoDepartamento = idBancoDepartamento;
    }

    public int getIdJefe() {
        return idJefe;
    }

    public void setIdJefe(int idJefe) {
        this.idJefe = idJefe;
    }
    
    
}
