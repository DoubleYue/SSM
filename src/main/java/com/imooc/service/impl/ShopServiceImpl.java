package com.imooc.service.impl;

import com.imooc.dao.ShopDao;
import com.imooc.dto.ShopExecution;
import com.imooc.entity.Shop;
import com.imooc.enums.ShopStateEnum;
import com.imooc.exceptions.ShopOperationException;
import com.imooc.service.ShopService;
import com.imooc.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import com.imooc.util.ImageUtil;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.InputStream;
import java.util.Date;

/**
 * Desciption:
 *
 * @author yxl
 * @date 2019/1/7 19:05
 */
@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopDao shopDao;
    @Override
    public ShopExecution addShop(Shop shop, InputStream shopImgInputStream,String fileName) {
        //空值判断
        if(shop==null){
            return new ShopExecution(ShopStateEnum.NULL_SHOP);
        }
        try{
            //给店铺信息赋初值
            shop.setEnableStatus(0);
            shop.setCreateTime(new Date());
            shop.setLastEditTime(new Date());
            //添加店铺信息
            int effectedNum = shopDao.insertShop(shop);
            if(effectedNum<=0) {
                throw new ShopOperationException("店铺创建失败");
            }else{
                if(shopImgInputStream!=null){
                    //存储图片
                    try{
                        addShopImg(shop,shopImgInputStream,fileName);
                    }catch (Exception e){
                        throw new ShopOperationException("addShopImg error:"+ e.getMessage());
                    }
                    //更新店铺的图片地址
                    effectedNum = shopDao.updateShop(shop);
                    if(effectedNum<=0){
                        throw new ShopOperationException("更新图片失败");
                    }
                }
            }
        }catch (Exception e){
            throw  new ShopOperationException("addShop error:"+e.getMessage());
        }
        return new ShopExecution(ShopStateEnum.CHECK,shop);
    }

    private void addShopImg(Shop shop, InputStream shopImgInputStream,String fileName) {
        //获取shop图片目录的相对子路径
        String dest = PathUtil.getShopImagePath(shop.getShopId());
        String shopImgAddr = ImageUtil.generatorThumbnail(shopImgInputStream,fileName,dest);
        shop.setShopImg(shopImgAddr);
    }
}
