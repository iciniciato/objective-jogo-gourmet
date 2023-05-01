import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ScreenBuilder {
    private final ArrayList<JFrame> frames = new ArrayList<>();

    public JFrame thinkInAPlateScreen (JFrame nextScreen) {
        FrameBuilder frameBuilder = new FrameBuilder();
        ActionListenerBuilder actionListenerBuilder = new ActionListenerBuilder();

        JFrame thinkInAPlateFrame = frameBuilder.buildEmptyFrame("Jogo Gourmet");

        JPanel thinkInAPlatePanel = frameBuilder.textPanel("Pense em um prato que gosta");
        thinkInAPlateFrame.add(thinkInAPlatePanel,  BorderLayout.CENTER);

        thinkInAPlatePanel.add(frameBuilder.createCentralizedButton(actionListenerBuilder.actionListener(nextScreen), "OK"));

        return thinkInAPlateFrame;
    }

    public JFrame itIsPastaScreen (JFrame yesScreen, JFrame noScreen) {
        FrameBuilder frameBuilder = new FrameBuilder();

        JFrame itIsPastaFrame = frameBuilder.buildEmptyFrame("Jogo Gourmet");
        frames.add(itIsPastaFrame);
        JPanel itIsPastaPanel = frameBuilder.questionTextPanel("O prato que você pensou é massa?");
        itIsPastaFrame.add(itIsPastaPanel,  BorderLayout.CENTER);
        itIsPastaPanel.add(frameBuilder.createYesNoButton(yesScreen, noScreen), BorderLayout.CENTER);

        return itIsPastaFrame;
    }

    public JFrame itIsLasagnaScreen(JFrame yesScreen, JFrame noScreen){
        FrameBuilder frameBuilder = new FrameBuilder();

        JFrame itIsLasagnaFrame = frameBuilder.buildEmptyFrame("Jogo Gourmet");
        frames.add(itIsLasagnaFrame);

        JPanel itIsLasagnaPanel = frameBuilder.questionTextPanel("O prato que você pensou é Lasanha?");
        itIsLasagnaFrame.add(itIsLasagnaPanel,  BorderLayout.CENTER);
        itIsLasagnaPanel.add(frameBuilder.createYesNoButton(yesScreen, noScreen), BorderLayout.CENTER);

        return itIsLasagnaFrame;
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

}
