package com.cn.test;

import com.cn.utils.SystemUtil;

import java.io.*;

/**
 * 功能描述：
 *
 * @author 杨康
 * @version 1.0
 * @date 2021-07-15 22:00:22
 */
public class CmdTest {

    public static void main(String[] args) {
        String exec = "java -version";
        Process process = SystemUtil.getProcessByExec(exec);
        readProcessOutput(process);
        process.destroy();
        int exitCode = process.exitValue();
        if (exitCode == 0) {
            System.out.println("执行成功");
        }
    }

    private static void readProcessOutput(final Process process) {
        // 将进程的正常输出在 System.out 中打印，进程的错误输出在 System.err 中打印
        read(process.getInputStream(), System.out);
        read(process.getErrorStream(), System.err);
    }

    private static void read(InputStream inputStream, PrintStream out) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
