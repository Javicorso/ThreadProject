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
public class InsertConHilos extends Thread{
    
        @Override
        public void run() {
        try {
            Connection conn = BDConnection.getConn();
            PreparedStatement pst = null;
            long s = System.currentTimeMillis();
            for (int i = 1; i <= 1000; i++) {
                String query = "INSERT INTO TBL_HILOS(hilo,registro) VALUES(?,?)";
                pst = conn.prepareStatement(query);
                pst.setString(1, this.getName());
                pst.setInt(2, i);
                pst.execute();
            }
            System.out.println( "Tiempo de ejecución " + this.getName() + ": "  + (System.currentTimeMillis() - s) + " ms. "  );


        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
