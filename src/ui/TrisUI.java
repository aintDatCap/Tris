package ui;

import tris.Simbolo;
import tris.Tris;
import tris.bot.Bot;

import javax.swing.*;
import java.awt.*;

public class TrisUI extends JPanel {
    private JButton[][] bottoni = new JButton[3][3];
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
        });
        pulisci();
    }

    public void dueGiocatori() {
        tris = new Tris(coordinate -> {
            bottoni[coordinate.getX()][coordinate.getY()].setText(tris.carattereDellaCella(coordinate));
        });
        pulisci();
    }

    public void pulisci() {
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                bottoni[i][j].setText("");

        tris.pulisciTabella();
    }

}
