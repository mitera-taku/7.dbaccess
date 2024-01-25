package test;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;

import org.postgresql.Driver;

import java.sql.PreparedStatement;

public class EXextra {
    public static void main(String[] args) {
        String url= "jdbc:postgresql://localhost:5432/student";
        String user = "postgres";
        String password = "postgres";

        Connection con = null;
        String sql = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        
        try{
            con = DriverManager.getConnection(url, user, password);
            sql = "select * from members;";
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.print("id = " + id);
                System.out.print("name = " + name);
                System.out.println();
            }
        }catch(SQLException ex){
            System.err.println("SQLにエラーが発生しました");
            System.err.println("SQL = 「" + sql + "」");
            ex.printStackTrace();
        }finally{
        try{
            if(con != null){
                con.close();
            }
            if(rs != null){
                rs.close();
            }
            if(pstmt != null){
                pstmt.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        }
        }
    }
        
    

