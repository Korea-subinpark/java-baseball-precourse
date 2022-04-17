package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class BallSet {

    private final List<Ball> ballSet;
    private static final int LIMIT = 3;

    public BallSet() {
        this.ballSet = new ArrayList<>();
    }

    public BallSet(String ballNums) {
        this.ballSet = new ArrayList<>();

        if (ballNums.length() != LIMIT) {
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
        }

        for (int i = 0; i < ballNums.length(); i++) {
            char num = ballNums.charAt(i);
            Ball ball = new Ball(Character.getNumericValue(num));
            add(ball);
        }
    }

    public void generate() {
        while (LIMIT > ballSet.size()) {
            Ball ball = new Ball();
            add(ball);
        }
    }

    public void add(Ball ball) {
        if (ballSet.size() == LIMIT) {
            return;
        }

        if (ballSet.contains(ball)) {
            return;
        }

        ballSet.add(ball);
    }

    public int size() {
        return ballSet.size();
    }

    public GameResult compare(BallSet other) {
        GameResult gameResult = new GameResult();
        for (int i = 0; i < LIMIT; i++) {
            Ball ball = ballSet.get(i);
            gameResult.add(ball.compare(i, other));
        }

        return gameResult;
    }

    public boolean compare(int index, Ball ball) {
        return ballSet.get(index).equals(ball);
    }

    public boolean contains(Ball ball) {
        return ballSet.contains(ball);
    }
}
