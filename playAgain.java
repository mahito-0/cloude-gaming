package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class playAgain extends JFrame implements ActionListener {
    JPanel panel;
    JLabel imgLabel;
    JButton startGameButton, backButton;
    ImageIcon img;
    user u;
    users us;
    Login lg;

    public playAgain() {
        super("GAMES");
        this.setSize(500, 420);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(51, 102, 153));

        img = new ImageIcon("images/playAgain.jpg");
        imgLabel = new JLabel(img);
        imgLabel.setBounds(0, -20, 500, 500);
        panel.add(imgLabel);

        startGameButton = new JButton("");
        startGameButton.setBounds(155, 250, 95, 50);
        startGameButton.setBackground(Color.BLACK);
        startGameButton.setFocusPainted(false);
        startGameButton.setForeground(Color.WHITE);
        startGameButton.setBorder(null);
        startGameButton.setContentAreaFilled(false);
        panel.add(startGameButton);

        backButton = new JButton(".");
        backButton.setFont(new Font("Gotham", Font.BOLD, 13));
        backButton.setBounds(255, 250, 95, 50);
        backButton.setBackground(Color.BLACK);
        backButton.setFocusPainted(false);
        backButton.setBorder(null);
        backButton.setForeground(Color.WHITE);
        backButton.setContentAreaFilled(false);
        panel.add(backButton);

        this.add(panel);

        startGameButton.addActionListener(this);
        backButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();

        if (startGameButton.getText().equals(command)) {
            GameFrame gp = new GameFrame();
            gp.setVisible(true);
            this.setVisible(false);
        } else if (backButton.getText().equals(command)) {
            newSnake db = new newSnake(u, us, lg);
            db.setVisible(true);
            this.setVisible(false);
        }
    }

}
