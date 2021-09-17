package lyt.dao;

import lyt.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author lyt
 * @version 1.0
 * @date 2021/9/13 22:29
 */
public interface UserMapper {
    //根据id查询用户
    User queryById(@Param("id") int id);

    int updateUser(User user);
}
