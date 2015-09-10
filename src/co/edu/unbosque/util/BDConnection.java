/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unbosque.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Huber
 */
public class BDConnection {

    private static final String driver = "org.postgresql.Driver";
    private static final String connectString = "jdbc:postgresql://aretico.com:5432/software_2?searchpath=grupo6";
    private static final String user = "grupo6";
    private static final String password = "YckGwYC8r3";
    private static Connection con;
    private static BDConnection instance = new BDConnection();

    
    public static Connection getConn() {
        if (instance == null) {
            System.out.println(instance);
            instance = new BDConnection();
        }
        return BDConnection.con;
    }

    private BDConnection() {
        try {
            Class.forName(driver);
            this.con = DriverManager.getConnection(connectString, user,
                    password);
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException(contruyendoConexion)  : " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("SQLException(contruyendoConexion) : " + e.getMessage());
        } catch (Exception e) {
            System.out.println(" Exception General (contruyendoConexion) : " + e.getMessage());
        }
    }
}
