package lotto;

import lotto.Lotto;
import lotto.LottoGame;
import lotto.LottoGameDisplay;
import lotto.LottoNumber;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LottoGameTest {

    private LottoGame lottoGame;
    private Lotto sampleLotto;
    private List<Lotto> lottos;
    private LottoGameDisplay lottoGameDisplay;

    @Before
    public void setUp() throws Exception {
        lottoGame = new LottoGame(2000);
        sampleLotto = new Lotto(Arrays.asList(
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(11),
                new LottoNumber(12),
                new LottoNumber(13)
        ));

        lottos = Arrays.asList(
                new Lotto(Arrays.asList(
                        new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(6)
                )),
                new Lotto(Arrays.asList(
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(6),
                        new LottoNumber(7)
                ))
        );
    }


    @Test
    public void calculatePrizeSum() {
        // input: lotto output: prizeSum

        lottoGame.setLottoHolder(lottos);
        assertEquals(10000, lottoGame.getPrizeSum(sampleLotto));
    }

    @Test
    public void getProfitRate() {
        lottoGame.setCost(14000);
        lottoGame.setLottoHolder(lottos);
        assertEquals(71, lottoGame.getProfitRate(sampleLotto));
    }
}