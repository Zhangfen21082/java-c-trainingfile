package user;

import book.BookList;
import operation.*;

import java.util.Scanner;

public class AdminUser extends User{
    public AdminUser(String name) {
        super(name);
        this.bookListOperations = new BookListOperation[]{
                new QuitOperation(), //0-退出系统
                new FindOperation(), //1-查找
                new AddOperation(),  //2-新增
                new DelOperation(), //3-删除
                new ShowOperation(),  //4-显示
        };
    }

    @Override
    public int menu(){
        System.out.println("欢迎您" + this.name + "(管理员)进入图书管理系统");
        System.out.println("输入【1】：查找图书");
        System.out.println("输入【2】：新增图书");
        System.out.println("输入【3】：删除图书");
        System.out.println("输入【4】：显示图书");
        System.out.println("输入【0】：退出系统");
        System.out.print("请输入");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        return input;
    }



}
