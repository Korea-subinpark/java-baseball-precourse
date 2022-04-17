package baseball;

import baseball.domain.BallSet;
import baseball.domain.GameResult;
import baseball.view.InputView;
import baseball.view.ResultView;

public class BaseballGame {

    public BaseballGame() {
    }

    public void play() {
        BallSet computer = new BallSet();
        computer.generate();
        GameResult gameResult = new GameResult();
        while (!gameResult.isGameOver()) {
            String input = InputView.input();
            BallSet user = new BallSet(input);
            gameResult = computer.compare(user);
            ResultView.result(gameResult);
        }
        ResultView.exit();
    }
}
