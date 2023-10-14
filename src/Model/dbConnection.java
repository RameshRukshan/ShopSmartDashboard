/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Ramesh
 */
public class dbConnection {
    public Connection con;

    public Connection createConnection(){
        try{
            String mydbpath = "jdbc:mysql://localhost/dbtest";
            con = DriverManager.getConnection(mydbpath,"root","");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return con;
    }
}
