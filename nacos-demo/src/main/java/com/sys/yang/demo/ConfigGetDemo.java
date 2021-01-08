package com.sys.yang.demo;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;

import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * @author yangLongFei 2021-01-04-20:31
 */
public class ConfigGetDemo {
    public static void main(String[] args) throws NacosException, InterruptedException {
        //nacos 地址
        String serverAddr = "127.0.0.1:8848";
        // data id
        String dataId = "nacos-demo.yaml";
        // Group
        String group = "DEFAULT_GROUP";
        Properties properties = new Properties();
        properties.put(PropertyKeyConst.SERVER_ADDR, serverAddr);
        // 指定命名空间， 使用的是，命名空间的id
        properties.put(PropertyKeyConst.NAMESPACE, "fca23eb6-3866-4b8c-8f86-5eeb14e0599d");
        ConfigService configService = NacosFactory.createConfigService(properties);
        String content = configService.getConfig(dataId, group, 5000);
        System.out.println(content);
        configService.addListener(dataId, group, new Listener() {
            @Override
            public void receiveConfigInfo(String configInfo) {
                System.out.println("recieve:" + configInfo);
            }

            @Override
            public Executor getExecutor() {
                return null;
            }
        });

        boolean isPublishOk = configService.publishConfig(dataId, group, "content");
        System.out.println(isPublishOk);

        Thread.sleep(3000);
        content = configService.getConfig(dataId, group, 5000);
        System.out.println(content);

        // 删除 dataid 的配置文件
        /*boolean isRemoveOk = configService.removeConfig(dataId, group);
        System.out.println(isRemoveOk);
        Thread.sleep(3000);*/

        content = configService.getConfig(dataId, group, 5000);
        System.out.println(content);
        Thread.sleep(300000);
    }
}
