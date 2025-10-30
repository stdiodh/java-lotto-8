package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest {
    private static final List<Integer> SUCCESS_NUMBERS = Arrays.asList(1, 2, 3, 4, 5, 6);
    private static final List<Integer> FAIL_NUMBERS = Arrays.asList(0, 2, 3, 4, 5, 46);

    @Test
    void 당첨_번호가_모두_1과_45사이일_때_성공_테스트() {
        assertThat(new WinningNumbers(SUCCESS_NUMBERS)).isNotNull();
    }

    @Test
    void 당첨_번호_중_하나라도_1과_45사이가_아닐_때_예외_테스트() {
        assertThatThrownBy(() -> new WinningNumbers(FAIL_NUMBERS))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다. 확인 후 다시 입력해주세요.");
    }
}

