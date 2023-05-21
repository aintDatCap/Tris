package ui;

import tris.bot.RandomBot;

import javax.swing.*;

public class FinestraGioco extends JFrame{
    private JPanel panel;
    private JButton menuButton;
    private JButton facileButton;
    private JButton difficileButton;
    private JPanel trisPanel;
    private JButton dueGiocatoriButton;

    public FinestraGioco() {
        menuButton.addActionListener(e -> {
            new Menu();
            dispose();
        });
        dueGiocatoriButton.addActionListener(e -> {
            ((TrisUI)trisPanel).dueGiocatori();
            invalidate();
            validate();
        });
        facileButton.addActionListener(e -> {
            ((TrisUI)trisPanel).giocatoreSingolo(new RandomBot());
            invalidate();
            validate();
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
