/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import com.mysql.cj.xdevapi.PreparableStatement;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author Ramesh
 */
public class Bill {

    public void insertBillDate(String subTotal, String customerID){
        try{
            dbConnection con = new dbConnection();
            con.createConnection();
            String query = "insert into bill (totalPrice, billDate, billTime) values (?,getDate(), getTime())";
            PreparedStatement pst = con.con.prepareStatement(query);
            pst.setString(1, subTotal);
            pst.executeQuery();
            String query2 = "insert into client_payments (ClientID, paymentAmount, bilNumber, payemntDate) values (?,?,?,getDate())";
            PreparedStatement pst2 = con.con.prepareStatement(query2);
            pst2.setString(1, customerID);
            pst2.setString(2, subTotal);
            pst2.executeQuery();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
}
