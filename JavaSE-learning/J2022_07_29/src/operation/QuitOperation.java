package operation;

import book.BookList;

public class QuitOperation implements BookListOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("退出系统");
    }
}
