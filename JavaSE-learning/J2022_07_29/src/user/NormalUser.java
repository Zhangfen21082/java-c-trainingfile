package user;

import operation.*;

public class NormalUser extends User{
    public NormalUser(String name){
        super(name);
        this.bookListOperations = new BookListOperation[]{
                new QuitOperation(), //0-退出系统
                new FindOperation(),  //1-查找
                new BorrowOperation(), //2-借阅
                new ReturnOperation(),  //3-归还
        };
    }

    @Override
    public int menu(){
        System.out.println("欢迎您" + this.name + "(普通用户)进入图书管理系统");
        return 0;
    }
}
