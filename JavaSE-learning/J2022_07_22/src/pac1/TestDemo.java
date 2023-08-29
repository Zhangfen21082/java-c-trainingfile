package pac1;

/*
import java.util.Scanner;

//抽象类
abstract class Shape{
    public abstract void draw();//抽象方法
}

class Rectangle extends Shape{
    @Override
    public void draw(){
        System.out.println("画一个矩形");
    }
}

class Triangle extends Shape{
    @Override
    public void draw(){
        System.out.println("画一个三角形");
    }
}
class Circle extends Shape{
    @Override
    public void draw(){
        System.out.println("画一个三角形");
    }
}
public class TestDemo {

    public static void drawing(Shape input){
        input.draw();
    }

    public static void main(String[] args) {
    }
}*/

//接口
interface Shape {
    void draw();
}

class Rectangle implements Shape{
    @Override
    public void draw(){
        System.out.println("画一个矩形");
    }
}

class Triangle implements Shape{
    @Override
    public void draw(){
        System.out.println("画一个三角形");
    }
}
class Circle implements Shape{
    @Override
    public void draw(){
        System.out.println("画一个三角形");
    }
}
public class TestDemo {

    public static void drawing(Shape input){
        input.draw();
    }

    public static void main(String[] args) {
    }
}