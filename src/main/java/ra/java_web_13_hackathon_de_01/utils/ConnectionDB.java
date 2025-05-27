package ra.java_web_13_hackathon_de_01.utils;

import java.sql.CallableStatement;
import java.sql.Connection;

public class ConnectionDB {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/product_management";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    public static Connection openConnection(Connection conn) {
        try {
            Class.forName(DRIVER);
            conn = java.sql.DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeConnection(Connection conn, CallableStatement cs) {
        try {
            if (cs != null) {
                cs.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
