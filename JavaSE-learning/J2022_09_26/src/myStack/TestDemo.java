package myStack;

import java.util.Stack;

public class TestDemo {
    public static void main(String[] args) {
        MyStack s = new MyStack();
        s.push(12);
        s.push(34);
        s.push(56);
        s.push(78);
        s.push(90);

        System.out.println("获取栈中有效元素个数：" + s.size());
        System.out.println("获取栈顶元素：" + s.peek());
        s.pop();
        s.pop();
        System.out.println("出栈两个元素并返回此时栈顶元素：" + s.peek());
        System.out.println("判断栈是否为空：" + s.isEmpty());

    }
}
