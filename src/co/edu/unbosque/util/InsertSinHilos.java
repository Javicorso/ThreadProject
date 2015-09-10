/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unbosque.util;

import co.edu.unbosque.model.Main;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Huber
 */
public class InsertSinHilos {
    
        public static void insert() {
        try {
            Connection conn = BDConnection.getConn();
            PreparedStatement pst = null;
            String query = "INSERT INTO TBL_HILOS(hilo,registro) VALUES(?,?)";
            pst = conn.prepareStatement(query);
            for (int i = 0; i <= 3000; i++) {
                pst.setString(1, "Hilo único");
                pst.setInt(2, i);
                pst.execute();
            }
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
