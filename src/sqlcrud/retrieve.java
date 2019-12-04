
package sqlcrud;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class retrieve {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/bigdata";
    static final String USER = "root";
    static final String PASS = "";
    
    public void retrieveData(){
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss.SSS");
        Connection conn = null;
        Statement stmt = null;
        Date oldTime = null;
        Date stop = null;
        String data = null;
        float col1 = 0;
        float col2 = 0;
        float col3 = 0;
        float col4 = 0;
        float col5 = 0;
        try {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
            String dateStart = sdf.format(date);
            System.out.println("Time Started: " + sdf.format(date));
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            for (int x = 1; x <= 1000; ++x) {
                ResultSet rs = stmt.executeQuery(String.format("SELECT Column1,Column2,Column3,Column4,Column5 FROM tblInsert WHERE id='%s'", x));
                rs.next();
                col1 += rs.getFloat("Column1");
                col2 += rs.getFloat("Column2");
                col3 += rs.getFloat("Column3");
                col4 += rs.getFloat("Column4");
                col5 += rs.getFloat("Column5");
            }
            System.out.println(col1 / 1000);
            System.out.println(col2 / 1000);
            System.out.println(col3 / 1000);
            System.out.println(col4 / 1000);
            System.out.println(col5 / 1000);
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
    
    public void retrieve(){
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss.SSS");
        Connection conn = null;
        Statement stmt = null;
        Date oldTime = null;
        Date stop = null;
        String data = null;
        try {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
            String dateStart = sdf.format(date);
            System.out.println("Time Started: " + sdf.format(date));
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet rsAccount = stmt.executeQuery(String.format("SELECT AVG(Column1) FROM tblInsert"));
            rsAccount.next();
            System.out.println(rsAccount.getFloat("AVG(Column1)"));
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
}
