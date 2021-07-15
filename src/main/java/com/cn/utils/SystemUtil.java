package com.cn.utils;

import java.io.File;
import java.io.IOException;

/**
 * 功能描述：系统工具类
 *
 * @author 杨康
 * @version 1.0
 * @date 2021-07-15 21:56:12
 */
public class SystemUtil {

    /**
     * 运行环境名
     */
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String SLASH = "/";
    public static final String BACKSLASH = "\\";

    /**
     * 方法描述：判断当前操作系统是否是windows
     *
     * @return
     *
     * @author 杨康
     * @date 日期：2018年5月8日 时间：下午10:26:03
     * @version 1.0
     */
    public static boolean isWindowsSystem() {
        return OS_NAME.toLowerCase().contains("windows") && File.separator.equals(BACKSLASH);
    }

    /**
     * 方法描述：判读当前操作系统是否是Mac OS
     *
     * @param
     * @return
     *
     * @Author 杨康
     * @Date 2019/10/16 14:5146
     */
    public static boolean isMacSystem() {
        return OS_NAME.toLowerCase().contains("mac") && File.separator.equals(SLASH);
    }

    /**
     * 方法描述：判断当前操作系统是否是Linux
     *
     * @param
     * @return
     *
     * @Author 杨康
     * @Date 2019/10/16 14:5237
     */
    public static boolean isLinuxSystem() {
        return OS_NAME.toLowerCase().contains("linux") && File.separator.equals(SLASH);
    }

    /**
     * 方法描述：命令行执行
     *
     * @param exec 执行语句
     * @return java.lang.Process
     *
     * @Author 杨康
     * @Date 2020-04-15 14:58:56
     */
    public static Process getProcessByExec(String exec) {
        Process process = null;
        if (SystemUtil.isWindowsSystem()) {
            String[] commands = {"cmd", "/c", exec};
            try {
                process = Runtime.getRuntime().exec(commands);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            String[] commands = {"/bin/sh", "-c", exec};
            try {
                process = Runtime.getRuntime().exec(commands);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return process;
    }
}
