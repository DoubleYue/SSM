package com.imooc.service;

import com.imooc.BaseTest;
import com.imooc.dto.ShopExecution;
import com.imooc.entity.Area;
import com.imooc.entity.PersonInfo;
import com.imooc.entity.Shop;
import com.imooc.entity.ShopCategory;
import com.imooc.enums.ShopStateEnum;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Desciption:
 *
 * @author yxl
 * @date 2019/1/8 11:01
 */
public class ShopServiceTest extends BaseTest {
    @Autowired
    private ShopService shopService;
    @Test
    public void testAddShop() throws FileNotFoundException {
        Shop shop = new Shop();
        Area area = new Area();
        PersonInfo person = new PersonInfo();
        ShopCategory shopCategory = new ShopCategory();
        area.setAreaId(2);
        person.setUserId(1);
        shopCategory.setShopCategoryId(1L);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setOwner(person);
        shop.setShopName("测试的店铺3");
        shop.setShopDesc("店铺装修很有特色，店主很有品");
        shop.setShopAddr("店铺位置很好找，交通很便利");
        shop.setPhone("15663255664");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(ShopStateEnum.CHECK.getState());
        shop.setAdvice("审核中");
        File shopImg = new File("D:\\BaiduNetdiskDownload\\photo\\demo.jpg");
        InputStream is = new FileInputStream(shopImg);
        ShopExecution shopExecution = shopService.addShop(shop, is,shopImg.getName());
        assertEquals(ShopStateEnum.CHECK.getState(),shopExecution.getState());
    }


}