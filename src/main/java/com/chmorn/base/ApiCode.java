package com.chmorn.base;

/**
 * @author chenxu
 * @version 1.0
 * @className TradeCode
 * @description 返回代码
 * @date 2021/7/7
 **/
public enum ApiCode {
    SUCC("0000","操作成功"),
    FAIL("0001","操作失败"),
    URL_ERROR("0043","连接异常"),
    URL_TIMEOUT("0044","连接超时"),
    OTHER("other","其他异常");

    private String code;
    private String msg;

    ApiCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static String getMsg(String code) {
        for (ApiCode tc : ApiCode.values()) {
            if(tc.code == code){
                return tc.msg;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
