package com.imooc.dao;

import com.imooc.entity.Shop;

/**
 * Desciption:
 *
 * @author yxl
 * @date 2019/1/7 14:27
 */
public interface ShopDao {
    /**
     * 新增店铺
     *
     * @param shop
     * @return
     */
    int insertShop(Shop shop);

    /**
     * 更新店铺信息
     * @param shop
     * @return
     */
    int updateShop(Shop shop);
}
