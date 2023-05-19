package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {
    private JPanel panel;
    private JButton singleplayerButton;
    private JButton multiplayerButton;
    private JButton statisticheButton;

    public Menu() {
        singleplayerButton.addActionListener(e -> {
            JFrame frame = new JFrame("Singleplayer");
            frame.setContentPane(new TrisUI().getPanel());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1080, 720);
            frame.setVisible(true);
        });


        multiplayerButton.addActionListener(e -> {

        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Menu");
        frame.setContentPane(new Menu().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1080, 720);
        frame.setVisible(true);
    }
}
