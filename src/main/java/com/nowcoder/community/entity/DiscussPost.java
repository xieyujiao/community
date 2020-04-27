package com.nowcoder.community.entity;

import lombok.Data;

import java.util.Date;

/**
 * className:DiscustPost
 * Package:
 * Description
 *
 * @Date:
 * @Author:736354146@qq.com
 */
@Data
public class DiscussPost {
    //帖子编号
    private int id;
    //用户编号
    private int userId;
    //标题
    private String title;
    //内容
    private String content;
    //类型
    private int type;
    //状态
    private int status;
    //创建时间
    private Date createTime;
    //评论次数
    private int commentCount;
    //分数
    private Double score;



}
