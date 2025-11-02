package lotto.service;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.PurchaseAmount;
import lotto.domain.Rank;

public class LottoService {
    private final LottoMachine lottoMachine;

    public LottoService() {
        this.lottoMachine = new LottoMachine();
    }

    public List<Lotto> purchaseLottos(int count) {
        return lottoMachine.generateLottos(count);
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

    public double calculateTotalReturn(Map<Rank, Integer> statistics, PurchaseAmount purchaseAmount) {
        double totalPrizeMoney = 0;
        for (Map.Entry<Rank, Integer> entry : statistics.entrySet()) {
            Rank rank = entry.getKey();
            int count = entry.getValue();
            totalPrizeMoney += (long) rank.getMoney() * count;
        }

        double totalInvestment = purchaseAmount.getLottoCount() * 1000.0;

        return (totalPrizeMoney / totalInvestment) * 100.0;
    }
}
