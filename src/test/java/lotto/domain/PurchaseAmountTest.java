package lotto.domain;

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
    void 로또_갯수_반환_테스트() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(8000);

        int lottoCount = purchaseAmount.getLottoCount();

        assertThat(lottoCount).isEqualTo(8);
    }
}
