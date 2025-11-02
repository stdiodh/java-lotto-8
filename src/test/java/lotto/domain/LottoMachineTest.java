package lotto.domain;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {
    @Test
    void 로또_발행_개수_테스트() {
        LottoMachine lottoMachine = new LottoMachine();
        int count = 8;

        List<Lotto> lottos = lottoMachine.generateLottos(count);

        assertThat(lottos).isNotNull();
        assertThat(lottos.size()).isEqualTo(8);
    }
}
