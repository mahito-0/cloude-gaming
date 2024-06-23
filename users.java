package Classes;

import java.lang.*;
import java.io.*;
import java.util.Scanner;

public class users {
    user userList[] = new user[1000];
    static int userCount = 0;

    public users() {
        try {
            File file = new File("Files/userList.txt"); // location must be the path where the file is saved
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {

                String n = sc.nextLine();
                String un = sc.nextLine();
                String a = sc.nextLine();
                String p = sc.nextLine();
                String g = sc.nextLine();
                String d = sc.nextLine();
                String ad = sc.nextLine();

                String name = n.substring(7);
                String uname = un.substring(6);
                String age = a.substring(9);
                String password = p.substring(10);
                String gender = g.substring(8);
                String dob = d.substring(15);
                String address = ad.substring(4);

                System.out.println(name);
                System.out.println(uname);
                System.out.println(age);
                System.out.println(password);
                System.out.println(gender);
                System.out.println(dob);
                System.out.println(address);

                user u = new user(name, uname, age, password, gender, dob, address);
                userList[userCount] = u;
                userCount++;
                System.out.println(userCount + "////////////////////////////");
            }
            sc.close(); // closing the file
        } catch (Exception ex) {
            // System.out.println(ex);
            System.out.println("File not found.");
            return;
        }
    }

    public int userExists(String uname) {
        int index = -1;
        for (int i = 0; i < userCount; i++) {
            if (userList[i] != null && userList[i].getUname().equals(uname)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void addUser(user u) {
        userList[userCount] = u;
        userCount++;
        // also adding them in file
        String userDetails = "Name: " + u.getName() + "\n";
        userDetails += "User Name: " + u.getUname() + "\n";
        userDetails += "Age: " + u.getAge() + "\n";
        userDetails += "Password: " + u.getPassword() + "\n";
        userDetails += "Gender: " + u.getGender() + "\n";
        userDetails += "Date of birth: " + u.getDOB() + "\n";
        userDetails += "Address: " + u.getAddress() + "\n" + "\n";

        try {
            FileWriter fw = new FileWriter("Files/userList.txt", true);
            fw.write(userDetails);
            fw.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public user checkCredentials(int index, String pass) {
        if ((userList[index].getPassword().equals(pass))) {
            return userList[index];
        } else {
            return null;
        }
    }

    public user getUser(int index) {
        return userList[index];
    }

    public void updateUser(user oldUser, user updatedUser) {

        String oldUserDetails = "Name: " + oldUser.getName() + "\n";
        oldUserDetails += "User Name: " + oldUser.getUname() + "\n";
        oldUserDetails += "Age: " + oldUser.getAge() + "\n";
        oldUserDetails += "Password: " + oldUser.getPassword() + "\n";
        oldUserDetails += "Gender: " + oldUser.getGender() + "\n";
        oldUserDetails += "Date of birth: " + oldUser.getDOB() + "\n";
        oldUserDetails += "Address: " + oldUser.getAddress() + "\n" + "\n";

        // deleting from file
        String updatedDetails = "Name: " + updatedUser.getName() + "\n";
        updatedDetails += "User Name: " + updatedUser.getUname() + "\n";
        updatedDetails += "Age: " + updatedUser.getAge() + "\n";
        updatedDetails += "Password: " + updatedUser.getPassword() + "\n";
        updatedDetails += "Gender: " + updatedUser.getGender() + "\n";
        updatedDetails += "Date of birth: " + updatedUser.getDOB() + "\n";
        updatedDetails += "Address: " + updatedUser.getAddress() + "\n" + "\n";

        try {
            String filepath = "Files/userList.txt";
            File originalFile = new File(filepath);

            String newDetails = "";
            Scanner sc = new Scanner(originalFile);
            while (sc.hasNext()) {
                String readUser = sc.nextLine() + "\n";
                readUser += sc.nextLine() + "\n";
                readUser += sc.nextLine() + "\n";
                readUser += sc.nextLine() + "\n";
                readUser += sc.nextLine() + "\n";
                readUser += sc.nextLine() + "\n";
                readUser += sc.nextLine() + "\n";
                readUser += sc.nextLine();

                System.out.println(readUser);
                System.out.println(oldUserDetails);

                if (readUser.equals(oldUserDetails)) {
                    System.out.println("Updated");
                    newDetails += updatedDetails + "\n";
                } else {
                    System.out.println("Writing");
                    newDetails += readUser + "\n";
                }
            }
            sc.close();
            FileWriter fw = new FileWriter(filepath);
            fw.write(newDetails);
            fw.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void deleteUser(user u) {
        if (u == null) {
            System.out.println("User is null. Cannot delete.");
            return;
        }

        int index = userExists(u.getUname()); // Use getUname() for comparison
        if (index == -1) {
            System.out.println("User not found. Cannot delete.");
            return;
        }

        for (int i = index; i < userCount - 1; i++) {
            userList[i] = userList[i + 1];
        }
        --userCount;
        userList[userCount] = null;

        // deleting from file
        String userDetails = "Name: " + u.getName() + "\n";
        userDetails += "User Name: " + u.getUname() + "\n";
        userDetails += "Age: " + u.getAge() + "\n";
        userDetails += "Password: " + u.getPassword() + "\n";
        userDetails += "Gender: " + u.getGender() + "\n";
        userDetails += "Date of birth: " + u.getDOB() + "\n";
        userDetails += "Address: " + u.getAddress() + "\n" + "\n";

        try {
            String filepath = "Files/userList.txt";
            File originalFile = new File(filepath);

            String newDetails = "";
            Scanner sc = new Scanner(originalFile);
            while (sc.hasNext()) {
                String readUser = sc.nextLine() + "\n";
                readUser += sc.nextLine() + "\n";
                readUser += sc.nextLine() + "\n";
                readUser += sc.nextLine() + "\n";
                readUser += sc.nextLine() + "\n";
                readUser += sc.nextLine() + "\n";
                readUser += sc.nextLine() + "\n";
                readUser += sc.nextLine();

                System.out.println(readUser);
                System.out.println(userDetails);

                if (readUser.equals(userDetails)) {
                    System.out.println("Equal");
                    continue;
                }
                System.out.println("Writing");
                newDetails += readUser + "\n";
            }
            sc.close();
            FileWriter fw = new FileWriter("Files/new.txt");
            fw.write(newDetails);
            fw.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void updateScore(int index, int newScore) {
        userList[index].setScore(newScore);
    }

    public int getScore(int index) {
        return userList[index].getScore();
    }

}
