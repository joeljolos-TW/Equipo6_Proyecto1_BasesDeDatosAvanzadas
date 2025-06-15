/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO.Abono;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @author joel_
 */
public class DTOregistrarAbono {
    private BigDecimal monto;
    private LocalDateTime fechaHora;
    private int idPrestamo;

    public DTOregistrarAbono() {
    }

    public DTOregistrarAbono(BigDecimal monto, LocalDateTime fechaHora, int idPrestamo) {
        this.monto = monto;
        this.fechaHora = fechaHora;
        this.idPrestamo = idPrestamo;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    @Override
    public String toString() {
        return "DTOregistrarAbono{" + "monto=" + monto + ", fechaHora=" + fechaHora + ", idPrestamo=" + idPrestamo + '}';
    }
    
    
}
