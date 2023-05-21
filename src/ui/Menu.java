package ui;

import javax.swing.*;

public class Menu extends JFrame {
    private JButton giocaButton;
    private JButton statisticheButton;

    private JPanel panel;


    public Menu() {
        giocaButton.addActionListener(e -> {
            new FinestraGioco();
            dispose();
        });
        statisticheButton.addActionListener(e -> {
            new FinestraStatistiche();
            dispose();
        });

        setTitle("Tris - menu");
        setContentPane(panel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1080, 720);
        setVisible(true);
    }
}
