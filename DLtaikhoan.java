/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;
import thucthehethong.Taikhoan;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Tung
 */
public class DLtaikhoan {
    private ConnectDB con = null;
    private ResultSet rs = null;
    private Vector vec = null;
    public DLtaikhoan() {
        try {
            con = new ConnectDB();
            con.open();
        }catch (Exception ex){
            Logger.getLogger(DLtaikhoan.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    public Taikhoan gettaikhoan(String TaiKhoan, String Pincode){
        String sql="Select * From taikhoan Where Username='"+TaiKhoan+"' and Password='"+Pincode+"'";
        Taikhoan tk=null;
        try{
            rs=con.doQuery(sql);
            while (rs.next()){
                tk = new Taikhoan();
                tk.setTaikhoanID(rs.getInt(1));
                tk.setTaiKhoan(rs.getString(2));
                tk.setPinCode(rs.getString(3));
                tk.setHoTen(rs.getString(4));
            }
        }catch(SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tk;
    }
    public void CloseData(){
        try {
            con.close();
        }catch (Exception ex){
            Logger.getLogger(Taikhoan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
