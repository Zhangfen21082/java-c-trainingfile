package myBinarySearchTree;

import java.util.function.BinaryOperator;

public class TestDemo {
    public static void main(String[] args) {
        MyBinarySearchTree myBinarySearchTree = new MyBinarySearchTree();
        int[] array = {21,28,14,32,25,18,11,30,19};
        for(int i = 0; i < array.length; i++){
            myBinarySearchTree.insert(array[i]);
        }
    }
}
