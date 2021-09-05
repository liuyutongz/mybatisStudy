package lyt.dao;

import lyt.pojo.User;
import lyt.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class UserDaoTest {

   static Logger logger = Logger.getLogger(UserDaoTest.class);
   @Test
   public void testGetUsers(){
       SqlSession sqlSession = MybatisUtils.getSqlSession();
//       底层主要应用反射
       UserMapper mapper = sqlSession.getMapper(UserMapper.class);
       List<User> users = mapper.getUsers();
       for (User user : users) {
           System.out.println(user);
       }
       sqlSession.close();
   }
   @Test
   public void getUserByRowBounds(){
       SqlSession sqlSession = MybatisUtils.getSqlSession();
       //RowBounds实现
       RowBounds rowBounds = new RowBounds(1,2);

       //通过Java代码层面实现分页
       List<User> userList = sqlSession.selectList("lyt.dao.UserMapper.getUserByRowBounds",null,rowBounds);
       for (User user : userList) {
           System.out.println(user);
       }
       sqlSession.close();
   }
    @Test
    public void getUserByLimit(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Integer> map = new HashMap<String,Integer>();
        map.put("startIndex",1);
        map.put("pageSize",2);
       List<User> userList= mapper.getUserByList(map);
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void testLog4j(){
          logger.info("info:进入testLog4j");
          logger.debug("debug:进入testLog4j");
          logger.error("error:进入testLog4j");
    }
    @Test
    public void test(){
//        第一步：获取SqlSession 对象
        SqlSession sqlSession;

            sqlSession= MybatisUtils.getSqlSession();
            //        执行SQl   方式一：getMapper 获得接口
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();

            for (User user : userList) {
                System.out.println(user);
            }
            //关闭sqlSession
            sqlSession.close();
    }
    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);
        sqlSession.close();
    }



    //增删改需要提交事务
    @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.addUser(new User(5,"哈哈","12333"));
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.updateUser(new User(5,"和和哈哈","1277733"));

        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser(5);
        sqlSession.commit();
        sqlSession.close();
    }

}
