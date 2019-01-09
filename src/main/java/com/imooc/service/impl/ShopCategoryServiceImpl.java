package com.imooc.service.impl;

import com.imooc.dao.ShopCategoryDao;
import com.imooc.entity.ShopCategory;
import com.imooc.service.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Desciption:
 *
 * @author yxl
 * @date 2019/1/9 11:19
 */@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {

     @Autowired
     private ShopCategoryDao shopCategoryDao;
     @Override
    public List<ShopCategory> queryShopCategory(ShopCategory shopCategoryCondition) {
        return shopCategoryDao.queryShopCategory(shopCategoryCondition);
    }
}
