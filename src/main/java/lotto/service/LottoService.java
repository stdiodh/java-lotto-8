package lotto.service;

import lotto.domain.BonusNumber;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;

public class LottoService {
    private final ParseService parseService;
    private PurchaseAmount purchaseAmount;
    private WinningNumbers winningNumbers;
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
