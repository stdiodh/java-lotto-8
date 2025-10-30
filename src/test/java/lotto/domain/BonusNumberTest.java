package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class BonusNumberTest {
    private static final int SUCCESS_BONUS_NUMBER = 20;
    private static final int FAIL_BONUS_NUMBER = 46;

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
}
