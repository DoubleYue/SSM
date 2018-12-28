package dao;

import com.imooc.dao.AreaDao;
import com.imooc.entity.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Desciption:
 *
 * @author yxl
 * @date 2018/12/28 10:14
 */
public class AreaTest extends BaseTest {
    @Autowired
    private AreaDao areaDao;
    @Test
    public void testQueryArea()
    {
        List<Area> areaList = areaDao.queryArea();
        assertEquals(2,areaList.size());
    }
}
