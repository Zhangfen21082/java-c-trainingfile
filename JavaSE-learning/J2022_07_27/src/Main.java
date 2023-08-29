import book.BookList;
import user.User;
import user.AdminUser;
import user.NormalUser;

import java.util.Scanner;

public class Main {

    public static User login(){
        System.out.println("请输入您的姓名：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        System.out.println("请输入您的身份：【1：管理员】  【2：普通用户】");
        int input = scanner.nextInt();

        if(input == 1){
            return new AdminUser(name);
        }else{
            return new NormalUser(name);
        }


    }
    public static void main(String[] args) {
        //准备图书
        BookList bookList = new BookList();
        //进行登录，返回用户身份
        User user = login();

        while(true) {
            //展示对应用户菜单
            int user_choice = user.menu();//动态绑定
            user.doOperation(user_choice, bookList);
        }



    }
}
