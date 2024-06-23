package Classes;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class updatePassword extends JFrame implements MouseListener, ActionListener {
    JPanel panel;
    JLabel userLabel, passwordLabel, confirmPassLabel;
    JPasswordField passwordTF, confirmPasswordTF;
    JButton searchBtn, cancelBtn, updateBtn;
    Color myColor1, myColor2, myColor3;
    Font myFont, myFont2;
    ImageIcon icon;
    Login lg;
    users us;

    String pass = "", confirmPass = "", newPass = "";
    int index = -1;

    public updatePassword(users us, String uname, int index) {
        super("Upadte password");
        this.setSize(500, 300);
        icon = new ImageIcon("images/forgotPass.jpg");
        this.setIconImage(icon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.us = us;
        this.index = index;
        this.lg = lg;

        myColor3 = new Color(50, 120, 0);
        myFont = new Font("Century", Font.ITALIC, 17);
        myFont2 = new Font("Times New Roman", Font.BOLD, 17);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(51, 102, 153));

        userLabel = new JLabel("USER NAME: " + uname);
        userLabel.setBounds(50, 40, 250, 30);
        userLabel.setBackground(Color.WHITE);
        userLabel.setForeground(Color.BLACK);
        userLabel.setFont(myFont2);
        panel.add(userLabel);

        passwordLabel = new JLabel("NEW PASSWORD: ");
        passwordLabel.setBounds(50, 95, 150, 30);
        passwordLabel.setFont(myFont2);
        passwordLabel.setBackground(Color.WHITE);
        passwordLabel.setForeground(Color.BLACK);
        panel.add(passwordLabel);

        passwordTF = new JPasswordField();
        passwordTF.setBounds(245, 90, 200, 30);
        passwordTF.setFont(myFont2);
        passwordTF.setEchoChar('*');
        panel.add(passwordTF);

        confirmPassLabel = new JLabel("CONFIRM PASSWORD: ");
        confirmPassLabel.setBounds(50, 135, 200, 30);
        confirmPassLabel.setFont(myFont2);
        confirmPassLabel.setBackground(Color.WHITE);
        confirmPassLabel.setForeground(Color.BLACK);
        panel.add(confirmPassLabel);

        confirmPasswordTF = new JPasswordField();
        confirmPasswordTF.setBounds(245, 130, 200, 30);
        confirmPasswordTF.setFont(myFont);
        confirmPasswordTF.setEchoChar('*');
        panel.add(confirmPasswordTF);

        updateBtn = new JButton("UPDATE");
        updateBtn.setBounds(250, 180, 90, 30);
        updateBtn.setFont(myFont2);
        updateBtn.setBackground(Color.BLACK);
        updateBtn.setFocusPainted(false);
        updateBtn.setForeground(Color.WHITE);
        updateBtn.setBorder(null);
        panel.add(updateBtn);

        cancelBtn = new JButton("CANCEL");
        cancelBtn.setBounds(150, 180, 90, 30);
        cancelBtn.setFont(myFont2);
        cancelBtn.setBackground(Color.BLACK);
        cancelBtn.setFocusPainted(false);
        cancelBtn.setForeground(Color.WHITE);

        cancelBtn.setBorder(null);
        panel.add(cancelBtn);

        this.add(panel);

        updateBtn.addMouseListener(this);
        updateBtn.addActionListener(this);
        cancelBtn.addMouseListener(this);
        cancelBtn.addActionListener(this);
        // this.setVisible(true);
    }

    public void mouseClicked(MouseEvent me) {
    }

    public void mouseEntered(MouseEvent me) {
        if (me.getSource() == updateBtn) {
            updateBtn.setForeground(Color.BLACK);
            updateBtn.setBackground(Color.GRAY);
        } else if (me.getSource() == cancelBtn) {
            cancelBtn.setBackground(Color.GRAY);
            cancelBtn.setForeground(Color.BLACK);
        }
    }

    public void mouseExited(MouseEvent me) {
        if (me.getSource() == updateBtn) {
            updateBtn.setForeground(Color.WHITE);
            updateBtn.setBackground(Color.BLACK);
        } else if (me.getSource() == cancelBtn) {
            cancelBtn.setBackground(Color.BLACK);
            cancelBtn.setForeground(Color.WHITE);
        }
    }

    public void mousePressed(MouseEvent me) {
    }

    public void mouseReleased(MouseEvent me) {
    }

    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        if (updateBtn.getText().equals(command)) {
            pass = passwordTF.getText();
            confirmPass = confirmPasswordTF.getText();
            if ((!pass.isEmpty()) && (!confirmPass.isEmpty()) && (pass.equals(confirmPass))) {
                newPass = pass;
                user u = us.getUser(index);

                // keeping the old info
                String oldName = u.getName();
                String oldUname = u.getUname();
                String oldPass = u.getPassword();
                String oldAge = u.getAge();
                String oldGender = u.getGender();
                String oldDOB = u.getDOB();
                String oldAddress = u.getAddress();
                user oldUser = new user(oldName, oldUname, oldPass, oldAge, oldGender, oldDOB, oldAddress);

                // updating the password
                u.setPassword(newPass);

                // also updating in file
                us.updateUser(oldUser, u);

                JOptionPane.showMessageDialog(this, "Password updated. Please login to continue.");
                new Login(us);
                Login lg = new Login(us);
                lg.setVisible(true);
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "Password missmatch!");
            }
        } else if (cancelBtn.getText().equals(command)) {
            forgotPassword fg = new forgotPassword(null, lg);
            fg.setVisible(true);
            this.setVisible(false);
        } else {
        }
    }

}