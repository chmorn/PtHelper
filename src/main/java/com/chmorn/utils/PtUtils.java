package com.chmorn.utils;

import com.chmorn.entity.DoubanEntity;
import org.apache.commons.lang.StringUtils;
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
    public static synchronized int getDownloadId() {
        return Integer.valueOf(String.valueOf(System.currentTimeMillis()).substring(6));
    }

    //拼接字符串（拼接符号：join）
    public static synchronized String joinStrs(String join, String... strs) {
        String result = "";
        for (int i = 0; i < strs.length; i++) {
            if (StringUtils.isNotBlank(strs[i])) {
                result += join + strs[i];
            }
        }
        while (result.startsWith(join)){
            result = result.substring(1);
        }
        return result;
    }

}
