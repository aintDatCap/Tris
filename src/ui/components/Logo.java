package ui.components;

import javax.swing.*;
import java.awt.*;

public class Logo extends JLabel {
    public Logo(String text) {
        setText(text);
        setFont(new Font("Arial", Font.BOLD, 50));
    }
}
