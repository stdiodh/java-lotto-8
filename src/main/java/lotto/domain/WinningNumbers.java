package lotto.domain;

import java.util.List;

public class WinningNumbers {
    private final List<Integer> numbers;
    private static final String ERROR_INVALID_RANGE = "[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다. 확인 후 다시 입력해주세요.";

    public WinningNumbers(List<Integer> numbers) {
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validateRange (List<Integer> numbers) {
        for(Integer number : numbers) {
            checkNumberInRange(number);
        }
    }

    private void checkNumberInRange (int number) {
        if(number < 1 || number > 45) {
            throw new IllegalArgumentException(ERROR_INVALID_RANGE);
        }
    }
}
