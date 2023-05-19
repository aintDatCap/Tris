package ui;

import tris.Tris;
import tris.bot.RandomBot;

import javax.swing.*;
import java.awt.*;

public class TrisUI {
    private JPanel panel;
    private Tris tris;
    private final JButton[][] bottoni = new JButton[3][3];

    public TrisUI() {
        tris = new Tris(new RandomBot(), coordinate -> {
            JButton button = bottoni[coordinate.getX()][coordinate.getY()];
            button.setText(String.valueOf(tris.carattereDellaCella(coordinate.getX(), coordinate.getY())));
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("TrisUI");
        frame.setSize(1080, 720);
        frame.setContentPane(new TrisUI().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void createUIComponents() {
        panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton button = new JButton();
                button.setFont(new Font("button_font", Font.PLAIN, 60));

                int finalI = i;
                int finalJ = j;
                button.addActionListener(event -> {
                    tris.mossa(finalI, finalJ);
                });

                bottoni[i][j] = button;
                panel.add(button);
            }
        }
    }

    public JPanel getPanel() {
        return panel;
    }
}
