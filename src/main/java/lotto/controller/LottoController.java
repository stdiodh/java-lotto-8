package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.domain.Rank;
import lotto.service.LottoService;
import lotto.view.OutputView;

public class LottoController {
    private final OutputView outputView;
    private final LottoService lottoService;
    private final InputController inputController;

    public LottoController(OutputView outputView,
                           LottoService lottoService, InputController inputController) {
        this.outputView = outputView;
        this.lottoService = lottoService;
        this.inputController = inputController;
    }

    public void run() {
        PurchaseAmount purchaseAmount = inputController.setupPurchaseAmount();
        Lotto winningNumbers = inputController.setupWinningNumbers();
        BonusNumber bonusNumber = inputController.setupBonusNumber(winningNumbers);

        int count = purchaseAmount.getLottoCount();
        List<Lotto> lottos = lottoService.purchaseLottos(count);
        outputView.printLottoCount(count);
        outputView.printLottos(lottos);

        Map<Rank, Integer> statistics = lottoService.calculateStatistics(lottos, winningNumbers, bonusNumber);
        double totalReturn = lottoService.calculateTotalReturn(statistics, purchaseAmount);
        outputView.printWinningStatistics(statistics);
        outputView.printTotalReturn(totalReturn);
    }
}
