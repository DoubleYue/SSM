package com.imooc.service;

import com.imooc.BaseTest;
import com.imooc.entity.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Desciption:
 *
 * @author yxl
 * @date 2019/1/4 10:55
 */
public class AreaServiceTest extends BaseTest {
    @Autowired
    private AreaService areaService;
    @Test
    public void  testGetAreaList(){
        List<Area> areaList = areaService.getAreaList();
        assertEquals("东苑",areaList.get(0).getAreaName());
    }
}