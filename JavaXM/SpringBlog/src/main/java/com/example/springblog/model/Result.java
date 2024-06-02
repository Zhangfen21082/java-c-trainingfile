package com.example.springblog.model;


import com.example.springblog.constants.Constant;
import lombok.Data;

@Data
public class Result {
    /*
    状态码
        200：成功
        -1：失败
        ....
     */
    private int code;
    // 错误返回信息
    private String errMsg;
    // 业务返回数据
    private Object data;

    public static Result success(Object data){
        Result result=new Result();
        result.setCode(Constant.RESULT_CODE_SUCCESS);
        result.setErrMsg(null);
        result.setData(data);
        return result;
    }

    public static Result fail(String errMsg){
        Result result=new Result();
        result.setCode(Constant.RESULT_CODE_FAIL);
        result.setErrMsg(errMsg);
        result.setData(null);
        return result;
    }

    public static Result unlogin(Object data){
        Result result=new Result();
        result.setCode(Constant.RESULT_CODE_UNLOGIN);
        result.setErrMsg("用户未登录");
        result.setData(data);
        return result;
    }


}
