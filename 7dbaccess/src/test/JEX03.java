package test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JEX03 {
    
// try{
//     con = DriverManager.getConnection(url,user,password);
//     sql = "SELECT m.name, m.birth_day, m.gender, m.color_id, c.color_name FROM members m INNER JOIN colors c ON m.color_id = c.id;";
//     pstmt = con.prepareStatement(sql);
//     rs = pstmt.executeQuery();

//     while(rs.next()){
//         String name = rs.getString("name");
//         java.sql.Date birth_day = rs.getDate("birth_day");
//         String gender = rs.getString("gender");
//         int color_id = rs.getInt("color_id");
//         String color_name = rs.getString("color_name");

//         System.out.print("name = " + name + " ");
//         System.out.print("birth_day = " + birth_day + " ");
//         System.out.print("gender = " + gender + " ");
//         System.out.print("color_id = " + color_id + " ");
//         System.out.print("color_name = " + color_name + " ");
//         System.out.println();
//     }
// }catch(Exception ex){
//     System.err.println("SQL関連の例外が発生しました");
//     System.err.println("発生したSQLは「"+ sql + "」");
//     ex.printStackTrace();
// }finally{
//     try {
//         if(rs != null){
//                                 rs.close();
//                             }
//                             if(pstmt != null){
//                                 pstmt.close();
//                             }
//                             if(con != null){
//                                 con.close();
//                             }
//                         } catch (Exception e) {
//                             e.printStackTrace();
//                 }
//             }
//                 }
//             }
            



    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/student";
        String user = "postgres";
        String password = "postgres";

        Connection con = null;
        PreparedStatement pstmt = null;
        String sql =  "SELECT m.id m_id, m.name m_name, m.birth_day m_birth_day, m.gender m_gender, c.name c_name FROM members m INNER JOIN colors c ON m.color_id = c.id";
        ResultSet rs = null;

        try{
            con = DriverManager.getConnection(url,user,password);
            // sql = "SELECT m.name, m.birth_day, m.gender, m.color_id, c.color_name FROM members m INNER JOIN colors c ON m.color_id = c.id;";
            
            pstmt = con.prepareStatement(sql.toString());
            rs = pstmt.executeQuery();

            while(rs.next()){
                String name = rs.getString("m_name");
                String birth_day = rs.getString("m_birth_day");
                String gender = rs.getString("m_gender");
                String color_name = rs.getString("c_color_name");
                System.out.println(name + "\t" + birth_day + "\t" + gender + "\t" + color_name);

                // System.out.print("name = " + name + " ");
                // System.out.print("birth_day = " + birth_day + " ");
                // System.out.print("gender = " + gender + " ");
                // System.out.print("color_name = " + color_name + " ");
                // System.out.println();
            }
        }catch(SQLException ex){
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
            } catch (SQLException e) {
                e.printStackTrace();
    }
}
    }
}
