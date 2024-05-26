package compile;

/**
 * Task的执行结果
 */
public class Answer {
    // 错误码，如果为0表示编译运行正常，如果为1表示编译出错，如果为2表示运行出错，3表示其他错误
    private int error;
    //错误提示信息，如果error不为0，则放对应的提示信息
    private String reason;
    // 标准输出
    private String stdout;
    // 标准错误
    private String stderr;

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStdout() {
        return stdout;
    }

    public void setStdout(String stdout) {
        this.stdout = stdout;
    }

    public String getStderr() {
        return stderr;
    }

    public void setStderr(String stderr) {
        this.stderr = stderr;
    }
}
