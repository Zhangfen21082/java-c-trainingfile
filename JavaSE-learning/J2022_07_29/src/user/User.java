package user;


import operation.BookListOperation;

abstract public class User {
    protected String name;
    protected BookListOperation[] bookListOperations;

    public User(String name){
        this.name = name;
    }
    public abstract int menu();//菜单
}
