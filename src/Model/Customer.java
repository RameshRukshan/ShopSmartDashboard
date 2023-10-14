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
 * @author Ramesh
 */
public class Customer extends View.VCustomers {
    
    public Boolean queryStatus;
    public String Name ,CID ,email,tel ,NIC, address;
    public String tbData[];

    public void insertCustomerData(String title, String fName, String lName, String email, String tel, String nic, String address){
        try{
            dbConnection con = new dbConnection();
            con.createConnection();
            String query = "insert into customer (title, first_name, last_name, email, tel, nic, address) values (?,?,?,?,?,?,?)";
            PreparedStatement pst = con.con.prepareStatement(query);
            pst.setString(1, title);
            pst.setString(2, fName);
            pst.setString(3, lName);
            pst.setString(4, email);
            pst.setString(5, tel);
            pst.setString(6, nic);
            pst.setString(7,address);
            int i = pst.executeUpdate();
            if (i == 1){
                queryStatus = true;
            }else{
                queryStatus = false;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }

    public void searchUsers(String nameOrClientId){
        try{
            dbConnection con = new dbConnection();
            con.createConnection();
            String query = "select * from customer where first_name = ? OR last_name = ? OR cID = ?";
            PreparedStatement pst = con.con.prepareStatement(query);
            pst.setString(1, nameOrClientId);
            pst.setString(2, nameOrClientId);
            pst.setString(3, nameOrClientId);
            ResultSet rs = pst.executeQuery();
            if (rs.next()){
                queryStatus = true;
                Name = rs.getString("title")+ " " + rs.getString("first_name") + " " + rs.getString("last_name");
                CID = rs.getString("cID");
                email = rs.getString("email");
                tel = rs.getString("tel");
                NIC = rs.getString("nic");
                address = rs.getString("address");
            }else{
                queryStatus = false;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }

    public void fetchDatatoTable(){
        try{
            dbConnection con = new dbConnection();
            con.createConnection();
            String query = "select * from customer";
            PreparedStatement pst = con.con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                CID = rs.getString("cID");
                Name = rs.getString("title")+ " " + rs.getString("first_name") + " " + rs.getString("last_name");
                email = rs.getString("email");
                tel = rs.getString("tel");
                NIC = rs.getString("nic");

                String tbData[] = {CID,Name,tel,email,NIC};

                DefaultTableModel tblModel = (DefaultTableModel)tbl_customerData.getModel();
                tblModel.addRow(tbData);
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }

    public void deleteCustomer(String cId){
        try{
            dbConnection con = new dbConnection();
            con.createConnection();
            String query = "delete from customer where cID = ?";
            PreparedStatement pst = con.con.prepareStatement(query);
            pst.setString(1, cId);
            int i = pst.executeUpdate();
            if (i == 1){
                queryStatus = true;
            }else{
                queryStatus = false;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }

    public String[] returnTBLData(){
        return tbData;
    }


    public Boolean returnQueryStatus(){
        return queryStatus; 
    }
}
