package Main;

import Model.Admin;
import manager.ManagerStudent;
import manager.ManagerSubjects;

import java.util.Scanner;

public class MainStudent {
    static Scanner scanner = new Scanner(System.in);
    static ManagerStudent managerStudent = new ManagerStudent();
    static ManagerSubjects managerSubjects = new ManagerSubjects();


    public void mainStudent(String acc) {
        while (true) {
            System.out.println("                         STUDENT                         ");
            System.out.println("|========================================================|");
            System.out.println("|1.Đổi Mật Khẩu                                          |");
            System.out.println("|2.Đăng Ký Môn Học(Nhập tên muốn đăng kí)                |");
            System.out.println("|3.Danh Sách Môn Học                                     |");
            System.out.println("|4.Số tiền bạn phải trả cho số tín chỉ đăng kí kì này là |");
            System.out.println("|5.Hiển thị danh sách môn học kì này bạn đã đăng kí      |");
            System.out.println("|6.Xóa môn học bạn đã đăng kí                            |");
            System.out.println("|7.Đăng Xuất                                             |");
            System.out.println("|========================================================|");
            try {
                int choie = Integer.parseInt(scanner.nextLine());
                switch (choie) {
                    case 1:
                        managerStudent.changePassword();
                        break;
                    case 2:
                        managerSubjects.registerSubject(acc);
                        break;
                    case 3:
                        managerSubjects.showSubject();
                        break;
                    case 4:
                        managerSubjects.sumPrice(acc);
                        break;
                    case 5:
                        managerSubjects.showRegisteredCourses(acc);
                        break;
                    case 6:
                        managerSubjects.deleteRemove(acc);
                        break;
                    case 7:
                        return;

                }

            } catch (Exception e) {

            }
        }
    }

}
