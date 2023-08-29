package lambda;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

//无返回值无参数
@FunctionalInterface
interface NoParameterNoReturn{
    void test();
}

//无返回值一个参数
@FunctionalInterface
interface OneParameterNoReturn{
    void test(int a);
}


//无返回值多个参数
@FunctionalInterface
interface MoreParametersNoReturn{
    void test(int a, int b);
}


//有返回值无参数
@FunctionalInterface
interface NoParameterReturn{
    int test();
}

//有返回值一个参数
@FunctionalInterface
interface OneParameterReturn{
    int test(int a);
}


//有返回值多个参数
@FunctionalInterface
interface MoreParameterReturn{
    int test(int a, int b);
}

class Test{
    public void func(){
        System.out.println("func方法");
    }
}

public class TestDemo {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(11, "what");
        map.put(22, "are");
        map.put(33, "you");
        map.put(44, "doing");
        map.put(55, "now");
        map.forEach(new BiConsumer<Integer, String>() {
            @Override
            public void accept(Integer integer, String s) {
                System.out.print("【key:" + integer + "val:" + s + "】 ");
            }
        });
        System.out.println();
        map.forEach((x, y) ->System.out.print("【key:" + x + "val:" + y + "】 "));
        System.out.println();
    }
}


/*public class TestDemo {
    public static void main(String[] args) {
        //无返回值无参数
        NoParameterNoReturn noParameterNoReturn = ()->{
            System.out.println("无返回值无参数1次");
            System.out.println("无返回值无参数2次");
        };
        noParameterNoReturn.test();
        System.out.println("=======================================================");

        //无返回值一个参数
        OneParameterNoReturn oneParameterNoReturn = (int a) ->{
            System.out.println("无返回值一个参数1次，传入参数为：" + a);
            System.out.println("无返回值一个参数2次，传入参数为：" + a);

        };
        oneParameterNoReturn.test(100);
        System.out.println("=======================================================");

        //无返回值多个参数
        MoreParametersNoReturn moreParametersNoReturn = (int a, int b) ->{
            System.out.println("无返回值多个参数1次，传入参数为：" + a + "和" + b);
            System.out.println("无返回值多个参数2次，传入参数为：" + a + "和" + b);
        };
        moreParametersNoReturn.test(200, 300);
        System.out.println("=======================================================");

        //有返回值无参数
        NoParameterReturn noParameterReturn = ()->{
            return 10;
        };
        int ret1 = noParameterReturn.test();
        System.out.println("返回值为：" + ret1);
        System.out.println("=======================================================");

        //有返回值一个参数
        OneParameterReturn oneParameterReturn = (int a)->{
            return a*a;
        };
        int ret2 = oneParameterReturn.test(10);
        System.out.println("参数：" + 10 + "；返回值为：" + ret2);
        System.out.println("=======================================================");

        //有返回值多个参数
        MoreParameterReturn moreParameterReturn = (int a, int b)->{
          return a * b;
        };
        int ret3 = moreParameterReturn.test(8, 9);
        System.out.println("参数a：" + 8 + "；参数b：" + 9 + "；返回值为：" + ret3);
        System.out.println("=======================================================");


    }
}*/
