package com.chmorn.utils;

import com.chmorn.entity.DoubanEntity;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chenxu
 * @version 1.0
 * @description TODO
 * @date 2021/8/31
 **/
public class PtUtils {

    //根据时间戳后6位生成id
    public static synchronized int getDownloadId(){
        return Integer.valueOf(String.valueOf(System.currentTimeMillis()).substring(6));
    }

}
