package ui;

import tris.bot.RandomBot;

import javax.swing.*;

public class FinestraGioco extends JFrame{
    private JPanel panel;
    private JButton menuButton;
    private JButton botButton;
    private JPanel trisPanel;
    private JButton dueGiocatoriButton;

    public FinestraGioco() {
        menuButton.addActionListener(e -> {
            new Menu();
            dispose();
        });
        dueGiocatoriButton.addActionListener(e -> {
            ((TrisUI)trisPanel).dueGiocatori();
        });
        botButton.addActionListener(e -> {
            ((TrisUI)trisPanel).giocatoreSingolo(new RandomBot());
        });

        setTitle("Tris");
        setContentPane(panel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1080, 720);
        setVisible(true);

    }

    private void createUIComponents() {
        trisPanel = new TrisUI(null);
    }

}
