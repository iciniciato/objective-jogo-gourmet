import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ActionListenerBuilder {

    public ActionListener actionListener (JFrame nextScreen) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextScreen.setVisible(true);
            }
        };
    }

    public ActionListener closeAllScreens (ArrayList<JFrame> screensToClose) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                screensToClose.forEach(Window::dispose);
            }
        };
    }
}
