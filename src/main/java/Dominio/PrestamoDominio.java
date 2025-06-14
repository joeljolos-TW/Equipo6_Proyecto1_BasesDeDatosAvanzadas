/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.util.Date;

/**
 * Clase que representa a la entidad Prestamo en la base de datos del sistema
 * @author joel_
 */
public class PrestamoDominio {
    /*id INT PRIMARY KEY,
    monto DECIMAL(10,2) NOT NULL,
    comprobantePago DECIMAL(10,2) NOT NULL,
    fecha DATETIME NOT NULL,
    idTipo INT NOT NULL,
    idBancoEmpleado INT NOT NULL,
    idBancoDepartamento INT NOT NULL,
    idJefe INT NOT NULL,
    FOREIGN KEY (idTipo) REFERENCES tipos(id),
    FOREIGN KEY (idBancoEmpleado) REFERENCES cuentaEmpleado(id),
    FOREIGN KEY (idBancoDepartamento) REFERENCES cuentaDepartamento(id),
    FOREIGN KEY (idJefe) REFERENCES jefes(idEmpleado)*/
    
    private int id;
    private double monto;
    private double comprobantePago;
    private Date fechaHora;
    private int idTipo;
    private int idBancoEmpleado;
    private int idBancoDepartamento;
    private int idJefe;

    public PrestamoDominio() {
    }

    public PrestamoDominio(int id, double monto, double comprobantePago, Date fechaHora, int idTipo, int idBancoEmpleado, int idBancoDepartamento, int idJefe) {
        this.id = id;
        this.monto = monto;
        this.comprobantePago = comprobantePago;
        this.fechaHora = fechaHora;
        this.idTipo = idTipo;
        this.idBancoEmpleado = idBancoEmpleado;
        this.idBancoDepartamento = idBancoDepartamento;
        this.idJefe = idJefe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getComprobantePago() {
        return comprobantePago;
    }

    public void setComprobantePago(double comprobantePago) {
        this.comprobantePago = comprobantePago;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
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

    @Override
    public String toString() {
        return "PrestamoDominio{" + "id=" + id + ", monto=" + monto + ", comprobantePago=" + comprobantePago + ", fechaHora=" + fechaHora + ", idTipo=" + idTipo + ", idBancoEmpleado=" + idBancoEmpleado + ", idBancoDepartamento=" + idBancoDepartamento + ", idJefe=" + idJefe + '}';
    }
    
    
}
