package lotto.service;

import java.util.Arrays;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;

public class ParseService {
    private static final String DELIMITER = ",";

    public PurchaseAmount createPurchaseAmountFromInput(String rawPurchaseAmount) {
        int number = validateAndParseNumber(rawPurchaseAmount);

        return new PurchaseAmount(number);
    }

    public Lotto createWinningNumbersFromInput(String rawWinningNumber) {
        validateNullValue(rawWinningNumber);

        List<Integer> numbers = Arrays.stream(rawWinningNumber.split(DELIMITER, -1))
                .map(String::trim)
                .map(this::validateAndParseNumber)
                .toList();

        return new Lotto(numbers);
    }

    public BonusNumber createBonusNumberFromInput(String rawBonusNumber) {
        int number = validateAndParseNumber(rawBonusNumber);

        return new BonusNumber(number);
    }

    private int validateAndParseNumber(String value) {
        validateNullValue(value);
        return parseNumber(value);
    }

    private void validateNullValue(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 공백은 들어올 수 없습니다.");
        }
    }

    private int parseNumber(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 들어오도록 다시 입력해주세요.");
        }
    }
}
