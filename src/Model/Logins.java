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
public class Logins {
    Boolean loginStatus, userStatus, queryStatus;
    String Username;

    public void checkLogins(String username, String password){
        try{
            dbConnection con = new dbConnection();
            con.createConnection();
            String query = "select * from adminlogin where username=? and password=?";
            PreparedStatement pst = con.con.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            if (rs.next()){
                loginStatus = true;
            }else{
                loginStatus = false;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    } 

    public Boolean returnStatus(){
        return loginStatus;
    } 

    public void checkUser(String text){
        try{
            dbConnection con = new dbConnection();
            con.createConnection();
            String query = "select * from adminlogin where email=? or username=?";
            PreparedStatement pst = con.con.prepareStatement(query);
            pst.setString(1, text);
            pst.setString(2, text);
            ResultSet rs = pst.executeQuery();
            if (rs.next()){
                queryStatus = true;
            }else{
                queryStatus = false;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }

    public void getUsername(String text){
        try{
            dbConnection con = new dbConnection();
            con.createConnection();
            String query = "select username from adminlogin where email=? or username=?";
            PreparedStatement pst = con.con.prepareStatement(query);
            pst.setString(1, text);
            pst.setString(2, text);
            ResultSet rs = pst.executeQuery();
            if (rs.next()){
                Username = rs.getString("username");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }

    public void updateLogins(String text, String newPassword){
        checkUser(text);
        if (userStatus = true){
            try{
                dbConnection con = new dbConnection();
                con.createConnection();
                String query = "update adminlogin set password = ? where username=?";
                PreparedStatement pst = con.con.prepareStatement(query);
                pst.setString(1, newPassword);
                pst.setString(2,text);
                int i = pst.executeUpdate();
                if (i == 1){
                    userStatus = true;
                }else{
                    userStatus = false;
                }
            }catch(Exception e){
            
            }
        }
    }

    public Boolean returnUserStatus(){
        return userStatus;
    }

    public Boolean returnQueryStatus(){
        return queryStatus;
    }

    public String returnUsername(){
        return Username;
    }
}
