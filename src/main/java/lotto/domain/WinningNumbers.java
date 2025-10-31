package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbers {
    private final List<Integer> numbers;
    private static final String ERROR_INVALID_SIZE = "[ERROR] 당첨 번호는 6개여야 합니다. 확인 후 다시 입력해주세요.";
    private static final String ERROR_DUPLICATE_NUMBER = "[ERROR] 당첨 번호에 중복된 숫자가 없어야 합니다. 확인 후 다시 입력해주세요.";
    private static final String ERROR_INVALID_RANGE = "[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다. 확인 후 다시 입력해주세요.";

    public WinningNumbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validateRange (List<Integer> numbers) {
        for (Integer number : numbers) {
            checkNumberInRange(number);
        }
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicates(numbers);
        validateRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_INVALID_SIZE);
        }
    }

    private void validateDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (numbers.size() != uniqueNumbers.size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_NUMBER);
        }
    }

    private void checkNumberInRange (int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ERROR_INVALID_RANGE);
        }
    }

    public boolean contains(int number) {
        return this.numbers.contains(number);
    }
}
