package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}