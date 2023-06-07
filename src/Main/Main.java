package Main;

import manager.ManagerStudent;
import manager.MannagerAdmin;

import java.util.Scanner;

public class Main {
 static    Scanner scanner = new Scanner(System.in);
   static MannagerAdmin mannagerAdmin = new MannagerAdmin();
    static  ManagerStudent managerStudent = new ManagerStudent();

    public static void main(String[] args) {
        while (true){
            System.out.println("| ======== MENU========== |");
            System.out.println("|1.Đăng Nhập Admin        |");
            System.out.println("|2.Đăng Nhập Student      |");
            System.out.println("|3.Thoát                  |");
            System.out.println("|=========================|");
            int choie= Integer.parseInt(scanner.nextLine());
            switch (choie){
                case 1:
//                    mannagerAdmin.addAmin();
                    mannagerAdmin.loginAdmin();
                    break;
                case 2:
                    managerStudent.loginStudent();
                    break;
                case 3:
                    System.exit(3);
                    break;
            }
        }
    }
}
