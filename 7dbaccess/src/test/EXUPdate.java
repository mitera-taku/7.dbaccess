package test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
// import java.sql.SQLException;

public class EXUPdate {
    public static void main(String[] args) {
        String url= "jdbc:postgresql://localhost:5432/student";//単純に打ち間違えに注意する
        String user = "postgres";
        String password = "postgres";

        Connection con = null;
        String sql = null;
        PreparedStatement pstmt = null;

        try{
            con = DriverManager.getConnection(url,user,password);
            sql = "update members set name = '田中太郎', age = 21 from members where name ='伊賀将之';";
            int numOfUpdate = pstmt.executeUpdate();
            System.out.println(numOfUpdate + "件のデータを変更しました");
            }catch(SQLException ex){
                System.err.println("SQLに以上が発生しました");
                System.err.println("SQL =" + sql);
                ex.printStackTrace();
            }finally{
                try{
                    if(con != null){
                        con.close();
                    }
                    if(pstmt != null){
                        pstmt.close();
                    }
                }catch (SQLException e) {
                        e.printStackTrace();
                        // TODO: handle exception
                    }
                }
            }
    }
}
