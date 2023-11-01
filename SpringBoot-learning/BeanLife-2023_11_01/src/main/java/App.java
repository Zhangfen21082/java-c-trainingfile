import com.demo.controller.UserController;
import com.demo.controller.UserController2;
import com.demo.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        UserController userController = context.getBean("userController", UserController.class);
        userController.getUser();

        UserController2 userController2 = context.getBean("userController2", UserController2.class);
        userController2.getUser();


    }
}