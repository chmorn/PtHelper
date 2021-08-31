package com.chmorn.entity;


import java.util.Date;

public class DoubanEntity {

    private String doubanId; //豆瓣id
    private String doubanUrl; //豆瓣链接
    private String doubanScore; //豆瓣评分
    private String banner; //海报地址https: //img9.doubanio.com/view/photo/l_ratio_poster/public/p510860435.jpg
    private String nameOrigin; //原名
    private String nameCn; //简体中文名
    private String nameAlias; //又名
    private String imdb; //IMDb编号
    private String imdbUrl; //IMDb链接
    private String imdbScore; //IMDb评分
    private String director; //导演
    private String scriptwriter; //编剧
    private String stars; //主演
    private String filmType; //类型
    private String website; //官网
    private String country; //制片国家/地区
    private String lng;  //语言
    private String filmYear; //年份
    private String showTime; //上映日期
    private String filmLength; //片长
    private String filmDesc; //剧情简介
    private String filmLabel; //标签
    private String award; //获奖情况
    private Date updateTime; //更新时间


    public String getDoubanId() {
        return doubanId;
    }

    public void setDoubanId(String doubanId) {
        this.doubanId = doubanId;
    }


    public String getDoubanUrl() {
        return doubanUrl;
    }

    public void setDoubanUrl(String doubanUrl) {
        this.doubanUrl = doubanUrl;
    }


    public String getDoubanScore() {
        return doubanScore;
    }

    public void setDoubanScore(String doubanScore) {
        this.doubanScore = doubanScore;
    }


    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }


    public String getNameOrigin() {
        return nameOrigin;
    }

    public void setNameOrigin(String nameOrigin) {
        this.nameOrigin = nameOrigin;
    }


    public String getNameCn() {
        return nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }


    public String getNameAlias() {
        return nameAlias;
    }

    public void setNameAlias(String nameAlias) {
        this.nameAlias = nameAlias;
    }


    public String getImdb() {
        return imdb;
    }

    public void setImdb(String imdb) {
        this.imdb = imdb;
    }


    public String getImdbUrl() {
        return imdbUrl;
    }

    public void setImdbUrl(String imdbUrl) {
        this.imdbUrl = imdbUrl;
    }


    public String getImdbScore() {
        return imdbScore;
    }

    public void setImdbScore(String imdbScore) {
        this.imdbScore = imdbScore;
    }


    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }


    public String getScriptwriter() {
        return scriptwriter;
    }

    public void setScriptwriter(String scriptwriter) {
        this.scriptwriter = scriptwriter;
    }


    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }


    public String getFilmType() {
        return filmType;
    }

    public void setFilmType(String filmType) {
        this.filmType = filmType;
    }


    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getFilmYear() {
        return filmYear;
    }

    public void setFilmYear(String filmYear) {
        this.filmYear = filmYear;
    }


    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }


    public String getFilmLength() {
        return filmLength;
    }

    public void setFilmLength(String filmLength) {
        this.filmLength = filmLength;
    }


    public String getFilmDesc() {
        return filmDesc;
    }

    public void setFilmDesc(String filmDesc) {
        this.filmDesc = filmDesc;
    }


    public String getFilmLabel() {
        return filmLabel;
    }

    public void setFilmLabel(String filmLabel) {
        this.filmLabel = filmLabel;
    }


    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "DoubanEntity{" +
                "doubanId=" + doubanId +
                ", doubanUrl='" + doubanUrl + '\'' +
                ", doubanScore='" + doubanScore + '\'' +
                ", banner='" + banner + '\'' +
                ", nameOrigin='" + nameOrigin + '\'' +
                ", nameCn='" + nameCn + '\'' +
                ", nameAlias='" + nameAlias + '\'' +
                ", imdb='" + imdb + '\'' +
                ", imdbUrl='" + imdbUrl + '\'' +
                ", imdbScore='" + imdbScore + '\'' +
                ", director='" + director + '\'' +
                ", scriptwriter='" + scriptwriter + '\'' +
                ", stars='" + stars + '\'' +
                ", filmType='" + filmType + '\'' +
                ", website='" + website + '\'' +
                ", country='" + country + '\'' +
                ", lng='" + lng + '\'' +
                ", filmYear='" + filmYear + '\'' +
                ", showTime='" + showTime + '\'' +
                ", filmLength='" + filmLength + '\'' +
                ", filmDesc='" + filmDesc + '\'' +
                ", filmLabel='" + filmLabel + '\'' +
                ", award='" + award + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }
}
