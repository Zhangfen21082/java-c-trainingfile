package user;

import operation.*;

import java.util.Scanner;

public class NormalUser extends User{
    public NormalUser(String name) {
        super(name);
        this.bookListOperations = new BookListOperation[]{
                new QuitOperation(), //0-退出系统
                new FindOperation(),  //1-查找
                new BorrowOperation(), //2-借阅
                new ReturnOperation(),  //3-归还
        };
    }

    /**
     * @return 显示菜单后返回用户选择
     */
    @Override
    public int menu(){
        System.out.println("欢迎您" + this.name + "(普通用户)进入图书管理系统");
        System.out.println("输入【1】：查找图书");
        System.out.println("输入【2】：借阅图书");
        System.out.println("输入【3】：归还图书");
        System.out.println("输入【0】：退出系统");
        System.out.print("请输入");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        return input;
    }
}
