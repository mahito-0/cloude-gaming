package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class adRegister extends JFrame implements ActionListener, MouseListener {
    JPanel panel;
    JLabel ulabel, plabel, msg, name, age, dobLabel, genderLabel, addressLabel;
    JTextField nm, userTF, passwordTF, ag, addressTF;
    JComboBox<String> date, month, year;
    JButton regstrBtn, backButton;
    JRadioButton r1, r2, r3;
    ButtonGroup bg;
    ImageIcon icon;
    Color myColor;
    Login lg;
    static users us;

    public adRegister(users us, Login login) {
        super("SIGN UP");
        icon = new ImageIcon("signup.png");
        this.setIconImage(icon.getImage());
        this.setSize(550, 450);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.lg = login;
        this.us = us;

        myColor = new Color(255, 255, 255);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(51, 102, 153));

        msg = new JLabel("REGISTER AS ADMIN");
        msg.setFont(new Font("Gotham ", Font.BOLD, 20));
        msg.setForeground(Color.WHITE);
        msg.setBounds(30, 0, 350, 70);
        panel.add(msg);

        name = new JLabel("NAME: ");
        name.setBounds(50, 60, 60, 30);
        name.setBackground(Color.WHITE);
        name.setForeground(myColor);
        panel.add(name);

        age = new JLabel("AGE: ");
        age.setBounds(50, 90, 60, 30);
        age.setBackground(Color.WHITE);
        age.setForeground(myColor);
        panel.add(age);

        ulabel = new JLabel("GAME ID: ");
        ulabel.setBounds(50, 120, 200, 30);
        ulabel.setForeground(Color.WHITE);
        panel.add(ulabel);

        plabel = new JLabel("PASSWORD: ");
        plabel.setBounds(50, 150, 200, 30);
        plabel.setForeground(Color.WHITE);
        panel.add(plabel);

        dobLabel = new JLabel("DATE OF BIRTH: ");
        dobLabel.setBounds(50, 210, 200, 30);
        dobLabel.setForeground(Color.WHITE);
        panel.add(dobLabel);

        genderLabel = new JLabel("GENDER: ");
        genderLabel.setBounds(50, 240, 200, 30);
        genderLabel.setForeground(Color.WHITE);
        panel.add(genderLabel);

        addressLabel = new JLabel("ADDRESS: ");
        addressLabel.setBounds(50, 180, 200, 30);
        addressLabel.setForeground(Color.WHITE);
        panel.add(addressLabel);

        r1 = new JRadioButton("Male");
        r1.setBounds(150, 240, 60, 30);
        r1.setForeground(Color.WHITE);
        r1.setOpaque(false);
        panel.add(r1);

        r2 = new JRadioButton("Female");
        r2.setBounds(210, 240, 70, 30);
        r2.setForeground(Color.WHITE);
        r2.setOpaque(false);
        panel.add(r2);

        r3 = new JRadioButton("Others");
        r3.setBounds(280, 240, 70, 30);
        r3.setForeground(Color.WHITE);
        r3.setOpaque(false);
        panel.add(r3);

        bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);

        String[] dates = { "1", "2", "3", "4", "5", "6", "7", "8", "9",
                "10", "11", "12", "13", "14", "15", "16", "17",
                "18", "19", "20", "21", "22", "23", "24", "25",
                "26", "27", "28", "29", "30", "31" };

        date = new JComboBox<>(dates);
        date.setBounds(150, 210, 50, 30);
        panel.add(date);

        String[] months = { "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC" };
        month = new JComboBox<>(months);
        month.setBounds(211, 210, 60, 30);
        panel.add(month);

        String[] years = { "1990", "1991", "1992", "1993", "1994",
                "1995", "1996", "1997", "1998", "1999", "2000",
                "2001", "2002", "2003", "2004", "2005", "2006",
                "2007", "2008", "2009", "2010", "2011", "2012",
                "2013", "2014", "2015", "2016", "2017", "2018",
                "2019", "2020", "2021", "2022", "2023" };
        year = new JComboBox<>(years);
        year.setBounds(280, 210, 70, 30);
        panel.add(year);

        nm = new JTextField();
        nm.setBounds(150, 60, 200, 25);
        panel.add(nm);

        ag = new JTextField();
        ag.setBounds(150, 90, 200, 25);
        panel.add(ag);

        userTF = new JTextField();
        userTF.setBounds(150, 120, 200, 25);
        panel.add(userTF);

        passwordTF = new JPasswordField();
        passwordTF.setBounds(150, 150, 200, 25);
        panel.add(passwordTF);

        addressTF = new JTextField();
        addressTF.setBounds(150, 180, 200, 25);
        panel.add(addressTF);

        regstrBtn = new JButton("SIGN UP");
        regstrBtn.setFont(new Font("Gotham ", Font.BOLD, 13));
        regstrBtn.setBounds(175, 280, 120, 25);
        regstrBtn.setBackground(Color.BLACK);
        regstrBtn.setFocusPainted(false);
        regstrBtn.setForeground(Color.WHITE);
        panel.add(regstrBtn);

        backButton = new JButton("BACK");
        backButton.setFont(new Font("Gotham ", Font.BOLD, 13));
        backButton.setBounds(400, 20, 75, 25);
        backButton.setBackground(Color.BLACK);
        backButton.setFocusPainted(false);
        backButton.setForeground(Color.WHITE);
        panel.add(backButton);

        regstrBtn.addActionListener(this);
        backButton.addActionListener(this);
        regstrBtn.addMouseListener(this);
        backButton.addMouseListener(this);

        this.add(panel);

    }

    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        if (regstrBtn.getText().equals(command)) {
            String name, Uname, age, pass, gender, dt, mnth, yr, address;

            name = nm.getText();
            Uname = userTF.getText();
            age = ag.getText();
            pass = passwordTF.getText();
            address = addressTF.getText();

            if (r1.isSelected()) {
                gender = "Male";
            } else if (r2.isSelected()) {
                gender = "Female";
            } else if (r3.isSelected()) {
                gender = "Other";
            } else {
                gender = "";
            }

            dt = date.getSelectedItem().toString();
            mnth = month.getSelectedItem().toString();
            yr = year.getSelectedItem().toString();

            String dob = dt + "/" + mnth + "/" + yr;

            if (!pass.isEmpty()) {
                if (!name.isEmpty() && !pass.isEmpty() && !gender.isEmpty() && !dob.isEmpty() && !address.isEmpty()) {
                    user u = new user(name, Uname, age, pass, gender, dob, address);
                    us.addUser(u);
                    JOptionPane.showMessageDialog(this, "You are Signed up! Please login to continue.");
                    lg.setVisible(true);
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(this, "Information missing.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Password mismatch.");
            }
        } else if ("BACK".equals(command)) {
            lg.setVisible(true);
            this.setVisible(false);
        }
    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent me) {
        if (me.getSource() == regstrBtn) {
            regstrBtn.setForeground(Color.BLACK);
            regstrBtn.setBackground(Color.GRAY);
        } else if (me.getSource() == backButton) {
            backButton.setBackground(Color.GRAY);
            backButton.setForeground(Color.BLACK);
        }
    }

    public void mouseExited(MouseEvent me) {
        if (me.getSource() == regstrBtn) {
            regstrBtn.setForeground(Color.WHITE);
            regstrBtn.setBackground(Color.BLACK);
        } else if (me.getSource() == backButton) {
            backButton.setBackground(Color.BLACK);
            backButton.setForeground(Color.WHITE);
        }
    }

}
