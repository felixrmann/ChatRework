package ChatRework.Main;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-September-16
 */

public class Chat {
    public static void main(String[] args) {
        System.out.println("Hello World");
        //LogInView logInView = new LogInView();
        new UserView(Color.black, "Gergö");
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
