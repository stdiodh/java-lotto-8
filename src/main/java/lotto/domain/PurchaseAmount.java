package lotto.domain;

public class PurchaseAmount {
    private final Integer lottoCount;
    private static final String ERROR_NOT_SEPARATED_BY_1000 = "[ERROR] 구입 금액은 1,000원으로 나누어 떨어져야 합니다.";
    private static final String ERROR_AMOUNT_IS_ZERO = "[ERROR] 구입 금액은 1000원 이상이어야 합니다.";

    public PurchaseAmount(Integer value) {
        validate(value);
        this.lottoCount = calculatingTheNumberOfLotto(value);
    }

    private void validate(Integer value) {
        validateSeparatedBy1000(value);
        validateAmountIsZero(value);
    }

    private void validateSeparatedBy1000(Integer value) {
        if (value % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_NOT_SEPARATED_BY_1000);
        }
    }

    private void validateAmountIsZero(Integer value) {
        if(value == 0) {
            throw new IllegalArgumentException(ERROR_AMOUNT_IS_ZERO);
        }
    }

    private int calculatingTheNumberOfLotto(Integer value) {
        return value / 1000;
    }

    public int getLottoCount() {
        return this.lottoCount;
    }
}
