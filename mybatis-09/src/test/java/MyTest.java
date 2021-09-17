import lyt.dao.UserMapper;
import lyt.pojo.User;
import lyt.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author lyt
 * @version 1.0
 * @date 2021/9/13 22:42
 */
public class MyTest {
    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user1 = mapper.queryById(1);
        System.out.println("user1 mapper 查询1"+user1);
        sqlSession.close();
        System.out.println("-------------------");

        SqlSession sqlSession2=MybatisUtils.getSqlSession();
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        User user2 = mapper2.queryById(1);
        System.out.println("user2 mapper2 查询1"+user2);
        System.out.println("------");
        User user3 = mapper2.queryById(2);
        System.out.println("user2 mapper2 查询1"+user2);
        System.out.println("user3 mapper2 查询2"+user3);
        User user4 = mapper2.queryById(2);
        System.out.println("user4 mapper2 查询2"+user4);
        System.out.println("user1 mapper 查询1"+user1);
        sqlSession2.close();
    }
}
