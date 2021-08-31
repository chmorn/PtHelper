package com.chmorn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author chenxu
 * @version 1.0
 * @className PtHelper
 * @description 启动类
 * @date 2021/8/30
 **/
@SpringBootApplication
@EnableSwagger2
public class PtHelperApplication {
    private static Logger logger = LoggerFactory.getLogger(PtHelperApplication.class);
    public static void main(String[] args) {
        logger.info("启动开始喽……");
        SpringApplication.run(PtHelperApplication.class,args);
    }

}
