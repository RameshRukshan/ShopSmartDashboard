/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sun.security.rsa.RSACore;

/**
 *
 * @author umesh
 */
public class Inventry 
{
   public void insertInventryData(String prodID,String stocks,String inventryStatus )
    {
        try{
            dbConnection con = new dbConnection();
            con.createConnection();
            String query = "update inventry set stocks=? and inventryStatus=? where prodID=?";
            PreparedStatement psta = con.con.prepareStatement(query);
            
            psta.setString(1,stocks);
            psta.setString(2,inventryStatus);
            psta.setString(3,prodID);
           
            psta.executeUpdate();       
        }
        catch(Exception e)
        {
          JOptionPane.showMessageDialog(null,e);
        } 
    }
}
