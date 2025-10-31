package lotto.controller;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.PurchaseAmount;
import lotto.service.ParseService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final ParseService parseService;
    private final LottoMachine lottoMachine;

    public LottoController(InputView inputView, OutputView outputView, ParseService parseService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.parseService = parseService;
        this.lottoMachine = new LottoMachine();
    }

    public void run() {
        PurchaseAmount purchaseAmount = setupPurchaseAmount();
        Lotto winningNumbers = setupWinningNumbers();
        BonusNumber bonusNumber = setupBonusNumber(winningNumbers);

        int count = purchaseAmount.getLottoCount();
        List<Lotto> lottos = lottoMachine.generateLottos(count);
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

    private Lotto setupWinningNumbers() {
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

    private BonusNumber setupBonusNumber(Lotto winningNumbers) {
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
