import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectSmaple {
    public static void main(String[] args) {
        String url = "jdbc.psotgress://lacal.host:5432/student";
        String user = "postgres";
        String password = "postgres";

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = null; 

        try {
            con = DriverManager.getConnection(url,user,password);
            
        } catch (Exception e) {
            // TODO: handle exception
        }













    // }
}
