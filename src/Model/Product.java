/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Ramesh
 */
public class Product {

    Boolean queryStatus;
    public String Name ,PID ,price ,description, stockStatus, stocoCount;

    public void insertProduct(String pName, String price, String description, String inventry){
        try{
            dbConnection con = new dbConnection();
            con.createConnection();
            String query = "insert into product (ProductName, price, description) values (?,?,?)";
            PreparedStatement pst = con.con.prepareStatement(query);
            pst.setString(1, pName);
            pst.setString(2, price);
            pst.setString(3, description);
            int i = pst.executeUpdate();
            if (i == 1){
                queryStatus = true;
            }else{
                queryStatus = false;
            }
            searchProduct(pName);
            query = "insert into inventry (prodID,stocks,inventryStatus) values (?,?,?)";
            pst = con.con.prepareStatement(query);
            pst.setString(1, PID);
            pst.setString(2, inventry);
            String status;
            if (Integer.parseInt(inventry) <= 5){
                status = "Low Stocks";
            }else if (Integer.parseInt(inventry) == 0){
                status = "Out Of Stocks";            
            }else{
                status = "In Stocks";            
            }
            pst.setString(3, status);
            i = pst.executeUpdate();
            if (i == 1){
                queryStatus = true;
            }else{
                queryStatus = false;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }

    public void searchStocks(){
        try{
            dbConnection con = new dbConnection();
            con.createConnection();
            String query = "select * from inventry  where prodID = ?";
            PreparedStatement pst = con.con.prepareStatement(query);
            pst.setString(1, PID);
            ResultSet rs = pst.executeQuery();
            if (rs.next()){
                stockStatus = rs.getString("inventryStatus");
                stocoCount = rs.getString("stocks");
            }else{
                queryStatus = false;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }

    }

    public void searchProduct(String nameOrId){
        try{
            dbConnection con = new dbConnection();
            con.createConnection();
            String query = "select * from product where pID = ? OR ProductName = ?";
            PreparedStatement pst = con.con.prepareStatement(query);
            pst.setString(1, nameOrId);
            pst.setString(2, nameOrId);
            ResultSet rs = pst.executeQuery();
            if (rs.next()){
                queryStatus = true;
                Name = rs.getString("ProductName");
                PID = rs.getString("pID");
                price = rs.getString("price");
                description = rs.getString("description");
            }else{
                queryStatus = false;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }

    public void deleteProduct(String prodId){
        try{
            dbConnection con = new dbConnection();
            con.createConnection();
            String query = "delete from product where pID = ?";
            PreparedStatement pst = con.con.prepareStatement(query);
            pst.setString(1, prodId);
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

    public Boolean returnQueryStatus(){
        return queryStatus;
    }
}
