package com.sthg.web.controller.system;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sthg.common.config.ZfwConfig;
import com.sthg.common.utils.StringUtils;

/**
 * 首页
 *
 * @author zfw
 */
@RestController
@Api(tags = "首页")
public class SysIndexController {
    /**
     * 系统基础配置
     */
    @Autowired
    private ZfwConfig zfwConfig;

    /**
     * 访问首页，提示语
     */
    @RequestMapping("/")
    public String index() {
        return StringUtils.format("欢迎使用{}后台管理框架，当前版本：v{}，请通过前端地址访问。", zfwConfig.getName(), zfwConfig.getVersion());
    }
}
