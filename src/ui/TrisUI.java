package ui;

import tris.Tris;
import tris.bot.Bot;

import javax.swing.*;
import java.awt.*;

public class TrisUI extends JPanel {
    private final JButton[][] bottoni = new JButton[3][3];
    private Tris tris;

    public TrisUI(Bot bot) {
        setLayout(new GridLayout(3,3));

        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++) {
                JButton bottone = new JButton("");
                bottone.setFont(new Font("Arial", Font.BOLD, 60));
                bottone.setBackground(new Color(240, 240, 240));

                int finalI = i;
                int finalJ = j;
                bottone.addActionListener(event -> {
                    tris.mossa(finalI, finalJ);
                });
                add(bottone);
                bottoni[i][j] = bottone;
            }

        if(bot == null) {
            dueGiocatori();
        } else {
            giocatoreSingolo(bot);
        }
    }

    public void giocatoreSingolo(Bot bot) {
        tris = new Tris(bot, coordinate -> {
            bottoni[coordinate.getX()][coordinate.getY()].setText(tris.carattereDellaCella(coordinate));
        }, risultatoPartita -> {
            for(int i = 0; i < 3; i++)
                for(int j = 0; j < 3; j++)
                    bottoni[i][j].setEnabled(false);

            switch (risultatoPartita) {
                case Pareggio -> {
                    JOptionPane.showMessageDialog(this, "La partita è finita in pareggio");
                    Tris.statistiche.aggiungiPareggio();
                }
                case VinceX -> {
                    JOptionPane.showMessageDialog(this, "Congratulazioni al giocatore per la vittoria");
                    Tris.statistiche.aggiungiVittoriaX();
                }
                case VinceO -> {
                    JOptionPane.showMessageDialog(this, "Congratulazioni al bot per la vittoria");
                    Tris.statistiche.aggiungiVittoriaO();
                }
            }
        });
        pulisci();
    }

    public void dueGiocatori() {
        tris = new Tris(coordinate -> {
            bottoni[coordinate.getX()][coordinate.getY()].setText(tris.carattereDellaCella(coordinate));
        }, risultatoPartita -> {
            for(int i = 0; i < 3; i++)
                for(int j = 0; j < 3; j++)
                    bottoni[i][j].setEnabled(false);

            switch (risultatoPartita) {
                case Pareggio -> {
                    JOptionPane.showMessageDialog(this, "La partita è finita in pareggio");
                    Tris.statistiche.aggiungiPareggio();
                }
                case VinceX -> {
                    JOptionPane.showMessageDialog(this, "Congratulazioni ad X per la vittoria");
                    Tris.statistiche.aggiungiVittoriaX();
                }
                case VinceO -> {
                    JOptionPane.showMessageDialog(this, "Congratulazioni ad O per la vittoria");
                    Tris.statistiche.aggiungiVittoriaO();
                }
            }

        });
        pulisci();
    }

    public void pulisci() {
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++) {
                bottoni[i][j].setText("");
                bottoni[i][j].setEnabled(true);
            }

        tris.pulisciTabella();
    }
}
