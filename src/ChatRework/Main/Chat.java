package ChatRework.Main;

import ChatRework.View.LogInView;
import ChatRework.View.MainFrame;
import ChatRework.View.UserView;

import java.awt.*;
import java.net.Socket;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-September-16
 */

public class Chat {
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setContent(new LogInView(mainFrame));
    }

    private boolean isPortInUse(String hostName, int portNumber) {
        boolean result;

        try {
            Socket s = new Socket(hostName, portNumber);
            s.close();
            result = true;
        }
        catch(Exception e) {
            result = false;
        }

        return(result);
    }
}
