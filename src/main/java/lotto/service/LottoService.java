package lotto.service;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;

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
}
