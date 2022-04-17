package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class BallSet {

    private final List<Ball> ballSet;
    private static final int LIMIT = 3;

    public BallSet() {
        this.ballSet = new ArrayList<>();
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
}
