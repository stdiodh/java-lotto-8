package lotto.domain;

public class BonusNumber {
    private final int number;
    private static final String ERROR_INVALID_RANGE = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다. 확인 후 다시 입력해주세요.";
    private static final String ERROR_BONUS_DUPLICATE = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다. 확인 후 다시 입력해주세요.";

    public BonusNumber(int number) {
        validateRange(number);
        this.number = number;
    }

    private void validateRange(int number) {
        if(number < 1 || number > 45) {
            throw new IllegalArgumentException(ERROR_INVALID_RANGE);
        }
    }

    public void validateDuplicate(WinningNumbers winningNumbers) {
        if(winningNumbers.contains(this.number)) {
            throw new IllegalArgumentException(ERROR_BONUS_DUPLICATE);
        }
    }
}
