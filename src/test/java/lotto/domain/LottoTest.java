package lotto.domain;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호_생성_성공_테스트() {
        assertThat(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))).isNotNull();
    }

    @Test
    void 로또_번호가_6개가_아닐_때_예외_테스트() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @Test
    void 로또_번호_중_하나라도_1과_45사이가_아닐_때_예외_테스트() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(0, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    void 로또_번호_오름차순으로_정렬_성공_테스트() {
        Lotto lotto = new Lotto(List.of(6, 5, 4, 3, 2, 1));
        List<Integer> expectedSortedList = List.of(1, 2, 3, 4, 5, 6);

        List<Integer> sortedNumbers = lotto.getSortedNumber();

        assertThat(sortedNumbers).isEqualTo(expectedSortedList);
    }
}
