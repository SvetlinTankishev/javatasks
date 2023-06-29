package my.punch.card;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(PunchCardGUI::new);
    }
}