package com.yovvis.utils;

import java.io.*;

/**
 * 流工具类
 *
 * @author yovvis
 */
public class StreamUtils {

    /**
     * 读取字节信息，存放到byte[]
     *
     * @param is
     * @return array
     * @throws IOException
     */
    public static byte[] streamToByteArray(InputStream is) throws IOException {
        // 创建输出流对象
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buff = new byte[1024];
        int len;
        while ((len = is.read(buff)) != -1) {
            // count初始为0，每次+len，一次读不完，数据覆盖上一个buff，但是write时候从cout+len，len加
            bos.write(buff, 0, len);
        }
        byte[] array = bos.toByteArray();
        return array;
    }

    public static String streamToByteString(InputStream is) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuffer buffer = new StringBuffer();
        String line;
        while ((line = reader.readLine()) != null) {
            buffer.append(line + "\n");
        }
        return buffer.toString();
    }
}
