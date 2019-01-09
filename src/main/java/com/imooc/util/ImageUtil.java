package com.imooc.util;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Desciption:
 *  图片处理的工具类
 *
 * @author yxl
 * @date 2019/1/7 15:53
 */
public class ImageUtil {
    private static Logger logger =LoggerFactory.getLogger(ImageUtil.class);

    /**获取根路径*/
    private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    /**获取年月日时分秒*/
    private static final SimpleDateFormat sFormat = new java.text.SimpleDateFormat("yyyyMMddHHmmss");
    /**随机对象用于生成随机数*/
    private static final Random r = new Random();

    public static void main(String[] args) throws IOException {
        Thumbnails.of(new File("D:\\BaiduNetdiskDownload\\photo\\demo.jpg")).size(200,200)
                .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath+"/waterMark.jpg")),0.25f)
                .outputQuality(0.8f).toFile("D:\\BaiduNetdiskDownload\\photo\\demo01.jpg");
    }

    /**
     * 处理缩略图
     * @param thumbnailInputStream 上传的图片
     * @param targetAddr 图片的存储路径
     * @return
     */
    public static String generatorThumbnail(InputStream thumbnailInputStream,String fileName, String targetAddr)
    {
        //创建随机文件名
        String realFileName = getRandomFileName();
        //获取文件扩展名
        String extension = getFileExtension(fileName);
        //创建路径
        makeDirPath(targetAddr);
        //相对路径
        String relativeAddr = targetAddr+realFileName+extension;
        logger.debug("current relativeAddr is:"+relativeAddr);
        //绝对路径
        File dest = new File(PathUtil.getImgBasePath()+relativeAddr);
        logger.debug("current complete addr is :"+PathUtil.getImgBasePath()+relativeAddr);
        try{
            Thumbnails.of(thumbnailInputStream).size(200,200)
                    .watermark(Positions.BOTTOM_RIGHT,ImageIO.read(new File(basePath+"/waterMark.jpg")),0.2f)
                    .outputQuality(0.8f).toFile(dest);
        }catch (IOException e){
            logger.error(e.toString());
            throw new RuntimeException("创建缩略图失败：" + e.toString());
        }
        return relativeAddr;
    }

    /**
     * 创建目标路径所涉及的目录
     * @param targetAddr
     */
    private static void makeDirPath(String targetAddr) {
        String realPath = PathUtil.getImgBasePath()+targetAddr;
        File dirFile = new File(realPath);
        if(!dirFile.exists()){
            dirFile.mkdirs();
        }
    }

    /**
     * 获取输入文件流的扩展名
     * @param fileName
     * @return
     */
    private static String getFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    /**
     * 生成随机文件名：
     *      当前年月日时分秒+五位随机数
     * @return
     */
    public static String getRandomFileName() {
        int rannum = r.nextInt(89999)+10000;
        String nowTimeStr = sFormat.format(new Date());
        return nowTimeStr+rannum;
    }
}
