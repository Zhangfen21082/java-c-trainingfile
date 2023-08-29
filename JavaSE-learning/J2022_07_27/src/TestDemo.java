import java.util.Objects;

class Person{
    String IdNum;
    public Person(String IdNum){
        this.IdNum = IdNum;
    }
    @Override
    public int hashCode(){
        return Objects.hash(IdNum);
    }


}
public class TestDemo {

    public static void main(String[] args) {
        Person person1 = new Person("123456");
        Person person2 = new Person("123456");
        System.out.println(person1.hashCode());
        System.out.println(person2.hashCode());
    }
}
