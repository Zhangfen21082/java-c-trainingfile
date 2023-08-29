/*public class TestDemo {
    public static void main(String[] args) {
        int sum = 0;
        for(int i = 1; i <= 5; i++){
            sum += fac(i);
        }
        System.out.println("1!+2!+3!+4!+5!=" + sum);
    }
    //计算的n!
    public static int fac(int n){
        System.out.print("计算" + n + "!=：");
        int ret = 1;
        for(int i = 1; i <= n ; i++){
            ret*=i;
        }
        System.out.println(ret);
        return ret;
    }
}*/


import java.util.Scanner;


/*public class TestDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=i; j++){
                System.out.print(i + "*" + j + "=" + i * j+"\t");
            }
            System.out.println();
        }
    }
}*/


/*
public class TestDemo {
    public static void main(String[] args) {
        String PassWord = "nhjkasd";
        String input;
        int count = 0;
        do{
            Scanner sc = new Scanner(System.in);
            input = sc.nextLine();
            if(input.equals(PassWord)){
                System.out.println("登录成功");
                break;
            }else{
                System.out.println("密码错误，请重新输入");
            }
            count+=1;
        }while(count < 3);
        if(count == 3) {
            System.out.println("连续输入错误超过3次程序退出");
        }
    }
}*/


/*public class TestDemo {
    public static boolean judege(int num){
        int num1 = num;
        int sum = 0;

        while(num1!=0){
            sum+=Math.pow(num1%10, 3);
            num1/=10;
        }

        if(sum == num)
            return true;

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 100; i <= n; i++){
            if(judege(i)){
                System.out.println(i);
            }
        }

    }

}*/



/*
public class TestDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int r = 1;
        */
/*
        辗转相除法：a对b取余，接着b赋值给a，余数赋值给b，知道b为0
         *//*

        while(b!=0){
            r = a % b;
            a = b;
            b = r;
        }
        System.out.println(a);
    }
}*/


import java.util.Scanner;

/*public class TestDemo {
    public static void main(String[] args) {
        for(int year = 1000 ; year <= 2000; year++) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    System.out.println(year + "是闰年");
                }
            } else {
                if (year % 4 == 0) {
                    System.out.println(year + "是闰年");
                }
            }
        }

    }
}*/


/*public class TestDemo {
    public static boolean Prime(int n) {
        int i = 0;
        for (i = 2; i < Math.sqrt(n); i++) {    //从2循环到根号n
            if (n % i == 0) {
                return false;
            }
        }
        return  true;
    }

    public static void main(String[] args) {
        for(int i = 1 ; i <= 100 ; i++){
            if(Prime(i)){
                System.out.println(i);
            }
        }
    }
}*/


/*
public  class TestDemo {
    public static void main(String[] args) {
        int num = 0;
        int count = 0;//计数器
        for (num = 1; num <= 100; num++) {
            //判断个位上是否有 9
            if (num % 10 == 9) {
                count++;
            }
            //判断十位上是否有 9
            if (num / 10 == 9) {
                count++;
            }
        }
        System.out.println(count);
    }
}*/



/*public class TestDemo {
    public static void main(String[] args) {
        int sum = 0;
        for(int i = 1; i <= 5; i++){
            sum += fac(i);
        }
        System.out.println("1!+2!+3!+4!+5!=" + sum);
    }
    //计算的n!
    public static int fac(int n){
        System.out.print("计算" + n + "!=：");
        int ret = 1;
        for(int i = 1; i <= n ; i++){
            ret*=i;
        }
        System.out.println(ret);
        return ret;
    }
}*/

public class TestDemo {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        swap(a, b);
        System.out.println("a="+a+" b="+b);
    }
    public static void swap(int x, int y){
        int temp = x;
        x = y;
        y = temp;
    }
}
