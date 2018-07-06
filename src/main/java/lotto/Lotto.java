package lotto;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private final int NUMBERS_LENGTH = 6;
    protected List<LottoNumber> numbers;

    public static Lotto of(Integer... numbers) {
        if (numbers.length == 0)
            return new Lotto();

        return new Lotto(Arrays.stream(numbers)
                .map(LottoNumber::new)
                .collect(Collectors.toList()));
    }

    public Lotto() {
        initializeNumbers();
    }

    public Lotto(List<LottoNumber> numbers) {
        this.numbers = numbers;
        if (!isValid())
            throw new IllegalArgumentException();
    }

    public boolean isValid() {
        return isLengthValid() && isNonOverlapValid();
    }

    private boolean isNonOverlapValid() {
        long  distinctSize = numbers.stream()
                .map(LottoNumber::getValue)
                .distinct()
                .count();
        return distinctSize == numbers.size();
    }

    private boolean isLengthValid() {
        return numbers.size() == NUMBERS_LENGTH;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < NUMBERS_LENGTH; i++) {
            sb.append(String.valueOf(numbers.get(i)));
            sb.append(", ");
        }
        return sb.toString().substring(0, sb.length() - 2) + "]";
    }

    public void initializeNumbers() {
        numbers = new ArrayList<>();
        List<LottoNumber> pot = makeInitialPot();

        Collections.shuffle(pot);
        for (int i = 0; i < NUMBERS_LENGTH; i++) {
            numbers.add(pot.get(i));
        }

        Collections.sort(numbers);

    }

    public List<LottoNumber> makeInitialPot() {
        List<LottoNumber> pot = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            pot.add(new LottoNumber(i));
        }
        return pot;
    }

    public int matchCount(Lotto lottoB) {
        List<LottoNumber> matchingNumbers = lottoB.numbers.stream()
                .filter(num -> containsNumber(num))
                .collect(Collectors.toList());
        return matchingNumbers.size();
    }

    private boolean containsNumber(LottoNumber number) {

        return this.numbers.contains(number);
    }
}
