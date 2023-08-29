package myHeap;

public class TestDemo {
    public static void main(String[] args) {
        MyHeap myHeap = new MyHeap();
        int[] array = {27, 15, 19, 18, 28, 34, 65, 49, 25, 37};
        myHeap.initArray(array);
        myHeap.createHeap();
        myHeap.display();
        myHeap.insert(3);
        myHeap.display();
        myHeap.remove();
        myHeap.display();
        myHeap.remove();
        myHeap.display();
    }
}
