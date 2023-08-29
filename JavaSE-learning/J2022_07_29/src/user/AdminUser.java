package user;

import book.BookList;
import operation.*;

public class AdminUser extends User{
    public AdminUser(String name){
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
        return 0;
    }
}
