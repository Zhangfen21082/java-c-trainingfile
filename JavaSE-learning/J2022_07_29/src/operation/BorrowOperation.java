package operation;

import book.BookList;

public class BorrowOperation implements BookListOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("借阅图书");
    }
}
