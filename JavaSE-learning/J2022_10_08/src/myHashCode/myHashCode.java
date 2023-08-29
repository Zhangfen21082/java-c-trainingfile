package myHashCode;

import java.util.Arrays;

public class myHashCode {
    static class Node{
        public int key;
        public int value;
        public Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    public Node[] array;
    public int usedSize;
    public static final float loadFactor = 0.75F; //负载因子

    public myHashCode() {
        this.array = new Node[10];
        this.usedSize = 0;
    }

    //返回负载因子
    private float getLoadFactor(){
        return usedSize*1.0f / array.length;
    }
    //扩容
    private void resize(){
        Node[] newArray = new Node[2 * this.array.length];
        for(int i =0; i < this.array.length; i++){
            Node cur = this.array[i];
            while(cur != null){
                Node next = cur.next;
                int index = cur.key % newArray.length;
                cur.next = newArray[index];
                cur = next;
            }
        }
        this.array = newArray;
    }

    //存储key-value
    public Boolean put(int key, int val){
        int index = key % this.array.length;
        Node cur = this.array[index];
        while(cur != null){
            if(key == cur.key){
                cur.value = val;  //一旦key相同则覆盖
                return false;
            }
            cur = cur.next;
        }
        Node newNode = new Node(key, val);
        newNode.next = this.array[index];
        this.array[index] = newNode;
        usedSize++;
        //检查负载因子是否需要扩容
        if(this.getLoadFactor() > loadFactor){
            //扩容
            this.resize();
        }
        return true;
    }

    //返回key对应的value
    public int get(int key){
        int index = key % array.length;
        Node cur = this.array[index];
        while(cur != null){
            if(key == cur.key){
                return cur.value;
            }
            cur = cur.next;
        }
        return -1;
    }
}
