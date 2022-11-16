package com.llkj.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName CartItem
 * @Description TODO
 * @Author qing
 * @Date 2022/11/15 9:28
 * @Version 1.0
 */
//商品详情
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
    //1.
    private Integer bookId;
    //商品名称
    private String bookName;
    private String imgPath;
    //商品图品
    private Integer total;
    private Double price;
    //当前购物商品的总金额
    private Double amount;

    public void setTotal(Integer total) {
        this.total = total;
        if (this.price != null) {
            this.amount = this.price * total;
        }
    }
}
