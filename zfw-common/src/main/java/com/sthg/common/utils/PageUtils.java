package com.sthg.common.utils;

import com.github.pagehelper.PageHelper;
import com.sthg.common.core.page.PageDomain;
import com.sthg.common.core.page.TableSupport;
import com.sthg.common.utils.sql.SqlUtil;

/**
 * 分页工具类
 *
 * @author zfw
 */
public class PageUtils extends PageHelper {
    /**
     * 设置请求分页数据
     */
    public static void startPage() {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        String orderBy = SqlUtil.escapeOrderBySql(pageDomain.getOrderBy());
        Boolean reasonable = pageDomain.getReasonable();
        PageHelper.startPage(pageNum, pageSize, orderBy).setReasonable(reasonable);
    }

    /**
     * 清理分页的线程变量
     */
    public static void clearPage() {
        PageHelper.clearPage();
    }
}
