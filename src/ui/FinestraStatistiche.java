package ui;

import tris.Statistiche;
import tris.Tris;

import javax.swing.*;

public class FinestraStatistiche extends JFrame {
    private JPanel panel;
    private JLabel totalePartiteLabel;
    private JLabel vittorieXLabel;
    private JLabel vittorieOLabel;
    private JButton tornaAlMenuButton;


    public FinestraStatistiche() {

        totalePartiteLabel.setText("Partite totali: " + Tris.statistiche.getPartiteTotali());
        vittorieXLabel.setText("Vittorie X: " + Tris.statistiche.getVittorieX());
        vittorieOLabel.setText("Vittorie O: " + Tris.statistiche.getVittorieO());


        tornaAlMenuButton.addActionListener(e -> {
            new Menu();
            dispose();
        });

        setTitle("Tris - statistiche");
        setContentPane(panel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1080, 720);
        setVisible(true);
    }
}
