package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;

public class OutputView {
    public void printError(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printLottoCount(int count) {
        System.out.println();
        System.out.println(count + "개를 구매했습니다.");
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getSortedNumber());
        }
    }

    public void printWinningStatistics(Map<Rank, Integer> statistics) {
        System.out.println("\n당첨 통계"); // 실행 결과 예시의 줄바꿈
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", statistics.get(Rank.FIFTH));
        System.out.printf("4개 일치 (50,000원) - %d개\n", statistics.get(Rank.FOURTH));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", statistics.get(Rank.THIRD));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", statistics.get(Rank.SECOND));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", statistics.get(Rank.FIRST));
    }
}
