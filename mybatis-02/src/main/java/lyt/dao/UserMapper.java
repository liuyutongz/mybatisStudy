package lyt.dao;

import lyt.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUserLike(String value);

    //查询获取全部用户
    List<User> getUserList();

    //根据ID查询用户
    User getUserById(int id);




    //insert一个用户
    int  addUser(User user);


    //修改用户
    int updateUser(User user);

    //删除一个用户
    int deleteUser(int id);

}
