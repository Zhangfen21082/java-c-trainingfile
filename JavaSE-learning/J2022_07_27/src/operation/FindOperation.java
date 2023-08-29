package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class FindOperation implements BookListOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("查找图书");
        int currentNum = bookList.getCurrentNum();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要查找的图书的名字：");
        String name = scanner.nextLine();
        for(int i = 0; i < currentNum; i++){
            Book book = bookList.getBook(i);
            if(book.getName().equals(name)){
                System.out.println("已经找到了" + name + "这本书," + "信息如下");
                System.out.println(book);
                return;
            }
        }
        //说明没有找到
        System.out.println("没有" + name + "这本书");
    }

}
