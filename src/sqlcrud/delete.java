
package sqlcrud;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class delete {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/bigdata";
    static final String USER = "root";
    static final String PASS = "";
    
    public void deleteData(){
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss.SSS");
        Connection conn = null;
        Statement stmt = null;
        Date oldTime = null;
        Date stop = null;
        try {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
            String dateStart = sdf.format(date);
            System.out.println("Time Started: " + sdf.format(date));
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            for (int x = 1; x <= 1000; ++x) {
                stmt.executeUpdate(String.format("DELETE FROM tblInsert WHERE id='%s'", x));
            }
            conn.close();
            Date stopDate = new Date();
            SimpleDateFormat newFormat = new SimpleDateFormat("HH:mm:ss.SSS");
            String dateStop = newFormat.format(stopDate);
            System.out.println("Time Stop: " + newFormat.format(stopDate));
            try {
                oldTime = format.parse(dateStart);
                stop = format.parse(dateStop);
                long diff = stop.getTime() - oldTime.getTime();
                long diffSeconds = diff / 1000 % 60;
                long diffMinutes = diff / (60 * 1000) % 60;
                long diffHours = diff / (60 * 60 * 1000) % 24;
                System.out.print("Total time consumed: " + diffHours + " hours, ");
                System.out.print(diffMinutes + " minutes, ");
                System.out.println(diffSeconds + " seconds.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void delete(){
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss.SSS");
        Connection conn = null;
        Statement stmt = null;
        Date oldTime = null;
        Date stop = null;
        try {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
            String dateStart = sdf.format(date);
            System.out.println("Time Started: " + sdf.format(date));
            for (int x = 1; x <= 200; ++x) {
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                stmt = conn.createStatement();
                stmt.executeUpdate(String.format("DELETE FROM tblInsert WHERE id='%s'", x));
                conn.close();
            }
            Date stopDate = new Date();
            SimpleDateFormat newFormat = new SimpleDateFormat("HH:mm:ss.SSS");
            String dateStop = newFormat.format(stopDate);
            System.out.println("Time Stop: " + newFormat.format(stopDate));
            try {
                oldTime = format.parse(dateStart);
                stop = format.parse(dateStop);
                long diff = stop.getTime() - oldTime.getTime();
                long diffSeconds = diff / 1000 % 60;
                long diffMinutes = diff / (60 * 1000) % 60;
                long diffHours = diff / (60 * 60 * 1000) % 24;
                System.out.print("Total time consumed: " + diffHours + " hours, ");
                System.out.print(diffMinutes + " minutes, ");
                System.out.println(diffSeconds + " seconds.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}