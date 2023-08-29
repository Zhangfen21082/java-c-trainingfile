package myQueue;

public class MyQueue {
    //结点定义
    static class Node{
        public int val;
        public Node next;
        public Node(int val){
            this.val = val;
        }
    }

    //队列头结点和尾节点
    public Node front;
    public Node rear;

    //入队
    public void offer(int val){
        Node node = new Node(val);
        if(this.front == null){
            this.front = node;
            this.rear = node;
        }else{
            this.rear.next = node;
            this.rear = node;
        }
    }

    //出队
    public int poll(){
        if(this.front == null){
            return -1;
        }
        int retVal = this.front.val;
        if(this.front.next == null){
            this.front = this.rear =null;
        }else {
            this.front = this.front.next;
        }
        return retVal;
    }

    //查看队头元素
    public int peek(){
        if(this.front == null){
            return -1;
        }
        return this.front.val;
    }
}
