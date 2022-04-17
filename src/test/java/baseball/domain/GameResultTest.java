package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameResultTest {

    @Test
    @DisplayName("게임 결과 더하기")
    void add() {
        GameResult gameResult1 = new GameResult(1, 1);
        GameResult gameResult2 = new GameResult(0, 1);
        GameResult gameResult3 = new GameResult(1, 0);

        gameResult1.add(gameResult2);
        assertEquals(gameResult1.strikeCount(), 1);
        assertEquals(gameResult1.ballCount(), 2);

        gameResult1.add(gameResult3);
        assertEquals(gameResult1.strikeCount(), 2);
        assertEquals(gameResult1.ballCount(), 2);
    }

    @Test
    @DisplayName("게임 종료 테스트")
    void game_over() {
        GameResult gameResult1 = new GameResult(3, 0);
        assertTrue(gameResult1.isGameOver());

        GameResult gameResult2 = new GameResult(1, 2);
        assertFalse(gameResult2.isGameOver());

        GameResult gameResult3 = new GameResult(0, 3);
        assertFalse(gameResult3.isGameOver());
    }
}
