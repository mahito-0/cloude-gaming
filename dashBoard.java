package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class dashBoard extends JFrame implements ActionListener, MouseListener {
    JPanel panel;
    JLabel ulabel, plabel, age, name;
    JLabel msg;
    JLabel genderLabel, dobLabel, addressLabel;
    JButton logoutBtn;
    JButton newGameButton, showBtn, editBtn, changeBtn, deleteBtn;
    Login lg;
    user u;
    users us;
    String pass = "", hiddenPass = "";

    public dashBoard(user u, users us, Login lg) {
        super("USER DASHBOARD");
        this.setSize(500, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.lg = lg;
        this.u = u;
        this.us = us;
        this.plabel = new JLabel();

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(51, 102, 153));
        panel.setBounds(30, 0, 150, 700);

        msg = new JLabel("USER INFORMATION");
        msg.setFont(new Font("Heivetica Bold ", Font.BOLD, 25));
        msg.setForeground(Color.WHITE);
        msg.setBounds(30, 0, 400, 70);
        panel.add(msg);

        name = new JLabel("NAME: " + u.getUname());
        name.setBounds(50, 50, 200, 30);
        name.setFont(new Font("Gotham ", Font.BOLD, 15));
        name.setForeground(Color.WHITE);
        name.setOpaque(false);
        panel.add(name);

        ulabel = new JLabel("USER NAME: " + u.getName());
        ulabel.setBounds(50, 80, 200, 30);
        ulabel.setFont(new Font("Gotham ", Font.BOLD, 15));
        ulabel.setForeground(Color.WHITE);
        ulabel.setOpaque(false);
        panel.add(ulabel);

        pass = u.getPassword();
        int passLenghth = pass.length();
        for (int i = 0; i < passLenghth; i++) {
            hiddenPass += '*';
        }

        plabel = new JLabel("PASSWORD: " + hiddenPass);
        plabel.setBounds(50, 110, 200, 30);
        plabel.setFont(new Font("Gotham ", Font.BOLD, 15));
        plabel.setForeground(Color.WHITE);
        plabel.setOpaque(false);
        panel.add(plabel);

        genderLabel = new JLabel("GENDER: " + u.getGender());
        genderLabel.setBounds(50, 140, 300, 30);
        genderLabel.setFont(new Font("Gotham ", Font.BOLD, 15));
        genderLabel.setForeground(Color.WHITE);
        genderLabel.setOpaque(false);
        panel.add(genderLabel);

        dobLabel = new JLabel("DATE OF BIRTH: " + u.getDOB());
        dobLabel.setBounds(50, 170, 300, 30);
        dobLabel.setFont(new Font("Gotham ", Font.BOLD, 15));
        dobLabel.setForeground(Color.WHITE);
        dobLabel.setOpaque(false);
        panel.add(dobLabel);

        age = new JLabel("AGE: " + u.getAge());
        age.setBounds(50, 200, 60, 30);
        age.setForeground(Color.WHITE);
        age.setOpaque(false);
        age.setFont(new Font("Gotham ", Font.BOLD, 15));
        panel.add(age);

        addressLabel = new JLabel("ADDRESS: " + u.getAddress());
        addressLabel.setBounds(50, 230, 300, 30);
        addressLabel.setFont(new Font("Gotham ", Font.BOLD, 15));
        addressLabel.setForeground(Color.WHITE);
        addressLabel.setOpaque(false);
        panel.add(addressLabel);

        logoutBtn = new JButton("LOGOUT");
        logoutBtn.setBounds(135, 270, 100, 25);
        logoutBtn.addActionListener(this);
        logoutBtn.setForeground(Color.WHITE);
        logoutBtn.setBackground(Color.BLACK);
        logoutBtn.setFocusPainted(false);
        logoutBtn.setBorder(null);
        panel.add(logoutBtn);

        newGameButton = new JButton("NEW GAME");
        newGameButton.setBounds(240, 270, 100, 25);
        newGameButton.addActionListener(this);
        newGameButton.setBackground(Color.BLACK);
        newGameButton.setForeground(Color.WHITE);
        newGameButton.setFocusPainted(false);
        newGameButton.setBorder(null);
        panel.add(newGameButton);

        showBtn = new JButton("SHOW");
        showBtn.setBounds(250, 110, 70, 25);
        showBtn.setBackground(Color.BLACK);
        showBtn.setForeground(Color.WHITE);
        showBtn.setBorder(null);
        panel.add(showBtn);

        editBtn = new JButton("Edit profile");
        editBtn.setBounds(50, 310, 100, 25);
        editBtn.setBackground(Color.BLACK);
        editBtn.setForeground(Color.WHITE);
        editBtn.setBorder(null);
        panel.add(editBtn);

        changeBtn = new JButton("CHANGE PASSWORD");
        changeBtn.setBounds(155, 310, 160, 25);
        changeBtn.setBackground(Color.BLACK);
        changeBtn.setForeground(Color.WHITE);
        changeBtn.setBorder(null);
        panel.add(changeBtn);

        deleteBtn = new JButton("DELETE PROFILE");
        deleteBtn.setBounds(319, 310, 140, 25);
        deleteBtn.setBackground(Color.BLACK);
        deleteBtn.setForeground(Color.WHITE);
        deleteBtn.setBorder(null);
        panel.add(deleteBtn);

        logoutBtn.addActionListener(this);
        newGameButton.addActionListener(this);
        logoutBtn.addMouseListener(this);
        newGameButton.addMouseListener(this);
        showBtn.addMouseListener(this);
        showBtn.addActionListener(this);
        deleteBtn.addMouseListener(this);
        deleteBtn.addActionListener(this);
        changeBtn.addActionListener(this);
        changeBtn.addMouseListener(this);
        editBtn.addActionListener(this);
        editBtn.addMouseListener(this);
        this.add(panel);
    }

    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        if (logoutBtn.getText().equals(command)) {
            Login lg = new Login(us);
            lg.setVisible(true);
            this.setVisible(false);
        } else if (deleteBtn.getText().equals(command)) {
            int dialog = JOptionPane.YES_NO_OPTION;
            int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete your account?",
                    "Delete Account?", dialog);
            if (result == 0) {
                us.deleteUser(u);
                JOptionPane.showMessageDialog(this, "User Deleted!");
                Login lg = new Login(us);
                lg.setVisible(true);
                this.setVisible(false);
            } else {
            }
        } else if (editBtn.getText().equals(command)) {
            updateProfile upr = new updateProfile(u, us, this, lg);
            upr.setVisible(true);
            this.setVisible(false);
        } else if (changeBtn.getText().equals(command)) {
            String uname = u.getUname();
            int index = us.userExists(uname);
            updatePassword up = new updatePassword(us, uname, index);
            up.setVisible(true);
            this.setVisible(false);
        } else if (newGameButton.getText().equals(command)) {
            newSnake ns = new newSnake(u, us, lg);
            ns.setVisible(true);
            this.setVisible(false);
        }

    }

    public void mouseClicked(MouseEvent me) {
    }

    public void mouseEntered(MouseEvent me) {
        if (me.getSource() == logoutBtn) {
            logoutBtn.setForeground(Color.BLACK);
            logoutBtn.setBackground(Color.WHITE);
        } else if (me.getSource() == newGameButton) {
            newGameButton.setBackground(Color.WHITE);
            newGameButton.setForeground(Color.BLACK);
        } else if (me.getSource() == editBtn) {
            editBtn.setBackground(Color.WHITE);
            editBtn.setForeground(Color.BLACK);
        } else if (me.getSource() == changeBtn) {
            changeBtn.setBackground(Color.WHITE);
            changeBtn.setForeground(Color.BLACK);
        } else if (me.getSource() == deleteBtn) {
            deleteBtn.setBackground(Color.WHITE);
            deleteBtn.setForeground(Color.BLACK);
        }
    }

    public void mouseExited(MouseEvent me) {
        if (me.getSource() == logoutBtn) {
            logoutBtn.setForeground(Color.WHITE);
            logoutBtn.setBackground(Color.BLACK);
        } else if (me.getSource() == newGameButton) {
            newGameButton.setBackground(Color.BLACK);
            newGameButton.setForeground(Color.WHITE);
        } else if (me.getSource() == editBtn) {
            editBtn.setBackground(Color.BLACK);
            editBtn.setForeground(Color.WHITE);
        } else if (me.getSource() == changeBtn) {
            changeBtn.setBackground(Color.BLACK);
            changeBtn.setForeground(Color.WHITE);
        } else if (me.getSource() == deleteBtn) {
            deleteBtn.setBackground(Color.BLACK);
            deleteBtn.setForeground(Color.WHITE);
        }
    }

    public void mousePressed(MouseEvent me) {
        if (me.getSource() == showBtn) {
            plabel.setText("PASSWORD: " + pass);
        }
    }

    public void mouseReleased(MouseEvent me) {
        if (me.getSource() == showBtn) {
            plabel.setText("PASSWORD: " + hiddenPass);
        }
    }

}
