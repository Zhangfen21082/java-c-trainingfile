package MyLinkedList;

import card.IndexNottLegelException;

public class MySingleList {
    //结点定义
    static class Node{
        public int val;
        public Node next;
        public Node(int val){
            this.val = val;
        }
    }
    public Node head;//头结点引用

    //构造函数
    public MySingleList(){
        this.head = null;
    }

    //检查位置是否合法
    private void checkIndex(int index){
        if(index < 0 || index > this.size()){
            throw new IndexNottLegelException("非法位置");
        }
    }

    //找寻前置结点（依靠位置）
    private Node findIndexSubOfOne(int index){
        Node cur = head;
        while(index-1 != 0){
            cur = cur.next;
            index--;
        }
        return cur;
    }

    //找寻前置结点（依靠关键字）
    private Node findIndexPreOfOne(int key){
        Node cur = this.head;
        while(cur.next != null){
            if(cur.next.val == key){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    //打印单链表
    public void display(){
        Node cur = this.head;
        while(cur != null){
            System.out.print(cur.val + " -> ");
            cur = cur.next;
        }
        System.out.println();
    }

    //返回单链表长度
    public int size(){
        int count = 0;
        Node cur = this.head;
        while(cur != null){
            count ++;
            cur = cur.next;
        }
        return count;
    }

    //查找该链表是否存在key这个结点
    public boolean contains(int key){
        Node cur = this.head;
        while(cur != null){
            if(cur.val == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //头插法建立单链表
    public void creatHead(int data){
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    //尾插法建立单链表
    public void creatTail(int data){
        Node node = new Node(data);
        if(head == null){
            head = node;
        }else{
            Node cur = head;
            while(cur.next != null){
                cur = cur.next;
            }
            cur.next = node;
        }



    }

    //任意位置插入
    public void addIndex(int index, int data){
        checkIndex(index);
        if(index == 0){
            //等价于头插
            this.creatHead(data);
            return;
        }
        if(index == this.size()){
            //等价于尾插
            this.creatTail(data);
            return;
        }
        //非头插、非尾插，且index合法
        Node node = new Node(data);
        Node cur = findIndexSubOfOne(index);
        node.next = cur.next;
        cur.next = node;
    }

    //删除第一次关键字为key结点
    public void remove(int key){
        //如果head.val == key
        if(this.head.val == key){
            this.head = this.head.next;
            return;
        }

        Node cur = findIndexPreOfOne(key);
        if(cur == null){return;}
        Node del = cur.next;
        cur.next = del.next;
    }

    //删除所有值为key的结点
    public void removeAll(int key){
        if(this.head == null) return;
        Node cur = this.head.next;
        Node prev = this.head;
        while(cur != null){
            if(cur.val == key){
                prev.next = cur.next;
                cur = cur.next;
            }else{
                prev = cur;
                cur =cur.next;
            }
        }
        //如果head.val == key
        if(this.head.val == key){
            this.head = this.head.next;
            return;
        }
    }

    //清空链表
    public void clear(){
        this.head = null;//连锁销毁
    }
}
