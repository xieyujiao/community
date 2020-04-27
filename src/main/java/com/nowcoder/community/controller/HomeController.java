package com.nowcoder.community.controller;

import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.Page;
import com.nowcoder.community.entity.User;
import com.nowcoder.community.service.DiscussPostsService;
import com.nowcoder.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:HomeController
 * Package:
 * Description
 *
 * @Date:
 * @Author:736354146@qq.com
 */
@Controller
public class HomeController {

    @Autowired
    private DiscussPostsService discussPostsService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String getIndexPage(Model model, Page page) {
        //方法调用前springmvc会自动实例化model和page,并且会将page注入给model,
        //所以,在thymeleaf中可以直接访问Page对象中的数据

        //总行数
        //因为是首页不以用户编号来查询,所有userId传入0
        page.setRows(discussPostsService.findDiscussPostRows(0));
        //传入当前页面的访问路径
        page.setPath("/index");

        List<DiscussPost> list = discussPostsService.findDiscussPosts(0, page.getOffset(), page.getLimit());
        //由于查到数据是不完整的,主要是因为userId,只是id不是用户名,但我们需要的用户名,好在页面上展现
        //这种情况下把集合遍历一遍,针对每一个discussPost 我们在根据userId查到user,在组装一下放到新的集合中
        List<Map<String, Object>> discussPosts = new ArrayList<>();
        //判断是否为空
        if (list != null) {
            for (DiscussPost post : list) {
                //由于每次遍历都要把最终的结果放到map中
                Map<String, Object> map = new HashMap<>();
                //将帖子装进去
                map.put("post", post);
                //将获取user 从帖子里面找 找到以后查询它所对应的user
                User user = userService.findUserById(post.getUserId());
                //最终将user装到map里面
                map.put("user",user);
                discussPosts.add(map);
            }
        }
        //将最终的展现结果装到model页面才能够进行显示
        model.addAttribute("discussPosts", discussPosts);

        return "index";
    }
}
