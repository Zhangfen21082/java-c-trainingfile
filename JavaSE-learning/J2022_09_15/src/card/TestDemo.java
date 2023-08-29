package card;

import java.security.Policy;
import java.util.List;

public class TestDemo {
    public static void main(String[] args) {
        //买牌
        Poker poker = new Poker();
        List<Card> ret = poker.buyPoker();
        System.out.println(ret);

        //洗牌
        Poker.shuffle(ret);
        System.out.println(ret);
    }
}
