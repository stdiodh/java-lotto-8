package lotto.service;

import java.util.List;
import java.util.Map;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.domain.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoServiceTest {
    private LottoService lottoService;
    private Lotto winningLotto;
    private BonusNumber bonusNumber;

    @BeforeEach
    void setUp() {
        this.lottoService = new LottoService(null);
        this.winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        this.bonusNumber = new BonusNumber(7);
    }

    @Test
    void 통계_계산_확인_테스트() {
        List<Lotto> purchasedLottos = List.of(
                new Lotto(List.of(1, 2, 3, 10, 11, 12)), // 3개 일치 (5등)
                new Lotto(List.of(1, 2, 40, 41, 42, 43)) // 2개 일치 (꽝)
        );

        Map<Rank, Integer> statistics = lottoService.calculateStatistics(purchasedLottos, winningLotto, bonusNumber);

        assertThat(statistics.get(Rank.FIFTH)).isEqualTo(1);
        assertThat(statistics.get(Rank.NOTHING)).isEqualTo(1);
        assertThat(statistics.get(Rank.FIRST)).isEqualTo(0);
    }

    @Test
    void 통계_계산_테스트_2등_3등_구분() {
        List<Lotto> purchasedLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 7)), // 5개 일치 + 보너스 (2등)
                new Lotto(List.of(1, 2, 3, 4, 5, 8))  // 5개 일치 (3등)
        );

        Map<Rank, Integer> statistics = lottoService.calculateStatistics(purchasedLottos, winningLotto, bonusNumber);

        assertThat(statistics.get(Rank.SECOND)).isEqualTo(1);
        assertThat(statistics.get(Rank.THIRD)).isEqualTo(1);
    }

    @Test
    void 총_수익률_계산_정수_테스트() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(1000);

        List<Lotto> purchasedLotto = List.of(
                new Lotto(List.of(1, 2, 3, 10, 11, 12)) // 3개 일치 (5등)
        );

        // (총 수입 : 5000 / 초기 자금 : 1000) * 100 = 500
        Map<Rank, Integer> statistics = lottoService.calculateStatistics(purchasedLotto, winningLotto, bonusNumber);
        double totalReturn = lottoService.calculateTotalReturn(statistics, purchaseAmount);

        assertThat(totalReturn).isEqualTo(500.0);
    }

    @Test
    void 총_수익률_계산_소수점_테스트() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(8000);

        List<Lotto> purchasedLotto = List.of(
                new Lotto(List.of(1, 3, 5, 14, 22, 45)) // 3개 일치 (5등)
        );

        Map<Rank, Integer> statistics = lottoService.calculateStatistics(purchasedLotto, winningLotto, bonusNumber);
        double totalReturn = lottoService.calculateTotalReturn(statistics, purchaseAmount);

        //(총 수입 : 5000 / 초기 자금 : 8000) * 100 = 62.5
        assertThat(totalReturn).isEqualTo(62.5);
    }
}
