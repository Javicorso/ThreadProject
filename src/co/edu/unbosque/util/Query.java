/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unbosque.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Huber
 */
public class Query {

    public static void main(String[] args) {
        selectCount();
        //selectLast();
        //delete();
    }

    public static void selectCount() {
        Connection conn = BDConnection.getConn();
        String query = "SELECT COUNT(hilo) as total FROM TBL_HILOS";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println("Total de registros: " + rs.getString("total"));
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void selectLast() {
        Connection conn = BDConnection.getConn();
        String query = "SELECT hilo,registro FROM TBL_HILOS LIMIT 6100 ";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println("Registro: " + rs.getString("hilo") + " -- " + rs.getString("registro"));
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void deleteAll() {
        Connection conn = BDConnection.getConn();
        String query = "DELETE FROM TBL_HILOS";
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(query);
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void delete() {
        Connection conn = BDConnection.getConn();
        String query = "DELETE FROM TBL_HILOS WHERE hilo LIKE '%Batch%'";
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(query);
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
