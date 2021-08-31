package com.chmorn.utils;

/**
 * @author chenxu
 * @version 1.0
 * @className DownloadUtils
 * @description TODO
 * @date 2021/8/31
 **/
public class PtUtils {

    //根据时间戳后6位生成id
    public static synchronized int getDownloadId(){
        return Integer.valueOf(String.valueOf(System.currentTimeMillis()).substring(6));
    }

    //
    public static synchronized void getDoubanEdit(int doubanId){
        //https://movie.douban.com/subject/1292063/edit
    }

}
