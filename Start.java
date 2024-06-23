import Classes.*;

public class Start {
    public static void main(String[] args) {
        users us = new users();
        Login mg = new Login(us);
        mg.setVisible(true);

    }
}