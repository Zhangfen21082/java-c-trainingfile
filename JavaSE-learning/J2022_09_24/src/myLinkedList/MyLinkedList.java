package myLinkedList;

public class MyLinkedList {
    //结点定义
    static class ListNode{
        public int val;
        public ListNode prev;
        public ListNode next;
        public ListNode(int val){
            this.val = val;
        }
    }

    //头结点和尾节点
    public ListNode head;
    public ListNode tail;

    //显示链表
    public void disPlay(){
        ListNode cur = this.head;
        while(cur != null){
            System.out.print(cur.val + "---");
            cur = cur.next;
        }
        System.out.println();
    }
    //返回某个索引对应的结点
    private ListNode findIndexNode(int index){
        ListNode cur = head;
        while(index != 0){
            cur = cur.next;
            index--;
        }
        return cur;
    }

    //判断某个结点是否在链表中
    public boolean contains(int key){
        ListNode cur = this.head;
        while(cur != null){
            if(cur.val == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //返回链表长度
    public int size(){
        int count = 0;
        ListNode cur = this.head;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }

    //头插法
    public void createHead(int data){
        ListNode node = new ListNode(data);
        if(this.head == null){
            this.head = node;
            this.tail = node;
        }else{
            node.next = this.head;
            this.head.prev = node;
            head = node;
        }
    }

    //尾插法
    public void createTail(int data){
        ListNode node = new ListNode(data);
        if(this.head == null){
            this.head = node;
            this.tail = node;
        }else{
            this.tail.next = node;
            node.prev = this.tail;
            this.tail = node;
        }
    }

    //给定索引插入对应位置
    public void insertByIndex(int index, int data){
        ListNode node = new ListNode(data);
        if(index < 0 || index > this.size()){
            throw  new IndexNotLegalException("非法位置");
        }
        if(index == 0){
            createHead(data);
            return;
        }
        if(index == size()){
            createTail(data);
            return;
        }
        ListNode cur = findIndexNode(index);
        node.next = cur;
        cur.prev.next = node;
        node.prev = cur.prev;
        cur.prev = node;
    }

    //删除第一次出现关键字为key结点
    public void remove(int key){
        ListNode cur = this.head;
        while(cur != null){
            //如果找到就开始删除
            if(cur.val == key){
                //如果删除的第一个元素
                if(cur == this.head){
                    this.head = this.head.next;
                    //防止删除后没有元素导致空指针异常，所以这里要进行判断
                    if(head != null) {
                        this.head.prev = null;
                    }
                }else {
                    cur.prev.next = cur.next;
                    //如果删除的是最后一个结点
                    if(cur.next == null){
                        this.tail =this.tail.prev;
                    }else {
                        cur.next.prev = cur.prev;
                    }
                }
                return;
            }
            cur = cur.next;
        }
    }

    //删除所有关键字为key的结点
    public void removeAll(int key){
        ListNode cur = this.head;
        while(cur != null){
            //如果找到就开始删除
            if(cur.val == key){
                //如果删除的第一个元素
                if(cur == this.head){
                    this.head = this.head.next;
                    //防止删除后没有元素导致空指针异常，所以这里要进行判断
                    if(head != null) {
                        this.head.prev = null;
                    }
                }else {
                    cur.prev.next = cur.next;
                    //如果删除的是最后一个结点
                    if(cur.next == null){
                        this.tail =this.tail.prev;
                    }else {
                        cur.next.prev = cur.prev;
                    }
                }
            }
            cur = cur.next;
        }
    }

    //清空链表
    public void clear(){
        ListNode cur = this.head;
        while(cur != null){
            ListNode curNext = cur.next;
            cur.next = null;
            cur.prev = null;
            cur = curNext;
        }
        this.head = null;
        this.tail = null;
    }


}
