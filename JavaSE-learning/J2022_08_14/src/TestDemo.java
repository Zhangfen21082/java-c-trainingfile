
/*public class TestDemo {
    public static void main(String[] args){
        //使用常量字符串构造
        String str1 = "Hello World1";
        //直接newString对象
        String str2 = new String("Hello World2");
        //使用字符数组进行构造
        char[] arr = {'H','e','l','l','o','W','o','r','l','d','3'};
        String str3 = new String(arr);

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
    }
}*/


/*public class TestDemo {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int c = 10;

        //对于基本类型，比较的是值
        System.out.println(a == b);
        System.out.println(a == c);

        System.out.println("----------------------------------------------");

        //对于引用类型，比较是否引用的是同一个对象
        String s1 = new String("hello");
        String s2 = new String("hello");
        String s3 = new String("world");
        String s4 = s1;
        System.out.println(s1 == s2);
        System.out.println(s2 == s3);
        System.out.println(s1 == s4);
    }
}*/


/*public class TestDemo {
    public static void main(String[] args) {
        String s1 = new String("hello");
        String s2 = new String("hello");
        String s3 = new String("hello");

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }
}*/


/*
public class TestDemo {
    public static void main(String[] args) {
        String s1 = new String("abc");
        String s2 = new String("ac");
        String s3 = new String("abc");
        String s4 = new String("abcdef");

        System.out.println(s1.compareTo(s2));//不同输出字符差值 -1
        System.out.println(s1.compareTo(s3)); //相同为零
        System.out.println(s1.compareTo(s4)); //前k个字符完全相同，输出长度差值 -3
    }
}*/


/*
public class TestDemo {
    public static void main(String[] args) {
        String s1 = new String("abc");
        String s2 = new String("ac");
        String s3 = new String("ABc");
        String s4 = new String("abcdef");
        System.out.println(s1.compareToIgnoreCase(s2));
        System.out.println(s1.compareToIgnoreCase(s3));//相同
        System.out.println(s1.compareToIgnoreCase(s4));
    }
}*/


/*
public class TestDemo {
    public static void main(String[] args) {
        String s1 = new String("Hello");
        String s2 = new String("World");

        char c1 = s1.charAt(2);
        System.out.println(c1);
        System.out.println("-----------------------------------");

        for(int i = 0; i < s2.length(); i++){
            System.out.println(s2.charAt(i));
        }
    }
}*/


/*
public class TestDemo {
    public static void main(String[] args) {
        String s1 = new String("one two three one four nine");

        System.out.println(s1.indexOf("one", 4));
        System.out.println(s1.indexOf("one", 15));

    }
}
*/

/*public class TestDemo {
    public static void main(String[] args) {
        String s1 = String.valueOf(123);
        String s2 = String.valueOf(3.14);
        String s3 = String.valueOf(true);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}*/


/*
public class TestDemo {
    public static void main(String[] args) {
        int num1 = Integer.parseInt("1234");
        int num2 = Integer.parseInt("64", 8);//8表示八进制，八进制下的64对应十进制下的52
        double num3 = Double.parseDouble("3.14");
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);
    }
}*/


import java.util.Locale;

/*public class TestDemo {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "HELLO";

        //小写转换为大写
        System.out.println(s1 + "->" + s1.toUpperCase());
        //大写转换为小写
        System.out.println(s2 + "->" + s2.toLowerCase());
    }
}*/


/*
public class TestDemo {
    public static void main(String[] args) {
        String str = "Hello!";
        char[] ch = str.toCharArray();

        for(int i = 0; i < ch.length; i++){
            System.out.println(ch[i]);
        }
    }
}*/


/*
public class TestDemo {
    public static void main(String[] args) {
        String str = String.format("%d-%d-%d", 2000, 10, 12);
        System.out.println(str);
        System.out.println(str);
        System.out.println(str);
        System.out.println(str);
        System.out.println(str);
        System.out.println(str);
        System.out.println("test");
    }
}*/


/*
public class TestDemo{
    public static void main(String[] args) {
        String s1 = "HelloWorld,Hello You";
        String s2 = s1.replaceFirst("Hello", "Bye"); //将第一个Hello替换为Bye
        System.out.println(s2);
    }
}*/


/*
public class TestDemo{
    public static void main(String[] args) {
        String str = "中国-北京市-东城区-长安街-天安门广场";
        String[] ret = str.split("-", 3);
        for(String s : ret){
            System.out.println(s);
        }
    }
}*/


/*
public class TestDemo{
    public static void main(String[] args) {
        String str = "www.baidu.com";
        String[] ret = str.split("\\.");
        for(String s : ret){
            System.out.println(s);
        }
    }
}*/

/*
public class TestDemo{
    public static void main(String[] args) {
        String str = "name=zhangsan&age=18";
        String[] result = str.split("&");
        for(int i = 0; i < result.length;i++){
            String[] temp = result[i].split("=");
            System.out.println(temp[1]);
        }
    }
}*/


public class TestDemo{
    public static void main(String[] args) {
        String str = "-Hello_World";
        String str1 = str.substring(7);
        String str2 = str.substring(1,6);
        System.out.println(str1);
        System.out.println(str2);
    }
}