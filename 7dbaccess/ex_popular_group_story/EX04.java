import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class EX04 {
    public static void main(String[] args) {
              String url= "jdbc:postgresql://localhost:5432/student";
        String user = "postgres";
        String password = "postgres";

        Connection con = null;
        PreparedStatement pstmt = null;
        String sql = null;

        try {
            con = DriverManager.getConnection(url, user, password);
            sql = "UPDATE members SET name = '三寺 拓', birth_day = '1997-08-28', gender = '男' WHERE color_id = 1;";
            pstmt = con.prepareStatement(sql);
            int numOfUpdate = pstmt.executeUpdate();
            System.out.println(numOfUpdate + "件のデータを操作しました");
        } catch (Exception ex) {
            System.err.println("SQL = " + sql);
            ex.printStackTrace();
    }

        finally{
            try {
                if(con != null){
                    con.close();
                }
                if(pstmt != null){
                    pstmt.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
        
