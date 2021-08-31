package com.chmorn;

import com.chmorn.entity.DoubanEntity;
import com.chmorn.mapper.DoubanMapper;
import org.apache.ibatis.type.JdbcType;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenxu
 * @version 1.0
 * @className PtHelperApplicationTest
 * @description TODO
 * @date 2021/8/31
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class PtHelperApplicationTest {

    @Autowired
    DoubanMapper doubanMapper;

    @Test
    public void testDouban(){
//        int cn = doubanMapper.getCount();
//        System.out.println(cn);
        DoubanEntity entity = doubanMapper.getDoubanInfo("1");
        System.out.println(entity);
//        Map<String, String> headers = new HashMap<String, String>();
//        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.107 Safari/537.36");
//        headers.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
//        Document res = null;
//        String tmpurl = "https://movie.douban.com/subject/1292063/edit";
//        try {
//            res = Jsoup.connect(tmpurl).headers(headers).ignoreContentType(true).get();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        String body = res.body().html();
//        System.out.println(body);
    }
}
