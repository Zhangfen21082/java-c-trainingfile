package operation;

import book.BookList;

public class DelOperation implements BookListOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("删除图书");
    }
}
