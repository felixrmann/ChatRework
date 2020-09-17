package ChatRework.View;

import ChatRework.Model.User;

import javax.swing.*;
import java.awt.*;

/**
 * @author Gergö Dusza
 * @version 1.0
 * @since 2020-September-16
 */

public class LogInView extends JPanel {

    private User user;
    private MainFrame mainFrame;
    private JPanel mainPanel, namePanel, colorPanel, buttonPanel;
    private JLabel nameLabel, colorLabel;
    private JTextField nameText;
    private JButton colorButton, exitButton, joinButton;

    public LogInView(MainFrame mainFrame) {
        this.mainFrame = mainFrame;

        user = new User();
        mainPanel = new JPanel();
        namePanel = new JPanel();
        colorPanel = new JPanel();
        buttonPanel = new JPanel();

        nameLabel = new JLabel("Your Name: ");
        colorLabel = new JLabel("Pick your favorite color: ");

        nameText = new JTextField();

        colorButton = new JButton("Choose a Color");
        exitButton = new JButton("Exit App");
        joinButton = new JButton("Join the Server");

        init();
    }

    private void init() {
        add(mainPanel);

        GridLayout grid = new GridLayout(3,1);
        grid.setVgap(65);
        mainPanel.setLayout(grid);
        mainPanel.add(namePanel);
        mainPanel.add(colorPanel);
        mainPanel.add(buttonPanel);

        namePanel.setLayout(new BorderLayout());
        namePanel.add(nameLabel, BorderLayout.WEST);
        namePanel.add(nameText, BorderLayout.CENTER);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        nameText.setFont(new Font("Arial", Font.BOLD, 20));

        colorPanel.setLayout(new BorderLayout());
        colorPanel.add(colorLabel, BorderLayout.WEST);
        colorPanel.add(colorButton, BorderLayout.EAST);
        colorLabel.setFont(new Font("Arial", Font.BOLD, 20));
        colorButton.setFont(new Font("Arial", Font.BOLD, 20));

        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(exitButton, BorderLayout.WEST);
        buttonPanel.add(joinButton, BorderLayout.EAST);
        exitButton.setFont(new Font("Arial", Font.BOLD, 20));
        joinButton.setFont(new Font("Arial", Font.BOLD, 20));


        joinButton.addActionListener(e -> {
            if (nameText.getText() != null && user.getColor() != null){
                user.setName(nameText.getText());
                user.setMyIP();

                mainFrame.setContent(new UserView(user, mainFrame));
                mainFrame.setSize(600,600);
            }
        });

        colorButton.addActionListener(e -> {
            ColorView colorView = new ColorView(mainFrame);
            colorButton.setBackground(colorView.giveColorToUser());
            user.setColor(colorView.giveColorToUser());
        });

        exitButton.addActionListener(e -> System.exit(0));
    }
}
