package lotto.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

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
                .hasMessageContaining("[ERROR] 공백은 들어올 수 없습니다.");
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
    void 당첨_번호가_공백일_때_예외_테스트() {
        String rawWinningNumber = "";

        assertThatThrownBy(() -> parseService.createWinningNumbersFromInput(rawWinningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 공백은 들어올 수 없습니다.");
    }

    @Test
    void 당첨_번호가_숫자가_아닌_값이_포함될_때_예외_테스트() {
        String rawWinningNumber = "1,2,3,a,b,c";

        assertThatThrownBy(() -> parseService.createWinningNumbersFromInput(rawWinningNumber))
                .isInstanceOfAny(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자가 들어오도록 다시 입력해주세요.");
    }

    @Test
    void 당첨_번호가_공백이_포함될_때_예외_테스트() {
        String rawWinningNumber = "1,,3,4,5,6";

        assertThatThrownBy(() -> parseService.createWinningNumbersFromInput(rawWinningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 공백은 들어올 수 없습니다.");
    }

    @Test
    void 보너스_번호_파싱_성공_테스트() {
        String rawBonusNumber = "7";

        assertThat(parseService.createBonusNumberFromInput(rawBonusNumber)).isNotNull();
    }

    @Test
    void 보너스_번호가_공백일_때_예외_테스트() {
        String rawBonusNumber = "";

        assertThatThrownBy(() -> parseService.createBonusNumberFromInput(rawBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 공백은 들어올 수 없습니다.");
    }

    @Test
    void 보너스_번호가_숫자가_아닐_때_예외_테스트() {
        String rawBonusNumber = "a";

        assertThatThrownBy(() -> parseService.createBonusNumberFromInput(rawBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자가 들어오도록 다시 입력해주세요.");
    }
}
