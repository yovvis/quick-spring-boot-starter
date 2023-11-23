package com.yovvis.utils;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;

/**
 * 路径工具类
 *
 * @author yovvis
 */
public class PathUtils {
    public static final String CONFIG_FOLDER = "config";

    /**
     * 获取java运行时的环境
     *
     * @return
     */
    public static String getRunTimePath() {
        return System.getProperty("user.dir");
    }

    /**
     * 获取classes路径
     *
     * @return
     */
    public static String getClassesPath() {
        return getClassUrl("").getPath();
    }

    /**
     * urlPath一般是包名
     *
     * @param urlPath
     * @return
     */
    public static URL getClassUrl(String urlPath) {
        URL url = Thread.currentThread().getContextClassLoader().getResource(urlPath);
        return url;
    }

    /**
     * 获取配置文件夹路径
     *
     * @param isJarRun
     * @return
     */
    public static String getConfigPath(boolean isJarRun) {
        if (isJarRun) {
            return PathUtils.getRunTimePath() + File.separator + CONFIG_FOLDER;
        }
        return PathUtils.getClassesPath() + File.separator + CONFIG_FOLDER;
    }

    /**
     * 获取配置文件路径
     *
     * @param fileName
     * @return
     */
    public static String getPath(String fileName) {

        String filePath = System.getProperty("user.dir") + File.separator + fileName;
        if (new File(filePath).exists()) {
            return filePath;
        }

        URL url = PathUtils.class.getClassLoader().getResource(fileName);
        if (url != null && new File(url.getPath()).exists()) {
            String urlPath = url.getPath();
            return urlPath;
        }

        return null;
    }

    /**
     * 获取配置文件路径
     *
     * @param fileName 文件名
     * @param encoding 编码方式
     * @return
     */
    public static String getPath(String fileName, String encoding) {

        String filePath = System.getProperty("user.dir") + File.separator + fileName;
        if (new File(filePath).exists()) {
            return filePath;
        }

        URL url = PathUtils.class.getClassLoader().getResource(fileName);
        if (url == null) {
            return null;
        }

        try {
            filePath = URLDecoder.decode(url.getPath(), encoding);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (new File(filePath).exists()) {
            return filePath;
        }
        return null;
    }
}
