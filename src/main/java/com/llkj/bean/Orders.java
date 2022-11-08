package com.llkj.bean;

import cn.hutool.core.date.DateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Orders
 * @Description TODO
 * @Author qing
 * @Date 2022/11/6 18:55
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    private String id;
    private DateTime ordertime;
    private Integer totalcount;
    private Double totalamount;
    private Integer state;
    private Integer userid;
}
