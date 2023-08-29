
/*abstract class Animal{
    public String name;
    public int age;
    public Animal(String name, int age){
        this.name = name;
        this.age = age;
    }
    public abstract void eat();
}
//飞的行为
interface AnimalFly{
    void fly();
}
//跑的行为
interface AnimalRun{
    void run();
}

class Dog extends Animal implements AnimalRun{
    public Dog(String name, int age){
        super(name, age);
    }
    @Override
    public void eat(){
        System.out.println(name + "正在吃狗粮");
    }
    @Override
    public void run(){
        System.out.println(name + "正在用四条腿跑路");
    }
}

class Bird extends Animal implements AnimalFly, AnimalRun{
    public Bird(String name, int age){
        super(name, age);
    }
    @Override
    public void eat(){
        System.out.println(name + "正在吃鸟食");
    }

    @Override
    public void fly() {
        System.out.println(name + "正在天上飞");

    }
    @Override
    public void run(){
        System.out.println(name + "正在用两个脚丫跑路");
    }
}

public class TestDemo {
    //通用行为
    public static void eating(Animal animal){
        animal.eat();
    }
    //飞翔行为
    public static void flying(AnimalFly animalFly){
        animalFly.fly();
    }
    //跑路行为
    public static void running(AnimalRun animalRun){
        animalRun.run();
    }
    public static void main(String[] args) {
        Dog dog = new Dog("旺财", 2);
        Bird bird = new Bird("啾啾", 3);
        eating(dog);
        eating(bird);
        System.out.println("----------------------------");
        flying(bird);
        System.out.println("----------------------------");
        running(dog);
        running(bird);
    }
}*/


/*interface A{
    void A_method();
}
interface B{
    void B_method();
}
interface C extends A, B{

}

class D implements C{
    @Override
    public void A_method(){

    }
    @Override
    public void B_method(){

    }
}*/

/*
import java.util.Comparator;

class Student{
    public String name;
    public int age;
    public double score;

    public Student(String name, int age, double score){
        this.name = name;
        this.age = age;
        this.score = score;
    }
}

class AgeComparator implements Comparator<Student>{
    @Override
    public int compare(Student student1, Student student2){
        return student1.age - student2.age;
    }
}
class ScoreComparator implements Comparator<Student>{
    @Override
    public int compare(Student student1, Student student2){
        return (int)(student1.score - student2.score);
    }
}



public class TestDemo {
    public static void main(String[] args) {
        Student student1 = new Student("张三", 27, 92.3);
        Student student2 = new Student("李四", 25, 96.3);

        //使用age进行比较，那么就建立一个关于age的比较器
        AgeComparator ageComparator = new AgeComparator();
        int ret = ageComparator.compare(student1, student2);
        if(ret > 0){
            System.out.println(student1.name + "的年龄大");
        }else if(ret == 0){
            System.out.println(student1.name + "和" +student2.name + "的年龄一样的");
        }else {
            System.out.println(student2.name + "的年龄大");
        }
        System.out.println("--------------------------------------------------------");
        //使用score进行比较，那么就建立一个关于score的比较器
        ScoreComparator scoreComparator = new ScoreComparator();
        int ret1 = scoreComparator.compare(student1, student2);
        if(ret1 > 0){
            System.out.println(student1.name + "的成绩高");
        }else if(ret1 == 0){
            System.out.println(student1.name + "和" +student2.name + "的成绩一样");
        }else{
            System.out.println(student2.name + "的成绩高");
        }
    }
}
*/

abstract interface test{

}