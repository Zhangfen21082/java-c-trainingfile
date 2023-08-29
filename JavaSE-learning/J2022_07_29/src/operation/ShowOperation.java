package operation;

import book.BookList;

public class ShowOperation implements BookListOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("显示图书");
    }
}
