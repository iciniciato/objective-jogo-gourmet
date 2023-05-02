package br.com.gourmetgame.builders;

import br.com.gourmetgame.orchestrator.FramesOrchestrator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Objects;

public class ActionListenerBuilder {

    public ActionListener lastActionListener(List<JFrame> screensToClose, JTextField textField) {
        return e -> {
            closeScreens(screensToClose);
            ScreenBuilder.getInstance().setGuess(textField.getText());
            textField.setText("");
            FramesOrchestrator.getInstance().setShouldRestart(true);
        };
    }

    public ActionListener actionListenerForTextField(List<JFrame> screensToClose, JTextField textField) {
        return e -> {
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
        };
    }

    public ActionListener actionListener(List<JFrame> screensToClose, JFrame nextScreen) {
        return e -> {
            closeScreens(screensToClose);
            nextScreen.setVisible(true);
        };
    }

    public ActionListener closeAllScreens(List<JFrame> screensToClose) {
        return e -> {
            closeScreens(screensToClose);
            FramesOrchestrator.getInstance().setShouldRestart(true);
        };
    }

    private void closeScreens(List<JFrame> frames) {
        frames.forEach(Window::dispose);
    }
}