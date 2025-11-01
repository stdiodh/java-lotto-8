package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {
    @Test
    void 당첨_1등_테스트() {
        assertThat(Rank.valueOfRank(6, false)).isEqualTo(Rank.FIRST);
    }

    @Test
    void 당첨_2등_테스트() {
        assertThat(Rank.valueOfRank(5, true)).isEqualTo(Rank.SECOND);
    }

    @Test
    void 당첨_3등_테스트() {
        assertThat(Rank.valueOfRank(5, false)).isEqualTo(Rank.THIRD);
    }

    @Test
    void 당첨_4등_테스트() {
        assertThat(Rank.valueOfRank(4, false)).isEqualTo(Rank.FOURTH);
    }

    @Test
    void 당첨_5등_테스트() {
        assertThat(Rank.valueOfRank(3, false)).isEqualTo(Rank.FIFTH);
    }

    @Test
    void 낙첨_테스트_2개() {
        assertThat(Rank.valueOfRank(2, false)).isEqualTo(Rank.NOTHING);
    }

    @Test
    void 낙첨_테스트_2개_보너스() {
        assertThat(Rank.valueOfRank(2, true)).isEqualTo(Rank.NOTHING);
    }

    @Test
    void 낙첨_테스트_1개() {
        assertThat(Rank.valueOfRank(1, true)).isEqualTo(Rank.NOTHING);
    }

    @Test
    void 낙첨_테스트_0개() {
        assertThat(Rank.valueOfRank(0, false)).isEqualTo(Rank.NOTHING);
    }
}
