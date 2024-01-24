import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EX01 {
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
            sql = "SELECT id, name FROM departments ORDER BY id;";
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
  
                System.out.print("id = " +  id + " ");
                System.out.print("name = " + name + " ");

                System.out.println();
            }
        } catch (SQLException ex) {
            System.err.println("SQL関連の例外が発生しました");
            System.err.println("発生したSQLは「"+ sql + "」");
            ex.printStackTrace();//発生したエラーの情報を表示する
            // TODO: handle exception
        }finally{
            try {
                if(rs != null){
                    rs.close();
                }
                if(pstmt != null){
                    pstmt.close();
                }
                if(con != null){
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                // TODO: handle exception
            }
        }
    }
}
