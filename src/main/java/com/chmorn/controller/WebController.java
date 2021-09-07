package com.chmorn.controller;

import com.chmorn.base.ApiCode;
import com.chmorn.base.ApiResult;
import com.chmorn.entity.DoubanEntity;
import com.chmorn.utils.PtUtils;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author chenxu
 * @version 1.0
 * @description 提供页面
 * @date 2021/9/6
 **/
@Controller
@RequestMapping(value = "/pt")
public class WebController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${server.port}")
    private String port;

    private String doubanInfoUrlPre = "http://localhost:port/douban/genDoubanInfo/";

    //页面
//    @RequestMapping(value = "/douban")
//    public String douban() {
//        return "/douban.html";
//    }
//
//    @RequestMapping(value = "/douban2")
//    public ModelAndView douban2() {
//        //return "douban.html";
//        ModelAndView mav = new ModelAndView("/douban.html");
//        return mav;
//    }

    @GetMapping(value = "/genDoubanInfo/{doubanId}")
    @ResponseBody
    public ApiResult doubanInfo(@PathVariable("doubanId") String doubanId) {
        doubanInfoUrlPre = doubanInfoUrlPre.replace("port",port);
        String url = doubanInfoUrlPre + doubanId;
        ApiResult apiResult = restTemplate.getForObject(url, ApiResult.class);
        StringBuffer info = new StringBuffer("");
        try {
            if (!apiResult.getCode().equals(ApiCode.SUCC.getCode())) {
                return apiResult;
            } else {
                JSONObject jo = JSONObject.fromObject(apiResult.getData());
                DoubanEntity entity = (DoubanEntity) JSONObject.toBean(jo, DoubanEntity.class);
                //海报 [img]https://img9.doubanio.com/view/photo/l_ratio_poster/public/p510861873.jpg[/img]
                info.append("[img]").append(entity.getBanner()).append("[/img]\r\n");
                //◎片　　名
                info.append("◎片　　名：").append(PtUtils.joinStrs("/", entity.getNameCn(), entity.getNameOrigin(), entity.getNameAlias())).append("\r\n");
                //◎年　　代
                if (StringUtils.isNotBlank(entity.getFilmYear()))
                    info.append("◎年　　代：").append(entity.getFilmYear()).append("\r\n");
                //◎官　　网
                if (StringUtils.isNotBlank(entity.getWebsite()))
                    info.append("◎官　　网：").append(entity.getWebsite()).append("\r\n");
                //◎产　　地
                if (StringUtils.isNotBlank(entity.getCountry()))
                    info.append("◎产　　地：").append(entity.getCountry()).append("\r\n");
                //◎类　　别
                if (StringUtils.isNotBlank(entity.getFilmType()))
                    info.append("◎类　　别：").append(entity.getFilmType()).append("\r\n");
                //◎语　　言
                if (StringUtils.isNotBlank(entity.getLng()))
                    info.append("◎语　　言：").append(entity.getLng()).append("\r\n");
                //◎上映日期
                if (StringUtils.isNotBlank(entity.getShowTime()))
                    info.append("◎上映日期：").append(entity.getShowTime()).append("\r\n");
                //◎豆瓣评分
                if (StringUtils.isNotBlank(entity.getDoubanScore()))
                    info.append("◎豆瓣评分：").append(entity.getDoubanScore()).append("\r\n");
                //◎豆瓣链接
                if (StringUtils.isNotBlank(entity.getDoubanUrl()))
                    info.append("◎豆瓣链接：").append(entity.getDoubanUrl()).append("\r\n");
                //◎IMDB评分
                if (StringUtils.isNotBlank(entity.getImdbScore()))
                    info.append("◎imdb评分：").append(entity.getImdbScore()).append("\r\n");
                //◎IMDB链接
                if (StringUtils.isNotBlank(entity.getImdbUrl()))
                    info.append("◎imdb链接：").append(entity.getImdbUrl()).append("\r\n");
                //◎季　　数
                if (StringUtils.isNotBlank(entity.getSeason()))
                    info.append("◎季　　数：").append(entity.getSeason()).append("\r\n");
                //◎集　　数
                if (StringUtils.isNotBlank(entity.getEpisode()))
                    info.append("◎集　　数：").append(entity.getEpisode()).append("\r\n");
                //◎片　　长
                if (StringUtils.isNotBlank(entity.getFilmLength()))
                    info.append("◎片　　长：").append(entity.getFilmLength()).append("\r\n");
                //◎导　　演
                if (StringUtils.isNotBlank(entity.getDirector()))
                    info.append("◎导　　演：").append(entity.getDirector()).append("\r\n");
                //◎编　　剧
                if (StringUtils.isNotBlank(entity.getScriptwriter()))
                    info.append("◎编　　剧：").append(entity.getScriptwriter().replaceAll("/", "\r\n　　　　　 ")).append("\r\n");
                //◎主　　演
                if (StringUtils.isNotBlank(entity.getStars()))
                    info.append("◎主　　演：").append(entity.getStars().replaceAll("/", "\r\n　　　　　 ")).append("\r\n");
                //◎标　　签
                if (StringUtils.isNotBlank(entity.getFilmTags()))
                    info.append("\r\n").append("◎标　　签：").append(entity.getFilmTags()).append("\r\n");
                //◎简　　介
                if (StringUtils.isNotBlank(entity.getFilmDesc()))
                    info.append("\r\n").append("◎简　　介：").append("\r\n").append(entity.getFilmDesc()).append("\r\n");
                //◎获奖情况
                if (StringUtils.isNotBlank(entity.getAward()))
                    info.append("\r\n").append("◎获奖情况：").append("\r\n　　").append(entity.getAward().replaceAll("\n", "\n　　")).append("\r\n");
                return ApiResult.result(ApiCode.SUCC, info);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ApiResult.result(ApiCode.FAIL, e.getMessage());
        }
    }
}
