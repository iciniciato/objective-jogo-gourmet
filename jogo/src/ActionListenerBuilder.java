import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class ActionListenerBuilder {

    public ActionListener lastActionListener(ArrayList<JFrame> screensToClose, JTextField textField) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeScreens(screensToClose);
                ScreenBuilder.getInstance().setGuess(textField.getText());
                textField.setText("");
                FramesOrchestrator.getInstance().setShouldRestart(true);
            }
        };
    }

    public ActionListener actionListenerForTextField(ArrayList<JFrame> screensToClose, JTextField textField) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                closeScreens(screensToClose);

                if (Objects.nonNull(text) && !text.isEmpty()) {
                    ScreenBuilder.getInstance().setOldPlate(ScreenBuilder.getInstance().getPlate());
                    ScreenBuilder.getInstance().setPlate(textField.getText());
                    textField.setText("");
                    JFrame butIsNot = ScreenBuilder.getInstance().butIsNot();
                    butIsNot.setVisible(true);
                } else {
                    FramesOrchestrator.getInstance().setShouldRestart(true);
                }
            }
        };
    }

    public ActionListener actionListener(ArrayList<JFrame> screensToClose, JFrame nextScreen) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeScreens(screensToClose);
                nextScreen.setVisible(true);
            }
        };
    }

    public ActionListener closeAllScreens(ArrayList<JFrame> screensToClose) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeScreens(screensToClose);
                FramesOrchestrator.getInstance().setShouldRestart(true);
            }
        };
    }

    private void closeScreens(ArrayList<JFrame> frames) {
        frames.forEach(Window::dispose);
    }
}