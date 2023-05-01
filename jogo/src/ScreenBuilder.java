import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ScreenBuilder {
    private static ScreenBuilder instance;
    private static final ArrayList<JFrame> frames = new ArrayList<>();

    private String plate = "bolo de chocolate";

    public JFrame thinkInAPlateScreen (JFrame nextScreen) {
        FrameBuilder frameBuilder = new FrameBuilder();
        ActionListenerBuilder actionListenerBuilder = new ActionListenerBuilder();

        JFrame thinkInAPlateFrame = frameBuilder.buildEmptyFrame("Jogo Gourmet");

        JPanel thinkInAPlatePanel = frameBuilder.textPanel("Pense em um prato que gosta");
        thinkInAPlateFrame.add(thinkInAPlatePanel,  BorderLayout.CENTER);

        thinkInAPlatePanel.add(frameBuilder.createCentralizedButton(actionListenerBuilder.actionListener(frames, nextScreen), "OK"));

        return thinkInAPlateFrame;
    }

    public JFrame itIsPastaScreen (JFrame yesScreen, JFrame noScreen) {
        return defaultYesNoScreen("O prato que você pensou é massa?", yesScreen, noScreen);
    }

    public JFrame itIsLasagnaScreen(JFrame yesScreen, JFrame noScreen){
        return defaultYesNoScreen("O prato que você pensou é Lasanha?", yesScreen, noScreen);
    }

    public JFrame doYouThoughtInThisPlate(JFrame yesScreen, JFrame noScreen){
        JFrame screen = defaultYesNoScreen("O prato que você pensou é " + plate + "?", yesScreen, noScreen);
        screen.setSize(340, 130);
        return screen;
    }

    public JFrame whatDoYouThought(){
        FrameBuilder frameBuilder = new FrameBuilder();
        ActionListenerBuilder actionListenerBuilder = new ActionListenerBuilder();

        JFrame whatDoYouThoughtFrame = frameBuilder.buildEmptyFrame("Jogo Gourmet");
        whatDoYouThoughtFrame.setSize(285, 150);
        frames.add(whatDoYouThoughtFrame);

        JPanel whatDoYouThoughtPanel = frameBuilder.questionTextPanel("Qual prato você pensou?");

        JTextField plateTextField = new JTextField();
        plateTextField.setColumns(1);
        plateTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        whatDoYouThoughtPanel.add(plateTextField);

        whatDoYouThoughtFrame.add(whatDoYouThoughtPanel,  BorderLayout.CENTER);
        whatDoYouThoughtPanel.add(frameBuilder.createOkCancelButton(frames, actionListenerBuilder.actionListenerForTextField(frames, null, plateTextField)), BorderLayout.CENTER);

        return whatDoYouThoughtFrame;
    }


    public JFrame imRightAgain(){
        FrameBuilder frameBuilder = new FrameBuilder();
        ActionListenerBuilder actionListenerBuilder = new ActionListenerBuilder();

        JFrame imRightAgainFrame = frameBuilder.buildEmptyFrame("Jogo Gourmet");
        frames.add(imRightAgainFrame);
        JPanel imRightAgainPanel = frameBuilder.infoTextPanel("Acertei de novo!");
        imRightAgainFrame.add(imRightAgainPanel,  BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton okButton = new JButton("OK");
        okButton.addActionListener(actionListenerBuilder.closeAllScreens(frames));

        buttonPanel.add(okButton);
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        imRightAgainPanel.add(buttonPanel, BorderLayout.SOUTH);
        imRightAgainPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        return imRightAgainFrame;
    }

    private JFrame defaultYesNoScreen (String text, JFrame yesScreen, JFrame noScreen){
        FrameBuilder frameBuilder = new FrameBuilder();

        JFrame defaultYesNoFrame = frameBuilder.buildEmptyFrame("Jogo Gourmet");
        frames.add(defaultYesNoFrame);

        JPanel defaultYesNoPanel = frameBuilder.questionTextPanel(text);
        defaultYesNoFrame.add(defaultYesNoPanel,  BorderLayout.CENTER);
        defaultYesNoPanel.add(frameBuilder.createYesNoButton(frames, yesScreen, noScreen), BorderLayout.CENTER);

        return defaultYesNoFrame;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getPlate() {
        return plate;
    }
}
