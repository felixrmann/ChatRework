package ChatRework.Main;

import ChatRework.View.LogInView;
import ChatRework.View.UserView;

import java.awt.*;

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
}
