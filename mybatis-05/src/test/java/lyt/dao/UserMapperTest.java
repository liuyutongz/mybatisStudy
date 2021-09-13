package lyt.dao;

import lyt.pojo.User;
import lyt.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {
    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.deleteUser(5);
/*
        mapper.updateUser(new User(5,"word","2325555"));
        mapper.addUser(new User(6, "helooo", "1327448"));

        List<User> users = mapper.getUsers();
        for (User user : users) {
            System.out.println(user);
        }

        User userByID = mapper.getUserByID(1);
        System.out.println(userByID);
*/

        sqlSession.close();


    }
}
