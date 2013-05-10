/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;
import thucthehethong.Taikhoan;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Tung
 */
public class TruyCapTaiKhoan {
    ConnectDB con = null;
    ResultSet rs = null;
    Statement stat = null;
    Vector vec = null;
    String sql;
    //kết nối database
    public TruyCapTaiKhoan() {
        try {
            con = new ConnectDB();
            con.open();
        }catch (Exception ex){
            Logger.getLogger(TruyCapTaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    public Taikhoan gettaikhoan(String TaiKhoan, String Pincode) throws Exception{
        String sql="Select * From Taikhoan Where TaiKhoan='"+TaiKhoan+"' and Pincode='"+Pincode+"'";
        Taikhoan tk=null;
        //lấy giữ liệu từ csdl
        try{
            rs=con.executeQuery(sql);
            while (rs.next()){
                tk = new Taikhoan();
                tk.setTaikhoanID(rs.getString(1));
                tk.setTaiKhoan(rs.getString(2));
                tk.setPinCode(rs.getString(3));
                tk.setHoTen(rs.getString(4));
            }
        }
        catch(SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tk;
    }
    public void CloseData(){
        try {
            con.close();
        }catch (Exception e){
            //Logger.getLogger(Taikhoan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
