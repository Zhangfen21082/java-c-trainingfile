package Util;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 文件操作，使用字符流处理
 */
public class FileUtil {
    // 负责读取filePath文件内容并返回
    public static String readFile(String filePath) {
        StringBuilder result = new StringBuilder();
        try (FileReader fileReader = new FileReader(filePath)){
            while(true) {
                int ch = fileReader.read();
                if(ch == -1) {
                    break;
                }
                result.append((char)ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toString();

    }

    // 负责把content写入到filePath对应文件中
    public static void writeFile(String filePath, String content) {
        try (FileWriter fileWriter = new FileWriter(filePath)){
            fileWriter.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FileUtil.writeFile("./test.txt", "aaaaas");
        String content = FileUtil.readFile("./test.txt");
        System.out.println(content);
    }
}

