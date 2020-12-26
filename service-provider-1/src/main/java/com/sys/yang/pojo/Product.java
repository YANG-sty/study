package com.sys.yang.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yangLongFei 2020-12-25-19:12
 */
@Data
public class Product implements Serializable {

    private static final long serialVersionUID = 2912696142145869028L;
    private int id;
    private String productName;
    private int productNum;
    private double productPrice;

    public Product(int id, String productName, int productNum, double productPrice) {
        this.id = id;
        this.productName = productName;
        this.productNum = productNum;
        this.productPrice = productPrice;
    }

    public Product() {
    }
}
