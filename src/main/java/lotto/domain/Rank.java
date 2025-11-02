package lotto.domain;

import java.util.Arrays;
import java.util.Map;

public enum Rank {
    NOTHING(0, false, 0),
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);

    private final int matchCount;
    private final boolean bonusMatch;
    private final int money;

    Rank(int matchCount, boolean bonusMatch, int money) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public static Rank valueOfRank(int matchCount, boolean bonusMatch) {
        if (matchCount == SECOND.matchCount && bonusMatch == SECOND.bonusMatch) {
            return SECOND;
        }

        if (matchCount == THIRD.matchCount && bonusMatch == THIRD.bonusMatch) {
            return THIRD;
        }

        return findRankByMatchCount(matchCount);
    }

    private static Rank findRankByMatchCount(int matchCount) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount && !rank.bonusMatch)
                .findFirst()
                .orElse(NOTHING);
    }
}
