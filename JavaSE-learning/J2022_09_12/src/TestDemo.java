import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/*class MyArray<T extends Number>{
    public T[] array = (T[])new Object[10];//注意：不能写成 "T[] array = new T[10]"

    public T getPos(int pos){
        return this.array[pos];
    }
    public void setVal(int pos, T val){
        this.array[pos] = val;
    }
    public T[] getArray(){
        return array;
    }
}

public class TestDemo {
    public static void main(String[] args) {
        MyArray<Integer> myArray1 = new MyArray<>();
        MyArray<Double> myArray2 = new MyArray<>();
        MyArray<String> myArray3 = new MyArray<>();
    }
}*/

/*
class MyArray<E extends Number>{
    public E[] array = (E[])new Object[10];
}

public class TestDemo {
    public static void main(String[] args) {
        MyArray<Integer> myArray1 = new MyArray<>();
        MyArray<Double> myArray2 = new MyArray<>();
        MyArray<String> myArray3 = new MyArray<>();
    }
}*/


/*
class Alg<T extends Comparable<T>>{
    //注意T需要实现该接口
    public T findMaxVal(T[] array){
        T max = array[0];
        for(int i = 1; i < array.length; i++){
            if(array[i].compareTo(max) > 0){
                //说明arr[i]比目前的最大值还要大，所以更新max
                max = array[i];
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Integer[] test1 ={99, 2, 199, 23, 34, 73};
        Double[] test2 = {3.14, 9.01, 19.83, 6.24, 5.33};
        String[] test3 = {"hello", "world", "this", "is", "it"};

        Alg<Integer> test1_alg = new Alg<>();
        Alg<Double> test2_alg = new Alg<>();
        Alg<String> test3_alg = new Alg<>();
        System.out.println(test1_alg.findMaxVal(test1));
        System.out.println(test2_alg.findMaxVal(test2));
        System.out.println(test3_alg.findMaxVal(test3));
    }
}*/


/*
class Alg{
    public static<T extends Comparable> T findMaxVal(T[] array){
        T max = array[0];
        for(int i = 1; i < array.length; i++){
            if(array[i].compareTo(max) > 0){
                //说明arr[i]比目前的最大值还要大，所以更新max
                max = array[i];
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Integer[] test1 ={99, 2, 199, 23, 34, 73};
        Double[] test2 = {3.14, 9.01, 19.83, 6.24, 5.33};
        String[] test3 = {"hello", "world", "this", "is", "it"};

        System.out.println(Alg.findMaxVal(test1));//注意完整形式为"Alg.<Integer>findMaxVal(test1)"，也可以省略
        System.out.println(Alg.findMaxVal(test2));//注意完整形式为"Alg.<Double>findMaxVal(test1)"，也可以省略
        System.out.println(Alg.findMaxVal(test3));//注意完整形式为"Alg.<String>findMaxVal(test1)"，也可以省略
    }
}*/


/*
public class TestDemo {
    public static void main(String[] args) {
        //装箱：新建一个Integer类型对象，将i的值放入对象的某个属性中
        int i = 10;
        Integer ii =new Integer(i); //或者"Integer = Integer.valueOf(i)"
        //拆箱：将Integer对象中的值取值，放到一个基本类型中
        int j = ii.intValue();
    }
}*/


public class TestDemo {
    public static void main(String[] args) {
        //自动装箱
        int i = 10;
        Integer ii = i;//或者"Integer ii = (Integer)i"
        //自动拆箱
        int j = ii;//或者"int j = (int)ii"
    }
}