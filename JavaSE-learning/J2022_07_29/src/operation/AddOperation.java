package operation;

import book.BookList;

public class AddOperation implements BookListOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("增加图书");

    }
}
