package baseball;

import baseball.domain.BallSet;
import baseball.view.InputView;

public class BaseballGame {

    public BaseballGame() {
    }

    public void play() {
        BallSet computer = new BallSet();
        computer.generate();

        String input = InputView.input();
        BallSet user = new BallSet(input);
    }
}
