/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unbosque.model;

import co.edu.unbosque.util.InsertConHilos;
import co.edu.unbosque.util.InsertConHilosBatch;

/**
 *
 * @author Huber
 */
public class Main {

    public static void main(String[] args) {
        long time_start, time_end;
        
        InsertConHilosBatch hilo1 = new InsertConHilosBatch();
        InsertConHilosBatch hilo2 = new InsertConHilosBatch();
        InsertConHilosBatch hilo3 = new InsertConHilosBatch();
        
        time_start = System.currentTimeMillis();
        hilo1.setName("Batch_2-0");
        hilo2.setName("Batch_2-1");
        hilo3.setName("Batch_2-2");
        hilo1.start();
        hilo2.start();
        hilo3.start();
        time_end = System.currentTimeMillis();
        System.out.println("the task has taken "+ ( time_end - time_start ) +" milliseconds");

    }
    
}
