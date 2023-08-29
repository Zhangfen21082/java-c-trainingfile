package myStack;

public class StackEmptyException extends RuntimeException{
    public StackEmptyException(){

    }
    public StackEmptyException(String msg){
        super(msg);
    }
}
