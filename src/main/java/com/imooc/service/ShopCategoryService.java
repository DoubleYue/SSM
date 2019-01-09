package com.imooc.service;

import com.imooc.entity.ShopCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Desciption:
 *
 * @author yxl
 * @date 2019/1/9 11:18
 */
public interface ShopCategoryService {
    /**
     * 获取店铺类别信息
     * @param shopCategoryCondition
     * @return
     */
    List<ShopCategory> queryShopCategory( ShopCategory shopCategoryCondition);

}
