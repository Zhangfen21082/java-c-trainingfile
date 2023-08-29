package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class BorrowOperation implements BookListOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("借阅图书");

        int currentNum = bookList.getCurrentNum();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要借阅的图书的名字：");
        String name = scanner.nextLine();

        for(int i = 0; i < currentNum; i++){
            Book book = bookList.getBook(i);
            if(book.getName().equals(name)){
                if(!book.isBorrowed()) {
                    //如果未借出
                    book.setBorrowed(true);//借出
                    System.out.println(name + "借阅成功");
                }else{
                    System.out.println("借阅失败,"+ name + "已经被借出了");
                }
                return;
            }
        }
        System.out.println("没有" + name + "这本书");
    }
}
