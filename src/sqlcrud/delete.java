
package sqlcrud;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.*;

public class delete {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/bigdata";
    static final String USER = "root";
    static final String PASS = "";
    
    public void deleteData(){
        double start = System.currentTimeMillis();  
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            for (int x = 1; x <= 1000; ++x) {
                stmt.executeUpdate(String.format("DELETE FROM tblInsert WHERE id='%s'", x));
            }
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }finally{
            double stop = System.currentTimeMillis();
            System.out.println(stop);
            double timeConsumed = (stop-start)/1000;
            System.out.println("Total time consumed: " + timeConsumed + " seconds");
        }
    }
    
    public void delete(){
        double start = System.currentTimeMillis();  
        Connection conn = null;
        Statement stmt = null;
        try {
            for (int x = 1; x <= 200; ++x) {
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                stmt = conn.createStatement();
                stmt.executeUpdate(String.format("DELETE FROM tblInsert WHERE id='%s'", x));
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            double stop = System.currentTimeMillis();
            System.out.println(stop);
            double timeConsumed = (stop-start)/1000;
            System.out.println("Total time consumed: " + timeConsumed + " seconds");
        }
    }
}
