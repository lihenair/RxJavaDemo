package com.none.rxretrodemo.model;

/**
 * 功能：
 *
 * @author liwei
 * @version 1.0
 * @since 2016/1/27.
 */
public class NewsModel {
    private String title;
    private String description;
    private String picUrl;
    private String url;

    public NewsModel(String title, String description, String picUrl, String url) {
        this.title = title;
        this.description = description;
        this.picUrl = picUrl;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return description;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "NewsModel{" +
                "title='" + title + '\'' +
                ", desc='" + description + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
