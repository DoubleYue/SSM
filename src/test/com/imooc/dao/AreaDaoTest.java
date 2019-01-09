package com.imooc.dao;

import com.imooc.BaseTest;
import com.imooc.entity.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Desciption:
 *
 * @author yxl
 * @date 2019/1/4 9:25
 */
public class AreaDaoTest extends BaseTest {
    @Autowired
    private AreaDao areaDao;

    @Test
    public void queryArea(){
        List<Area> resultList = areaDao.queryArea();
        assertEquals(2,resultList.size());
    }

}