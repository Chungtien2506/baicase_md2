package Model;

import java.io.Serializable;
import java.util.List;

public class Student  implements Serializable {
    private String acc;
    private  String pass;
    private String name;
    private int age;
    private String sex;
    private String address;

    public List<Subject> SaveSubjects;

    public Student() {
    }


    public Student(String acc, String pass, String name, int age, String sex, String address, List<Subject> saveSubjects) {
        this.acc = acc;
        this.pass = pass;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
        SaveSubjects = saveSubjects;
    }

    public String getAcc() {
        return acc;
    }

    public void setAcc(String acc) {
        this.acc = acc;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Subject> getSaveSubjects() {
        return SaveSubjects;
    }

    public void setSaveSubjects(List<Subject> saveSubjects) {
        SaveSubjects = saveSubjects;
    }
    public void addSaveSubjects(Subject subject){
        SaveSubjects.add(subject);
    }

    @Override
    public String toString() {
        return "Student{" +
                "acc='" + acc + '\'' +
                ", pass='" + pass + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", SaveSubjects=" + SaveSubjects +
                '}';
    }
}
