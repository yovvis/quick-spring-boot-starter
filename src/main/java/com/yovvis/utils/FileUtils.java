package com.yovvis.utils;


import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 文件工具类
 *
 * @author yovvis
 */
public class FileUtils extends PathUtils {
    public static final String CLASS_EXT = ".class";
    public static final String JAR_FILE_EXT = ".jar";
    public static final String JAR_PATH_EXT = ".jar!";
    public static final String PATH_FILE_PRE = "file:";
    public static final String DEFAULT_DOWNLOAD_PATH = "";
    public static final String FILE_SEPARATOR;
    public static final String PATH_SEPARATOR;
    private static final Pattern PATTERN_PATH_ABSOLUTE;

    public FileUtils() {
    }

    public static File newFile(String path) {
        return new File(path);
    }

    public static File file(String path) {
        return null == path ? null : new File(getAbsolutePath(new File(path)));
    }

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
     * <p>
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

    public static List<File> loopFiles(String path, FileFilter fileFilter) {
        return loopFiles(file(path), fileFilter);
    }

    public static List<File> loopFiles(File file, FileFilter fileFilter) {
        return loopFiles(file, -1, fileFilter);
    }

    public static void walkFiles(Path start, FileVisitor<? super Path> visitor) {
        walkFiles(start, -1, visitor);
    }

    public static void walkFiles(Path start, int maxDepth, FileVisitor<? super Path> visitor) {
        if (maxDepth < 0) {
            maxDepth = Integer.MAX_VALUE;
        }
        try {
            Files.walkFileTree(start, EnumSet.noneOf(FileVisitOption.class), maxDepth, visitor);
        } catch (IOException var4) {
            throw new RuntimeException(var4);
        }
    }

    public static List<File> loopFiles(File file, int maxDepth, FileFilter fileFilter) {
        return loopFiles(file.toPath(), maxDepth, fileFilter);
    }

    public static List<File> loopFiles(String path) {
        return loopFiles(file(path));
    }

    public static List<File> loopFiles(File file) {
        return loopFiles((File) file, (FileFilter) null);
    }

    public static List<File> loopFiles(Path path, int maxDepth, final FileFilter fileFilter) {
        final List<File> fileList = new ArrayList();
        if (null != path && Files.exists(path, new LinkOption[0])) {
            if (isDirectory(path)) {
                walkFiles(path, maxDepth, new SimpleFileVisitor<Path>() {
                    public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) {
                        File file = path.toFile();
                        if (null == fileFilter || fileFilter.accept(file)) {
                            fileList.add(file);
                        }

                        return FileVisitResult.CONTINUE;
                    }
                });
                return fileList;
            } else {
                File file = path.toFile();
                if (null == fileFilter || fileFilter.accept(file)) {
                    fileList.add(file);
                }

                return fileList;
            }
        } else {
            return fileList;
        }
    }

    public static String getAbsolutePath(File file) {
        if (file == null) {
            return null;
        } else {
            try {
                return file.getCanonicalPath();
            } catch (IOException e) {
                return file.getAbsolutePath();
            }
        }
    }

    public static boolean isDirectory(String path) {
        return null != path && file(path).isDirectory();
    }

    public static boolean isDirectory(File file) {
        return null != file && file.isDirectory();
    }

    public static boolean isFile(String path) {
        return null != path && file(path).isFile();
    }

    public static boolean isFile(File file) {
        return null != file && file.isFile();
    }

    static {
        FILE_SEPARATOR = File.separator;
        PATH_SEPARATOR = File.pathSeparator;
        PATTERN_PATH_ABSOLUTE = Pattern.compile("^[a-zA-Z]:([/\\\\].*)?");
    }

}
