package ChatRework.Model;

import java.awt.*;

/**
 * @author Gergö Dusza
 * @version 1.0
 * @since 2020-September-16
 */

public class User {

    private MyIP myIP;
    private String name;
    private Color color;

    public User(){

    }

    public User(MyIP myIP, Color color, String name) {
        this.myIP = myIP;
        this.color = color;
        this.name = name;
    }

    public MyIP getMyIP() {
        return myIP;
    }

    public void setMyIP() {
        this.myIP = new MyIP();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
