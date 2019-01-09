package com.imooc.service.impl;

import com.imooc.dao.AreaDao;
import com.imooc.entity.Area;
import com.imooc.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Desciption:
 *
 * @author yxl
 * @date 2018/12/28 10:39
 */

@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }
}
