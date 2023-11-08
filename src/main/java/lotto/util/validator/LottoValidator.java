package lotto.util.validator;

import lotto.error.LottoErrorMessage;
import lotto.util.constant.LottoConstant;

public class LottoValidator extends Validator {

    public static void validateRange(String input) {
        validateNumeric(input);
        int number = Integer.parseInt(input);
        if (number < LottoConstant.LOTTO_MIN_NUMBER || number > LottoConstant.LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(LottoErrorMessage.LOTTO_NUMBER_RANGE_EXCEPTION.getMessage());
        }
    }
}
