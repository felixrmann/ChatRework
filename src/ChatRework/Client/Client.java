package ChatRework.Client;

import ChatRework.View.LogInView;
import ChatRework.View.MainFrame;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-September-16
 */

public class Client {
    private PrintWriter out;

    public Client() throws IOException {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setContent(new LogInView(mainFrame));

        run();
    }

    private void run() throws IOException {
        try {
            Socket socket = new Socket();
            Scanner in = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream(), true);

            while (in.hasNextLine()){
                String line = in.nextLine();
                if (line.startsWith("SUBMITNAME")){
                    out.println();
                } else if (line.startsWith("NAMEACCEPTED")){

                } else if (line.startsWith("MESSAGE")){

                }
            }
        } finally {

        }
    }
}
