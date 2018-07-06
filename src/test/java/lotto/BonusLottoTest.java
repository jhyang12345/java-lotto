package lotto;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BonusLottoTest {

    @Test
    public void setUp() throws Exception {
        BonusLotto bonus = new BonusLotto();
        System.out.println(bonus.numbers.size());
    }
}