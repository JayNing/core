package com.util;

import org.springframework.util.Base64Utils;

import java.io.*;
import java.util.Base64;

/**
 * @author ningjianjian
 * @Date 2021/6/17 11:32 上午
 * @Description
 */
public class FileUtils {

    public static void main(String[] args) {
        String path = "/Users/edy/Downloads/avatar.jpg";
        File file = new File(path);
        System.out.println(fileToBase64(file));
    }

    /**
     * 文件转base64字符串
     * @param file
     * @return
     */
    public static String fileToBase64(File file){
        String base64 = null;
        InputStream in = null;
        try {
            in = new FileInputStream(file);
            byte[] bytes = new byte[in.available()];
            int length = in.read(bytes);
            base64 = Base64Utils.encodeToString(bytes);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return base64;
    }

}
