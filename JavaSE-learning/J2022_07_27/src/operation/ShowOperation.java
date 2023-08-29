package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class ShowOperation implements BookListOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("显示图书");
        int currentNum = bookList.getCurrentNum();
        for(int i = 0; i < currentNum; i++){
            Book book = bookList.getBook(i);
            System.out.println(book);
        }
        }
    }

