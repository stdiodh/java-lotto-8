package lotto.domain;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {
    @Test
    void 보너스_번호가_1과_45사이일_때_성공_테스트() {
        assertThat(new BonusNumber(20)).isNotNull();
    }

    @Test
    void 보너스_번호가_1과_45사이가_아닐_때_예외_테스트() {
        assertThatThrownBy(() -> new BonusNumber(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    void 보너스_번호_중복이_없을_때_성공_테스트() {
        BonusNumber validBonusNumber = new BonusNumber(7);

        assertThatCode(() -> validBonusNumber.validateDuplicate(new Lotto(List.of(1, 2, 3, 4, 5, 6))))
                .doesNotThrowAnyException();
    }

    @Test
    void 보너스_번호_중복_시_예외_테스트() {
        BonusNumber duplicateBonusNumber = new BonusNumber(6);

        assertThatThrownBy(() -> duplicateBonusNumber.validateDuplicate(new Lotto(List.of(1, 2, 3, 4, 5, 6))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }
}
