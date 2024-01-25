package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDao {
    private static final String TABLE_NAME = "Departments";

    public List<Department> findById(int id){
        Connection con = DBManager.createConnection();


        String sql = "select id, name from " + TABLE_NAME+
        " where id = ?";

        try{
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            List<Department> departmentlist = new ArrayList<>();

            while(rs.next()){
                Department department = new Department();
                department.setId(rs.getInt("id"));
                department.setName(rs.getString("name"));
                departmentlist.add(department);
            }
            return departmentlist;
        }catch(SQLException ex){
            System.err.println("SQL = " + sql);
            throw new RuntimeException("findBy処理に失敗しました",ex);
        }finally{
            DBManager.closeConnection(con);
        }
    
    }

    public void delete(int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    public Department load(int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'load'");
    }


}




// public Department load(int id){//キーとなる数字を読んでいる
//     Connection con = DBManager2.createConnection();

//     String sql = "select id, name  from "+
//     TABLE_NAME + " WHERE id = ?";

//     try{
//         PreparedStatement pstmt = con.prepareStatement(sql);
//         pstmt.setInt(1, id);
//         ResultSet rs = pstmt.executeQuery();

//         if(rs.next()){
//             Department department = new Department();
//             department.setId(rs.getInt("id"));
//             department.setName(rs.getString("name"));
//             return department;
//         }
//         return null;
//     }catch(SQLException ex){
//         System.err.println("SQL = " + sql);
//         throw new RuntimeException();
//     }finally{
//         DBManager2.closeConnection(con);
//     }
// }
