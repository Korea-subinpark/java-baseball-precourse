package baseball.view;

import baseball.domain.GameResult;

public class ResultView {

    public static void exit() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void result(GameResult gameResult) {
        if (gameResult.ballCount() == 0 && gameResult.strikeCount() == 0) {
            System.out.println("낫싱");
            return;
        }

        System.out.println(String.join(" ", gameResult.ballToString(), gameResult.strikeToString()).trim());
    }
}
