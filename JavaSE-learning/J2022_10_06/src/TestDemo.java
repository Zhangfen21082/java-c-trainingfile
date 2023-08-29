import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Book {
    public String name;
    public double price;
    public int year;

    public Book(String name, double price, int year) {
        this.name = name;
        this.price = price;
        this.year = year;
    }

    @Override
    public String toString() {
        return "【name：" + this.name + "；price：" + this.price + "：year：" + this.year + "】\n" ;
    }
}

//按照价格升序排序比较器
class BookComparatorByPriceAscend implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2){
        if(o1 == o2){
            return 0;
        }
        if(o1 == null){
            return -1;
        }
        if(o2 == null){
            return 1;
        }

        if((o1.price - o2.price) < 0){
            return -1;
        }else if((o1.price - o2.price) == 0){
            return 0;
        }else{
            return 1;
        }
    }
}

//按照年份降序排序比较器

class BookComparatorByYearDescend implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2){
        if(o1 == o2){
            return 0;
        }
        if(o1 == null){
            return -1;
        }
        if(o2 == null){
            return 1;
        }

        if((o1.year - o2.year) < 0){
            return 1;
        }else if((o1.price - o2.price) == 0){
            return 0;
        }else{
            return -1;
        }
    }
}

public class TestDemo {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("水浒传",78,2200));
        books.add(new Book("西游记", 88, 1999));
        books.add(new Book("红楼梦",28,1820));
        books.add(new Book("三国演义",68,1999));
        System.out.println("排序前");
        System.out.println(books);

        Collections.sort(books, new BookComparatorByPriceAscend());
        System.out.println("按照价格升序排序后");
        System.out.println(books);

        Collections.sort(books, new BookComparatorByYearDescend());
        System.out.println("按照年份降序排序后");
        System.out.println(books);
    }
}
















/*import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestDemo {
    public static void main(String[] args) {
        Integer[] testNum = {4, 2, 6, 1, 7, 9, 3, 3, 5};
        List<Integer> integers = Arrays.asList(testNum);
        Collections.sort(integers);
        System.out.println(integers);
    }
}*/






/*import java.util.Comparator;

class Student {
    int age;
    String name;
    public Student(int age, String name){
        this.age = age;
        this.name = name;
    }
}

class StudentComparator implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2){
        if(o1 == o2){
            return 0;
        }
        if(o1 == null){
            return -1;
        }
        if(o2 == null){
            return 1;
        }

        if(o1.age == o2.age && o1.name.equals(o2.name)){
            return 0;
        }
        return o1.age - o2.age;

    }
}

public class TestDemo {
    public static void main(String[] args) {
        Student student1 = new Student(17, "张三");
        Student student2 = new Student(19, "李四");
        Student student3 = new Student(17, "张三");
        StudentComparator studentComparator =  new StudentComparator();
        System.out.println(studentComparator.compare(student1, student3));
        System.out.println(studentComparator.compare(student1, student2));
        System.out.println(studentComparator.compare(student2, student3));
    }
}*/



/*public class TestDemo {
    public static void main(String[] args) {
        // 数值类型比较
        int a = 10;
        int b = 20;
        System.out.println(a > b);
        System.out.println(a < b);

        // 字符类型比较
        char c = 'A';
        char d = 'B';
        System.out.println(c > d);
        System.out.println(c < d);

        // 布尔类型比较
        boolean e = true;
        boolean f = false;
        System.out.println(e == f);
        System.out.println(e != f);
    }
}*/
