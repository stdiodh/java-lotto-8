package lotto;

import lotto.controller.LottoController;
import lotto.service.ParseService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        ParseService parseService = new ParseService();

        LottoController lottoController = new LottoController(inputView, outputView, parseService);
        lottoController.run();
    }
}
