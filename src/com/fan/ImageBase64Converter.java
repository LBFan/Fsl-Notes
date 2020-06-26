package com.fan;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;

/**
 * @Description :
 * @Author : shulin.fan
 * @Date : 2020/6/23
 */
public class ImageBase64Converter {
    /**
     * 本地文件（图片、excel等）转换成Base64字符串
     *
     * @param imgPath
     */
    public static String convertFileToBase64(String imgPath) {
        byte[] data = null;
        // 读取图片字节数组
        try {
            InputStream in = new FileInputStream(imgPath);
            System.out.println("文件大小（字节）=" + in.available());
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组进行Base64编码，得到Base64编码的字符串
        BASE64Encoder encoder = new BASE64Encoder();
        String base64Str = encoder.encode(data);
        return base64Str;
    }

    /**
     * 将base64字符串，生成文件
     */
    public static File convertBase64ToFile(String fileBase64String, String filePath, String fileName) {

        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file = null;
        try {
            File dir = new File(filePath);
            if (!dir.exists() && dir.isDirectory()) {//判断文件目录是否存在
                dir.mkdirs();
            }

            BASE64Decoder decoder = new BASE64Decoder();
            byte[] bfile = decoder.decodeBuffer(fileBase64String);

            file = new File(filePath + File.separator + fileName);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(bfile);
            return file;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String imgBase64Str= ImageBase64Converter.convertFileToBase64("/Users/xmly/Documents/workspaces/Fsl-Notes/src/com/fan/2.png");
//        String imgBase64Str= "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";
//        System.out.println("本地图片转换Base64:" + imgBase64Str);
        System.out.println("Base64字符串length="+imgBase64Str.length());
        ImageBase64Converter.convertBase64ToFile(imgBase64Str,"/Users/xmly/Documents/workspaces/Fsl-Notes/src/com/fan/","test.jpg");
        System.out.println("duration:"+(System.currentTimeMillis()-start));

//        start=System.currentTimeMillis();
//        String fileBase64Str= ImageBase64Converter.convertFileToBase64("D:\\Pictures\\科技\\PayOrderList200109075516581.xlsx");
////        System.out.println("本地excel转换Base64:" + fileBase64Str);
//        System.out.println("size="+fileBase64Str.length());
//        ImageBase64Converter.convertBase64ToFile(fileBase64Str,"D:\\Pictures\\科技","test.xlsx");
//        System.out.println("duration:"+(System.currentTimeMillis()-start));

    }

}
