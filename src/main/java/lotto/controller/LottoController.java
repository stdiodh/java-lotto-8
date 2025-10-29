package lotto.controller;

import lotto.view.InputView;

public class LottoController {
    private final InputView inputView;

    public LottoController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        setupLotto();
    }

    private void setupLotto() {
        String rawPurchaseAmount = inputView.readPurchaseAmount();
        String rawWinningNumbers = inputView.readWinningNumbers();
        String rawBonusNumber = inputView.readBonusNumber();
    }
}
