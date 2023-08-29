package MyLinkedList;

public class TestDemo {
    public static void main(String[] args) {
        MySingleList singleList = new MySingleList();
        singleList.creatTail(4);
        singleList.creatTail(9);
        singleList.creatHead(2);
        singleList.creatHead(23);
        singleList.addIndex(2, 999);
        singleList.remove(2);
        singleList.display();
    }

}
