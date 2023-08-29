import java.io.File;
import java.io.IOException;

public class TestDemo1 {
    public static void main(String[] args) throws IOException {
        // 通过绝对路径或相对路径创建File
        File f = new File("F:/test.txt");
        System.out.println("所在目录路径：" + f.getParent());
        System.out.println("文件名字为：" + f.getName());
        System.out.println("文件路径为：" + f.getPath());
        System.out.println("文件绝对路径为：" + f.getAbsolutePath());
        System.out.println("被File修饰过后的绝对路径为：" + f.getCanonicalPath());

    }
}
