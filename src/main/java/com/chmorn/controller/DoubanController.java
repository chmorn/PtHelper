package com.chmorn.controller;

import com.chmorn.base.ApiCode;
import com.chmorn.base.ApiResult;
import com.chmorn.config.GlobalConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONArray;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author chenxu
 * @version 1.0
 * @className IptvController
 * @description 下载iptv
 * @date 2021/8/30
 **/
@RestController
@Api(tags = "DoubanController")
@RequestMapping(value = "/douban")
public class DoubanController {

    private static Logger logger = LoggerFactory.getLogger(DoubanController.class);

    @PostMapping(value = "/genInfo")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "requrl",value = "豆瓣电影地址",required = true,dataType = "String")
            //,example = "http://183.207.248.142/ott.js.chinamobile.com/PLTV/3/224/3221227467/index.m3u8"
    })
    @ApiOperation(value = "定时下载",notes = "定时下载")
    public synchronized ApiResult genInfo(String requrl) throws InterruptedException {

        return ApiResult.result(ApiCode.SUCC );
    }

    /**
     * 校验地址
    **/
    private static ApiResult checkDoubanUrl(String requrl){
        //1、校验时间
        try {
            URL url = new URL(requrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setUseCaches(false);
            conn.setConnectTimeout(500);
            int status = conn.getResponseCode();
            if(status!=200){
                return ApiResult.result(ApiCode.URL_TIMEOUT);
            }
        }catch (Exception e){
            e.printStackTrace();
            return ApiResult.result(ApiCode.URL_ERROR);
        }

        return ApiResult.success();
    }

    public static void main(String[] args) {
        String requrl = "https://movie.douban.com/subject/1292063/";
        //String requrl = "https://www.baidu.com";
        ApiResult re = checkDoubanUrl(requrl);
        System.out.println(re);
    }

}
