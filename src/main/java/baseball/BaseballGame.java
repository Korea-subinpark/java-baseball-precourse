package baseball;

import baseball.domain.BallSet;

public class BaseballGame {

    public BaseballGame() {
    }

    public void play() {
        BallSet computer = new BallSet();
        computer.generate();
    }
}
