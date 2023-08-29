package singletonPattern;

import java.util.Timer;
import java.util.TimerTask;

public class TestDemo4 {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask(){
            @Override
            public void run(){
                System.out.println("3s时间到");
            }
        }, 3000);

        System.out.println("开始计时");
    }
}
