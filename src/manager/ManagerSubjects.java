package manager;

import IO.WriteAndRead;
import IO.WriteAndReadSubject;
import Model.Student;
import Model.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerSubjects extends ManagerStudent {
    Scanner scanner = new Scanner(System.in);
    static List<Student> students = new ArrayList<>();
    static ArrayList<Subject> subjectsList = (ArrayList<Subject>) WriteAndReadSubject.read();
// Thêm môn học
    public void addSubject() {
        System.out.println("Nhập số tín chỉ của môn học");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên môn học");
        String name = scanner.nextLine();
        System.out.println("Thêm môn học thành công");
        int price = id * 500000;
        Subject subject = new Subject(id, name, price);
        subjectsList.add(subject);
        WriteAndReadSubject.write(subjectsList);

    }
// Check tên môn học
    public int checkNamesubject(String nameSubject) {
        for (int i = 0; i < subjectsList.size(); i++) {
            if (nameSubject.equals(subjectsList.get(i).getName())) {
                return i;
            }
        }
        return -1;
    }
// Xóa môn học
    public void deleteSubject() {
        System.out.println("Nhập tên môn học muốn xóa");
        String name = scanner.nextLine();
        if (checkNamesubject(name) == -1) {
            System.out.println("Không có tên môn học nào");
        } else {
            int index = checkNamesubject(name);
            subjectsList.remove(index);
            System.out.println("Xóa thành công");
            WriteAndReadSubject.write(subjectsList);

        }
    }
// Hiển thị môn học
    public void showSubject() {
        for (int i = 0; i < subjectsList.size(); i++) {
            System.out.println(subjectsList.get(i).toString());
        }
    }
// Sửa môn học
    public void editSubject() {
        System.out.println("Nhập môn  học muốn sửa");
        String name = scanner.nextLine();
        if (checkNamesubject(name) == -1) {
            System.out.println("không có môn học này");
        } else {
            int index = checkNamesubject(name);
            System.out.println("1. Sửa  Số Tín Chỉ");
            System.out.println("2. Sửa Tên Môn Học");
            System.out.println("3. Thoát");
            int chon = Integer.parseInt(scanner.nextLine());
            switch (chon) {
                case 1:
                    System.out.println("Nhập số tín chỉ muốn thay đổi");
                    int idmoi = Integer.parseInt(scanner.nextLine());
                    subjectsList.get(index).setId(idmoi);
                    System.out.println("Thành công");
                    WriteAndReadSubject.write(subjectsList);
                    break;
                case 2:
                    System.out.println("Nhập tên muốn thay đổi");
                    String namemoi = scanner.nextLine();
                    subjectsList.get(index).setName(namemoi);
                    System.out.println("Thành công");
                    WriteAndReadSubject.write(subjectsList);
                case 3:
                    return;
            }
        }
    }
//    Đăng kí môn học
    public void registerSubject(String acc) {
        System.out.println("Chọn môn học muốn đăng kí");
        String name = scanner.nextLine();
        int temp = -1; // Khởi tạo giá trị ban đầu cho biến temp
        for (int i = 0; i < studentsList.size(); i++) {
            if (studentsList.get(i).getAcc().equals(acc))
                temp = i;
        }
        if (temp != -1) { // Kiểm tra xem sinh viên có tồn tại trong danh sách không
            boolean isRegistered = false; // Khởi tạo biến để kiểm tra môn học đã được đăng ký hay chưa
            boolean isSubjectFound = false; // Khởi tạo biến để kiểm tra xem có môn học trùng khớp không
            for (Subject sb : studentsList.get(temp).getSaveSubjects()) {
                if (sb.getName().equals(name)) {
                    isRegistered = true;
                    break;
                }
            }
            for (Subject sb : subjectsList) {
                if (sb.getName().equals(name)) {
                    isSubjectFound = true;
                    if (!isRegistered) {
                        studentsList.get(temp).addSaveSubjects(sb);
                        System.out.println("Đăng kí thành công!");
                        WriteAndReadSubject.write(subjectsList);
                        WriteAndRead.write(studentsList);
                    } else {
                        System.out.println("Bạn đã đăng kí môn học này rồi.");
                    }
                    break;
                }
            }
            if (!isSubjectFound) {
                System.out.println("Không có môn học nào có tên này.");
            }
        } else {
            System.out.println("Không tìm thấy sinh viên. Vui lòng thử lại.");
        }
    }

// Tổng tiền và tổng số tín chỉ
    public void sumPrice(String acc) {
        int sum = 0;
        int sum1 = 0;
        int temp = -1; // Khởi tạo giá trị ban đầu cho biến temp
        for (int i = 0; i < studentsList.size(); i++) {
            if (studentsList.get(i).getAcc().equals(acc))
                temp = i;
        }
        if (temp != -1) { // Kiểm tra xem sinh viên có tồn tại trong danh sách không
            for (Subject sb : studentsList.get(temp).getSaveSubjects()) {
                sum += sb.getPrice();
                sum1 += sb.getId();


            }
        } else {
            System.out.println("Không tìm thấy sinh viên. Vui lòng thử lại.");
        }
        System.out.println("Tổng tiền bạn phải trả cho " + sum1 + " tín chỉ kì này là:" + sum);
    }
// Hiển thị những môn học mà sinh viên này đã đăng kí
    public void showRegisteredCourses(String acc) {
        int temp = -1; // Khởi tạo giá trị ban đầu cho biến temp
        for (int i = 0; i < studentsList.size(); i++) {
            if (studentsList.get(i).getAcc().equals(acc)){
                temp = i;
                break;
        }}
        if (temp != -1) { // Kiểm tra xem sinh viên có tồn tại trong danh sách không
            for (Subject sb : studentsList.get(temp).getSaveSubjects()) {
                System.out.println(sb);
            }
        }else {
            System.out.println("Không tìm thấy sinh viên có tài khoản " + acc);
        }
    }}



