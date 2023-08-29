//public class TestDemo {
//    public static String arrToString(int[] arr){
//        String ret = "[";
//        for(int i = 0; i < arr.length; i++){
//            ret += String.valueOf(arr[i]);
//            if(i < arr.length-1) {
//                ret += ", ";//最后一个逗号不要输出
//            }
//        }
//        ret += ']';
//        return ret;
//    }
//    public static void main(String[] args) {
//        int[] arr = new int[]{1, 7, 7, 8, 9, 2, 3, 0, 9, 17, 0, 7};
//        String ret = arrToString(arr);
//        System.out.println(ret);
//    }
//}


/*import java.util.Arrays;

public class TestDemo {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 7, 7, 8, 9, 2, 3, 0, 9, 17, 0, 7};
        int[] copy1 = Arrays.copyOf(arr, 3);
        int[] copy2 = Arrays.copyOf(arr, arr.length);
        int[] copy3 = Arrays.copyOf(arr, arr.length*3);
        int[] copy4 = Arrays.copyOfRange(arr, 3, 8);
        int[] copy5 = arr.clone();
        System.out.println("拷贝部分：" + Arrays.toString(copy1));
        System.out.println("拷贝完全：" + Arrays.toString(copy1));
        System.out.println("拷贝超过：" + Arrays.toString(copy3));
        System.out.println("范围拷贝：" + Arrays.toString(copy4));
        System.out.println("粗暴拷贝：" + Arrays.toString(copy5));
    }
}*/


/*
public class TestDemo {
    public static int binarySearch(int[] arr, int key){
        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
            int mid = (left+right) / 2;
            if(arr[mid] == key){
                return mid;
            }else if(arr[mid] < key) {
                left = mid + 1;
            }else{
                right = mid -1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{11, 22, 33, 44, 55, 66, 77, 88, 99, 100};
        System.out.println(binarySearch(arr, 88));
    }
}*/


/*import java.util.Arrays;

public class TestDemo {
    public static void bubbleSort(int[] arr){
        for(int i = 0; i < arr.length-1; i++){
            boolean flag = false;
            for(int j = 0; j < arr.length-1-i; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;
                }
            }
            if(!flag){
                return;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9, 8, 7, 6, 5, 5, 4, 2, 1, 28};
        System.out.println("排序前：" + Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
    }
}*/


/*import java.util.Arrays;

public class TestDemo {
    public static void transForm(int[] arr){
        for(int i = 0; i < arr.length; i++){
            arr[i] *= 2;
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{11, 22, 33, 44, 55};
        System.out.println("修改前：" + Arrays.toString(arr));
        transForm(arr);
        System.out.println("修改后：" + Arrays.toString(arr));
    }
}*/


/*
import java.util.Arrays;

public class TestDemo {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for(int i = 0; i < arr.length; i++){
            arr[i] = i+1;
        }
        System.out.println(Arrays.toString(arr));
    }
}*/


/*
public class TestDemo {
    public static boolean isSorted(int[] arr){
        for(int i = 0; i < arr.length-1; i++){
            if(arr[i] > arr[i+1]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 4, 5, 6};
        int[] arr2 = new int[]{1, 3, 4, 6, 7, 4};
        if(isSorted(arr1)){
            System.out.println("arr1有序");
        }else{
            System.out.println("arr1无序");
        }
        if(isSorted(arr2)){
            System.out.println("arr2有序");
        }else{
            System.out.println("arr2无序");
        }
    }
}*/

/*public class TestDemo {
    public static void main(String[] args) {
        int[][] arr1 = {{1, 2, 3,}, {4, 5, 6}};
        for(int[] tmp : arr1){
            for(int x : tmp){
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}*/

import java.util.Arrays;

public class TestDemo {
    public static void main(String[] args) {
        int[][] arr1 = new int[2][];
        arr1[0] = new int[3];
        arr1[1] = new int[5];
        System.out.println(Arrays.deepToString(arr1));
    }
}