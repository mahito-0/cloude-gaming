package Classes;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class forgotPassword extends JFrame implements MouseListener, ActionListener {
    JPanel panel;
    JLabel userLabel, passwordLabel, confirmPassLabel;
    JTextField userTF;
    JPasswordField passwordTF, confirmPasswordTF;
    JButton searchBtn, cancelBtn;
    Color myColor1, myColor2;
    Font myFont, myFont2;
    ImageIcon icon;

    Login lg;
    users us;

    public forgotPassword(users us, Login lg) {
        super("Forgot password");
        this.setSize(500, 250);
        icon = new ImageIcon("images/forgotPass.jpg");
        this.setIconImage(icon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.lg = new Login(us);
        this.us = us;

        myFont = new Font("Century", Font.BOLD, 15);
        myFont2 = new Font("Times New Roman", Font.BOLD, 17);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(51, 102, 153));

        userLabel = new JLabel("ENTER USER NAME: ");
        userLabel.setBounds(35, 50, 180, 30);
        userLabel.setFont(myFont2);
        userLabel.setForeground(Color.white);
        panel.add(userLabel);

        userTF = new JTextField();
        userTF.setBounds(205, 50, 250, 30);
        userTF.setFont(myFont2);
        panel.add(userTF);

        searchBtn = new JButton("SEARCH");
        searchBtn.setBounds(260, 100, 90, 25);
        searchBtn.setFont(myFont);
        searchBtn.setBackground(Color.BLACK);
        searchBtn.setFocusPainted(false);
        searchBtn.setForeground(Color.WHITE);
        searchBtn.setBorder(null);
        panel.add(searchBtn);

        cancelBtn = new JButton("CANCEL");
        cancelBtn.setBounds(160, 100, 90, 25);
        cancelBtn.setFont(myFont);
        cancelBtn.setBackground(Color.BLACK);
        cancelBtn.setFocusPainted(false);
        cancelBtn.setForeground(Color.WHITE);
        cancelBtn.setBorder(null);
        panel.add(cancelBtn);

        searchBtn.addMouseListener(this);
        searchBtn.addActionListener(this);
        cancelBtn.addMouseListener(this);
        cancelBtn.addActionListener(this);
        this.add(panel);
        this.setVisible(true);
    }

    public void mouseClicked(MouseEvent me) {
    }

    public void mouseEntered(MouseEvent me) {
        if (me.getSource() == searchBtn) {
            searchBtn.setForeground(Color.BLACK);
            searchBtn.setBackground(Color.GRAY);
        } else if (me.getSource() == cancelBtn) {
            cancelBtn.setBackground(Color.GRAY);
            cancelBtn.setForeground(Color.BLACK);
        }
    }

    public void mouseExited(MouseEvent me) {
        if (me.getSource() == searchBtn) {
            searchBtn.setForeground(Color.WHITE);
            searchBtn.setBackground(Color.BLACK);
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
        if (searchBtn.getText().equals(command)) {
            String name = userTF.getText();
            int index = us.userExists(name);

            if (index != -1) {
                updatePassword up = new updatePassword(us, name, index);
                up.setVisible(true);
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "Username doesn't exist!");
            }
        } else if (cancelBtn.getText().equals(command)) {
            new Login(us);
            lg.setVisible(true);
            this.setVisible(false);
        } else {
        }
    }
}