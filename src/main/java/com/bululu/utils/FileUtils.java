package com.bululu.utils;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * 文件工具类
 *
 * @author yovvis
 */
public class FileUtils {
    public static final String DEFAULT_DOWNLOAD_PATH = "";
    /**
     * 递归拷贝文件（目录完整拷贝）
     *
     * @param inputPath  输入路径
     * @param outputPath 输出路径
     */
    public static void copyFilesByRecursive(String inputPath, String outputPath) {
        File inputFile = new File(inputPath);
        File outputFile = new File(outputPath);
        try {
            copyFileByRecursive(inputFile, outputFile);
        } catch (Exception e) {
            System.err.println("文件拷贝失败！");
        }
    }
    /**
     * 文件A=>目录B,则文件A放在目录B下
     * 文件A=>文件B,则文件A覆盖文件
     * 目录A=>目录B,则目录A放在目录B下
     *
     * 核心思路：先创建目录，然后遍历目录内的文件，依次复制
     *
     * @param inputFile
     * @param outputFile
     * @throws IOException
     */
    public static void copyFileByRecursive(File inputFile, File outputFile) throws IOException {
        // 区分是不是目录
        if (inputFile.isDirectory()) {
            System.out.println("目录名称：" + inputFile.getName());
            File destOutputFile = new File(outputFile, inputFile.getName());
            // 如果是目录，就直接创建
            if (!destOutputFile.exists()) {
                destOutputFile.mkdirs();
            }
            // 获取源目录下一层所有文件
            File[] files = inputFile.listFiles();
            // 没有文件直接结束了
            if (ArrayUtils.isEmpty(files)) {
                return;
            }
            for (File file : files) {
                // 递归执行
                copyFileByRecursive(file, destOutputFile);
            }
        } else {
            // 是文件，直接复制
            Path destpath = outputFile.toPath().resolve(inputFile.getName());
            Files.copy(inputFile.toPath(), destpath, StandardCopyOption.REPLACE_EXISTING);
        }
    }
}
