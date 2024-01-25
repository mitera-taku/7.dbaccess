package test;

import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ex02MemberDao {
    private static final String TABLE_NAME = "members";

    public member load(int id){//主キーを条件に検索する
        Connection con = DBManager.createConnection();
        String sql = "select id,name,birth_day,gender,color_id from "+ TABLE_NAME + " where id = ?";

        try{
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if(rs.next()){
                Member member = new Member();
                member.setId(rs.getInt("id"));
                member.setName(rs.getString("name"));
                member.setBirth_day(rs.getjava.sql.Date("birth_day"));
                member.setId(rs.getInt("id"));
                return member;
            }
            return null;//もしも何もなかった時にはnullを返す
        }catch (SQLException e){//失敗した際に失敗したコードを表す
            System.err.println("SQL = " + sql);
            throw new RuntimeException("loadに失敗しました");
        }
        finally{//データベースから切る
            DBManager.closeConnection(con);

    }
}
}
    public List<member>findById(int id){//複数の返答を待つとき、ArrayListを使用し、複数返せるようにする
        Connection con = DBManager.createConnection();//接続を行う
        String sql = "select id,name,birth_day,gender,color_id from "+ TABLE_NAME + " where id = ?";
        try{
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();//結果を表示する

            List<Member>membersList = new ArrayList<>();

            while (rs.next()) {
                member.setId(rs.getInt("id"));
                member.setName(rs.getString("name"));
                member.setBirth_day(rs.getDate("birth_day"));
                member.setGender(rs.getString("gender"));
                member.setColor_id(rs .getInt("color_id"));
                membersList.add(member);
                return membersList;
            }catch(SQLException ex){
                System.err.println("SQL = " + sql);
                throw new RuntimeException("検索処理を実行しました");
            }finally{
                DBManager.closeConnection(con);
            }
        
    }

    public int insert(Member member){
        Connection con = DBManager.createConnection();
        String sql ="insert into " + TABLE_NAME + " (name,birth_day,gender,color_id)"+
        "values(? ,?, ?, ?)";
        try{
            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setString(1, member.getName());//?のところに値をセットする
            pstmt.setDate(2, member.getDate());
            pstmt.setString(3, member.getGender());
            pstmt.setInt(4, member.getColor_id());

            int affected  pstmt.executeUpdate();
            return affected;
        }catch(SQLException ex){
            System.err.print("SQL = " + sql);
            throw new RuntimeException("insert処理に失敗しました");
        }finally{
            DBManager.closeConnection(con);
        }
    }

    public int update(Member member){
        Connnection con = DBManager.createConnection();
        String sql = "update " + TABLE_NAME + " set name = ? ,birth_bay = ?,gender = ?,color_id = ?";
        try{
            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setString(1,member.getname());
            pstmt.setDate(2,member.getBirth_day());
            pstmt.setString(3,member.getGender());
            pstmt.setInt(4,member.getColor_id());
            int affected = pstmt.executeUpdate();
            return affected;
        }catch(SQLException ex){
            System.err.println("SQL = " + sql);
            throw new RuntimeException("update処理に失敗しました");
        }finally{
            DBManager.closeConnection(con);

        }
    }

    public int deleteByid(int id){
        Connnection con = DBManager.createConnection();
        String sql = "delete from " + TABLE_NAME + " where id = ?";

        try{
            PreparedStatement pstmt = DBManager.prepareStatement(sql);
            pstmt.setInt(1,id);
            int affected = pstmt.executeUpdate();
            return affected;
        }catch(SQLException ex){
            System.err.println("SQL = " + sql);
            throw new RuntimeException();
        }finally{
            DBManager.closeConnection(con);
        }
    }
}

