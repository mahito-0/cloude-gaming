package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class newSnake extends JFrame implements ActionListener {
    JPanel panel;
    JLabel userLabel;
    JButton startGameButton, backButton;

    public newSnake(user u, users us, Login lg2) {
        super("GAMES");
        this.setSize(400, 250);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(51, 102, 153));

        userLabel = new JLabel("START YOUR NEW GAME");
        userLabel.setBounds(67, 40, 250, 40);
        userLabel.setForeground(Color.WHITE);
        userLabel.setFont(new Font("Helvetica Bold", Font.BOLD, 20));
        userLabel.setOpaque(false);
        panel.add(userLabel);

        startGameButton = new JButton("START");
        startGameButton.setBounds(110, 100, 75, 25);
        startGameButton.setBackground(Color.BLACK);
        startGameButton.setFocusPainted(false);
        startGameButton.setForeground(Color.WHITE);
        startGameButton.setBorder(null);
        panel.add(startGameButton);

        backButton = new JButton("BACK");
        backButton.setFont(new Font("Gotham", Font.BOLD, 13));
        backButton.setBounds(205, 100, 75, 25);
        backButton.setBackground(Color.BLACK);
        backButton.setFocusPainted(false);
        backButton.setBorder(null);
        backButton.setForeground(Color.WHITE);
        panel.add(backButton);

        this.add(panel);

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Login l = new Login(us);
                l.setVisible(true);
                l.setLocationRelativeTo(null);
                dispose();
            }
        });
        startGameButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        if (startGameButton.getText().equals(command)) {
            GamePanel gp = new GamePanel();
            gp.GamePanel(true);
            this.setVisible(false);
        }

    }

}
