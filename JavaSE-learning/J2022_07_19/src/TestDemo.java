import java.util.Scanner;

/*class Animal{
    String name;
    int age;
    public Animal(String name, int age){
        this.name = name;
        this.age = age;
    }
    public void eating(){
        System.out.println(name + "吃饭");
    }
}

class Dog extends Animal{
    public Dog(String name, int age){
        super(name, age);
    }
    @Override //重写父类
    public void eating(){
        System.out.println(name + "啃骨头");
    }
}

class Cat extends Animal{
    public Cat(String name, int age){
        super(name, age);
    }
    @Override//重写父类
    public void eating(){
        System.out.println(name + "吃小鱼");
    }
}

public class TestDemo {

    //方法返回值为父类引用，此时可以返回任意子类对象
    public static Animal buyAnAnimal(String animal_name){
        if(animal_name.equals("狗")) {
            return new Dog("旺财", 2);
        }
        else if(animal_name.equals("猫")) {
            return new Cat("喵喵", 3);
        }
        else{
            return null;
        }
    }
    public static void main(String[] args) {
        System.out.println("进入宠物店：请问你需要什么动物");
        Scanner sc = new Scanner(System.in);
        String animal_name = sc.nextLine();
        Animal animal = buyAnAnimal(animal_name);
        System.out.println("你得到了:" + animal.name);
        sc.close();
    }
}*/


/*class Animal{
    String name;
    int age;
    public Animal(String name, int age){
        this.name = name;
        this.age = age;
    }
    public void eating(){
        System.out.println(name + "吃饭");
    }
}

class Dog extends Animal{
    public Dog(String name, int age){
        super(name, age);
    }
    @Override //重写父类
    public void eating(){
        System.out.println(name + "啃骨头");
    }

    public void dog_method(){
        System.out.println(name + "的特有方法");
    }
}

class Cat extends Animal{
    public Cat(String name, int age){
        super(name, age);
    }
    @Override//重写父类
    public void eating(){
        System.out.println(name + "吃小鱼");
    }
}

public class TestDemo {
    public static void function(Animal animal){
        animal.eating();
    }
    public static void main(String[] args) {
        Animal animal = new Dog("旺财", 2);
        Dog dog = (Dog)animal;//向下转型
        dog.dog_method();
    }
}*/

class A{
    public A(){
        func();
    }
    public void func(){
        System.out.println("A的func()方法");
    }
}
class B extends A{
    private int num = 1;
    @Override
    public void func(){
        System.out.println("B的func()方法,num="+num);

    }
}
public class TestDemo{
    public static void main(String[] args) {
        B b = new B();
        b.func();
    }
}
