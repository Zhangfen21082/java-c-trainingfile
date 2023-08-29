package card;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//描述一张牌
class Card{
    public int cardFaceSize;//牌面大小
    public String cardDecor;//花色

    public Card(int cardFaceSize, String cardDecor) {
        this.cardFaceSize = cardFaceSize;
        this.cardDecor = cardDecor;
    }

    @Override
    public String toString() {
        return "【" + cardDecor + " " + cardFaceSize + "】";
    }
}

public class Poker {
    public static final String[]cardDecors = {"♥", "♠", "♣", "♦"};//花色数组

    //买来一副扑克
    public List<Card> buyPoker(){
        List<Card> poker = new ArrayList<>();//用于存放所有牌
        //有4种花色的牌，每种花色的牌有13张
        for(int i = 0; i < 4; i++){
            for(int j = 1; j <= 13; j++){
                Card card = new Card(j, cardDecors[i]);
                poker.add(card);
            }
        }
        return poker;
    }

    //交换牌，便于完成洗牌操作
    private static void swap(List<Card> poker, int i, int j){
        Card temp = poker.get(i);
        poker.set(i, poker.get(j));
        poker.set(j, temp);
    }

    //洗牌
    public static void shuffle(List<Card> poker){
        for(int i = poker.size()-1; i > 0; i--){
            Random random = new Random();
            int index = random.nextInt(i); // 产生一个[0, i)的随机整数
            swap(poker, index, i);//将这两个牌交换
        }
    }
}
