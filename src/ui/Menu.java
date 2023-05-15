package ui;

import javax.swing.*;

public class Menu {
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JPanel schedaGiocatoreSingolo;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Menu");
        frame.setContentPane(new Menu().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        schedaGiocatoreSingolo = new JPanel();
        schedaGiocatoreSingolo.add(new JTable(3,3));
    }
}
