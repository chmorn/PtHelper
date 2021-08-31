package com.chmorn.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author chenxu
 * @version 1.0
 * @className Response
 * @description 用于controller返回数据
 * @date 2021/7/6
 **/
@ApiModel("返回类ApiResult")
public class ApiResult {

    @ApiModelProperty("返回码：0000成功码，其他错误码")
    private String code;

    @ApiModelProperty("返回信息")
    private String msg;

    @ApiModelProperty("交易成功返回数据")
    private Object data;

    private ApiResult(){
    }

    private ApiResult(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 操作成功
     **/
    public static ApiResult success(){
        return new ApiResult(ApiCode.SUCC.getCode(), ApiCode.SUCC.getMsg(),null);
    }
    /**
     * 操作失败
     **/
    public static ApiResult error(){
        return new ApiResult(ApiCode.FAIL.getCode(), ApiCode.FAIL.getMsg(),null);
    }
    /**
     * apiCode 代码
     **/
    public static ApiResult result(ApiCode apiCode){
        return new ApiResult(apiCode.getCode(),apiCode.getMsg(),null);
    }

    /**
     * apiCode 代码
     * msg 自定义信息
     **/
    public static ApiResult result(ApiCode apiCode, String msg){
        return new ApiResult(apiCode.getCode(),msg,null);
    }
    /**
     * apiCode 代码
     * data 数据
     **/
    public static ApiResult result(ApiCode apiCode, Object data){
        return new ApiResult(apiCode.getCode(),apiCode.getMsg(),data);
    }
    /**
     * apiCode 代码
     * msg 自定义信息
     * data 数据
     **/
    public static ApiResult result(ApiCode apiCode, String msg, Object data){
        return new ApiResult(apiCode.getCode(),msg,data);
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Response{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
