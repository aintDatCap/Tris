package ui.components;

import javax.swing.*;
import java.awt.*;

public class BottoneMenu extends JButton {
    public BottoneMenu(String text) {
        setText(text);
        setSize(500, 60);
        setFont(new Font("Arial", Font.BOLD, 16));
        setForeground(Color.white);
        setBackground(new Color(60, 72, 107));

    }
}
