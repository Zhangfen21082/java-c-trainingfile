import javafx.geometry.Pos;

import java.awt.font.TextMeasurer;
import java.util.Arrays;

public class MyArrayList {
    public int[] elem;//核心数组
    public int usedSize;//记录有效数据个数
    public static final int DefaultCapacity = 2;//默认顺序表容量

    //构造函数
    public MyArrayList(){
        this.elem = new int[DefaultCapacity];
    }

    //打印顺序表
    public void display(){
        for(int i = 0; i < this.usedSize; i++){
            System.out.print(elem[i] + " ");
        }
        System.out.println();
    }

    //新增元素（默认新增在最后）
    public void add(int data){
        //如果数组已经满了，那么进行扩容（2倍）
        if(isFull()){
            elem = Arrays.copyOf(elem, 2*elem.length);//可查看Arrays用法
        }
        elem[usedSize] = data;
        usedSize++;
    }

    //新增元素（在pos位置新增）
    public void add(int pos, int data){
        try{
            //检查位置是否合法
            checkAddPos(pos-1);
            //如果数组已经满了，那么进行扩容（2倍）
            if(isFull()){
                elem = Arrays.copyOf(elem, 2*elem.length);//可查看Arrays用法
            }
            //如果合法则继续执行
            for(int i = usedSize-1; i>=pos-1; i--){
                elem[i+1] = elem[i];
            }
            elem[pos-1] = data;
            usedSize++;
        }catch (PosIndexNotLegalException e){
            //如果非法抛出异常后捕获
            e.printStackTrace();
        }

    }

    //判断顺序表是否满
    public boolean isFull(){
        return usedSize == elem.length;
    }

    //检查add元素时，pos位置是否合法？
    private void checkAddPos(int pos){
        if(pos < 0 || pos > usedSize){
            throw  new PosIndexNotLegalException("所给位置非法");//抛出异常
        }
    }

    //检查get元素时，pos位置是否合法？（注意区别上面，因为add元素时，pos位置是可以等于usedSize的）
    private void checkGetPos(int pos){
        if(pos < 0 || pos >= usedSize)
            throw new PosIndexNotLegalException("所给位置非法");
    }

    //判断是否包含某个元素
    public boolean contains(int data){
        for(int i = 0; i < usedSize; i++){
            if(elem[i] == data)
                return true;
        }
        return false;
    }

    //返回某个元素对应位置，如果返回-1，表示该元素不存在
    public int indexOf(int data){
        for(int i = 0; i < usedSize; i++){
            if(elem[i] == data)
                return i;
        }
        return -1;
    }

    //获取pos位置的元素
    public int get(int pos){
        int retVal = -1;
        try{
            checkGetPos(pos-1);
            retVal = elem[pos-1];
        }catch (PosIndexNotLegalException e) {
            e.printStackTrace();
        }
        return retVal;
    }

    //将pos位置处的元素设置为data
    public void set(int pos, int data){
        checkGetPos(pos-1);
        elem[pos-1] = data;
    }

    //删除第一次出现的data
    public void del(int data){
        //首先检查此元素是否存在
        int index = indexOf(data);
        if(index == -1){
            System.out.println("此元素不存在");
            return;
        }
        for(int i = index; i <usedSize-1; i++){
            elem[i] = elem[i+1];
        }
        usedSize--;
    }

    //销毁顺序表
    public void clear(){
        usedSize = 0;
    }
}
