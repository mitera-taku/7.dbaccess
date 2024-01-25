package test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
// import java.sql.ResultSet;
import java.sql.SQLException;

public class EX2 {
    public static void main(String[] args) {
        String url= "jdbc:postgresql://localhost:5432/student";
        String user = "postgres";
        String password = "postgres";

        Connection con = null;
        PreparedStatement pstmt = null;
        String sql = null;

        try {
            con = DriverManager.getConnection(url, user, password);
            // sql = "INSERT INTO members(name,birth_day,gender,color_id) VALUES('大野 智','1980-11-26','男',1),('桜井 翔','1982-1-25','男',2),('相葉 雅樹','1982-12-24','男',3),('二宮 和也','1983-6-17','男',4),('松本 潤','1983-8-30','男',5);";
            sql = "create table departments (id integer,name text);";
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
