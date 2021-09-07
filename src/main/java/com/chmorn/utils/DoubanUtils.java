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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author chenxu
 * @version 1.0
 * @description 豆瓣信息工具类
 * @date 2021/9/11
 **/
public class DoubanUtils {

    public static void main(String[] args) {
        /*String name = "123";
        String p = "^[0-9]*$";
        Pattern pattern = Pattern.compile("^[0-9]*$");
        Matcher ma = pattern.matcher(name);
        System.out.println(ma.matches());*/
        String url = "https://www.imdb.com/title/tt12525326/";
        getImdbScore(url);
    }

    //获取首页信息
    public static synchronized Document getDoubanHome(String doubanId) {
        //https://movie.douban.com/subject/1292063/
        String url = "https://movie.douban.com/subject/" + doubanId + "/";
        return getJsoupConn(url);
    }

    //初始化首页信息
    public static synchronized DoubanEntity initHomeInfo(DoubanEntity entity, Document document) {
        //1、海报
        /**
         https://img2.doubanio.com/view/photo/s_ratio_poster/public/p2578474613.webp 换成
         https://img2.doubanio.com/view/photo/l_ratio_poster/public/p2578474613.jpg
         **/
        String bannerurl = document.getElementById("mainpic").getElementsByTag("img").get(0).attr("src").replaceAll("s_ratio", "l_ratio").replaceAll("webp", "jpg");
        entity.setBanner(bannerurl);

        //2、评分
        String score = document.getElementsByClass("ll rating_num").get(0).text();
        String rating_sum = document.getElementsByClass("rating_sum").get(0).text();
        if (StringUtils.isEmpty(score)) {
            entity.setDoubanScore("暂无评分");
        } else {
            entity.setDoubanScore(score + "/10 (" + rating_sum + ")");
        }

        //3、标签
        Elements tagsElement = document.getElementsByClass("tags-body");
        String tags = tagsElement.text().replaceAll(" ", " | ");
        entity.setFilmTags(tags);

        //4、简介
        String desc = document.getElementById("link-report").getElementsByTag("span").get(0).html().replaceAll("<br>", "\n");
        entity.setFilmDesc(desc);
        Element content = document.getElementById("content");

        //5、片名和年代
        Elements h1 = content.getElementsByTag("h1");
        Elements h1child = h1.get(0).children();
        String name = h1child.get(0).text();
        int index = name.indexOf(" ");
        if (index != -1) {
            entity.setNameOrigin(name.substring(index + 1));//原名
            entity.setNameCn(name.substring(0, index));//中文名
        } else {
            entity.setNameOrigin(name);//原名
        }
        String year = h1child.get(1).text().replaceAll("\\(", "").replaceAll("\\)", "");
        entity.setFilmYear(year);//年代

        //6、info信息
        //info带html标签格式
        String infoSource = content.getElementsByClass("subject clearfix").get(0).getElementById("info").html();
        //decodeInfo不带html格式,比如：导演:罗伯托nnnn编剧:温琴佐/贝尼尼
        String decodeInfo = Jsoup.parse(infoSource.replaceAll("<br>", "nnnn")).body().text();//自定义nnnn代表换行
        String[] infos = decodeInfo.split("nnnn");
        for (int i = 0; i < infos.length; i++) {
            String[] row = infos[i].split(":");
            String key = row[0].replaceAll(" ", "");
            String value = row[1].trim();
            if (key.contains("IMDb")) {
                entity.setImdb(value);
                entity.setImdbUrl("https://www.imdb.com/title/" + value + "/");
                entity.setImdbScore(getImdbScore(entity.getImdbUrl()));
            } else if ("导演".equals(key)) {
                entity.setDirector(value);
            } else if ("编剧".equals(key)) {
                entity.setScriptwriter(value);
            } else if ("主演".equals(key)) {
                entity.setStars(value);
            } else if ("类型".equals(key)) {
                entity.setFilmType(value);
            } else if ("制片国家/地区".equals(key)) {
                entity.setCountry(value);
            } else if ("语言".equals(key)) {
                entity.setLng(value);
            } else if ("上映日期".equals(key) || "首播".equals(key)) {//剧集：首播
                entity.setShowTime(value);
            } else if ("片长".equals(key) || "单集片长".equals(key)) {//剧集：单集片长
                entity.setFilmLength(value);
            } else if ("又名".equals(key)) {
                entity.setNameAlias(value);
            } else if ("官网".equals(key) || "官方网站".equals(key)) {
                entity.setWebsite(value + ":" + row[2].trim());
            } else if ("集数".equals(key)) {//剧集
                entity.setEpisode(value);
            } else if ("季数".equals(key)) {//剧集
                entity.setSeason(value);
            }
        }
        return entity;
    }

    //获取获奖页面
    public static synchronized Document getDoubanAwards(String doubanId) {
        //https://movie.douban.com/subject/1292063/awards/
        String url = "https://movie.douban.com/subject/" + doubanId + "/awards/";
        return getJsoupConn(url);
    }

    //初始化获奖信息：获奖
    public static synchronized DoubanEntity initAwardsfo(DoubanEntity entity, Document document) {
        Elements awards = document.getElementsByClass("awards");
        if (awards == null || awards.size() == 0) {
            entity.setAward(null);
        } else {
            String result = "";
            for (int i = 0; i < awards.size(); i++) {
                Element head = awards.get(i).getElementsByClass("hd").get(0);
                result += head.text() + "\n";
                Elements award = awards.get(i).getElementsByClass("award");
                for (int j = 0; j < award.size(); j++) {
                    result += award.get(j).text() + "\n";
                }
                result += "\n";
            }
            result = result.replaceAll(" ", "").replaceAll("&nbsp;", "").replaceAll(" ", "");
            entity.setAward(result);
        }
        return entity;
    }

    //初始化获奖信息：获奖
    public static synchronized DoubanEntity initAwardsfo(DoubanEntity entity, String doubanId) {
        Document document = getDoubanAwards(doubanId);
        return initAwardsfo(entity, document);
    }

    //获取IMDB评分
    ////https://www.imdb.com/title/tt0118799/
    public static synchronized String getImdbScore(String imdbUrl) {
        String imdbScore = "";
        String users = "";
        Document document = null;
        try {
            document = getJsoupConn(imdbUrl);

            Elements tmps = document.getElementsByClass("AggregateRatingButton__RatingScore-sc-1ll29m0-1 iTLWoV");
            if (tmps == null || tmps.size() == 0){
                imdbScore = "暂无评分";
            }else{
                imdbScore = tmps.get(0).text();
                users = document.getElementsByClass("AggregateRatingButton__TotalRatingAmount-sc-1ll29m0-3 jkCVKJ").get(0).text();
                imdbScore = imdbScore + "/10 (" + users + ")";
            }
        } catch (Exception e) {
            System.out.println("获取imdb评分失败：" + imdbUrl);
        }
        return imdbScore;
    }

    public static synchronized Document getJsoupConn(String url) {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.107 Safari/537.36");
        headers.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
        Document res = null;
        try {
            res = Jsoup.connect(url).headers(headers).ignoreContentType(true).get();
        } catch (IOException e) {
            System.out.println("连接失败：" + url);
            //e.printStackTrace();
        }
        //String body = res.body().html();
        return res;
    }


}
