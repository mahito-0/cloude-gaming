package Classes;

import java.lang.*;

public class user {
    String name;
    String Uname;
    String age;
    String password;
    String gender;
    String dob;
    String address;
    private int score;

    public user(String Uname, String name, String age, String pass, String gender, String dob, String address) {
        this.name = name;
        this.Uname = Uname;
        this.age = age;
        this.password = pass;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.score = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUname(String uname) {
        this.Uname = uname;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDOB(String dob) {
        this.dob = dob;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public String getUname() {
        return Uname;
    }

    public String getAge() {
        return age;
    }

    public String getPassword() {
        return password;
    }

    public String getGender() {
        return gender;
    }

    public String getDOB() {
        return dob;
    }

    public String getAddress() {
        return address;
    }

    public int getScore() {
        return score;
    }

}