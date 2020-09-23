package ChatRework.View;

import javax.swing.*;
import java.awt.*;

/**
 * The type Main frame.
 *
 * @author Felix Mann
 * @version 1.0
 * @since 2020 -September-17
 */
public class MainFrame extends JFrame {

    /**
     * Instantiates a new Main frame.
     */
    public MainFrame(){
        setSize(450,300);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Log In");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * Set content.
     *
     * @param panel the panel
     */
    public void setContent(JPanel panel){
        getContentPane().removeAll();
        setContentPane(panel);
        revalidate();
        repaint();
    }

    /**
     * Set frame size.
     *
     * @param width  the width
     * @param heigth the heigth
     */
    public void setFrameSize(int width, int heigth){
        setSize(width, heigth);
        setLocationRelativeTo(null);
    }

    /**
     * @return ContentPane
     */
    @Override
    public Container getContentPane() {
        return getContentPane();
    }
}
