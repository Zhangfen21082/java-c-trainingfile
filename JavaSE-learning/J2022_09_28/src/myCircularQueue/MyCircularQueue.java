package myCircularQueue;

public class MyCircularQueue {
    public int[] elem;
    public int usedSize;
    public int front;//队头
    public int rear;//队尾

    public MyCircularQueue(int k){
        this.elem = new int[k];
    }

    //入队
    public boolean enQueue(int value){
        if(this.isFull()){
            return false;
        }
        this.elem[rear] = value;
        this.rear = (this.rear+1) % (this.elem.length);
        return true;
    }

    //出队
    public boolean deQueue(){
        if(this.isEmpty()){
            return false;
        }
        this.front = (this.front+1)%(this.elem.length);
        return true;
    }

    //获取队头元素
    public int getFront(){
        if(isEmpty()) {
            return -1;
        }
        return this.elem[this.front];
    }

    //获取队尾元素
    public int getRear(){
        if(isEmpty()) {
            return -1;
        }
        int index = this.rear-1;
        if(this.rear == 0) {
           index = this.elem.length - 1;
        }
        return this.elem[index];
    }

    //判空
    public boolean isEmpty(){
        return this.rear == this.front;
    }
    //判满
    public boolean isFull(){
        return (this.rear+1)%(this.elem.length) == this.front;
    }
}
