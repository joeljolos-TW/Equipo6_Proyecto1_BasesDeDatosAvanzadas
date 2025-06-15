/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO.Prestamo;

import java.time.LocalDateTime;

/**
 *
 * @author joel_
 */
public class DTOAutorizarPrestamo {
    private int idPrestamo;       // El préstamo a autorizar o rechazar
    private int idEstatus;        // El nuevo estatus (por ejemplo, 2 = Autorizado, 3 = Rechazado)
    private int idJefe;           // El jefe que lo autoriza o rechaza
    private LocalDateTime fechaHora; // Momento de la decisión

    public DTOAutorizarPrestamo() {
    }

    public DTOAutorizarPrestamo(int idPrestamo, int idEstatus, int idJefe, LocalDateTime fechaHora) {
        this.idPrestamo = idPrestamo;
        this.idEstatus = idEstatus;
        this.idJefe = idJefe;
        this.fechaHora = fechaHora;
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public int getIdEstatus() {
        return idEstatus;
    }

    public void setIdEstatus(int idEstatus) {
        this.idEstatus = idEstatus;
    }

    public int getIdJefe() {
        return idJefe;
    }

    public void setIdJefe(int idJefe) {
        this.idJefe = idJefe;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    @Override
    public String toString() {
        return "DTOAutorizarPrestamo{" + "idPrestamo=" + idPrestamo + ", idEstatus=" + idEstatus + ", idJefe=" + idJefe + ", fechaHora=" + fechaHora + '}';
    }
    
    
}
