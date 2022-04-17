package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

class BallSetTest {

    @Test
    @DisplayName("중복되지 않는 숫자를 추가했을 때")
    void valid_add_test() {
        BallSet ballSet = new BallSet();
        int size = ballSet.size();
        ballSet.add(new Ball(1));

        // 정상 추가
        assertEquals(size + 1, ballSet.size());
    }

    @Test
    @DisplayName("중복된 숫자를 추가했을 때")
    void duplicate_add_test() {
        BallSet ballSet = new BallSet();
        ballSet.add(new Ball(1));
        int size = ballSet.size();
        ballSet.add(new Ball(1));

        // 중복된 것은 추가되지 않음
        assertEquals(size, ballSet.size());
    }

    @Test
    @DisplayName("허용치를 초과하여 추가한 경우")
    void limit_add_test() {
        BallSet ballSet = new BallSet();
        ballSet.add(new Ball(1));
        ballSet.add(new Ball(2));
        ballSet.add(new Ball(3));
        int size = ballSet.size();
        ballSet.add(new Ball(4));

        // 4번째 볼은 추가되지 않음
        assertEquals(size, ballSet.size());
    }

    @Test
    @DisplayName("허용치를 초과한 문자열로 생성한 경우")
    void limit_generate_test() {
        assertThrowsExactly(IllegalArgumentException.class, () -> new BallSet("1234"));
    }

    @Test
    @DisplayName("숫자가 아닌 문자로 생성한 경우")
    void non_number_generate_test() {
        assertThrowsExactly(IllegalArgumentException.class, () -> new BallSet("abc"));
    }

    @Test
    @DisplayName("1~9 범위 외 숫자로 생성한 경우")
    void non_range_generate_test() {
        assertThrowsExactly(IllegalArgumentException.class, () -> new BallSet("101"));
    }

    @Test
    @DisplayName("3 스트라이크")
    void strike_3() {
        BallSet ballSet1 = new BallSet("123");
        BallSet ballSet2 = new BallSet("123");

        GameResult gameResult = ballSet1.compare(ballSet2);
        assertEquals(gameResult.strikeCount(), 3);
        assertEquals(gameResult.ballCount(), 0);
    }

    @Test
    @DisplayName("2볼 1스트라이크")
    void ball_2_strike_1() {
        BallSet ballSet1 = new BallSet("123");
        BallSet ballSet2 = new BallSet("132");

        GameResult gameResult = ballSet1.compare(ballSet2);
        assertEquals(gameResult.strikeCount(), 1);
        assertEquals(gameResult.ballCount(), 2);
    }

    @Test
    @DisplayName("낫싱")
    void nothing() {
        BallSet ballSet1 = new BallSet("123");
        BallSet ballSet2 = new BallSet("456");

        GameResult gameResult = ballSet1.compare(ballSet2);
        assertEquals(gameResult.strikeCount(), 0);
        assertEquals(gameResult.ballCount(), 0);
    }
}