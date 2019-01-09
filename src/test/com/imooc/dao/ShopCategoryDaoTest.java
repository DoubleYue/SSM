package com.imooc.dao;

import com.imooc.BaseTest;
import com.imooc.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Desciption:
 *
 * @author yxl
 * @date 2019/1/9 10:56
 */
public class ShopCategoryDaoTest extends BaseTest {

    @Autowired
    private ShopCategoryDao shopCategoryDao;
    @Test
    public void testShopCategoryDao(){

        ShopCategory parentShopCategory = new ShopCategory();
        parentShopCategory.setShopCategoryId(1l);
        ShopCategory shopCategory = new ShopCategory();
        shopCategory.setParent(parentShopCategory);
        List<ShopCategory> queryShopCategory = shopCategoryDao.queryShopCategory(shopCategory);
        assertEquals(1,queryShopCategory.size());
    }


}