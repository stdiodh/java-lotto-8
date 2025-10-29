package lotto.service;

import java.util.Arrays;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;

public class ParseService {
    private static final String DELIMITER = ",";
    private static final String ERROR_NULL_VALUE = "[ERROR] 공백은 들어올 수 없으니 다시 입력해주세요.";
    private static final String ERROR_NOT_A_NUMBER = "[ERROR] 숫자가 들어오도록 다시 입력해주세요.";

    public PurchaseAmount createPurchaseAmountFromInput(String rawPurchaseAmount) {
        int number = validateAndParseNumber(rawPurchaseAmount);

        return new PurchaseAmount(number);
    }

    public WinningNumbers createWinningNumbersFromInput(String rawWinningNumber) {
        validateNullValue(rawWinningNumber);

        List<Integer> numbers = Arrays.stream(rawWinningNumber.split(DELIMITER))
                .map(String::trim)
                .map(this::parseNumber)
                .toList();

        return new WinningNumbers(numbers);
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
        if(value == null || value.isBlank()) {
            throw new IllegalArgumentException(ERROR_NULL_VALUE);
        }
    }

    private int parseNumber(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NOT_A_NUMBER);
        }
    }
}
