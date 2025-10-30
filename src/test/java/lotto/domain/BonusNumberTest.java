package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {
    private static final int SUCCESS_BONUS_NUMBER = 20;
    private static final int FAIL_BONUS_NUMBER = 46;

    private static final WinningNumbers WINNING_NUMBERS = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
    private static final int VALID_BONUS_NUMBER = 7;
    private static final int DUPLICATE_BONUS_NUMBER = 6;

    @Test
    void 보너스_번호가_1과_45사이일_때_성공_테스트() {
        assertThat(new BonusNumber(SUCCESS_BONUS_NUMBER)).isNotNull();
    }

    @Test
    void 보너스_번호가_1과_45사이가_아닐_때_예외_테스트() {
        assertThatThrownBy(() -> new BonusNumber(FAIL_BONUS_NUMBER))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다. 확인 후 다시 입력해주세요.");
    }

    @Test
    void 보너스_번호_중복_성공_테스트() {
        BonusNumber validBonusNumber = new BonusNumber(VALID_BONUS_NUMBER);

        assertThatCode(() -> validBonusNumber.validateDuplicate(WINNING_NUMBERS))
                .doesNotThrowAnyException();
    }

    @Test
    void 보너스_번호_중복_시_예외_테스트() {
        BonusNumber duplicateBonusNumber = new BonusNumber(DUPLICATE_BONUS_NUMBER);

        assertThatThrownBy(() -> duplicateBonusNumber.validateDuplicate(WINNING_NUMBERS))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다. 확인 후 다시 입력해주세요.");
    }
}
