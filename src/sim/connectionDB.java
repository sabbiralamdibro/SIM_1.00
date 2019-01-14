
package sim;



import java.sql.*;
/**
 *
 * @author SAM
 */
public class connectionDB {

       public static Connection connection_DB() {
        Connection con = null;
        try {
//            con= DriverManager.getConnection("jdbc:mysql://localhost/?student_ms=root&password=sabbir");
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_ms", "root", "123");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
    
}
