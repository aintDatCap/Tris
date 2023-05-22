package ui;

import tris.Simbolo;
import tris.bot.RandomBot;

import javax.swing.*;
import java.awt.*;

public class FinestraGioco extends JFrame{
    private JPanel panel;
    private JButton menuButton;
    private JButton botButton;
    private JPanel trisPanel;
    private JButton dueGiocatoriButton;
    private JLabel infoPartitaLabel;

    public FinestraGioco() {
        botButton.setForeground(Color.green);
        dueGiocatoriButton.setForeground(Color.white);

        menuButton.addActionListener(e -> {
            new Menu();
            dispose();
        });
        dueGiocatoriButton.addActionListener(e -> {
            ((TrisUI)trisPanel).dueGiocatori();
            botButton.setForeground(Color.green);
            dueGiocatoriButton.setForeground(Color.white);
            infoPartitaLabel.setText("Turno di " + (((TrisUI)trisPanel).getTurno() == Simbolo.X ? "X" : "O"));
        });
        botButton.addActionListener(e -> {
            ((TrisUI)trisPanel).giocatoreSingolo(new RandomBot());
            botButton.setForeground(Color.white);
            dueGiocatoriButton.setForeground(Color.green);
            infoPartitaLabel.setText("Turno di " + (((TrisUI)trisPanel).getTurno() == Simbolo.X ? "X" : "O"));
        });

        setTitle("Tris");
        setContentPane(panel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1080, 720);
        setVisible(true);

    }

    private void createUIComponents() {
        trisPanel = new TrisUI(null);
        ((TrisUI)trisPanel).setCambioTurno(turno -> {
            infoPartitaLabel.setText("Turno di " + (turno == Simbolo.X ? "X" : "O"));
        });
    }

}
