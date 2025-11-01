package lotto.service;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.domain.Rank;

public class LottoService {
    private final ParseService parseService;
    private PurchaseAmount purchaseAmount;
    private Lotto winningNumbers;
    private BonusNumber bonusNumber;

    public LottoService(ParseService parseService) {
        this.parseService = parseService;
    }

    public void setupLotto(String rawPurchaseAmount, String rawWinningNumbers, String rawBonusNumber) {
        this.purchaseAmount = parseService.createPurchaseAmountFromInput(rawPurchaseAmount);
        this.winningNumbers = parseService.createWinningNumbersFromInput(rawWinningNumbers);
        this.bonusNumber = parseService.createBonusNumberFromInput(rawBonusNumber);
    }

    public Map<Rank, Integer> calculateStatistics(List<Lotto> purchasedLottos, Lotto winningLotto, BonusNumber bonusNumber) {
        Map<Rank, Integer> result = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }

        for (Lotto lotto : purchasedLottos) {
            int matchCount = lotto.countMatchingNumbers(winningLotto);
            boolean bonusMatch = lotto.contains(bonusNumber.getNumber());

            Rank rank = Rank.valueOfRank(matchCount, bonusMatch);

            result.put(rank, result.get(rank) + 1);
        }

        return result;
    }
}
