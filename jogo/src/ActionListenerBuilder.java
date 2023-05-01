import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ActionListenerBuilder {

    public ActionListener actionListenerForTextField (ArrayList<JFrame> screensToClose, JFrame nextScreen, JTextField textField) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeScreens(screensToClose);
            }
        };
    }

    public ActionListener actionListener (ArrayList<JFrame> screensToClose, JFrame nextScreen) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeScreens(screensToClose);
                nextScreen.setVisible(true);
            }
        };
    }

    public ActionListener closeAllScreens (ArrayList<JFrame> screensToClose) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeScreens(screensToClose);
            }
        };
    }

    private void closeScreens (ArrayList<JFrame> frames){
        frames.forEach(Window::dispose);
    }
}
