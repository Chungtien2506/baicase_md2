package manager;

import IO.WriteAndRead;
import Main.MainStudent;
import Model.Student;
import Model.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerStudent {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Student> studentsList = (ArrayList<Student>) WriteAndRead.read();


    static MainStudent mainStudent = new MainStudent();
    WriteAndRead writeAndRead = new WriteAndRead();
// Thêm  sinh viên và khi thêm  sinh viên thì tạo cho sinh viên 1 tài khoản
    public void addStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên tài khoản");
        String acc = scanner.nextLine();

        // Kiểm tra tên tài khoản đã tồn tại trong danh sách sinh viên hay chưa
        boolean isDuplicateAcc = false;
        for (Student student : studentsList) {
            if (student.getAcc().equals(acc)) {
                isDuplicateAcc = true;
                break;
            }
        }

        while (isDuplicateAcc) {
            System.out.println("Tên tài khoản đã tồn tại. Vui lòng nhập lại tên tài khoản");
            acc = scanner.nextLine();

            // Kiểm tra lại tên tài khoản mới
            isDuplicateAcc = false;
            for (Student student : studentsList) {
                if (student.getAcc().equals(acc)) {
                    isDuplicateAcc = true;
                    break;
                }
            }
        }

        do {
            System.out.println("Nhập mật khẩu");
            String pass = scanner.nextLine();
            if (pass.length() > 6) {
                System.out.println("Nhập tên");
                String name = scanner.nextLine();
                System.out.println("Nhập tuổi");
                int age = Integer.parseInt(scanner.nextLine());
                System.out.println("Nhập giới tính");
                String sex = scanner.nextLine();
                System.out.println("Nhập quê");
                String address = scanner.nextLine();
                System.out.println("Đăng kí thành công");
                List<Subject> saveSubjects = new ArrayList<>();
                Student student = new Student(acc, pass, name, age, sex, address, saveSubjects);
                studentsList.add(student);
                WriteAndRead.write(studentsList);
                break;
            } else {
                System.out.println("Mật khẩu phải lớn hơn 6 ký tự");
            }
        } while (true);
    }



// Đăng nhập sinh viên

    public void loginStudent() {
        System.out.println("Nhập tài khoản");
        String acc = scanner.nextLine();
        if (checkAcc(acc)) {
            System.out.println("Nhâp Mật Khẩu");
            String pass = scanner.nextLine();
            if (checkPass(pass)) {
                System.out.println("Đăng Nhập Thành Công ");
                mainStudent.mainStudent(acc);
            } else {
                System.out.println("Đăng Nhập Thất Bại");
            }
        } else {
            System.out.println("Tài Khoản Không Tồn Tại");
        }

    }
// Check tài khoản của sinh viên
    public boolean checkAcc(String acc) {
        for (Student st : studentsList){
            if (st.getAcc().equals(acc)){
                return true;
            }
        }
        return false;
    }
// Check mật khaảu của sinh viên
    public boolean checkPass(String pass) {
        for (Student st : studentsList){
            if (st.getPass().equals(pass)){
                return true;
            }
        }
        return false;
    }
// Check tài khoải để đổi mật khẩu
    public int check(String acconut) {
        for (int i = 0; i < studentsList.size(); i++) {
            if (studentsList.get(i).getAcc().equals(acconut)) {
                return i;
            }
        }
        return -1;
    }
// Đổi mật khẩu
    public void changePassword() {
        System.out.println("Nhập Tài Khoản ");
        String acount = scanner.nextLine();

        if (check(acount) == -1) {
            System.out.println("Không Tìm Ra Tài Khoản ");
        } else {
            int index = check(acount);
            System.out.println("Nhập Mật Khẩu Cũ ");
            String pass = scanner.nextLine();
            if (checkPass(pass)) {
                System.out.println("Nhập Pass Mới ");
                String newPass = scanner.nextLine();
                studentsList.get(index).setPass(newPass);
                System.out.println("Đổi Mật Khẩu Thành Công ");
                WriteAndRead.write(studentsList);

            } else {
                System.out.println("Sai Mật Khẩu Cũ");
            }
        }
    }
// Xóa Sinh viên
    public void deleteStudent() {
        System.out.println("Nhập Tài Khoản Muốn Xóa ");
        String acount = scanner.nextLine();
        if (check(acount) == -1) {
            System.out.println("Không Tìm Ra Tài Khoản ");
        } else {
            int index = check(acount);
            studentsList.remove(index);
            System.out.println("Xóa Thành Công ");
            WriteAndRead.write(studentsList);
        }
    }
// Hiển thị sinh viên
    public void showStudent() {
        for (int i = 0; i < studentsList.size(); i++) {
            System.out.println(studentsList.get(i).toString() );
        }
    }
// Tìm kiếm sinh viên
    public void searchAcc() {
        System.out.println("Nhập Tài Khoản Muốn Tìm ");
        String acount = scanner.nextLine();
        if (check(acount) == -1) {
            System.out.println("Tài Khoản Không Tồn Tại ");
        } else {
            int index = check(acount);
            System.out.println("Tài Khoản Bạn Muốn Có Thông Tin Là : ");
            System.out.println(studentsList.get(index).toString());
        }
    }
// Sửa sinh viên
    public void editStudent() {
        System.out.println("Nhập Account Muốn Sửa ");
        String accout = scanner.nextLine();
        if (check(accout) == -1) {
            System.out.println("Tài Khoản Không Tồn Tại ");
        } else {
            int index = check(accout);
            System.out.println("Bạn Muốn Sửa Gì");
            System.out.println("1. Sửa Tên");
            System.out.println("2. Sửa Tuổi");
            System.out.println("3.Sửa giới Tính ");
            System.out.println("4.Sửa quê ");
            System.out.println("5. Thoát ");
            int choie = Integer.parseInt(scanner.nextLine());
            switch (choie) {
                case 1:
                    System.out.println("Nhập Tên Muốn Thay Đổi ");
                    String newName = scanner.nextLine();
                    studentsList.get(index).setName(newName);
                    System.out.println("Thành Công ");
                    WriteAndRead.write(studentsList);
                    break;
                case 2:
                    System.out.println("Nhập Tuổi Muốn Thay Đổi ");
                    int newage = Integer.parseInt(scanner.nextLine());
                    studentsList.get(index).setAge(newage);
                    System.out.println("Thành Công ");
                    WriteAndRead.write(studentsList);
                    break;
                case 3:
                    System.out.println("Nhập giới Tính Muốn Thay Đổi ");
                    String newsex = scanner.nextLine();
                    studentsList.get(index).setSex(newsex);
                    System.out.println("Thành Công ");
                    WriteAndRead.write(studentsList);
                    break;
                case 4:
                    System.out.println("Nhập quê Muốn Thay Đổi ");
                    String newaddress = scanner.nextLine();
                    studentsList.get(index).setSex(newaddress);
                    System.out.println("Thành Công ");
                    WriteAndRead.write(studentsList);
                    break;
                case 5:
                    return;

            }

        }
    }


}