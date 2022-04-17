package baseball;

import baseball.view.InputView;

public class Application {
    public static void main(String[] args) {
        BaseballGame game = new BaseballGame();
        boolean isRestart = true;

        while (isRestart) {
            game.play();
            String restartInput = InputView.restartInput();
            isRestart = InputView.parseRestartInput(restartInput);
        }
    }
}
