package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;
import lotto.service.ParseService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final ParseService parseService;

    public LottoController(InputView inputView, OutputView outputView, ParseService parseService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.parseService = parseService;
    }

    public void run() {
        PurchaseAmount purchaseAmount = setupPurchaseAmount();
        WinningNumbers winningNumbers = setupWinningNumbers();
        BonusNumber bonusNumber = setupBonusNumber(winningNumbers);
    }

    private PurchaseAmount setupPurchaseAmount() {
        while (true) {
            try {
                String rawPurchaseAmount = inputView.readPurchaseAmount();

                return parseService.createPurchaseAmountFromInput(rawPurchaseAmount);
            } catch (IllegalArgumentException e) {
                String errorMessage = e.getMessage();
                outputView.printError(errorMessage);
            }
        }
    }

    private WinningNumbers setupWinningNumbers() {
        while (true) {
            try {
                String rawWinningNumbers = inputView.readWinningNumbers();

                return parseService.createWinningNumbersFromInput(rawWinningNumbers);
            } catch (IllegalArgumentException e) {
                String errorMessage = e.getMessage();
                outputView.printError(errorMessage);
            }
        }
    }

    private BonusNumber setupBonusNumber(WinningNumbers winningNumbers) {
        while (true) {
            try {
                String rawBonusNumber = inputView.readBonusNumber();
                BonusNumber bonusNumber = parseService.createBonusNumberFromInput(rawBonusNumber);

                bonusNumber.validateDuplicate(winningNumbers);

                return bonusNumber;
            } catch (IllegalArgumentException e) {
                String errorMessage = e.getMessage();
                outputView.printError(errorMessage);
            }
        }
    }
}
