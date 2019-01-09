package com.imooc.service;

import com.imooc.dto.ShopExecution;
import com.imooc.entity.Shop;

import java.io.File;
import java.io.InputStream;

/**
 * Desciption:
 *
 * @author yxl
 * @date 2019/1/7 19:04
 */
public interface ShopService {
    /**
     * 添加商铺信息
     * @param shop 商铺信息
     * @param shopImgInputStream 商铺图片输入流
     * @param fileName 文件名
     * @return
     */
    ShopExecution addShop(Shop shop, InputStream shopImgInputStream,String fileName);
}
