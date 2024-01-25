package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao{
    public static final String TABLE_NAME = "employees";

                public List<Employee> findByDepartmentId(int department_id){

                    Connection con = DBManager.createConnection();//接続情報
                    String sql = "select id,name,age,gender,department_id from "+
                    TABLE_NAME + " where department_id = ?";
                
                try{
                    PreparedStatement pstmt = con.prepareStatement(sql);

                    pstmt.setInt(1, department_id);
                    ResultSet rs = pstmt.executeQuery();

                    List<Employee> employeelist = new ArrayList<>();

                    while(rs.next()){
                         Employee employee = new Employee();
                         employee.setId(rs.getInt("id"));
                         employee.setName(rs.getString("name"));
                         employee.setAge(rs.getInt("age"));
                         employee.setGender(rs.getString("gender"));
                         employee.setDepartmentId(rs.getInt("department_id"));
                         employeelist.add(employee);
                    }
                    return employeelist;//Entityのリストを返す
                }catch(SQLException ex){
                     System.err.println("SQL = " + sql);
                     throw new RuntimeException("findByDepartmentId処理に失敗しました",ex);
                }finally{
                    DBManager.closeConnection(con);//切断
                }
         }
}

// public class EmployeeDao {
//     private static final String  TABLE_NAME = "employees";//テーブル名
    // public Employee load(int id){
        // Connection con = DBManager.createConnection();

        // String sql = "select id, name, age, gender, department_id from "+
        //  TABLE_NAME + " where id = ?";
//         try {
//             PreparedStatement pstmt = con.prepareStatement(sql);
//             pstmt.setInt(1, id);//ここで？に数字をセット
//             ResultSet rs = pstmt.executeQuery();

//             if (rs.next()) {
//                 Employee employee = new Employee();
//                 employee.setId(rs.getInt("id"));
//                 employee.setName(rs.getString("name"));
//                 employee.setAge(rs.getInt("age"));
//                 employee.setGender(rs.getString("gender"));
//                 employee.setDepartmentId(rs.getString("department_id"));
//                 return employee;
//             }
//             return null;
//         } catch (Exception ex) {
//             // Exception handling code
//             System.out.println("SQL = " + sql);
//             throw new RuntimeException("load1処理に失敗しました",ex);
//         }
          
//          finally{
//             DBManager.closeConnection(con);//切断
//          }
//     }

// }
