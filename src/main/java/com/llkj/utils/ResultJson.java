package com.llkj.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName ResultJson
 * @Description TODO
 * @Author qing
 * @Date 2022/11/15 8:48
 * @Version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResultJson {
    private Boolean flag;
    private Object resultData;
    private String message;

    public Boolean getFlag() {
        return flag;
    }

    public ResultJson setFlag(Boolean flag) {
        this.flag = flag;
        return this;
    }

    public Object getResultData() {
        return resultData;
    }

    public ResultJson setResultData(Object resultData) {
        this.resultData = resultData;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResultJson setMessage(String message) {
        this.message = message;
        return this;
    }

    public static ResultJson ok() {
        return new ResultJson().setFlag(true);
    }
    public static ResultJson error(){
        return new ResultJson().setFlag(false);
    }
}
