/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author joel_
 */
public interface IConexion {
    public Connection crearConexion()throws SQLException;
}
