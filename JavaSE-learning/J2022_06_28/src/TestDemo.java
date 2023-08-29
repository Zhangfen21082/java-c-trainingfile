/*
public class TestDemo {
    public static void main(String[] args) {
        int a = add(1, 2);
        double b = add(3.14, 5.27);
        double c = add(1, 1.98, 2);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
    public static int add(int x, int y){
        return x + y;
    }
    public static double add(double x, double y){
        return x + y;
    }
    public static double add(int x, double y, int z){
        return x + y;
    }
}
*/

import java.util.Scanner;

/*
public class TestDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        for(int i = 1; i <= n; i++){
            sum += fac(i);
        }
        System.out.println("1!+2!+3!+4!+5!+...."+n+"!=" + sum);
    }
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


/*
public class TestDemo {
    public static int recur(int N){
        if(N == 1){//递归出口
            return 1;
        }
        return N * recur(N-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int ret = recur(N);
        System.out.println(N + "!=" + ret);
    }
}*/


/*
public class TestDemo{
    public static int fib(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1 || n == 2){
            return 1;
        }
        int a = 1;
        int b = 1;
        for(int i = 3; i <= n; i++){
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ret = fib(n);
        System.out.println(ret);
    }
}*/



/*public class TestDemo{
    public static void recur(int n){
        if(n < 10){
            System.out.println(n);
        }else{
            recur(n /10);
            System.out.println(n % 10);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        recur(n);
    }
}*/


/*
public class TestDemo {
    public static int recur(int n){
        if(n == 1){
            return 1;
        }else {
            return n + recur(n - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(recur(n));
    }
}*/


/*
public class TestDemo {
    public static int fib(int n){
        if(n == 0)
            return 0;
        if(n==1 || n==2)
            return 1;
        return fib(n-1)+fib(n-2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fib(n));
    }
}*/

public class TestDemo{
    public static int recur(int n){
        if(n < 10){
            return n;
        }else{
            return recur(n/10) + n%10;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(recur(n));
    }
}