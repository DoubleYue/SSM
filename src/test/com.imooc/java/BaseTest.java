import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Desciption:
 *  配置spring和junit整合，junit启动时加载springIOC容器
 * @author yxl
 * @date 2018/12/28 10:07
 */
@RunWith(SpringJUnit4ClassRunner.class)
//配置文件的位置
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class BaseTest {

}
