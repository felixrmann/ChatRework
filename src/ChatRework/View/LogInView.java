package ChatRework.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Gergö Dusza
 * @version 1.0
 * @since 2020-September-16
 */

public class LogInView extends JFrame {

    private static JPanel mainPanel, namePanel, colorPanel, buttonPanel, buttonBottomLayerPanel;
    private static JLabel nameLabel, colorLabel;
    private static JTextField nameText;
    private static JButton colorButton, exitButton, joinButton;

    public LogInView() {
        super("Log-In");
        mainPanel = new JPanel();
        namePanel = new JPanel();
        colorPanel = new JPanel();
        buttonPanel = new JPanel();
        buttonBottomLayerPanel = new JPanel();

        nameLabel = new JLabel("Your Name: ");
        colorLabel = new JLabel("Pick your favorite color: ");

        nameText = new JTextField();

        colorButton = new JButton("Choose a Color");
        colorButton.addActionListener(e -> {
            ColorView colorView = new ColorView(this);
            colorButton.setBackground(colorView.giveColorToUser());
        });
        exitButton = new JButton("Exit App");
        exitButton.addActionListener(e -> System.exit(0));
        joinButton = new JButton("Join the Server");


        init();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        getContentPane().add(mainPanel);

        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(namePanel, BorderLayout.NORTH);
        mainPanel.add(colorPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        namePanel.setLayout(new BorderLayout());
        namePanel.add(nameLabel, BorderLayout.WEST);
        namePanel.add(nameText, BorderLayout.CENTER);

        colorPanel.setLayout(new BorderLayout());
        colorPanel.add(colorLabel, BorderLayout.WEST);
        colorPanel.add(colorButton, BorderLayout.EAST);

        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(buttonBottomLayerPanel, BorderLayout.EAST);

        buttonBottomLayerPanel.setLayout(new FlowLayout());
        buttonBottomLayerPanel.add(exitButton);
        buttonBottomLayerPanel.add(joinButton);

    }
}
