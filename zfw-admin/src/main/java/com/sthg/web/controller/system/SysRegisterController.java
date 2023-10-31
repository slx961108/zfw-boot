package com.sthg.web.controller.system;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.sthg.common.core.controller.BaseController;
import com.sthg.common.core.domain.AjaxResult;
import com.sthg.common.core.domain.model.RegisterBody;
import com.sthg.common.utils.StringUtils;
import com.sthg.framework.web.service.SysRegisterService;
import com.sthg.system.service.ISysConfigService;

/**
 * 注册验证
 *
 * @author zfw
 */
@RestController
@Api(tags = "注册验证")
public class SysRegisterController extends BaseController {
    @Autowired
    private SysRegisterService registerService;

    @Autowired
    private ISysConfigService configService;

    @PostMapping("/register")
    public AjaxResult register(@RequestBody RegisterBody user) {
        if (!("true".equals(configService.selectConfigByKey("sys.account.registerUser")))) {
            return error("当前系统没有开启注册功能！");
        }
        String msg = registerService.register(user);
        return StringUtils.isEmpty(msg) ? success() : error(msg);
    }
}
