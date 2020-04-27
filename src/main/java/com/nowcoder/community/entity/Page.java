package com.nowcoder.community.entity;

import lombok.Data;

/**
 * className:Page
 * Package:
 * Description:封装分页的条件
 *
 * @Date:
 * @Author:736354146@qq.com
 */
@Data
public class Page {

    //当前页
    private int current = 1;
    //显示的上限
    private int limit = 10;
    //数据总数(用于计算总页数)
    private int rows;
    //查询路径(指的是分页每次都在不同页面会有不同的路径,如果每个去拼的话过于麻烦,因此组件中封装一个路径,然后返回给页面,页面就复用变量)
    //作用:复用分页的链接
    private String path;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        //数据比较特别,在set时,要判断避免传入不合理或错误的值(主要是判断0和负数情况)
        if (current >= 1) {
            this.current = current;
        }
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        //对limit每页显示的上限有限制,介于1-100之间
        //如果用户想显示出1000条或10000条数据,一个是给服务器的压力过大,
        // 再一个就是这么多数据给浏览器那么它就卡死了,用户体验感也不好
        if (limit >= 1 && limit <= 100) {
            this.limit = limit;
        }

    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        if(rows>=0) {
            this.rows = rows;
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 获取当前页的起始行
     * @return
     */
    public int getOffset()
    {
        return (current-1)*limit;
    }

    /**
     * 获取总页数
     * @return
     */
    public int getTotal()
    {
        if(rows%limit==0)
        {
            return rows/limit;
        }else{
         return rows/limit+1;
        }
    }

    /**
     * 获取起始页码
     * @return
     */
    public int getFrom()
    {
      int from=current-2;
      return from<1?1:from;//from该由的值
    }

    /**
     * 获取终止页码
     * 到第几
     *比如要显示100页不可能从第一页到100页都显示 最多显示前面几页即可
     * 显示当前页 最后一页 以及第一页 前两页即可
     * @return
     */
    public int getTo()
    {
        int to=current+2;
        int total=getTotal();
        return to>total?total:to;
    }
}
