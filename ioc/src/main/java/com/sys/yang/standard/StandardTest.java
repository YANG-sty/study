package com.sys.yang.standard;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yangLongFei 2020-12-24-15:25
 */
public class StandardTest {

    public static void main(String[] args) {
        //orderManager
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean-service.xml");
        OrderManager orderManager = (OrderManager) ac.getBean("orderManager");
        orderManager.getOrder();
    }

    @Test
    public void test1() {
        /**
         * bean-service.xml 指代的是，xml 文件
         * orderManagerSet 指代的是 bean 标签中的 name 的值
         * <bean name="orderManagerSet" class="com.sys.yang.standard.OrderManagerSet">
         *         <property name="orderService" ref="orderService"/>
         *  </bean>
         */
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean-service.xml");
        OrderManagerSet orderManagerSet = (OrderManagerSet) ac.getBean("orderManagerSet");
        orderManagerSet.getOrder();
    }


    /**
     * 依赖注入
     * set方式
     */
    @Test
    public void test2() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean-service.xml");

        OrderManagerSet orderManagerSet = (OrderManagerSet) ac.getBean("orderManagerSet");
        orderManagerSet.getOrder();

        /*OrderManagerSet orderManagerSet = (OrderManagerSet) ac.getBean("orderManagerSet");
        OrderManagerSet orderManagerSetParam = (OrderManagerSet) ac.getBean("orderManagerParam");
        // 有参，set, 构造出来的方法，不会相同
        System.out.println(orderManagerSet == orderManagerSetParam);
        //orderManagerSet
        orderManagerSetParam.getOrder();*/



        /*OrderManagerSet orderManagerAuto = (OrderManagerSet) ac.getBean("orderManagerAuto");
        orderManagerAuto.getOrder();*/
    }
}
