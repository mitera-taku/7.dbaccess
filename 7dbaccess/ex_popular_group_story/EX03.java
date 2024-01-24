import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EX03 {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/student";
        String user = "postgres";
        String password = "postgres";

        Connection con = null;
        PreparedStatement pstmt = null;
        String sql = null;
        ResultSet rs = null;

        try{
            con = DriverManager.getConnection(url,user,password);
            sql = "SELECT name, birth_day,gender,color_id FROM members ORDER BY color_id;";
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while(rs.next()){
                String name = rs.getString("name");
                java.sql.Date birth_day = rs.getDate("birth_day");
                String gender = rs.getString("gender");
                int color_id = rs.getInt("color_id");

                System.out.print("name = " + name + " ");
                System.out.print("birth_day = " + birth_day + " ");
                System.out.print("gender = " + gender + " ");
                System.out.print("color_id = " + color_id + " ");
                System.out.println();
            }
        }catch(Exception ex){
            System.err.println("SQL関連の例外が発生しました");
            System.err.println("発生したSQLは「"+ sql + "」");
            ex.printStackTrace();
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
            } catch (Exception e) {
                e.printStackTrace();
    }
}
    }
}