/*public class TestDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        //创建一个可以容纳10个int类型元素的数组
        int[] arr1 = new int [10];

        //创建一个可以容纳5个double类型元素的数组
        double[] arr2 = new double[5];

        //创建一个可以容纳3个字符串元素的数组
        String[] arr3 = new String[3];
        System.out.println(arr3);
    }
}*/

/*public class TestDemo{
    public static void main(String[] args) {
        int[] arr = new int[]{11, 22, 33, 44, 55, 66, 77};
        for(int i = 0; i < arr.length; i++){
            arr[i] *= 2;
            System.out.print(arr[i]+" ");
        }
    }
}*/

/*public class TestDemo {
    public static void main(String[] args) {
        //定义一个引用变量arr1指向数组
        int[] arr1 = new int[3];
        //利用该引用变量操作数组
        arr1[0] = 10;
        arr1[1] = 20;
        arr1[2] = 30;

        int[] arr2 = new int[]{1, 2, 3, 4, 5};
        arr2[0] = 100;
        arr2[1] = 200;

        //重点：让arr1指向arr2，然后arr1修改arr2数组
        arr1 = arr2;
        arr1[2] = 300;
        arr1[3] = 400;
        arr1[4] = 500;

        for(int i = 0 ; i < arr2.length; i++){
            System.out.println(arr2[i]);
        }
    }
}*/


//public class TestDemo {
//
//    public static void modif(int[] arr1){
//        arr1[0] = 100;
//    }
//    public static void main(String[] args) {
//        int[] arr = new int[]{1, 2, 3};
//        System.out.println("修改前：" + arr[0]);
//        modif(arr);
//        System.out.println("修改后：" + arr[0]);
//    }
//}

/*public class TestDemo {
    public static int[] test(){
        int[] temp = {1, 2, 3, 4, 5};
        return temp;
    }
    public static void main(String[] args) {
        int[] ret = test();
        for(int i = 0; i < ret.length; i++){
            System.out.println(ret[i]);
        }
    }
}*/
