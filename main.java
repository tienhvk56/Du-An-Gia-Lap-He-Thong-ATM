/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PhuongThucDK;
import DataAccess.ConnectDB;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Tung
 */
public class Main {
    public Main(){
        
    }
    public static void main(String[] args){
        ConnectDB con;
        try{
            con = new ConnectDB();
            if (con.open())
                System.out.println("KET NOI THANH CONG CSDL!!!");
        }catch (Exception ex){
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
