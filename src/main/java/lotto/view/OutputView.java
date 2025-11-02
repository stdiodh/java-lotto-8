package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;

public class OutputView {
    private static final String PURCHASE_COUNT_MESSAGE = "%d개를 구매했습니다.";
    private static final String STATISTICS_HEADER = "\n당첨 통계";
    private static final String SEPARATOR = "---";
    private static final String FIFTH_PLACE_MESSAGE = "3개 일치 (5,000원) - %d개\n";
    private static final String FOURTH_PLACE_MESSAGE = "4개 일치 (50,000원) - %d개\n";
    private static final String THIRD_PLACE_MESSAGE = "5개 일치 (1,500,000원) - %d개\n";
    private static final String SECOND_PLACE_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n";
    private static final String FIRST_PLACE_MESSAGE = "6개 일치 (2,000,000,000원) - %d개\n";
    private static final String TOTAL_RETURN_MESSAGE = "총 수익률은 %.1f%%입니다.\n";

    public void printError(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printLottoCount(int count) {
        System.out.println();
        System.out.printf(PURCHASE_COUNT_MESSAGE + "\n", count);
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getSortedNumber());
        }
    }

    public void printWinningStatistics(Map<Rank, Integer> statistics) {
        System.out.println(STATISTICS_HEADER);
        System.out.println(SEPARATOR);
        System.out.printf(FIFTH_PLACE_MESSAGE, statistics.get(Rank.FIFTH));
        System.out.printf(FOURTH_PLACE_MESSAGE, statistics.get(Rank.FOURTH));
        System.out.printf(THIRD_PLACE_MESSAGE, statistics.get(Rank.THIRD));
        System.out.printf(SECOND_PLACE_MESSAGE, statistics.get(Rank.SECOND));
        System.out.printf(FIRST_PLACE_MESSAGE, statistics.get(Rank.FIRST));
    }

    public void printTotalReturn(double totalReturn) {
        System.out.printf(TOTAL_RETURN_MESSAGE, totalReturn);
    }
}
