package lotto;

import java.util.List;

public class BonusLotto extends Lotto {

    private final int NUMBERS_LENGTH = 1;
    public List<LottoNumber> numbers;

    public BonusLotto() {
        super();
    }

    public BonusLotto(List<LottoNumber> numbers) {
        super(numbers);
    }

    @Override
    public boolean isValid() {
        return super.isValid();
    }

    @Override
    public List<LottoNumber> makeInitialPot() {
        return super.makeInitialPot();
    }

    @Override
    public int matchCount(Lotto lottoB) {
        return super.matchCount(lottoB);
    }
}
