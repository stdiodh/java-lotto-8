package lotto;

import lotto.controller.InputController;
import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.service.ParseService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        ParseService parseService = new ParseService();
        LottoService lottoService = new LottoService();

        InputController inputController = new InputController(
                inputView, outputView, parseService);
        LottoController lottoController = new LottoController(
                outputView, lottoService, inputController);

        lottoController.run();
    }
}
