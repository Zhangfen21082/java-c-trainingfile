/*public class TestDemo {
    public static void main(String[] args) {
        // 类型提升
        System.out.println(1+0.2);//1已经被提升为了double

        //注意/运算符
        System.out.println(5/2);//输出2
        System.out.println((float)5/2);//输出2.5
        System.out.println(5/(float)2);//输出2.5
        System.out.println((float)(5/2));//输出2.0
    }
}*/




/*public class TestDemo {
    public static void main(String[] args) {
        int a = 1;
        int b = 0;
        System.out.println(a / b);

    }
}*/

/*public class TestDemo {
    public static void main(String[] args) {
        System.out.println(10 % 3);
        System.out.println(10 % -3);
        System.out.println(-10 % 3);
        System.out.println(-10 % -3);
    }
}*/



/*public class TestDemo {
    public static void main(String[] args) {
        int a = 1;
        a+=2; //相当于a=a+2
        System.out.println(a);

        int b = 1;
        b-=2; //相当于b=b-2
        System.out.println(b);

        int c = 1;
        c*=2; //相当于c=c*2
        System.out.println(c);

        int d = 1;
        d/=2; //相当于d=d/2
        System.out.println(d);

        int e = 3;
        e%=2; //相当于e=e%2
        System.out.println(e);
    }
}*/


/*
public class TestDemo {
    public static void main(String[] args) {
        int a = 1;
        System.out.println(a++);//先使用故输出1，然后a变为2
        System.out.println(++a);//先++变为3然后输出
    }
}*/


/*
public class TestDemo {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        System.out.println(a==b);
        System.out.println(a!=b);
        System.out.println(a<b);
        System.out.println(a>b);
        System.out.println(a<=b);
        System.out.println(a>=b);
    }
}*/

/*public class TestDemo {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        System.out.println(a == 1 || b == 2);
        System.out.println(a == 1 || b > 100);
        System.out.println(a > 100 || b == 2);
        System.out.println(a > 100 || b > 100);

    }
}*/


/*public class TestDemo {
    public static void main(String[] args) {
        int a = 1;
        System.out.println(!(a == 1)); // a == 1 为true，取个非就是false
        System.out.println(!(a != 1)); // a != 1 为false，取个非就是true

    }
}*/



/*public class TestDemo {
    public static void main(String[] args) {
        //左移
        int a = 0x10;
        System.out.printf("%x\n", a);
        System.out.printf("%x\n", a << 1);
        System.out.println("---------------------------------");

        //右移
        int b = 0x10;//正数
        System.out.printf("%x\n", b);
        System.out.printf("%x\n", b >> 1);

        int c = 0xffff0000;//负数
        System.out.printf("%x\n", c);
        System.out.printf("%x\n", c >> 1);
        System.out.println("---------------------------------");


        //无符号右移
        int d = 0xffffffff;//负数
        System.out.printf("%x\n", d);
        System.out.printf("%x\n", d >>> 1);
    }
}*/


public class TestDemo {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int max = a>b?a:b;
        System.out.println(max);
    }
}
