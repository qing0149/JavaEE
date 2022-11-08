package com.llkj.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Books
 * @Description TODO
 * @Author qing
 * @Date 2022/11/6 18:51
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Books {
    private  Integer id;
    private  String title;
    private String author;
    private Double price;
    private Integer sales;
    private Integer stock;
    private String imgPath;
}
