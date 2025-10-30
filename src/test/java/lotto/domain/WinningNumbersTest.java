package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest {
    private static final List<Integer> SUCCESS_NUMBERS = Arrays.asList(1, 2, 3, 4, 5, 6);
    private static final List<Integer> ERROR_INVALID_SIZE_NUMBERS = Arrays.asList(1, 2, 3, 4, 5);
    private static final List<Integer> ERROR_DUPLICATE_NUMBERS = Arrays.asList(1, 1, 1, 1, 1, 1);
    private static final List<Integer> ERROR_INVALID_RANGE_NUMBERS = Arrays.asList(0, 2, 3, 4, 5, 46);

    @Test
    void 당첨_번호_생성_성공_테스트() {
        assertThat(new WinningNumbers(SUCCESS_NUMBERS)).isNotNull();
    }

    @Test
    void 당첨_번호가_6개가_아닐_때_예외_테스트() {
        assertThatThrownBy(() -> new WinningNumbers(ERROR_INVALID_SIZE_NUMBERS))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 6개여야 합니다. 확인 후 다시 입력해주세요.");
    }

    @Test
    void 당첨_번호_중_중복된_숫자가_있을_때_예외_테스트() {
        assertThatThrownBy(() -> new WinningNumbers(ERROR_DUPLICATE_NUMBERS))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호에 중복된 숫자가 없어야 합니다. 확인 후 다시 입력해주세요.");
    }

    @Test
    void 당첨_번호_중_하나라도_1과_45사이가_아닐_때_예외_테스트() {
        assertThatThrownBy(() -> new WinningNumbers(ERROR_INVALID_RANGE_NUMBERS))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다. 확인 후 다시 입력해주세요.");
    }
}
