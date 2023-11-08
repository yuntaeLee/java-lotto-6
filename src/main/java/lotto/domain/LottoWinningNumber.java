package lotto.domain;

import lotto.error.LottoErrorMessage;
import lotto.util.constant.LottoConstant;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoWinningNumber {
    private final List<Integer> numbers;
    private final int bonusNumber;

    public LottoWinningNumber(List<Integer> numbers, int bonusNumber) {
        validate(numbers, bonusNumber);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> numbers, int bonusNumber) {
        if (!validateDuplicationNumberSize(numbers)) {
            throw new IllegalArgumentException(LottoErrorMessage.DUPLICATE_NUMBER_EXCEPTION.getMessage());
        }

        if (!validateDuplicationBonusNumber(numbers, bonusNumber)) {
            throw new IllegalArgumentException(LottoErrorMessage.DUPLICATE_BONUS_NUMBER_EXCEPTION.getMessage());
        }
    }

    private boolean validateDuplicationNumberSize(List<Integer> numbers) {
        Set<Integer> duplicationNumbers = new HashSet<>(numbers);
        return duplicationNumbers.size() == LottoConstant.LOTTO_COUNT;
    }

    private boolean validateDuplicationBonusNumber(List<Integer> numbers, int bonusNumber) {
        return !numbers.contains(bonusNumber);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
