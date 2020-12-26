package com.sys.yang.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author yangLongFei 2020-12-25-19:37
 */
@Data
public class Order implements Serializable {
    private static final long serialVersionUID = -1756497124430834320L;

    private Integer id;
    private String orderNo;
    private String orderAddress;
    private Double totalPrice;
    private List<Product> productList;

    public Order(Integer id, String orderNo, String orderAddress, Double totalPrice, List<Product> productList) {
        this.id = id;
        this.orderNo = orderNo;
        this.orderAddress = orderAddress;
        this.totalPrice = totalPrice;
        this.productList = productList;
    }
}
