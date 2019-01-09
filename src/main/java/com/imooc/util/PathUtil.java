package com.imooc.util;

/**
 * Desciption:
 *  路径处理的工具类
 * @author yxl
 * @date 2019/1/7 16:42
 */
public class PathUtil {
    private static String separator = System.getProperty("file.separator");

    /**
     * 获取项目图片的根路径
     * @return
     */
    public static String getImgBasePath(){
        String os = System.getProperty("os.name");
        String basePath = "";
        if(os.toLowerCase().startsWith("win")){
            basePath = "D:\\BaiduNetdiskDownload\\photo";
        }else{
            basePath = basePath.replace("/",separator);
        }
        return basePath;
    }

    /**
     * 根据店铺id获取项目有关图片的子路径
     * @param shopId
     */
    public static String getShopImagePath(long shopId){
        String imagePath = "/upload/item/shop"+shopId+"/";
        return imagePath.replace("/",separator);
    }
}
