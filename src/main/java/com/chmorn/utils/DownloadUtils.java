package com.chmorn.utils;

/**
 * @author chenxu
 * @version 1.0
 * @className DownloadUtils
 * @description TODO
 * @date 2021/8/1
 **/
public class DownloadUtils {

    //根据时间戳返回下载id
    public static synchronized int getDownloadId(){
        return Integer.valueOf(String.valueOf(System.currentTimeMillis()).substring(6));
    }
}
