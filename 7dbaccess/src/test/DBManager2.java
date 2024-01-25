package test;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager2 {
    private final static String url= "jdbc:postgresql://localhost:5432/student";
    private final static String user = "postgres";
    private final static String password = "postgres";

    public static Connection createConnection(){
        try{
            Connection con = DriverManager.getConnection(url, user, password);
            return con;
        }
        catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException("DBの接続に失敗しました",e);
        }
    }

        public static void closeConnection(Connection con){
            try{
                if(con != null){
                    con.close();
                }
            }catch(Exception ex){
                ex.printStackTrace();
                throw new RuntimeException("DBの切断に失敗",ex);
            }
        }
    }

