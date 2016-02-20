package com.none.rxretrodemo.model;

import java.util.List;

/**
 * 功能：
 *
 * @author liwei
 * @version 1.0
 * @since 2016/1/27.
 */
public class NewsList {
    public int code;
    public String msg;
    public List<NewsModel> newslist;

    public NewsList(int code, String msg, List<NewsModel> newslist) {
        this.code = code;
        this.msg = msg;
        this.newslist = newslist;
    }
}
