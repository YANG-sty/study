package com.sys.yang.service.impl;

import com.sys.yang.pojo.Order;
import com.sys.yang.pojo.Product;
import com.sys.yang.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author yangLongFei 2020-12-25-19:17
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private RestTemplate restTemplate;

    // 元数据信息
    @Autowired
    private DiscoveryClient discoveryClient;

    @Override
    public Order selectOrderById(Integer id) {
        return new Order(id, "order-001", "henan", 58000D, selectProductListByDiscoveryClint());
    }

    // 方式 1 进行远程调用
    private List<Product> selectProductListByDiscoveryClint() {
        StringBuffer sb = null;

        //获取服务列表
        List<String> servideIds = discoveryClient.getServices();
        if (CollectionUtils.isEmpty(servideIds)) {
            return null;
        }
//        servideIds.forEach(s -> System.out.println(s.toString()));
        //根据服务名称获取服务
        List<ServiceInstance> instances = discoveryClient.getInstances("service-provider");
        if (CollectionUtils.isEmpty(instances)) {
            return null;
        }
        ServiceInstance serviceInstance = instances.get(0);
        sb = new StringBuffer();
        sb.append("http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/product/list");

        System.out.println(sb.toString());

        // ResponseEntity 封装了返回数据
        ResponseEntity<List<Product>> exchange = restTemplate.exchange(
                sb.toString(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>() {
                }
        );

        return exchange.getBody();
    }


    /**
     * 方式 2 通过 Ribbon 负载均衡器, 轮询的方式
     */
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    public List<Product> selectProductListByLoadBalancerClint() {
        StringBuffer stringBuffer = null;

        ServiceInstance choose = loadBalancerClient.choose("service-provider");
        if (choose == null) {
            return null;
        }
        stringBuffer = new StringBuffer();
        stringBuffer.append("http://" + choose.getHost() + ":" + choose.getPort() + "/product/list");

        System.out.println(stringBuffer.toString());

        // ResponseEntity 封装了返回数据
        ResponseEntity<List<Product>> exchange = restTemplate.exchange(
                stringBuffer.toString(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>() {
                }
        );

        return exchange.getBody();

    }

    /**
     * 第三种方式
     */
    private List<Product> selectProductListByBalancerAnnotation() {
        // ResponseEntity 封装了返回数据
        ResponseEntity<List<Product>> exchange = restTemplate.exchange(
                "http://service-provider/product/list",  // 直接使用 服务名称 进行远程调用
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>() {
                }
        );

        return exchange.getBody();
    }
}
