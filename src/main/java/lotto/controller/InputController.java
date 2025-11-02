package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.service.ParseService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class InputController {
    private final InputView inputView;
    private final OutputView outputView;
    private final ParseService parseService;

    public InputController(InputView inputView, OutputView outputView, ParseService parseService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.parseService = parseService;
    }

    public PurchaseAmount setupPurchaseAmount() {
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

    public Lotto setupWinningNumbers() {
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

    public BonusNumber setupBonusNumber(Lotto winningNumbers) {
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
