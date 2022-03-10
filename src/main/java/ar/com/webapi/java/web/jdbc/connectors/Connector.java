package ar.com.webapi.java.web.jdbc.connectors;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {
    private static String driver="org.mariadb.jdbc.Driver";
    private static String url="jdbc:mariadb://localhost/negocioWeb";
    private static String user="root";
    private static String pass="";
    private static Connection conn=null;
    private Connector(){}
    
    public synchronized static Connection getConnection(){
        try {
            if(conn==null || conn.isClosed()){
                Class.forName(driver);
                conn=DriverManager.getConnection(url, user, pass);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }
}