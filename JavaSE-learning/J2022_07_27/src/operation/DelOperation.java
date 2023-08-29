package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class DelOperation implements BookListOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("删除图书");

        int currentNum = bookList.getCurrentNum();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要删除的图书的名字");
        String name = scanner.nextLine();

        for(int i = 0; i < currentNum; i++){
            Book book = bookList.getBook(i);
            if(book.getName().equals(name)){
                if(i == currentNum - 1){
                    break;
                }
                for(int j = i; j < currentNum - 1; j++){
                    Book book_j = bookList.getBook(j+1);
                    bookList.putBook(j, book_j);
                }
            }
        }
        bookList.putBook(currentNum-1, null);
        bookList.setCurrentNum(currentNum-1);
    }
}
