package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BallTest {

    @Test
    @DisplayName("유효하지 않은 숫자로 볼 생성")
    void invalid_generate_test() {
        assertThrowsExactly(IllegalArgumentException.class, () -> new Ball(10));
    }

    @Test
    @DisplayName("스트라이크")
    void strike() {
        Ball ball = new Ball(1);
        BallSet ballSet = new BallSet("123");

        GameResult gameResult = ball.compare(0, ballSet);
        assertEquals(gameResult.strikeCount(), 1);
        assertEquals(gameResult.ballCount(), 0);
    }

    @Test
    @DisplayName("볼")
    void ball() {
        Ball ball = new Ball(1);
        BallSet ballSet = new BallSet("123");

        GameResult gameResult = ball.compare(2, ballSet);
        assertEquals(gameResult.strikeCount(), 0);
        assertEquals(gameResult.ballCount(), 1);
    }

    @Test
    @DisplayName("낫싱")
    void nothing() {
        Ball ball = new Ball(4);
        BallSet ballSet = new BallSet("123");

        GameResult gameResult = ball.compare(0, ballSet);
        assertEquals(gameResult.strikeCount(), 0);
        assertEquals(gameResult.ballCount(), 0);
    }
}