package Classes;

import java.lang.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class adminLogin extends JFrame implements ActionListener, MouseListener {
    JPanel panel;
    JLabel userLabel, passwordLabel;
    JTextField userTextfield, passwordTextfield;
    JButton loginBtn, cancelBtn;
    users us;
    userAdmin ua = new userAdmin("admin", "1234");

    public adminLogin(userAdmin as) {

        super("Admin Log-In");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(67, 99, 191));

        userLabel = new JLabel("ADMIN NAME :");
        userLabel.setBounds(50, 40, 110, 25);
        userLabel.setFont(new Font("Heivetica Bold", Font.BOLD, 15));
        userLabel.setOpaque(false);
        userLabel.setForeground(Color.WHITE);
        panel.add(userLabel);

        userTextfield = new JTextField();
        userTextfield.setBounds(165, 40, 150, 25);
        userTextfield.setForeground(Color.white);
        userTextfield.setOpaque(false);
        panel.add(userTextfield);

        passwordLabel = new JLabel("PASSWORD  :");
        passwordLabel.setBounds(50, 70, 110, 25);
        passwordLabel.setFont(new Font("Heivetica Bold", Font.BOLD, 15));
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setOpaque(false);
        panel.add(passwordLabel);

        passwordTextfield = new JTextField();
        passwordTextfield.setBounds(165, 70, 150, 25);
        passwordTextfield.setOpaque(false);
        passwordTextfield.setForeground(Color.white);
        panel.add(passwordTextfield);

        loginBtn = new JButton("LOGIN");
        loginBtn.setBounds(70, 150, 70, 30);
        loginBtn.setBackground(Color.BLACK);
        loginBtn.setForeground(Color.WHITE);
        loginBtn.setOpaque(true);
        loginBtn.setBorder(null);
        panel.add(loginBtn);

        cancelBtn = new JButton("CANCEL");
        cancelBtn.setBounds(220, 150, 75, 30);
        cancelBtn.setBackground(Color.BLACK);
        cancelBtn.setForeground(Color.WHITE);
        cancelBtn.setBorder(null);
        panel.add(cancelBtn);

        this.add(panel);

        cancelBtn.addActionListener(this);
        loginBtn.addActionListener(this);
        cancelBtn.addMouseListener(this);
        loginBtn.addMouseListener(this);

    }

    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        if (loginBtn.getText().equals(command)) {
            String name = userTextfield.getText();
            String pass = passwordTextfield.getText();

            if (name.equals(ua.getAname()) && pass.equals(ua.getApassword())) {
                JOptionPane.showMessageDialog(this, "Login successfull!");
                admin a = new admin(null);
                a.setVisible(true);
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "User doesn't exist!");
            }
        } else if (cancelBtn.getText().equals(command))

        {
            Login lg = new Login(us);
            lg.setVisible(true);
            this.setVisible(false);
        } else {
        }

    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent me) {

    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent me) {

    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent me) {

    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent me) {
        if (me.getSource() == loginBtn) {
            loginBtn.setForeground(Color.BLACK);
            loginBtn.setBackground(Color.GRAY);
        } else if (me.getSource() == cancelBtn) {
            cancelBtn.setBackground(Color.GRAY);
            cancelBtn.setForeground(Color.BLACK);
        }
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent me) {
        if (me.getSource() == loginBtn) {
            loginBtn.setForeground(Color.WHITE);
            loginBtn.setBackground(Color.BLACK);
        } else if (me.getSource() == cancelBtn) {
            cancelBtn.setBackground(Color.BLACK);
            cancelBtn.setForeground(Color.WHITE);
        }
    }

}