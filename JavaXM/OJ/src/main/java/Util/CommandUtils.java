package Util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created with IntelliJ IDEA.
 * Description：
 *
 * @author: ZhangXing
 * @date: 2024-05-17
 * @time: 09:22:16
 */
public class CommandUtils {

    /**
     * @description:
     * 通过Runtime类得到Runtime实例，执行exec方法
     * 获取标准输出，并写入指定文件
     * 获取标准错误，并写入指定文件
     * 等待子进程结束，拿到子进程状态码，返回
     * @param: [cmd 执行指令, stdoutFilePath 存储标准输出内容, stderrFilePath 存储标准错误的内容]
     * @return:
     **/
    public static int run(String cmd,String stdoutFilePath,String stderrFilePath) {
        try {
            // 通过Runtime类得到Runtime实例，执行exec方法
            Process process = Runtime.getRuntime().exec(cmd);
            // 获取标准输出，并写入指定文件
            if (stdoutFilePath != null) {
                InputStream stdoutFrom = process.getInputStream();
                FileOutputStream stdoutTo = new FileOutputStream(stdoutFilePath);
                while (true) {
                    int ch = stdoutFrom.read();
                    if (ch == -1) break;
                    stdoutTo.write(ch);
                }
                stdoutFrom.close();
                stdoutTo.close();
            }

            // 获取标准错误，并写入指定文件
            if (stderrFilePath != null) {
                InputStream stderrFrom = process.getErrorStream();
                FileOutputStream stderrTo = new FileOutputStream(stderrFilePath);
                while (true) {
                    int ch = stderrFrom.read();
                    if (ch == -1) break;
                    stderrTo.write(ch);
                }
                stderrFrom.close();
                stderrTo.close();
            }
            // 等待子进程结束，拿到状态码并返回
            int exitCode = process.waitFor();
            return exitCode;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return 1;
    }


    public static void main(String[] args) {
        run("javac","./stdout.txt","./stderr.txt");
    }
}
