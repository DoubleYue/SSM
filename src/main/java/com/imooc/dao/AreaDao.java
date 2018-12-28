package com.imooc.dao;

import com.imooc.entity.Area;

import java.util.List;

/**
 * Desciption:
 *
 * @author yxl
 * @date 2018/12/28 9:54
 */
public interface AreaDao {
    /**
     * 列出区域列表
     * @return
     */
    List<Area> queryArea();
}
