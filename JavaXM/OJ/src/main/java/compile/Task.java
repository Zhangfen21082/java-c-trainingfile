package compile;

import java.io.File;
import java.util.UUID;

import Util.FileUtil;
import Util.CommandUtils;

/**
 * 每一次的编译和运行就称为一个Task
 */
public class Task {

    // 临时文件所在目录
    private String WORK_DIR = null;
    // 代码类名
    private String CLASS = null;
    // 代码编译代码文件名
    private String CODE = null;
    // 编译错误信息文件名
    private String COMPILE_ERROR = null;
    // 标准输出文件名
    private String STDOUT = null;
    // 标准错误文件名
    private String STDERR = null;


    public Task(){
        WORK_DIR = "./tmp/" + UUID.randomUUID().toString() + "/";
        CLASS = "Solution";
        CODE = WORK_DIR + "Solution.java";
        COMPILE_ERROR = WORK_DIR + "compileError.txt";
        STDOUT = WORK_DIR + "stdout.txt";
        STDERR = WORK_DIR + "stderr.txt";
    }

    /**
     * 参数：待编译和运行的源代码，实体类为Question
     * 返回值：编译运行结果（可能有多种情况），实体类为Answer
     */
    public Answer compileAndRun(Question question) {
        Answer answer = new Answer();
        File workDir = new File(WORK_DIR);
        if(!workDir.exists()) {
            workDir.mkdirs();
        }
        // 1.首先需要将question中的代码写入到一个.java文件当中，直接规定类名和文件名都叫做Solution
        FileUtil.writeFile(CODE, question.getCode());

        // 2.创建子进程，调用javac命令进行编译，生成.class文件
                // 如果编译出错，则使用一个文件保存 compileError.txt
                // 对于javac命令，一旦编译失败，其内容就会通过标准错误反馈
        String compileCmd = String.format("javac -encoding utf8 %s -d %s", CODE, WORK_DIR);
        System.out.println(compileCmd);
        CommandUtils.run(compileCmd, null, COMPILE_ERROR);

                // 如果没有编程出错，此文件为空
        String compileError = FileUtil.readFile(COMPILE_ERROR);
        if(!compileError.equals("")) {
            // 编译出错，直接返回Answer，让Answer记录编译错误
            answer.setError(1);
            answer.setReason(compileError);
            return answer;
        }
        // 3.创建子进程，调用java命令并执行
                // 如果运行出错，则使用两个文件存在 stdout.txt, stderr.txt

        String runCmd = String.format("java -classpath %s %s", WORK_DIR, CLASS);
        System.out.println(runCmd);
        CommandUtils.run(runCmd, STDOUT, STDERR);

                // 如果没有运行出错，此文件为空
        String runError = FileUtil.readFile(STDERR);
        if(!runError.equals("")) {
            // 运行出错，记录错误
            answer.setError(2);
            answer.setReason(runError);
            return answer;
        }
        // 4.父进程获取结果，打包为Answer对象

        answer.setError(0);
        answer.setStdout(FileUtil.readFile(STDOUT));

        return answer;
    }

    public static void main(String[] args) {
        Task task = new Task();
        Question question = new Question();
        question.setCode("public class Solution {\n" +
                "    public static void main(String[] args) {\n" +
                "        System.out.println(\"Hello World\");\n" +
                "    }\n" +
                "}\n");

        Answer answer = task.compileAndRun(question);
        System.out.println(answer.getError());
    }
}
