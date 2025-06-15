    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Clase que representa a la entidad Abono en la base de datos del sistema
 * @author joel_
 */
public class AbonoDominio {
    /*id INT PRIMARY KEY,
    monto DECIMAL(10,2) NOT NULL,
    fechaHora DATETIME NOT NULL,
    idPrestamo INT NOT NULL*/
    
    private int id;
    private BigDecimal monto;
    private LocalDateTime fechaHora;
    private int idPrestamo;

    public AbonoDominio() {
    }

    public AbonoDominio(int id, BigDecimal monto, LocalDateTime fechaHora, int idPrestamo) {
        this.id = id;
        this.monto = monto;
        this.fechaHora = fechaHora;
        this.idPrestamo = idPrestamo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "AbonoDominio{" + "id=" + id + ", monto=" + monto + ", fechaHora=" + fechaHora + ", idPrestamo=" + idPrestamo + '}';
    }
    
    
}
