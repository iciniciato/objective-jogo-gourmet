import javax.swing.*;

public class FramesOrchestrator {
    private static FramesOrchestrator instance;
    private boolean hasChangedScreen = true;

    private FramesOrchestrator() {
    }

    public static FramesOrchestrator getInstance() {
        if (instance == null) {
            instance = new FramesOrchestrator();
        }
        return instance;
    }

    public void executor() throws InterruptedException {
        while (true) {
            Thread.sleep(100);
            if(isHasChangedScreen()) {
                new FramesOrchestrator().orchestrator();
                setHasChangedScreen(false);
            }
        }
    }

    public void orchestrator(){
        ScreenBuilder screenBuilder = ScreenBuilder.getInstance();

        JFrame imRightAgainScreen = screenBuilder.imRightAgain();

        JFrame whatDoYouThoughtScreen = screenBuilder.whatDoYouThought();
        JFrame itIsChocolateCakeScreen = screenBuilder.doYouThoughtInThisPlate(imRightAgainScreen, whatDoYouThoughtScreen);
        JFrame itIsLasagnaScreen = screenBuilder.itIsLasagnaScreen(imRightAgainScreen, whatDoYouThoughtScreen);
        JFrame itIsPastaScreen = screenBuilder.itIsPastaScreen(itIsLasagnaScreen, itIsChocolateCakeScreen);

        JFrame thinkInAPlateFrame = screenBuilder.thinkInAPlateScreen(itIsPastaScreen);

        thinkInAPlateFrame.setVisible(true);
    }

    public boolean isHasChangedScreen() {
        return hasChangedScreen;
    }

    public void setHasChangedScreen(boolean hasChangedScreen) {
        this.hasChangedScreen = hasChangedScreen;
    }
}
