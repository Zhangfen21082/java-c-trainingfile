package book;

public class BookList {
    private Book[] books = new Book[10];//用于对于Book进行组织，最多可以10本书
    private int currentNum;//当前书架书的数量

    public BookList(){
        books[0] = new Book("三国演义", "罗贯中", 39.9, "小说");
        books[1] = new Book("西游记", "吴承恩", 39.9, "小说");
        books[3] = new Book("红楼梦", "曹雪芹", 39.9, "小说");
        currentNum = 3;
    }
//
//    /**
//     * @param pos 书的位置，注意位置一定要合法
//     * @return 对应位置的书
//     */
//    public Book takeBook(int pos){
//        return books[pos];
//    }
//
//    /**
//     * @param pos 书的位置，注意位置一定要合法
//     * @param book 你需要放的书
//     */
//
//    public void putBook(int pos, Book book){
//        books[pos] = book;
//    }
//
//    /**
//     * @return 当前书架上书的数量
//     */
//
//    public int getCurrentNum(){
//        return currentNum;
//    }
//
//    /**
//     * @param Num 设置的数量
//     */
//    public void setCurrentNum(int Num){
//        currentNum = Num;
//    }

}
