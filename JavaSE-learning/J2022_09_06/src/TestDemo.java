//public class TestDemo {
//
//
//    public static void main(String[] args) {
//        StringBuilder s = new StringBuilder("hello");
//        s.reverse();
//        System.out.println(s);
//    }
//
//
//    public static void main4(String[] args) {
//        String s = "hello";
//        s += "world";
//        System.out.println(s);
//    }
//
//    public static void main3(String[] args) {
//        String s = new String("hello");//两个对象，一个在堆中，一个在常量池中
//        String s1 = s.intern();//检查常量池中是否存在“hello”，这里存在所以直接返回引用
//        String s2 = "hello";
//
//        System.out.println(s == s2);
//        System.out.println(s1 == s2);
//    }
//
//    public static void main2(String[] args) {
//        String str1 = "hello";
//        String str2 = "hello";
//        String str3 = new String("world");
//        String str4 = new String("world");
//        System.out.println(str3==str4);
//    }
//
//    public static void main1(String[] args) {
//        String str1 = "aaa";
//        String str2 = "aaa";
//        System.out.println(str1 == str2);
//
//    }
//}

//import java.io.File;
//import java.io.FileInputStream;
//
//public class TestDemo {
//    public static void main(String[] args) {
//        File file = new File("test");
//        FileInputStream fin = new FileInputStream(file);
//    }
//}

/*public class TestDemo {

    public static int getElement(int[] array, int index){
        if(null == array){
            throw new NullPointerException("传递的数组为null");
        }
        if(index < 0 || index >= array.length){
            throw new ArrayIndexOutOfBoundsException("数组下标越界");
        }
        return array[index];
    }
    public static void main(String[] args) {
        int[] arr = {61, 45, 93, 26, 88};
        int a = getElement(arr, 3);
        int b = getElement(arr, 10);
        int c = getElement(null, 2);

    }
}*/

/*public class TestDemo {
    public static void main(String[] args) {
        try{
            int[] arr = {1, 2, 3};
            System.out.println(arr[3]);  //数组越界异常
        }catch(NullPointerException e){
            e.printStackTrace();  //捕获空指针一样长
        }
        System.out.println("后续代码");
    }
}*/

/*public class TestDemo {
    public static void main(String[] args) {
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[100]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }finally {
            System.out.println("finally中代码执行");
        }

        System.out.println("后续代码");
    }
}*/


import java.util.InputMismatchException;
import java.util.Scanner;

public class TestDemo{
    public static int getDate(){
        Scanner sc = null;
        try {
            sc = new Scanner(System.in);
            int data = sc.nextInt();
            return data;
        }catch (InputMismatchException e){
            e.printStackTrace();
        }finally {
            System.out.println("finally中的代码");
            if(sc != null){
                System.out.println("关闭资源");
                sc.close();
            }
        }
        System.out.println("try-catch-finally后的代码");

        return 0;
    }

    public static void main(String[] args) {
        int data = getDate();
        System.out.println(data);
    }
}
