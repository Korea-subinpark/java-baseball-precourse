package baseball.domain;

import java.util.Objects;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Ball {

    private final int num;

    private static final int MIN = 1;
    private static final int MAX = 9;

    public Ball() {
        this.num = pickNumberInRange(MIN, MAX);
    }

    public Ball(int num) {
        if (num > MAX || num < MIN) {
            throw new IllegalArgumentException("1 ~ 9 숫자를 입력해주세요.");
        }
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return num == ball.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }
}
