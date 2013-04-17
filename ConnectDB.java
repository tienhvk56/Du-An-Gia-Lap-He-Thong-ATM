/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;
import java.sql.*;
import java.sql.DriverManager;
import java.beans.Statement;
import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Tung
 */
public class ConnectDB {
    private PreparedStatement pre = null;
    private Connection con = null;
    private Statement stat = null;
    private ResultSet rs = null;
    public ConnectDB() throws Exception{
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }catch (ClassNotFoundException ex){
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ConnectDB(String Driver) throws Exception {
         Class.forName(Driver);
    }
    public boolean open() throws Exception {
        boolean temp = false;
        try{
            String userName = "root";
            String password = "123456";
            String url = "jdbc:mysql://127.0.0.1:3306/csdl";
// String url = "jdbc:mysql://localhost:3306/test";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(url,userName,password);
            //System.out.println("DA KET NOI CSDL ");
            temp = true;
        }
        catch (Exception e){
            System.err.println ("KHONG KET NOI DUOC");
            e.printStackTrace();
            temp = false;
        }
        return temp;
    }
    public void close() throws Exception {
            if (rs != null) {
                rs.close();
            }
            if (pre != null){
                pre.close();
            }
            if (con != null){
                con = null;
            }
    }
    /*public ResultSet doQuery(String sql) throws SQLException {
        stat = con.createStatement();
        rs = stat.executeQuery(sql);
        return rs;
    }*/
}
    

