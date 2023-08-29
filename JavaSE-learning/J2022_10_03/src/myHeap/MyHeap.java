package myHeap;

import java.util.Arrays;

public class MyHeap {
    public int[] elem;
    public int usedSize;//当前堆中有效数据个数

    public MyHeap(){
        this.elem = new int[10];
        this.usedSize = 0;
    }

    //传入数组
    public void initArray(int[] array){
        this.elem = Arrays.copyOf(array, array.length);
        this.usedSize = this.elem.length;
    }

    //交换
    private void swap(int[]array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    //向下调整算法
    private void adjustDown(int parent, int len){
        int child = 2 * parent + 1;
        while(child < len){
            //建立小顶堆，那么就要找到更小的
            //注意child+1可能越界
            if(child+1 < usedSize && this.elem[child+1] < this.elem[child]){
                child++;
            }
            //如果孩子更小，那么交换
            if(this.elem[child] < this.elem[parent]){
                //交互完成后，继续向下走
                swap(this.elem, child, parent);
                parent = child;
                child = 2 * parent + 1;
            }else{
                break;
            }

        }
    }
    //向上调整算法
    private void adjustUp(int child){
        int parent = (child-1) / 2;
        while(child > 0){
            if(this.elem[child] < this.elem[parent]){
                swap(elem, child, parent);
                child = parent;
                parent = (child-1) / 2;
            }else{
                break;
            }
        }
    }

    //显示
    public void display(){
        System.out.println(Arrays.toString(this.elem));
    }

    //堆的建立（以小顶堆为例）
    public void createHeap(){
     //从最后一个非叶结点开始依次向下调整
     for(int parent = (usedSize-1-1)/2; parent>=0; parent--){
         adjustDown(parent, usedSize);
     }
    }

    //堆的插入
    public void insert(int val){
        if(isFull()){
            this.elem = Arrays.copyOf(this.elem, this.elem.length*2);
        }
        this.elem[usedSize] = val;
        usedSize++;
        adjustUp(usedSize-1);
    }

    //堆的删除
    public int remove(){
        if(isEmpty()){
            return -1;
        }
        int retVal = this.elem[0];
        swap(this.elem, 0, usedSize-1);
        usedSize--;
        adjustDown(0 ,usedSize);
        return retVal;
    }

    //判满
    public boolean isFull(){
        return this.usedSize == this.elem.length;
    }

    //判空
    public boolean isEmpty(){
        return this.usedSize == 0;
    }
}
