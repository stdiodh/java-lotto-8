package lotto.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ParseServiceTest {
    private ParseService parseService;

    @BeforeEach
    void setup() {
        parseService = new ParseService();
    }

    @Test
    void 구매금액_파싱_성공_테스트() {
        String rawPurchaseAmount = "1000";

        assertThat(parseService.createPurchaseAmountFromInput(rawPurchaseAmount)).isNotNull();
    }

    @Test
    void 구매금액이_공백일_때_예외_테스트() {
        String rawPurchaseAmount = "";

        assertThatThrownBy(() -> parseService.createPurchaseAmountFromInput(rawPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 공백은 들어올 수 없으니 다시 입력해주세요.");
    }

    @Test
    void 구매금액이_숫자가_아닐_때_예외_테스트() {
        String rawPurchaseAmount = "String";

        assertThatThrownBy(() -> parseService.createPurchaseAmountFromInput(rawPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자가 들어오도록 다시 입력해주세요.");
    }

    @Test
    void 당첨_번호_파싱_성공_테스트() {
        String rawWinningNumber = "1,2,3,4,5,6";

        assertThat(parseService.createWinningNumbersFromInput(rawWinningNumber)).isNotNull();
    }

    @Test
    void 당첨_번호가_공백일_때_예외_태스트() {
        String rawWinningNumber = "";

        assertThatThrownBy(() -> parseService.createPurchaseAmountFromInput(rawWinningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 공백은 들어올 수 없으니 다시 입력해주세요.");
    }

    @Test
    void 보너스_번호_파싱_성공_테스트() {
        String rawWinningNumber = "7";

        assertThat(parseService.createBonusNumberFromInput(rawWinningNumber)).isNotNull();
    }

    @Test
    void 보너스_번호가_공백일_때_예외_태스트() {
        String rawWinningNumber = "";

        assertThatThrownBy(() -> parseService.createBonusNumberFromInput(rawWinningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 공백은 들어올 수 없으니 다시 입력해주세요.");
    }
}
