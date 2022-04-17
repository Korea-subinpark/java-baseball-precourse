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
}