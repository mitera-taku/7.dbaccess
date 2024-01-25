package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EX04Department {
    private static final String TABLE_NAME = "Departments";
    public Department load(int id){
    

   

    public int update(Department department){
        Connection con = DBManager.createConnection();

        String sql = "update " + TABLE_NAME+ " set id=?, name = ?" ;

        try{
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, department.getId());
            pstmt.setString(2, department.getName());
            int affected = pstmt.executeUpdate();
            return affected;
        }catch(SQLException ex){
            System.err.println("SQL = " + sql);
            throw new RuntimeException("update処理に失敗しました",ex);
        }finally{
            DBManager.closeConnection(con);
        }
}
}
}
