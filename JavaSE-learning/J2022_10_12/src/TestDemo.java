import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Student{
    private String name = "zhangsan";
    public int age = 19;
    public Student(){
        System.out.println("调用无参构造方法");
    }

    private Student(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("调用含参构造方法（私有）");
    }
    private void eat(){
        System.out.println("调用私有eat方法");
    }
    private void sleep(){
        System.out.println("调用私有sleep方法");
    }
    private void function(String str){
        System.out.println(str);
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class TestDemo {
    //创建类的实例
    public void reflectNewInstance() {
        try {
            Class<?> c = Class.forName("Student");
            Student student = (Student) c.newInstance();
            System.out.println(student);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException((e));
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    //反射私有构造方法
    public void reflectPrivateConstructor() {
        try {
            Class<?> c = Class.forName("Student");
            //拿到带有两个参数的私有构造方法
            Constructor<?> constructor = c.getDeclaredConstructor(String.class, int.class);
            //只有设置为true后下一步才可以生效
            constructor.setAccessible(true);
            //使用该构造方法构造对象
            Student student = (Student) constructor.newInstance("李四", 18);
            System.out.println(student);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    //反射私有属性
    public void reflectPrivateField() {
        try {
            Class<?> c = Class.forName("Student");
            Student student = (Student) c.newInstance();

            //获取私有属性name
            Field field = c.getDeclaredField("name");
            //只有设置为true后下一步才可以生效
            field.setAccessible(true);
            //修改该属性
            field.set(student, "王麻子");
            System.out.println(student);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    //反射私有方法
    public void reflectPrivateMethod() {
        try {
            Class<?> c = Class.forName("Student");
            Student student = (Student) c.newInstance();

            //获取私有方法function
            Method method = c.getDeclaredMethod("function", String.class);
            //只有设置为true后下一步才可以生效
            method.setAccessible(true);
            //传参给该私有方法
            method.invoke(student, "通过反射给该方法传参");
            System.out.println(student);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        TestDemo testDemo = new TestDemo();
        testDemo.reflectNewInstance(); // 利用反射创建对象
        System.out.println("----------------------------------");
        testDemo.reflectPrivateConstructor(); //利用反射调用私有构造方法并创建对象
        System.out.println("----------------------------------");
        testDemo.reflectPrivateField(); //利用反射获取私有属性并修改
        System.out.println("----------------------------------");
        testDemo.reflectPrivateMethod();  //利用反射调用私有方法并传参
        System.out.println("----------------------------------");
    }
}
