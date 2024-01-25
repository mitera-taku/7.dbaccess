package test;

import java.sql.DriverManager;

import org.postgresql.Driver;
import org.postgresql.core.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EX005 {
    public static void main(String[] args) {
        
    
    String url= "jdbc:postgresql://localhost:5432/student";
    String user = "postgres";
    String password = "postgres";

    Connection con = null;
    PreparedStatement prtmt = null;
    String sql = null;

    try{
        con = DriverManager.getConnection(url, user, password);
        sql = "INSERT INTO employees(name,age) values('テスト太郎',19);";
        prtmt = con.prepareStatement(sql);
        int numOfUpdate = prtmt.executeUpdate();
        System.out.println(numOfUpdate + "件のデータを操作しました");
    }
    catch(SQLException ex){
        System.err.println("SQLのエラーが発生しました");
        ex.printStackTrace();
    }finally{
        try{
            if(con != null){
                con.close();
            }
            if(prtmt != null){
                prtmt.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        }
    }
}

