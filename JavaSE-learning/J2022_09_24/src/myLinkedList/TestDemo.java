package myLinkedList;

public class TestDemo {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.createTail(2);
        myLinkedList.createTail(2);
        myLinkedList.createTail(2);
        myLinkedList.createTail(2);
        myLinkedList.createTail(2);
        myLinkedList.createTail(2);
        myLinkedList.removeAll(2);
        myLinkedList.disPlay();
    }
}
