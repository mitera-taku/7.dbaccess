package test;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {//基本的な接続を行うメソッド
    private final static String url= "jdbc:postgresql://localhost:5432/student";
    private final static String user = "postgres";
    private final static String password = "postgres";

    public static Connection createConnection(){
        try{
            Connection con = DriverManager.getConnection(url, user, password);
            return con; //ここで接続情報を返している
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException("DBの接続に失敗しました",e);
            //接続がうまくいかなかった時のエラーを返す
        }
    }
     public static void closeConnection(Connection con){
        try{
            if(con != null){
                con.close();
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException("DBの接続に失敗会いました",e);
        }
     }
}
