import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystemException;

public class Config {
    File file;
    public void OpenConfig(String filename) throws FileNotFoundException, FileSystemException {
        if(filename.equals("config.ini")){
            throw  new FileNotFoundException("配置文件名字错误，请检查");
        }
    }
    //打开文件
    public void readConfig(){
        ;
    }

    public static void main(String[] args){
        Config config = new Config();
        try{
            //打开文件时有可能错误，然后抛出IOException异常
            config.OpenConfig("config.txt");
            System.out.println("文件打开成功");
        }catch (IOException e){
            //异常处理方式
            System.out.println(e.getMessage()); //可以只打印异常信息
            System.out.println(e); //可以打印异常类型：异常信息
            e.printStackTrace(); //可以把信息打印全
        }
        System.out.println("异常一旦被捕获且被处理了，此处代码便会执行");
    }
}
