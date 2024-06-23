package Classes;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class admin extends JFrame implements ActionListener, MouseListener {
    JPanel panel;
    JLabel userLabel;
    JButton bt1, bt2, backButton;
    users us;
    Login lg;

    public admin(Object o) {
        super("ADMIN");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(51, 102, 153));

        userLabel = new JLabel("ADMIN");
        userLabel.setBounds(150, 40, 80, 40);
        userLabel.setForeground(Color.WHITE);
        userLabel.setFont(new Font("Heivetica Bold", Font.BOLD, 25));
        userLabel.setOpaque(false);
        panel.add(userLabel);

        bt1 = new JButton("AADD USER");
        bt1.setBounds(30, 150, 120, 25);
        bt1.setBorder(null);
        panel.add(bt1);

        bt2 = new JButton("REMOVE USER");
        bt2.setBounds(230, 150, 120, 25);
        bt2.setBorder(null);
        panel.add(bt2);

        backButton = new JButton("BACK");
        backButton.setFont(new Font("Gotham ", Font.BOLD, 13));
        backButton.setBounds(300, 20, 75, 25);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);
        backButton.setBorder(null);
        panel.add(backButton);

        this.add(panel);

        backButton.addActionListener(this);
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        backButton.addMouseListener(this);
        bt1.addMouseListener(this);
        bt2.addMouseListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();

        if (backButton.getText().equals(command)) {
            adminLogin d = new adminLogin(null);
            d.setVisible(true);
            this.setVisible(false);

        } else if (bt1.getText().equals(command)) {
            adRegister re = new adRegister(null, null);
            re.setVisible(true);
            this.setVisible(false);

        } else if (bt2.getText().equals(command)) {
            delete dl = new delete(us, lg);
            dl.setVisible(true);
            this.setVisible(false);
        }

    }

    public void mouseEntered(MouseEvent me) {
        if (me.getSource() == bt1) {
            bt1.setForeground(Color.BLACK);
            bt1.setBackground(Color.GRAY);
        } else if (me.getSource() == bt2) {
            bt2.setBackground(Color.GRAY);
            bt2.setForeground(Color.BLACK);
        } else if (me.getSource() == backButton) {
            backButton.setBackground(Color.GRAY);
            backButton.setForeground(Color.BLACK);
        }
    }

    public void mouseExited(MouseEvent me) {
        if (me.getSource() == bt1) {
            bt1.setForeground(Color.WHITE);
            bt1.setBackground(Color.BLACK);
        } else if (me.getSource() == bt2) {
            bt2.setBackground(Color.BLACK);
            bt2.setForeground(Color.WHITE);
        } else if (me.getSource() == backButton) {
            backButton.setBackground(Color.BLACK);
            backButton.setForeground(Color.WHITE);
        }
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {

    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {

    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {

    }

}