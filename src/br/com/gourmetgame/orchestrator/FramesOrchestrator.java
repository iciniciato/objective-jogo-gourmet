package br.com.gourmetgame.orchestrator;

import br.com.gourmetgame.utils.*;
import br.com.gourmetgame.builders.ScreenBuilder;

import javax.swing.*;
import java.util.Objects;

public class FramesOrchestrator {
    private static FramesOrchestrator instance;
    private boolean shouldRestart = true;

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
            if (isShouldRestart()) {
                new FramesOrchestrator().orchestrator();
                setShouldRestart(false);
            }
        }
    }

    public void orchestrator() {
        ScreenBuilder screenBuilder = ScreenBuilder.getInstance();

        JFrame lastScreen = screenBuilder.lastScreen();
        JFrame fifthScreen = screenBuilder.fifthScreen();

        JFrame cakeScreen = screenBuilder.interrogationScreen(Constants.CHOCOLATE_CAKE, lastScreen, fifthScreen);
        JFrame forthScreen;

        if (Objects.nonNull(screenBuilder.getGuess()) && !screenBuilder.getGuess().isBlank()) {
            JFrame nextScreen = screenBuilder.interrogationScreen(screenBuilder.getPlate(), lastScreen, fifthScreen);
            forthScreen = screenBuilder.interrogationScreen(screenBuilder.getGuess(), nextScreen, cakeScreen);
        } else {
            forthScreen = cakeScreen;
        }

        JFrame thirdScreen = screenBuilder.thirdScreen(lastScreen, fifthScreen);
        JFrame secondScreen = screenBuilder.secondScreen(thirdScreen, forthScreen);
        JFrame firstScreen = screenBuilder.firstScreen(secondScreen);

        firstScreen.setVisible(true);
    }

    public boolean isShouldRestart() {
        return this.shouldRestart;
    }

    public void setShouldRestart(boolean shouldRestart) {
        this.shouldRestart = shouldRestart;
    }
}