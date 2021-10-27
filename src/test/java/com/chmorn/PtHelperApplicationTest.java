package com.chmorn;

import com.chmorn.entity.DoubanEntity;
import com.chmorn.mapper.DoubanMapper;
import org.apache.http.HttpRequest;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.net.URL;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenxu
 * @version 1.0
 * @className PtHelperApplicationTest
 * @description TODO258369
 * @date 2021/8/31
 **/
//@SpringBootTest
//@RunWith(SpringRunner.class)
public class PtHelperApplicationTest {

    @Autowired
    DoubanMapper doubanMapper;

    //@Test
    public void testDouban(){

    }

}
