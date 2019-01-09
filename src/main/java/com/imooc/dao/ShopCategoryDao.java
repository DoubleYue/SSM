package com.imooc.dao;

import com.imooc.entity.ShopCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Desciption:
 *
 * @author yxl
 * @date 2019/1/9 10:44
 */
public interface ShopCategoryDao {
    /**
     * 获取店铺类别信息
     * @param shopCategoryCondition
     * @return
     */
    List<ShopCategory> queryShopCategory(@Param("shopCategoryCondition") ShopCategory shopCategoryCondition);
}
