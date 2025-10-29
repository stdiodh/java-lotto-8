package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    static final String PURCHASE_AMOUNT_PROMPT = "구입금액을 입력해 주세요.";
    static final String WINNING_NUMBERS_PROMPT = "당첨 번호를 입력해 주세요.";
    static final String BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.";

    public String readInput() {
        return Console.readLine();
    }

    public String readPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_PROMPT);
        return readInput();
    }

    public String readWinningNumbers() {
        System.out.println(WINNING_NUMBERS_PROMPT);
        return readInput();
    }

    public String readBonusNumber() {
        System.out.println(BONUS_NUMBER_PROMPT);
        return readInput();
    }
}
