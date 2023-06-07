package manager;

import Main.MainAdmin;
import Model.Admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MannagerAdmin {
    Scanner scanner = new Scanner(System.in);
    List<Admin> adminList = new ArrayList<>();
    static MainAdmin mainAdmin = new MainAdmin();

// Khởi tạo đối tượng admin bằng gán cứng
    public  void  addAmin(){
        Admin admin = new Admin("admin","admin123");
        adminList.add(admin);
    }
// Đăng nhập admin
    public  void  loginAdmin(){
        addAmin();
        System.out.println("Nhập tài khoản");
        String Acc = scanner.nextLine();
        if (checkAcc(Acc)){
            System.out.println("Nhập mật khẩu");
            String Pass = scanner.nextLine();
            if (checkPass(Pass)){
                System.out.println("Đăng nhập thành công");
                mainAdmin.addMainAdmin();
            }else {
                System.out.println("Đăng nhập thất bại");
            }
        }else {
            System.out.println("Tài khoản không đúng");
        }
    }
// Check tài khoản
    public  boolean checkAcc(String acc){
        for (int i = 0; i<adminList.size();i++){
            if (acc.equals(adminList.get(i).getAcc())){
                return  true;
            }
        }
        return  false;
    }
// Check mật khẩu
    public  boolean checkPass(String pass){
        for (int i= 0; i<adminList.size();i++){
            if (adminList.get(i).getPass().equals(pass)){
                return  true;
            }
        }
        return false;
    }
}
