package lotto.domain;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchaseAmountTest {
    @Test
    void 구입_금액_1000원_단위_검증_테스트() {
        assertThatThrownBy(() -> new PurchaseAmount(1500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 1,000원으로 나누어 떨어져야 합니다.");
    }

    @Test
    void 구입_금액_0원_예외_테스트() {
        assertThatThrownBy(() -> new PurchaseAmount(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 최소 1,000원 이상이어야 합니다.");
    }

    @Test
    void 투자금_계산_테스트() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(8000);

        double investment = purchaseAmount.calculateInvestment();

        assertThat(investment).isEqualTo(8000.0);
    }

    @Test
    void 로또_갯수_요청_테스트() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(8000);

        LottoMachine lottoMachine = new LottoMachine();

        List<Lotto> lottos = purchaseAmount.purchaseLottos(lottoMachine);

        assertThat(lottos.size()).isEqualTo(8);
    }
}
