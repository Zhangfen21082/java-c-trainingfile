package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class AddOperation implements BookListOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("增加图书");

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入书名");
        String name = scanner.nextLine();
        System.out.println("请输入作者");
        String author = scanner.nextLine();
        System.out.println("请输入类型");
        String type = scanner.nextLine();
        System.out.println("请输入价格");
        double price = scanner.nextDouble();

        Book book = new Book(name, author, price, type);

        int currentNum = bookList.getCurrentNum();
        bookList.putBook(currentNum, book);

        bookList.setCurrentNum(currentNum+1);

        System.out.println(name + "新增成功");

    }
}
