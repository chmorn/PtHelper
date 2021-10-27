package com.chmorn.controller;

import com.chmorn.base.ApiCode;
import com.chmorn.base.ApiResult;
import com.chmorn.entity.DoubanEntity;
import com.chmorn.service.DoubanService;
import com.chmorn.utils.DoubanUtils;
import org.apache.commons.lang.StringUtils;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

/**
 * @author chenxu
 * @version 1.0
 * @className IptvController
 * @description 下载iptv
 * @date 2021/8/30
 **/
@RestController
@RequestMapping(value = "/douban")
public class DoubanController {

    private static Logger logger = LoggerFactory.getLogger(DoubanController.class);

    @Autowired
    private DoubanService doubanService;

    //获取简介
    @GetMapping(value = "/genDoubanInfo/{doubanId}")
    public synchronized ApiResult genDoubanInfo(@PathVariable("doubanId") String doubanId) throws InterruptedException {
        if (StringUtils.isEmpty(doubanId)) {
            return ApiResult.result(ApiCode.PARAM_ERROR, "参数为空，请检查豆瓣编号是否正确");
        }
        //DoubanEntity entity = doubanService.getDoubanInfo(doubanId);
        DoubanEntity entity = null;
        if (entity == null) {
            //数据库没有，则去豆瓣查询
            Document home = DoubanUtils.getDoubanHome(doubanId);
            if (home == null) {
                return ApiResult.result(ApiCode.PARAM_ERROR, "未查询到豆瓣信息，请检查豆瓣编号是否正确");
            }
            entity = new DoubanEntity();
            entity.setDoubanId(doubanId);
            entity.setDoubanUrl("https://movie.douban.com/subject/" + doubanId + "/");
            entity.setUpdateTime(new Date());
            //初始化首页信息: 详细信息
            entity = DoubanUtils.initHomeInfo(entity, home);
            //初始化获奖信息：获奖
            entity = DoubanUtils.initAwardsfo(entity, doubanId);
            //保存数据库
            //doubanService.addDoubanInfo(entity);
        }
        //使用entity生成信息

        return ApiResult.result(ApiCode.SUCC, entity);
    }

    /**
     * 校验地址
     **/
    private static ApiResult checkDoubanUrl(String requrl) {
        //1、校验时间
        try {
            URL url = new URL(requrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setUseCaches(false);
            conn.setConnectTimeout(500);
            int status = conn.getResponseCode();
            if (status != 200) {
                return ApiResult.result(ApiCode.URL_TIMEOUT);
            }
        } catch (Exception e) {
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
