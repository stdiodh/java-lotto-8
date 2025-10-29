package lotto.controller;

import lotto.domain.PurchaseAmount;
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
        PurchaseAmount punchaseAmount = setupPurchaseAmount();
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
}
