package baseball.domain;

public class GameResult {

    private int strike;
    private int ball;

    public GameResult() {
    }

    public GameResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public boolean isGameOver() {
        return strike == 3;
    }

    public void add(GameResult other) {
        this.strike += other.strike;
        this.ball += other.ball;
    }

    public int ballCount() {
        return ball;
    }

    public int strikeCount() {
        return strike;
    }

    public String ballToString() {
        if (ball == 0) {
            return "";
        }

        return ball + "볼";
    }

    public String strikeToString() {
        if (strike == 0) {
            return "";
        }

        return strike + "스트라이크";
    }
}
