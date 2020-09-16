package ChatRework.Main;

import java.net.Socket;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-September-16
 */

public class Chat {
    public static void main(String[] args) {

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
