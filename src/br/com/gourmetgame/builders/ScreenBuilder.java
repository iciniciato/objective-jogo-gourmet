package br.com.gourmetgame.builders;

import br.com.gourmetgame.utils.Constants;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class ScreenBuilder {

    private static ScreenBuilder instance;
    private static final ArrayList<JFrame> frames = new ArrayList<>();

    private String plate = null;
    private String oldPlate = null;
    private String guess = null;

    private ScreenBuilder() {
    }

    public static ScreenBuilder getInstance() {
        if (instance == null) {
            instance = new ScreenBuilder();
        }
        return instance;
    }

    public JFrame firstScreen(JFrame nextScreen) {
        FrameBuilder frameBuilder = new FrameBuilder();
        ActionListenerBuilder actionListenerBuilder = new ActionListenerBuilder();

        JFrame thinkInAPlateFrame = frameBuilder.buildEmptyFrame(Constants.GAME_GOURMET);
        frames.add(thinkInAPlateFrame);

        JPanel thinkInAPlatePanel = frameBuilder.textPanel(Constants.THINK_A_PLATE_YOU_LIKE);
        thinkInAPlateFrame.add(thinkInAPlatePanel, BorderLayout.CENTER);

        thinkInAPlatePanel.add(frameBuilder.createCentralizedButton(actionListenerBuilder.actionListener(frames, nextScreen), Constants.OK));

        return thinkInAPlateFrame;
    }

    public JFrame secondScreen(JFrame yesScreen, JFrame noScreen) {
        return defaultYesNoScreen(Constants.PASTA_TEXT, yesScreen, noScreen);
    }

    public JFrame thirdScreen(JFrame yesScreen, JFrame noScreen) {
        return defaultYesNoScreen(Constants.LASAGNA_TEXT, yesScreen, noScreen);
    }

    public JFrame fifthScreen() {
        FrameBuilder frameBuilder = new FrameBuilder();
        ActionListenerBuilder actionListenerBuilder = new ActionListenerBuilder();

        JFrame whatDoYouThoughtFrame = frameBuilder.buildEmptyFrame(Constants.GAME_GOURMET);
        whatDoYouThoughtFrame.setSize(285, 150);
        frames.add(whatDoYouThoughtFrame);

        JPanel whatDoYouThoughtPanel = frameBuilder.questionTextPanel(Constants.WITCH_PLATE_DID_YOU_THINK);

        JTextField plateTextField = new JTextField();
        plateTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        whatDoYouThoughtPanel.add(plateTextField);

        whatDoYouThoughtFrame.add(whatDoYouThoughtPanel, BorderLayout.CENTER);
        whatDoYouThoughtPanel.add(frameBuilder.createOkCancelButton(frames, actionListenerBuilder.actionListenerForTextField(frames, plateTextField)), BorderLayout.CENTER);

        return whatDoYouThoughtFrame;
    }

    public JFrame interrogationScreen(String plate, JFrame yesScreen, JFrame noScreen) {
        String text = Constants.THE_PLATE_YOU_THOUGHT_OF_IS + plate + Constants.INTERROGATION;
        JFrame screen = defaultYesNoScreen(text, yesScreen, noScreen);
        screen.setSize(text.length() * 9, 130);
        return screen;
    }

    public JFrame lastScreen() {
        FrameBuilder frameBuilder = new FrameBuilder();
        ActionListenerBuilder actionListenerBuilder = new ActionListenerBuilder();

        JFrame imRightAgainFrame = frameBuilder.buildEmptyFrame(Constants.GAME_GOURMET);
        frames.add(imRightAgainFrame);
        JPanel imRightAgainPanel = frameBuilder.infoTextPanel(Constants.I_HIT_AGAIN);
        imRightAgainFrame.add(imRightAgainPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton okButton = new JButton(Constants.OK);
        okButton.addActionListener(actionListenerBuilder.closeAllScreens(frames));

        buttonPanel.add(okButton);
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        imRightAgainPanel.add(buttonPanel, BorderLayout.SOUTH);
        imRightAgainPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        return imRightAgainFrame;
    }

    public JFrame butIsNot() {
        FrameBuilder frameBuilder = new FrameBuilder();
        ActionListenerBuilder actionListenerBuilder = new ActionListenerBuilder();
        String text = Constants.getButIsNot(getPlate(), getOldPlate());

        JFrame whatDoYouThoughtFrame = frameBuilder.buildEmptyFrame(Constants.GAME_GOURMET);
        whatDoYouThoughtFrame.setSize(text.length() * 9, 150);
        frames.add(whatDoYouThoughtFrame);

        JPanel whatDoYouThoughtPanel = frameBuilder.questionTextPanel(text);

        JTextField plateTextField = new JTextField();
        plateTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        whatDoYouThoughtPanel.add(plateTextField);

        whatDoYouThoughtFrame.add(whatDoYouThoughtPanel, BorderLayout.CENTER);
        whatDoYouThoughtPanel.add(frameBuilder.createOkCancelButton(frames, actionListenerBuilder.lastActionListener(frames, plateTextField)), BorderLayout.CENTER);

        return whatDoYouThoughtFrame;
    }

    private JFrame defaultYesNoScreen(String text, JFrame yesScreen, JFrame noScreen) {
        FrameBuilder frameBuilder = new FrameBuilder();

        JFrame defaultYesNoFrame = frameBuilder.buildEmptyFrame(Constants.GAME_GOURMET);
        frames.add(defaultYesNoFrame);

        JPanel defaultYesNoPanel = frameBuilder.questionTextPanel(text);
        defaultYesNoFrame.add(defaultYesNoPanel, BorderLayout.CENTER);
        defaultYesNoPanel.add(frameBuilder.createYesNoButton(frames, yesScreen, noScreen), BorderLayout.CENTER);

        return defaultYesNoFrame;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public void setOldPlate(String oldPlate) {
        this.oldPlate = oldPlate;
    }

    public void setGuess(String guess) {
        this.guess = guess;
    }

    public String getPlate() {
        if (Objects.isNull(plate) || plate.isEmpty()) {
            return Constants.CHOCOLATE_CAKE;
        }
        return plate;
    }

    public String getOldPlate() {
        if (Objects.isNull(this.oldPlate) || this.oldPlate.isEmpty()) {
            return Constants.CHOCOLATE_CAKE;
        }
        return oldPlate;
    }

    public String getGuess() {
        return this.guess;
    }
}