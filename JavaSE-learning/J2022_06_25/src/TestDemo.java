

/*public class TestDemo {
    public static void main(String[] args) {
        //格式1
        int a = 10;
        if(a > 1){
            System.out.println("不知道写啥");
        }
        System.out.println("---------------------------------");

        //格式2
        int b = 3;
        int c = 5;
        if(b > c){
            System.out.println("b比c要大");
        }else{
            System.out.println("b比c要小");
        }
        System.out.println("---------------------------------");

        //格式3
        int score = 77;
        if(score >= 90){
            System.out.println("优秀");
        }else if(score >= 80 && score < 90){
            System.out.println("良好");
        }else if(score >= 70 && score < 80){
            System.out.println("中等");
        }else if(score >= 60 && score < 70){
            System.out.println("及格");
        }else if(score >= 0 && score < 60){
            System.out.println("不及格");
        }else{
            System.out.println("错误数据");
        }
    }
}*/

import java.util.Random;
import java.util.Scanner;

/*public class TestDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //循环输入
        while (scanner.hasNextInt()) {
            int year = scanner.nextInt();//输入年份
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    System.out.println(year + "是闰年");
                } else {
                    System.out.println(year + "是平年");
                }
            } else {
                if (year % 4 == 0) {
                    System.out.println(year + "是闰年");
                } else {
                    System.out.println(year + "是平年");
                }
            }
        }
    }
}*/


/*public class TestDemo {
    public static void main(String[] args) {
        int day = 2;
        switch(day){
            case 1:
                System.out.println("周一");
                break;
            case 2:
                System.out.println("周二");
            case 3:
                System.out.println("周三");
                break;
            default:
                System.out.println("休息");
                break;
        }
    }
}*/


/*
public class TestDemo {
    public static void main(String[] args) {
        int i = 1;
        while(i <= 10){
            System.out.println(i++);
        }
    }
}*/

/*public class TestDemo {
    public static void main(String[] args) {
        int i = 1;
        int sum = 0;
        while(i <= 100){
            sum+=i++;
        }
        System.out.println(sum);
    }
}*/

/*public class TestDemo {
    public static void main(String[] args) {
        int num = 1;//统计每个阶乘
        int ret = 0;
        while(num <= 5){
            int i = 1;
            int  multi = 1;
            while(i <= num){
                multi*=i++;
            }
            ret+=multi;//累加
            num++;
        }
        System.out.println(ret);
    }
}*/





/*
public class TestDemo {
    public static void main(String[] args) {
        int i = 1;
        int sumJ = 0;
        int sumO = 0;
        while(i <= 100){
            if(i %2 == 0) {
                sumO += i;
            }else{
                sumJ += i;
            }
            i++;
        }
        System.out.println("1-100的和为：" + (sumJ+sumO));
        System.out.println("1-100奇数和为：" + sumJ);
        System.out.println("1-100偶数的和为：" + sumO);
    }
}*/

/*public class TestDemo {
    public static void main(String[] args) {
        int num = 1000;
        while(num <= 2000){
            if(num%7 != 0){
                num++;
                continue;
            }
            System.out.println("1000-2000中是7的倍数的数有：" + num + " ");
            num++;
        }
    }
}*/


/*
public class TestDemo {
    public static void main(String[] args) {
        int num = 1;
        while(num <= 100) {
            if(num%3 != 0 || num%5 != 0){
                num++;
                continue;
            }
            System.out.println(num+" ");
            num++;
        }
    }
}*/


/*public class TestDemo {
    public static void main(String[] args) {

        int ret = 0;
        for(int i = 1; i <= 5; i++){
            int sum = 1;
            for(int j = 1; j <= i; j++){
                sum*=j;
            }
            ret += sum;
        }
        System.out.println(ret);
    }
}*/




/*public class TestDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       int sum = 0;
       int num = 0;
       while(sc.hasNextInt()){
           int temp = sc.nextInt();
           sum += temp;
           num++;
           if(num == 10) {
               break;
           }
       }
        System.out.println(sum);
    }
}*/


public class TestDemo {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        int Guess = random.nextInt(100);
        int count = 0;
        while(true){
            if(count == 10){
                break;
            }
            int num = sc.nextInt();
            if(num < Guess){
                System.out.println("小了");
            }else if(num > Guess){
                System.out.println("大了");
            }else{
                System.out.println("You are right");
                break;
            }
            count++;
        }
        if(count == 10){
            System.out.println("达到10次");
        }
        sc.close();
    }
}
