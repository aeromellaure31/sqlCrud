
package sqlcrud;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.*;

public class retrieve {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/bigdata";
    static final String USER = "root";
    static final String PASS = "";
    
    public void retrieveData(){
        double start = System.currentTimeMillis();  
        Connection conn = null;
        Statement stmt = null;
        float col1 = 0;
        float col2 = 0;
        float col3 = 0;
        float col4 = 0;
        float col5 = 0;
        try {
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
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }finally{
            double stop = System.currentTimeMillis();
            System.out.println(stop);
            double timeConsumed = (stop-start)/1000;
            System.out.println("Total time consumed: " + timeConsumed + " seconds");
        }
    }
    
    public void retrieve(){
        double start = System.currentTimeMillis();  
        Connection conn = null;
        Statement stmt = null;
        String data = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet rsAccount = stmt.executeQuery(String.format("SELECT AVG(Column1), AVG(Column2), AVG(Column3), AVG(Column4), AVG(Column5) FROM tblInsert"));
            rsAccount.next();
            System.out.println(rsAccount.getFloat("AVG(Column1)"));
            System.out.println(rsAccount.getFloat("AVG(Column2)"));
            System.out.println(rsAccount.getFloat("AVG(Column3)"));
            System.out.println(rsAccount.getFloat("AVG(Column4)"));
            System.out.println(rsAccount.getFloat("AVG(Column5)"));
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        finally{
            double stop = System.currentTimeMillis();
            System.out.println(stop);
            double timeConsumed = (stop-start)/1000;
            System.out.println("Total time consumed: " + timeConsumed + " seconds");
        }
    }
}
