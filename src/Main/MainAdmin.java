package Main;

import manager.ManagerStudent;
import manager.ManagerSubjects;

import java.util.Scanner;

public class MainAdmin {
   static Scanner scanner= new Scanner(System.in);
   static ManagerStudent managerStudent = new ManagerStudent();
   static ManagerSubjects managerSubjects = new ManagerSubjects();


   public  void addMainAdmin(){
       try {
           while (true) {
               System.out.println("                 ADMIN                ");
               System.out.println("|=====================================|");
               System.out.println("|1. Đăng Kí Sinh Viên                 |");
               System.out.println("|2. Xoá Sinh Viên                     |");
               System.out.println("|3. Sửa sinh Viên                     |");
               System.out.println("|4. Hiển Thị Sinh Viên                |");
               System.out.println("|5. Tìm Sinh Viên                     |");
               System.out.println("|6. Thêm Môn Học                      |");
               System.out.println("|7. Sửa Môn Học                       |");
               System.out.println("|8. Xóa Môn Học                       |");
               System.out.println("|9. Hiển Thị Môn Học                  |");
               System.out.println("|10. Đăng Xuất                        |");
               System.out.println("|=====================================|");
               int choie = Integer.parseInt(scanner.nextLine());
               switch (choie) {
                   case 1:
                       managerStudent.addStudent();
                       break;
                   case 2:
                     managerStudent.deleteStudent();
                       break;
                   case 3:
                       managerStudent.editStudent();
                       break;
                   case 4:
                      managerStudent.showStudent();
                       break;
                   case 5:
                       managerStudent.searchAcc();
                       break;
                   case 6:
                       managerSubjects.addSubject();
                       break;
                   case 7:
                       managerSubjects.editSubject();
                       break;
                   case 8:
                      managerSubjects.deleteSubject();
                       break;
                   case 9:
                       managerSubjects.showSubject();
                       break;
                   case 10:
                       return;

               }
           }
       } catch (NumberFormatException e) {

       }
   }
}
