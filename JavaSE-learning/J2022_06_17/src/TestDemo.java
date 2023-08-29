/*
int型
public class TestDemo {
    public static void main(String[] args) {
        //case1：在定义时给出初值
        int a = 10;
        System.out.println(a);
        System.out.println("---------------------------------------------");
        //case2：先定义后赋值
        int b;
        b = 20;
        System.out.println(b);
        System.out.println("---------------------------------------------");
        //case3：输出最大和最小值
        System.out.println("最大值"+Integer.MAX_VALUE);
        System.out.println("最小值"+Integer.MIN_VALUE);
        //case4：定义时未初始化或者超过范围，Java将直接报错，非常安全

        int c = 9999999999999999999999999999999999;//error
        int d;
        System.out.println(d);//error


    }
}
*/

/*
public class TestDemo {
    public static void main(String[] args) {
        //case1
        long a = 100;
        System.out.println(a);
        System.out.println("--------------");
        //case2：初始化时为了进行区分，建议在后面加L
        long b = 100L;
        System.out.println(a);
        System.out.println("--------------");
        //case3：输出最大和最小值
        System.out.println("最大值"+Long.MAX_VALUE);
        System.out.println("最小值"+Long.MIN_VALUE);
    }
}

 */

/*

public class TestDemo{
    public static void main(String[] args) {
        //cas1:
        short a = 10;
        System.out.println(a);
        //case2:
        System.out.println("最大值"+Short.MAX_VALUE);
        System.out.println("最小值"+Short.MIN_VALUE);
    }
}

*/


/*

public class TestDemo{
    public static void main(String[] args) {
        //cas1:
        byte a = 10;
        System.out.println(a);
        //case2:
        System.out.println("最大值"+Byte.MAX_VALUE);
        System.out.println("最小值"+Byte.MIN_VALUE);
    }
}

 */

/*
public class TestDemo{
    public static void main(String[] args) {
        //cas1:
        byte a = 10;
        byte b = (byte)(a + 1);
        System.out.println(a);
        System.out.println(b);
        //case2:
        System.out.println("最大值"+Byte.MAX_VALUE);
        System.out.println("最小值"+Byte.MIN_VALUE);
    }
}


 */


/*


public class TestDemo{
    public static void main(String[] args) {
        //case1:
        double  a = 3.14;
        System.out.println(a);

        //case2:
        int b1 = 1;
        int c1= 2;
        System.out.println(b1/c1);//不等于0.5，等于0
        double b2 = 1;
        double c2 = 2;
        System.out.println(b2/c2);//等于0.5
        System.out.println(b1*1.0/c1);//这样也是0.5

        //case3:
        double d = 1.1;
        System.out.printf("%.20f", d*d);
    }
}


 */


/*
public class TestDemo{
    public static void main(String[] args) {
        //case1
        char a = 'a';
        char b ='6';
        System.out.println(a);
        System.out.println(b);

        //case2
        char c = 97;
        System.out.println(c);

    }
}*/


/*
public class TestDemo{
    public static void main(String[] args) {
        //case1
        boolean flg = true;
        System.out.println(flg);
    }
}*/

/*public class TestDemo{
    public static void main(String[] args) {
        //case1:
        int a = 10;
        long b = 100L;
        b = a;//编译通过；4字节转向8字节
        a = b;//编译失败；8字节转向4字节会丢失
        a = (int)b;//强转

        //case2:
        float f = 3.14F;
        double d =5.12;
        d = f;//编译通过；4字节转向8字节
        f = d;//编译失败；8字节转向4字节会丢失
        f = (float)d;//强转

        //case3：
        byte b1 = 100;//编译通过；未超过byte范围，会将int下的100转化为byte
        byte b2 = 257;////编译失败；超出范围，数据丢失
        byte b3 = (byte)257;//强转
    }
}*/


/*
public class TestDemo{
    public static void main(String[] args) {
        byte a = 1;
        byte b = 2;
        byte c = a + b;
    }
}*/

/*public class TestDemo{
    public static void main(String[] args) {
        byte a = 10;
        byte b = 20;
        byte c = a + b;//编译错误，右面成了int了
        byte d = (byte)(a+b);//编译通过
    }
}*/


public class TestDemo{
    public static void main(String[] args) {
        //int转换为String
        int num = 10;
        String intToString = String.valueOf(num);

        //String转换为int
        String str = "100";
        int stringToInt = Integer.parseInt(str);

        System.out.println(intToString);
        System.out.println(stringToInt);

    }
}
