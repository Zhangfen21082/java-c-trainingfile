package myStack;

import java.util.Arrays;

public class MyStack {
    public int[] elem;
    public int usedSize;//当前栈中有效元素个数，也即top指针
    public static final int DEFAULT_CAPACITY = 10;//默认容量

    public MyStack(){
        elem = new int[DEFAULT_CAPACITY];
    }

    //压栈
    public void push(int val){
        //如果栈满则扩容
        if(isFull()){
            elem = Arrays.copyOf(elem, 2*elem.length);
        }

        //放置元素，并移动指针
        elem[usedSize] = val;
        usedSize++;
    }

    //判满
    public boolean isFull(){
        if(elem.length == usedSize){
            return true;
        }
        return false;
    }

    //出栈
    public int pop(){
        //判空
        if(isEmpty()){
            throw new StackEmptyException("栈空！无法删除");
        }

        int retVal = elem[usedSize-1];;
        usedSize--;
        return retVal;
    }

    //判空
    public boolean isEmpty(){
        if(usedSize == 0){
            return true;
        }
        return false;
    }

    //查看栈顶元素
    public int peek(){
        //判空
        if(isEmpty()){
            throw new StackEmptyException("栈空！无法删除");
        }
        return elem[usedSize-1];
    }

    //返回栈顶有效元素个数
    public int size(){
        return usedSize;
    }
}
