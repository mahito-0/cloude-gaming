package Classes;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class updateProfile extends JFrame implements MouseListener, ActionListener {
    JPanel panel;
    JLabel userLabel, passwordLabel, confirmPassLabel, genderLabel, dobLabel, addressLabel, msg, age, name;
    JTextField userTF, addressTF, nm, ag;
    JPasswordField passwordTF;
    JButton updateBtn, backBtn, clearBtn, changeBtn;
    JRadioButton r1, r2, r3;
    ButtonGroup bg;
    JComboBox<String> date, month, year;
    Font myFont, myFont2;
    ImageIcon icon;
    dashBoard db;
    Login lg;
    users us;
    user u;

    public updateProfile(user u, users us, dashBoard db, Login lg) {
        super("Update profile");
        this.setSize(500, 400);
        icon = new ImageIcon("images/updateProfile.jpg");
        this.setIconImage(icon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.db = db;
        this.lg = lg;
        this.us = us;
        this.u = u;

        myFont = new Font("Gotham", Font.BOLD, 15);
        myFont2 = new Font("Gotham", Font.PLAIN, 15);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(51, 102, 153));

        msg = new JLabel("UPDATE YOUR DATA");
        msg.setFont(new Font("Gotham ", Font.BOLD, 20));
        msg.setForeground(Color.BLACK);
        msg.setBounds(30, 0, 350, 70);
        panel.add(msg);

        name = new JLabel("NAME: ");
        name.setBounds(50, 55, 60, 30);
        name.setFont(myFont);
        name.setBackground(Color.WHITE);
        name.setForeground(Color.BLACK);
        panel.add(name);

        userLabel = new JLabel("USER NAME: ");
        userLabel.setBounds(50, 90, 150, 30);
        userLabel.setFont(myFont);
        userLabel.setBackground(Color.WHITE);
        userLabel.setForeground(Color.BLACK);
        panel.add(userLabel);

        age = new JLabel("AGE: ");
        age.setBounds(50, 130, 150, 30);
        age.setFont(myFont);
        age.setBackground(Color.WHITE);
        age.setForeground(Color.BLACK);
        panel.add(age);

        genderLabel = new JLabel("GENDER: ");
        genderLabel.setBounds(50, 170, 150, 30);
        genderLabel.setFont(myFont);
        genderLabel.setBackground(Color.WHITE);
        genderLabel.setForeground(Color.BLACK);
        panel.add(genderLabel);

        dobLabel = new JLabel("DATE OF BIRTH:");
        dobLabel.setBounds(50, 210, 150, 30);
        dobLabel.setFont(myFont);
        dobLabel.setBackground(Color.WHITE);
        dobLabel.setForeground(Color.BLACK);
        panel.add(dobLabel);

        addressLabel = new JLabel("ADDRESS:");
        addressLabel.setBounds(50, 250, 243, 30);
        addressLabel.setFont(myFont);
        addressLabel.setBackground(Color.WHITE);
        addressLabel.setForeground(Color.BLACK);
        panel.add(addressLabel);

        String dates[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
                "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
        date = new JComboBox<>(dates);
        date.setBounds(200, 210, 50, 30);
        panel.add(date);

        String months[] = { "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC" };
        month = new JComboBox<>(months);
        month.setBounds(250, 210, 80, 30);
        panel.add(month);

        String years[] = { "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000",
                "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013",
                "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023" };
        year = new JComboBox<>(years);
        year.setBounds(330, 210, 80, 30);
        panel.add(year);

        nm = new JTextField(u.getName());
        nm.setBounds(200, 55, 243, 25);
        panel.add(nm);

        userTF = new JTextField(u.getUname());
        userTF.setBounds(200, 90, 243, 30);
        userTF.setFont(myFont2);
        panel.add(userTF);

        ag = new JTextField(u.getAge());
        ag.setBounds(200, 130, 243, 25);
        panel.add(ag);

        r1 = new JRadioButton("Male");
        r1.setBounds(200, 170, 80, 30);
        panel.add(r1);
        r2 = new JRadioButton("Female");
        r2.setBounds(280, 170, 80, 30);
        panel.add(r2);
        r3 = new JRadioButton("Other");
        r3.setBounds(360, 170, 80, 30);
        panel.add(r3);

        bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);

        addressTF = new JTextField(u.getAddress());
        addressTF.setBounds(200, 250, 243, 30);
        addressTF.setFont(myFont2);
        panel.add(addressTF);

        clearBtn = new JButton("Clear all");
        clearBtn.setBounds(255, 290, 100, 25);
        clearBtn.setBackground(Color.BLACK);
        clearBtn.setFocusPainted(false);
        clearBtn.setForeground(Color.WHITE);
        clearBtn.setBorder(null);
        panel.add(clearBtn);

        updateBtn = new JButton("Update");
        updateBtn.setBounds(135, 290, 100, 25);
        updateBtn.setBackground(Color.BLACK);
        updateBtn.setFocusPainted(false);
        updateBtn.setForeground(Color.WHITE);
        updateBtn.setBorder(null);
        panel.add(updateBtn);

        icon = new ImageIcon("images/backBtn.png");
        backBtn = new JButton(icon);
        backBtn.setBounds(450, 10, 36, 30);
        backBtn.setBorder(null);
        panel.add(backBtn);

        clearBtn.addMouseListener(this);
        clearBtn.addActionListener(this);
        updateBtn.addMouseListener(this);
        updateBtn.addActionListener(this);
        backBtn.addMouseListener(this);
        backBtn.addActionListener(this);

        this.add(panel);
        this.setVisible(true);
    }

    public void mouseClicked(MouseEvent me) {
    }

    public void mouseEntered(MouseEvent me) {
        if (me.getSource() == clearBtn) {
            clearBtn.setForeground(Color.BLACK);
            clearBtn.setBackground(Color.WHITE);
        } else if (me.getSource() == updateBtn) {
            updateBtn.setBackground(Color.WHITE);
            updateBtn.setForeground(Color.BLACK);
        }
    }

    public void mouseExited(MouseEvent me) {
        if (me.getSource() == clearBtn) {
            clearBtn.setForeground(Color.WHITE);
            clearBtn.setBackground(Color.BLACK);
        } else if (me.getSource() == updateBtn) {
            updateBtn.setBackground(Color.BLACK);
            updateBtn.setForeground(Color.WHITE);
        }
    }

    public void mousePressed(MouseEvent me) {
    }

    public void mouseReleased(MouseEvent me) {
    }

    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        if (updateBtn.getText().equals(command)) {
            String uname = "", name = "", age = "", address = "", gender = "", dt = "", mnth = "", yr = "", dob = "";

            name = userTF.getText();
            age = ag.getText();
            address = addressTF.getText();

            if (r1.isSelected()) {
                gender = "Male";
            } else if (r2.isSelected()) {
                gender = "Female";
            } else if (r3.isSelected()) {
                gender = "Other";
            } else {
            }

            dt = date.getSelectedItem().toString();
            mnth = month.getSelectedItem().toString();
            yr = year.getSelectedItem().toString();
            dob = dt + "/" + mnth + "/" + yr;

            if ((!name.isEmpty()) && (!gender.isEmpty()) && (!address.isEmpty())) {
                int dialog = JOptionPane.YES_NO_OPTION;
                int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to update these informations?",
                        "Profile update?", dialog);
                if (result == 0) {
                    // keeping the old info
                    String oldName = u.getName();
                    String oldUname = u.getUname();
                    String oldAge = u.getAge();
                    String oldPass = u.getPassword();
                    String oldGender = u.getGender();
                    String oldDOB = u.getDOB();
                    String oldAddress = u.getAddress();
                    user oldUser = new user(oldName, oldUname, oldAge, oldPass, oldGender, oldDOB, oldAddress);

                    u.setName(name);
                    u.setAge(age);
                    u.setAddress(address);

                    us.updateUser(oldUser, u);

                    dialog = JOptionPane.YES_NO_OPTION;
                    result = JOptionPane.showConfirmDialog(this,
                            "Information updated. Do you want to stay on this page?", "Stay on this page?", dialog);
                    if (result == 0) {
                    } else {
                        new dashBoard(u, us, lg);
                        dashBoard db = new dashBoard(u, us, lg);
                        db.setVisible(true);
                        this.setVisible(false);
                    }
                } else {
                }
            } else {
                JOptionPane.showMessageDialog(this, "Can't update, information missing!");
            }
        } else if (backBtn.getText().equals(command)) {
            dashBoard db = new dashBoard(u, us, lg);
            db.setVisible(true);
            this.setVisible(false);
        } else if (clearBtn.getText().equals(command)) {
            userTF.setText("");
            ag.setText("");
            addressTF.setText("");

        } else {
        }
    }
}
