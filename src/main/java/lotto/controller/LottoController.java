package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.domain.Rank;
import lotto.service.LottoService;
import lotto.service.ParseService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final OutputView outputView;
    private final LottoService lottoService;
    private final InputController inputController;

    public LottoController(InputView inputView, OutputView outputView,
                           ParseService parseService, LottoService lottoService) {
        this.outputView = outputView;
        this.lottoService = lottoService;
        this.inputController = new InputController(inputView, outputView, parseService);
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
