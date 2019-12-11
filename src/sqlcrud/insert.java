package sqlcrud;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.*;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;

public class insert {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 
    static final String DB_URL = "jdbc:mysql://localhost/bigdata";
    static final String USER = "root";
    static final String PASS = "";

    public void ins() {
        double start = System.currentTimeMillis();   
        System.out.println(start);
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            for (int x = 1; x <= 1000; ++x) {
                stmt.executeUpdate(String.format("INSERT INTO tblInsert(Column1,Column2,Column3,Column4,Column5) VALUES ('%d', '%d', '%d', '%d', '%d')", x, (x + 1), (x + 2), (x + 3), (x + 4)));
            }
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }finally{
            double stop = System.currentTimeMillis();
            System.out.println(stop);
            double timeConsumed = (stop-start)/1000;
            System.out.println("Total time consumed: " + timeConsumed);
        }
    }

    public void anotherTry() {
        double start = System.currentTimeMillis();        
        Connection conn = null;
        Statement stmt = null;
        try {
            for (int x = 1; x <= 200; ++x) {
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                stmt = conn.createStatement();
                stmt.executeUpdate(String.format("INSERT INTO tblInsert(Column1,Column2,Column3,Column4,Column5) VALUES ('%d', '%d', '%d', '%d', '%d')", x, (x + 1), (x + 2), (x + 3), (x + 4)));
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            double stop = System.currentTimeMillis();
            System.out.println(stop);
            double timeConsumed = (stop-start)/1000;
            System.out.println("Total time consumed: " + timeConsumed);
        }
    }
}
