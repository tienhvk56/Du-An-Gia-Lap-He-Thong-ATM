/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PhuongThucDK;
import DataAccess.TruyCapTaiKhoan;
import thucthehethong.Taikhoan;
/**
 *
 * @author Tung
 */
//lấy các giá trị trả về trong phương thức TruyCapTaiKhoan
public class LayGiaTriTK {
    TruyCapTaiKhoan dl = null;
    public LayGiaTriTK(){
        dl = new TruyCapTaiKhoan();
    }
    public Taikhoan gettaikhoan(String TaiKhoan, String Pincode) throws Exception{
        return dl.gettaikhoan(TaiKhoan, Pincode);
    }
    public void Close(){
        dl.CloseData();
    }
}
