package ChatRework.View;

import ChatRework.Model.User;

import javax.swing.*;
import java.awt.*;

/**
 * @author Gergö Dusza
 * @version 1.0
 * @since 2020-September-16
 */

public class UserView extends JPanel {

    private MainFrame mainFrame;
    private User user;
    private String[] testarray = {"1", "2", "3", "4", "test"};
    private JPanel mainPanel, chatRoomSelectPanel, gameSelectPanel, chatPanel, bottomPanel, leftsidePanel;
    private JLabel chatTitleLabel;
    private JTextArea chatBoxArea;
    private JTextField inputBarText;
    private JButton ticTacToeGameButton, rockPaperScissorsGameButton, tschauSeppGameButton, sendButton;
    private JList<String> serverSelectList;
    private JScrollPane scrollpane;

    public UserView(User user, MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.user = user;

        mainPanel = new JPanel();
        chatRoomSelectPanel = new JPanel();
        gameSelectPanel = new JPanel();
        chatPanel = new JPanel();
        leftsidePanel = new JPanel();
        bottomPanel = new JPanel();
        chatTitleLabel = new JLabel("abcedf");

        chatBoxArea = new JTextArea();
        inputBarText = new JTextField();
        ticTacToeGameButton = new JButton("Tic Tac Toe");
        rockPaperScissorsGameButton = new JButton("Rock Paper Scissors");
        tschauSeppGameButton = new JButton("Tschau Sepp");
        sendButton = new JButton("Send");
        serverSelectList = new JList<>(testarray);
        scrollpane = new JScrollPane();


        init();
    }

    private void init() {
        add(mainPanel);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(leftsidePanel, BorderLayout.WEST);
        mainPanel.add(chatPanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        leftsidePanel.setLayout(new BorderLayout());
        leftsidePanel.add(chatRoomSelectPanel, BorderLayout.CENTER);
        leftsidePanel.add(gameSelectPanel, BorderLayout.SOUTH);

        chatRoomSelectPanel.setLayout(new BorderLayout());
        chatRoomSelectPanel.add(scrollpane, BorderLayout.CENTER);

        scrollpane.setViewportView(serverSelectList);
        serverSelectList.setLayoutOrientation(JList.VERTICAL);

        gameSelectPanel.setLayout(new GridLayout(3, 1));
        gameSelectPanel.add(ticTacToeGameButton);
        gameSelectPanel.add(rockPaperScissorsGameButton);
        gameSelectPanel.add(tschauSeppGameButton);

        chatPanel.setLayout(new BorderLayout());
        chatPanel.setPreferredSize(new Dimension(420,520));
        chatPanel.add(chatTitleLabel, BorderLayout.NORTH);
        chatPanel.add(chatBoxArea, BorderLayout.CENTER);

        chatBoxArea.setLineWrap(true);
        chatBoxArea.setWrapStyleWord(true);
        chatBoxArea.setEditable(false);
        chatBoxArea.setFocusable(false);

        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(inputBarText, BorderLayout.CENTER);
        bottomPanel.add(sendButton, BorderLayout.EAST);
    }
}
