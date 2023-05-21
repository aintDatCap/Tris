package ui;

import tris.Statistiche;

import javax.swing.*;

public class FinestraStatistiche extends JFrame {
    private JPanel panel;
    private JLabel totalePartiteLabel;
    private JLabel vittorieXLabel;
    private JLabel vittorieOLabel;
    private JButton tornaAlMenuButton;

    public FinestraStatistiche() {

        totalePartiteLabel.setText("Partite totali: " + Statistiche.statistiche.getPartiteTotali());
        vittorieXLabel.setText("Vittorie X: " + Statistiche.statistiche.getVittorieX());
        vittorieOLabel.setText("Vittorie O: " + Statistiche.statistiche.getVittorieO());


        setTitle("Tris - statistiche");
        setContentPane(panel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1080, 720);
        setVisible(true);
    }
}
