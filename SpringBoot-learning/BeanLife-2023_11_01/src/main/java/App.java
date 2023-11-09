import com.demo.component.BeanLifeComponent;
import com.demo.controller.UserController;
import com.demo.controller.UserController2;
import com.demo.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        System.out.println("使用Bean");
        // 销毁Bean
        context.destroy();
    }
}