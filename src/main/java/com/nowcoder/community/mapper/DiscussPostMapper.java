package com.nowcoder.community.mapper;

import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * className:DiscussPostMapper
 * Package:
 * Description
 *
 * @Date:
 * @Author:736354146@qq.com
 */
@Mapper
public interface DiscussPostMapper {

    /**
     * 考虑到将来开发而不是首页
     *
     * @param userId 为0时不拼sql,为其他时拼接sql
     * @return
     */
    List<DiscussPost> selectDiscussPosts(@Param("userId") int userId,
                                         @Param("offset") int offset,
                                         @Param("limit") int limit);

    /**
     *查询总页数
     * @param userId 开发我的主页的时候用到而不是主页时用到
     * @return
     * @Param 用于参数取别名。如果只有一个参数并且子啊if标签里面用,则必须区别名
     */
    int selectDiscussPostRows(@Param("userId") int userId);

}
