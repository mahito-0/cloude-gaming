package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Login extends JFrame implements ActionListener, MouseListener {
    JPanel panel;
    JLabel userLabel;
    JLabel welcome;
    JLabel passwordLabel;
    JLabel rgetrLabel;
    JTextField userTF;
    JTextField passwordTF;
    JButton lgnBtn, exitBtn, rgstrBtn, adminBtn, forgotBtn;
    Color myColor;
    users us;
    user u;
    userAdmin as;

    public Login(users us) {
        super("GAME LOGIN");
        this.setSize(500, 275);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        myColor = new Color(255, 255, 255);
        this.us = us;

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(51, 102, 153));
        panel.setBounds(300, 0, 500, 700);

        welcome = new JLabel("Login To Your Account");
        welcome.setFont(new Font("Gotham ", Font.BOLD, 30));
        welcome.setForeground(myColor);
        welcome.setBounds(85, 6, 350, 70);
        panel.add(welcome);

        userLabel = new JLabel("GAME ID :");
        userLabel.setBounds(122, 66, 70, 25);
        userLabel.setForeground(myColor);
        panel.add(userLabel);

        passwordLabel = new JLabel("PASSWORD:");
        passwordLabel.setBounds(122, 96, 72, 25);
        passwordLabel.setForeground(Color.WHITE);
        panel.add(passwordLabel);

        userTF = new JTextField();
        userTF.setBounds(205, 66, 160, 25);
        panel.add(userTF);

        passwordTF = new JPasswordField();
        passwordTF.setBounds(205, 96, 160, 25);
        panel.add(passwordTF);

        lgnBtn = new JButton("LOGIN");
        lgnBtn.setBounds(206, 126, 75, 25);
        lgnBtn.setForeground(Color.WHITE);
        lgnBtn.setFocusPainted(false);
        lgnBtn.setBackground(Color.BLACK);
        lgnBtn.setBorder(null);
        // lgnBtn.setContentAreaFilled(false);
        panel.add(lgnBtn);

        exitBtn = new JButton("EXIT");
        exitBtn.setBounds(290, 126, 75, 25);
        exitBtn.setBackground(Color.BLACK);
        exitBtn.setFocusPainted(false);
        exitBtn.setForeground(Color.WHITE);
        exitBtn.setBorder(null);
        // exitBtn.setContentAreaFilled(false);
        panel.add(exitBtn);

        rgetrLabel = new JLabel("Don't have an account?");
        rgetrLabel.setFont(new Font("Gotham ", Font.BOLD, 13));
        rgetrLabel.setBounds(122, 183, 145, 25);
        rgetrLabel.setForeground(Color.WHITE);
        panel.add(rgetrLabel);

        rgstrBtn = new JButton("SIGN UP");
        rgstrBtn.setBounds(269, 183, 96, 25);
        rgstrBtn.setBackground(Color.BLACK);
        rgstrBtn.setForeground(Color.WHITE);
        rgstrBtn.setFocusPainted(false);
        rgstrBtn.setBorder(null);
        // rgstrBtn.setContentAreaFilled(false);
        panel.add(rgstrBtn);

        adminBtn = new JButton("ADMIN");
        adminBtn.setBounds(122, 126, 75, 25);
        adminBtn.setBackground(Color.BLACK);
        adminBtn.setFocusPainted(false);
        adminBtn.setForeground(Color.WHITE);
        adminBtn.setBorder(null);
        // adminBtn.setContentAreaFilled(false);
        panel.add(adminBtn);

        forgotBtn = new JButton("FORGOT PASSWORD?");
        forgotBtn.setBounds(159, 155, 170, 25);
        forgotBtn.setBackground(Color.BLACK);
        forgotBtn.setFocusPainted(false);
        forgotBtn.setForeground(Color.WHITE);
        forgotBtn.setBorder(null);
        // forgotBtn.setContentAreaFilled(false);
        panel.add(forgotBtn);

        lgnBtn.addActionListener(this);
        forgotBtn.addActionListener(this);
        exitBtn.addActionListener(this);
        adminBtn.addActionListener(this);
        lgnBtn.addMouseListener(this);
        exitBtn.addMouseListener(this);
        rgstrBtn.addMouseListener(this);
        adminBtn.addMouseListener(this);
        forgotBtn.addMouseListener(this);
        this.add(panel);
    }

    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        if (lgnBtn.getText().equals(command)) {
            String uname = userTF.getText();
            String pass = passwordTF.getText();

            int index = us.userExists(uname);
            if (index != -1) {
                u = us.checkCredentials(index, pass);
                if (u != null) {
                    JOptionPane.showMessageDialog(this, "Login successfull!");
                    dashBoard db = new dashBoard(u, us, this);
                    db.setVisible(true);
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(this, "Password incorrect!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "User doesn't exist!");
            }
        } else if (exitBtn.getText().equals(command)) {
            System.exit(0);
        } else if (rgstrBtn.getText().equals(command)) {
            Register rg = new Register(us, this);
            rg.setVisible(true);
            this.setVisible(false);
        } else if (forgotBtn.getText().equals(command)) {
            forgotPassword fp = new forgotPassword(us, this);
            fp.setVisible(true);
            this.setVisible(false);
        } else if (adminBtn.getText().equals(command)) {
            adminLogin ad = new adminLogin(as);
            ad.setVisible(true);
            this.setVisible(false);
        } else {
        }
    }

    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == lgnBtn) {
            lgnBtn.setForeground(Color.WHITE);
            lgnBtn.setBackground(Color.GREEN);
        } else if (me.getSource() == exitBtn) {
            exitBtn.setBackground(Color.GREEN);
            exitBtn.setForeground(Color.BLACK);
        } else if (me.getSource() == rgstrBtn) {
            rgstrBtn.setBackground(Color.GREEN);
            rgstrBtn.setForeground(Color.BLACK);
            Register rg = new Register(us, this);
            rg.setVisible(true);
            this.setVisible(false);
        } else if (me.getSource() == forgotBtn) {
            forgotBtn.setBackground(Color.GREEN);
            forgotBtn.setForeground(Color.BLACK);
        }
    }

    public void mouseEntered(MouseEvent me) {
        if (me.getSource() == lgnBtn) {
            lgnBtn.setForeground(Color.BLACK);
            lgnBtn.setBackground(Color.GRAY);
        } else if (me.getSource() == exitBtn) {
            exitBtn.setBackground(Color.GRAY);
            exitBtn.setForeground(Color.BLACK);
        } else if (me.getSource() == rgstrBtn) {
            rgstrBtn.setBackground(Color.GRAY);
            rgstrBtn.setForeground(Color.BLACK);
        } else if (me.getSource() == adminBtn) {
            adminBtn.setBackground(Color.GRAY);
            adminBtn.setForeground(Color.BLACK);
        } else if (me.getSource() == forgotBtn) {
            forgotBtn.setBackground(Color.GRAY);
            forgotBtn.setForeground(Color.BLACK);
        }
    }

    public void mouseExited(MouseEvent me) {
        if (me.getSource() == lgnBtn) {
            lgnBtn.setForeground(Color.WHITE);
            lgnBtn.setBackground(Color.BLACK);
        } else if (me.getSource() == exitBtn) {
            exitBtn.setBackground(Color.BLACK);
            exitBtn.setForeground(Color.WHITE);
        } else if (me.getSource() == rgstrBtn) {
            rgstrBtn.setBackground(Color.BLACK);
            rgstrBtn.setForeground(Color.WHITE);
        } else if (me.getSource() == adminBtn) {
            adminBtn.setBackground(Color.BLACK);
            adminBtn.setForeground(Color.WHITE);
        } else if (me.getSource() == forgotBtn) {
            forgotBtn.setBackground(Color.BLACK);
            forgotBtn.setForeground(Color.WHITE);
        }
    }

    public void mousePressed(MouseEvent me) {
    }

    public void mouseReleased(MouseEvent me) {
    }

    /*
     * public static void main(String[] args) {
     * SwingUtilities.invokeLater(() -> {
     * Login loginFrame = new Login(us);
     * loginFrame.setVisible(true);
     * loginFrame.setLocationRelativeTo(null);
     * });
     * }
     */
}
