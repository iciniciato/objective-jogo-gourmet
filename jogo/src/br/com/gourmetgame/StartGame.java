package br.com.gourmetgame;

import br.com.gourmetgame.orchestrator.FramesOrchestrator;

public class StartGame {

    public static void main(String[] args) throws InterruptedException {
        FramesOrchestrator.getInstance().executor();
    }
}