package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import models.Customer;

public class UserJDBC {
    public boolean insert(Customer user) {
        boolean result = false;
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/hotelmanagementsystem", "root", "");
            String sql = "INSERT INTO customers (Name,Contact,Email,Password,Address,Nationalid,Gender,DOB,Paymentmethod) VALUES (?, ?, ?, ?, ?, ?, ?,?,?)";
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1, user.getCustomerName());
            pstat.setString(2, user.getCustomerContact());
            pstat.setString(3, user.getCustomerEmail());
            pstat.setString(4, user.getCustomerPassword());
            pstat.setString(5, user.getCustomerAddress());
            pstat.setString(6, user.getCustomerNationalid());
            pstat.setString(7, user.getCustomerGender());
            pstat.setString(8, user.getCustomerDOB());
            pstat.setString(9, user.getCustomerPaymentmethod());
            int rowsAffected = pstat.executeUpdate();
            if (rowsAffected > 0) {
                result = true;
            }
        } catch (Exception ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return result;
    }

    public boolean login(Customer user) {
        //receive user info
        boolean result = false;
        try {
            //connect with db
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/hotelmanagementsystem","root", "");
            String sql = "SELECT * FROM customers WHERE Email=? and Password=?";
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1, user.getCustomerEmail());
            pstat.setString(2, user.getCustomerPassword());
            //search user in db table
            ResultSet rs = pstat.executeQuery();
            while(rs.next()) {
                result=true;
            }
            //return result
        }
        catch(Exception ex) {
            System.out.println("Error : "+ex.getMessage());
        }
        return result;
    }
}