package Classes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;

import javax.swing.JPanel;

import javax.swing.Timer;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {

    static final int WIDTH = 400;
    static final int HEIGHT = 400;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (HEIGHT * WIDTH) / (UNIT_SIZE * UNIT_SIZE);
    static final int DELAY = 175;
    final int x[] = new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];
    int bodyParts = 5;
    int appleEaten = 0;
    int appleX;
    int appleY;
    char direction = 'R';
    boolean running = false;
    Timer timer;
    Random random;
    private JButton playAgainButton;

    int FONT = 75;
    int FONT1 = 40;
    Color SCORE_COLOR = Color.WHITE;
    Color GAME_OVER_COLOR = Color.WHITE;

    GamePanel() {
        random = new Random();

        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();
        playAgainButton = new JButton("ff");
        playAgainButton.setVisible(true);
        playAgainButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                playAgain pa = new playAgain();
                pa.setVisible(true);
                this.setVisible(false);

            }

            private void setVisible(boolean b) {
            }
        });
        this.add(playAgainButton);
        playAgainButton.setVisible(false);

    }

    public void startGame() {
        newApple();
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        if (running) {

            // for (int i = 0; i < HEIGHT / UNIT_SIZE; i++) {
            //     g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, HEIGHT);
            //     g.drawLine(0, i * UNIT_SIZE, WIDTH, i * UNIT_SIZE);
            // }

            g.setColor(Color.red);
            g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

            for (int i = 0; i < bodyParts; i++) {
                if (i == 0) {
                    g.setColor(Color.green);
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                } else {
                    g.setColor(new Color(45, 180, 0));
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                }
            }

            g.setColor(SCORE_COLOR);
            g.setFont(new Font("SansSerif", Font.BOLD, FONT1));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("Score = " + appleEaten, (WIDTH - metrics.stringWidth("Score = " + appleEaten)) / 2,
                    g.getFont().getSize());
        } else {
            gameOver(g);
        }
    }

    public void newApple() {
        appleX = random.nextInt((int) (WIDTH / UNIT_SIZE)) * UNIT_SIZE;
        appleY = random.nextInt((int) (HEIGHT / UNIT_SIZE)) * UNIT_SIZE;
    }

    public void move() {
        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }
        switch (direction) {
            case 'U':
                y[0] = y[0] - UNIT_SIZE;
                break;
            case 'D':
                y[0] = y[0] + UNIT_SIZE;
                break;
            case 'L':
                x[0] = x[0] - UNIT_SIZE;
                break;
            case 'R':
                x[0] = x[0] + UNIT_SIZE;
                break;
        }
    }

    public void checkApple() {
        if (x[0] == appleX && y[0] == appleY) {
            bodyParts++;
            appleEaten++;
            newApple();
        }
    }

    public void checkCollision() {
        for (int i = bodyParts; i > 0; i--) {
            if (x[0] == x[i] && y[0] == y[i]) {
                running = false;
            }
        }
        if (x[0] < 0 || x[0] > WIDTH || y[0] < 0 || y[0] > HEIGHT) {
            running = false;
        }
        if (!running) {
            timer.stop();
        }
    }

    public void gameOver(Graphics g) {

        g.setColor(SCORE_COLOR);
        g.setFont(new Font("Serif", Font.BOLD, FONT1));
        FontMetrics metrics1 = getFontMetrics(g.getFont());
        g.drawString("Score = " + appleEaten, (WIDTH - metrics1.stringWidth("Score = " + appleEaten)) / 2,
                g.getFont().getSize());

        g.setColor(GAME_OVER_COLOR);
        g.setFont(new Font("Serif", Font.BOLD, FONT));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("Game Over", (WIDTH - metrics2.stringWidth("Game Over")) / 2, HEIGHT / 2);

        playAgainButton.setVisible(true);
        playAgainButton.setBounds(0, 0, WIDTH, HEIGHT);
        playAgainButton.setForeground(Color.BLACK);
        playAgainButton.setContentAreaFilled(false);
        playAgainButton.setBorder(null);
        playAgainButton.setFocusPainted(false);
    }

    public void actionPerformed(ActionEvent e) {
        if (running) {
            move();
            checkApple();
            checkCollision();
        }
        repaint();
    }

    private class MyKeyAdapter extends KeyAdapter {
        // private ActionEvent ae;

        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if (direction != 'R') {
                        direction = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (direction != 'L') {
                        direction = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if (direction != 'D') {
                        direction = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (direction != 'U') {
                        direction = 'D';
                    }
                    break;
            }
        }

    }

    public void GamePanel(boolean b) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            new GameFrame();
        });

    }
}