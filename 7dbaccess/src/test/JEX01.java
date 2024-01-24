package test;
// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.PreparedStatement;

// public class JEX01 {
//     public static void main(String[] args) {
//         String url= "jdbc:postgresql://localhost:5432/student";
//         String user = "postgres";
//         String password = "postgres";

//         Connection con = null;
//         PreparedStatement pstmt = null;
//         String sql = null;

//         try {
//             con = DriverManager.getConnection(url, user, password);
//             sql = "DROP TABLE IF EXISTS colors;" +
//                 "CREATE TABLE colors(" +
//                 "id INTEGER PRIMARY KEY," +
//                 "name text " +
//                 ");" +
//                 "CREATE TABLE members(" +
//                 "id serial primary key," +
//                 "name text not null," +
//                 "birth_day date," +
//                 "gender varchar(1),"+ 
//                 "color_id integer REFERENCES colors (id))";
//             pstmt = con.prepareStatement(sql);
//             int numOfUpdate = pstmt.executeUpdate();
//             System.out.println(numOfUpdate + "件のデータを操作しました");
//         } catch (Exception ex) {
//             System.err.println("SQL = " + sql);
//             ex.printStackTrace();
//     }

//         finally{
//             try {
//                 if(con != null){
//                     con.close();
//                 }
//                 if(pstmt != null){
//                     pstmt.close();
//                 }
//             } catch (Exception e) {
//                 e.printStackTrace();
//             }
//         }
//     }
// }


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JEX01 {

	public static void main(String[] args) {

		String url = "jdbc:postgresql://localhost:5432/student";
		String user = "postgres";
		String password = "postgres";

		Connection con = null;
		PreparedStatement pstmt = null;

		StringBuilder sql = new StringBuilder();
		sql.append("CREATE TABLE colors (");
		sql.append("id integer primary key,");
		sql.append("name text);");
		sql.append("CREATE TABLE members(");
		sql.append("id serial primary key,");
		sql.append("name text not null,");
		sql.append("birth_day date,");
		sql.append("gender varchar(1),");
		sql.append("color_id integer REFERENCES colors (id))");

		try {
			con = DriverManager.getConnection(url, user, password);

			pstmt = con.prepareStatement(sql.toString());

			pstmt.executeUpdate();

			System.out.println("成功しました。");

		} catch (SQLException e) {
			System.err.println("SQLExeptionが発生しました。" + sql);
			e.printStackTrace();
		} finally {
			// (6) メモリの解放(切断)
			try {
				if (con != null) {
					con.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}

