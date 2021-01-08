package com.sys.yang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangLongFei 2021-01-05-9:38
 */
@RestController
@RequestMapping("/nacos")
public class NacosController {

    @Autowired
    private ConfigurableApplicationContext applicationContext;

    /**
     * 动态更新，nacos 配置文件发生修改，能够实时看到
     */
    @GetMapping("/getCommonName")
    public String getCommonName() {
        return applicationContext.getEnvironment().getProperty("common.name");
    }

}
