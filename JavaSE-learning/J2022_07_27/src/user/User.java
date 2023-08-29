package user;

import book.BookList;
import operation.BookListOperation;

/**
 * 用户基础属性
 */
abstract public class User {
    protected String name;
    protected BookListOperation[] bookListOperations;

    public User(String name) {
        this.name = name;
    }
    public abstract int menu();

    public void doOperation(int choice, BookList bookList){
        this.bookListOperations[choice].work(bookList);
    }
}
