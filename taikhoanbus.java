/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PhuongThucDK;
import DataAccess.DLtaikhoan;
import thucthehethong.Taikhoan;
/**
 *
 * @author Tung
 */
public class taikhoanbus {
    DLtaikhoan dl = null;
    public taikhoanbus(){
        dl = new DLtaikhoan();
    }
    public Taikhoan gettaikhoan(String TaiKhoan, String Pincode){
        return dl.gettaikhoan(TaiKhoan, Pincode);
    }
    public void Close(){
        dl.CloseData();
    }
}
