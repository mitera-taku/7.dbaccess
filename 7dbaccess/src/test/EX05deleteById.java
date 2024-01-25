package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class EX05deleteById {
    private static String TABLE_NAME;

    public static void deleteById(int id){
        Connection con = DBManager.createConnection();
        String sql = "DELETE FROM" + TABLE_NAME + "WHERE id = ?";
        try{
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            int affected = pstmt.executeUpdate();
            return;
    }
    catch(SQLException ex){
        System.err.println("SQL = " + sql);
        throw new RuntimeException("delete処理に失敗しました",ex);
    }finally{
        DBManager.closeConnection(con);
    }
}
}
