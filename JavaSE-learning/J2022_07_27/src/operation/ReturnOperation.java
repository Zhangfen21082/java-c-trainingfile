package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class ReturnOperation implements BookListOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("归还图书");

        int currentNum = bookList.getCurrentNum();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要归还的图书的名字：");
        String name = scanner.nextLine();

        for(int i = 0; i < currentNum; i++){
            Book book = bookList.getBook(i);
            if(book.getName().equals(name)){
                book.setBorrowed(false);//归还
                System.out.println(name + "归还成功");
                return;
            }
        }
        System.out.println("没有" + name + "这本书");
    }
    }

