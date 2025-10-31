package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

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
}
