package test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JEX02 {
    public static void main(String[] args) {
          String url= "jdbc:postgresql://localhost:5432/student";
        String user = "postgres";
        String password = "postgres";

        Connection con = null;
        PreparedStatement pstmt = null;
        String sql = null;

        try {
            con = DriverManager.getConnection(url, user, password);
            sql = "INSERT INTO colors(id,name)" +
             "VALUES(1,'blue'),"+
             "(2,'red'),(3,'green'),"+
             "(4,'yellow'),(5,'purple'),(6,'orange');";
            
            pstmt = con.prepareStatement(sql);
            int numOfUpdate = pstmt.executeUpdate();
            System.out.println(numOfUpdate + "件のデータを操作しました");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(con != null){
                    con.close();
                }
                if(pstmt != null){
                    pstmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                // TODO: handle exception
            }

        }

    }
}
