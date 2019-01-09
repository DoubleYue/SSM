package com.imooc.dao;

import com.imooc.BaseTest;
import com.imooc.entity.*;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static net.sf.ezmorph.test.ArrayAssertions.assertEquals;

/**
 * Desciption:
 *测试店铺
 * @author yxl
 * @date 2019/1/7 14:52
 */
public class ShopDaoTest extends BaseTest {
    @Autowired
    private ShopDao shopDao;

    @Test
    @Ignore
    public void insertShop(){
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
        shop.setShopName("测试的店铺");
        shop.setShopDesc("店铺装修很有特色，店主很有品");
        shop.setShopAddr("店铺位置很好找，交通很便利");
        shop.setPhone("15663255664");
        shop.setShopImg("https://sfjslkdfj/jinhen/abc.jpg");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(1);
        shop.setAdvice("审核中");
        int effectedNum = shopDao.insertShop(shop);
        assertEquals(1,effectedNum);
    }
    @Test
    public void testUpdateShop(){
        Shop shop = new Shop();
        shop.setShopId(1L);
        shop.setShopDesc("测试描述");
        shop.setShopName("肯德基");
        shop.setLastEditTime(new Date());
        int effectedNum = shopDao.updateShop(shop);
        assertEquals(1,effectedNum);
    }
}
