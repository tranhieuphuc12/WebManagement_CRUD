/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;



/**
 *
 * @author Administrator
 */
public class DatabaseUntil {
    public static Connection getConnection(){
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/quan_ly_san_pham","root","");     
        } catch (Exception e) {
        }
        return con;
    }
    public static void main(String[] args) {
        System.out.println(DatabaseUntil.getConnection());
    }
}
