package lotto.domain;

public class PurchaseAmount {
    private final Integer value;
    private static final String ERROR_NOT_SEPARATED_BY_1000 = "[ERROR] 구입 금액은 1,000원으로 나누어 떨어져야 합니다.";

    public PurchaseAmount(Integer value) {
        validateSeparatedBy1000(value);
        this.value = value;
    }

    private void validateSeparatedBy1000(Integer value) {
        if(value % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_NOT_SEPARATED_BY_1000);
        }
    }
}
