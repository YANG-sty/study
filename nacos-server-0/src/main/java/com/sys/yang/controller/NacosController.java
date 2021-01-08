package com.sys.yang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangLongFei 2021-01-05-9:38
 */
@RestController
@RequestMapping("/nacos")
//@RefreshScope // 实现配置的动态更新
public class NacosController {

    /**
     * 这种方式，在经过nacos 修改后，无法实时获取配置信息
     * 如果配置文件中，不存在相应的配置，在启动的时候会报错
     */
    /*@Value("${common.name}")
    private String commonName;
    @Value("${common.age}")
    private String commonAge;
//    @Value("${common.sex}")
    private String commonSex;
    @Value("${common.phone}")
    private String commonPhone;*/

    @Autowired
    private ConfigurableApplicationContext applicationContext;

    @GetMapping("/getCommonName")
    public String getCommonName() {
        String commonName = applicationContext.getEnvironment().getProperty("common.name");
        String commonAge = applicationContext.getEnvironment().getProperty("common.age");
        String commonSex = applicationContext.getEnvironment().getProperty("common.sex");
        String commonPhone = applicationContext.getEnvironment().getProperty("common.phone");
        String commonAddress = applicationContext.getEnvironment().getProperty("common.address");
        String commonPort = applicationContext.getEnvironment().getProperty("common.port");
        return "name: " + commonName + " age:" + commonAge + " sex:" + commonSex + " phone:" + commonPhone + " address:" + commonAddress + " port:" + commonPort;
    }

}
