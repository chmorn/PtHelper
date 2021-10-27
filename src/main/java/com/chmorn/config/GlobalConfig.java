package com.chmorn.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author chenxu
 * @version 1.0
 * @className ChmornConfig
 * @description 读取配置文件自定义属性
 * @date 2021/7/21
 **/
//@Component
//@ConfigurationProperties(prefix = "app.video")
public class GlobalConfig {
    //@Value("${app.video.qq.qqPath}")
    private String qqPath;
    //@Value("${app.video.ffmpegPath}")
    private String ffmpegPath;
    //@Value("${app.video.nodePath}")
    private String nodePath;
    //@Value("${app.video.maxThreads}")
    private int maxThreads;

    public String getQqPath() {
        return qqPath;
    }

    public void setQqPath(String qqPath) {
        this.qqPath = qqPath;
    }

    public String getFfmpegPath() {
        return ffmpegPath;
    }

    public void setFfmpegPath(String ffmpegPath) {
        this.ffmpegPath = ffmpegPath;
    }

    public String getNodePath() {
        return nodePath;
    }

    public void setNodePath(String nodePath) {
        this.nodePath = nodePath;
    }

    public int getMaxThreads() {
        return maxThreads;
    }

    public void setMaxThreads(int maxThreads) {
        this.maxThreads = maxThreads;
    }

    @Override
    public String toString() {
        return "GlobalConfig{" +
                "qqPath='" + qqPath + '\'' +
                ", ffmpegPath='" + ffmpegPath + '\'' +
                ", nodePath='" + nodePath + '\'' +
                ", maxThreads=" + maxThreads +
                '}';
    }
}
