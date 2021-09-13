package lyt.dao;

import lyt.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    //插入数据
    int addBlog(Blog blog);

    //查询博客
    List<Blog> queryBlogIF(Map map);

    //
    List<Blog> queryBlogWhere(Map map);

    //选择其中一个查询
    List<Blog> queryBlogChoose(Map map);

    //更新博客
    int updateBlog(Map map);

    //更新使用trim
    int updateBlogByTrim(Map map);

    //查询第1,2,3号记录的博客
    List<Blog> queryByForeach(Map map);
}
