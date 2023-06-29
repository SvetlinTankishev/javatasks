package task.punch.in.time.card;

import javax.swing.*;
import java.awt.*;

public class PunchCardGUI {
    private final PunchCardManager punchCardManager;

    public PunchCardGUI() {
        punchCardManager = new PunchCardManager();
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Clock In/Out");
        JPanel panel = new JPanel();
        JButton clockInButton = new JButton("Clock In");
        JButton clockOutButton = new JButton("Clock Out");
        JButton openFileButton = new JButton("Open Punch Card");
        JButton workTotalButton = new JButton("Work Total");
        JButton setPasswordButton = new JButton("Set Password");

        clockInButton.addActionListener(e -> punchCardManager.clockIn());

        clockOutButton.addActionListener(e -> punchCardManager.clockOut());

        openFileButton.addActionListener(e -> punchCardManager.openPunchCardFile());

        workTotalButton.addActionListener(e -> punchCardManager.showTotalWorkTime());

        setPasswordButton.addActionListener(e -> punchCardManager.changePassword());

        panel.setLayout(new GridLayout(1,1));
        panel.add(clockInButton);
        panel.add(clockOutButton);
        panel.add(workTotalButton);
        panel.add(openFileButton);
        panel.add(setPasswordButton);

        frame.add(panel);
        frame.setTitle("Punch Card");
        frame.setSize(750, 125);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
