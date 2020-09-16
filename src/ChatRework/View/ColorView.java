package ChatRework.View;

import javax.swing.*;
import java.awt.*;

/**
 * @author Gergö Dusza
 * @version 1.0
 * @since 2020-September-16
 */

public class ColorView extends JDialog {

    private static Color color;

    public ColorView(Frame owner) {
        super(owner, "Color Picker", true);

        color = JColorChooser.showDialog(owner,
                "Choose Background Color",
                owner.getBackground());
    }

    public Color giveColorToUser() {
        return color;
    }
}
