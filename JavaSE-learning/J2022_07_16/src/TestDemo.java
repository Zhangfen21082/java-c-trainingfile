//动物
class Animal{
    public String name;
    public int age;
    public double weight;

    public void eat(){
        System.out.println(name + "正在吃饭");
    }

}
//狗
class Dog extends Animal{

    public void bark(){
        System.out.println(name + "正在吠叫");
    }
}

//猫
class Cat extends Animal{
    public void meow(){
        System.out.println(name + "正在喵喵");

    }
}



public class TestDemo {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.name = "狗蛋";
        dog.age = 5;
        dog.weight = 34.3;
        Cat cat = new Cat();
        cat.name = "花喵";
        cat.age = 4;
        cat.weight = 21.2;

        System.out.println(dog.name);
        dog.eat();
        dog.bark();

        System.out.println(cat.name);
        cat.eat();
        cat.meow();
    }
}