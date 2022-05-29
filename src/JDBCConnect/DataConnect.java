package JDBCConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class DataConnect {
    private static Connection connection = null;
    public static Connection openConnect() throws ClassNotFoundException, SQLException {
            //String dbURL1="jdbc:ucanaccess://D:\\QLNV.accdb";
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QuanLyCuaHang;integratedSecurity=true;characterEncoding=UTF-8");
            return connection;
    }
    public static void closeConnect() throws SQLException{
        connection.close();
    }
}
