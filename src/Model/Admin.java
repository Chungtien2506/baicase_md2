package Model;

import java.util.List;
import java.util.Scanner;

public class Admin {
    private  String acc;
    private  String pass;

    public Admin() {
    }

    public Admin(String acc, String pass) {
        this.acc = acc;
        this.pass = pass;
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

    @Override
    public String toString() {
        return "Admin{" +
                "acc='" + acc + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
