package com.a01.acortador.nginx_links.models;

import java.time.OffsetDateTime;
import java.time.OffsetTime;

public class LinkView {

    String code; 
    String url; 
    String shortUrl; 
    OffsetTime createdAt;


    

    public LinkView(String code, String url, String shortUrl, OffsetTime createdAt) {
        this.code = code;
        this.url = url;
        this.shortUrl = shortUrl;
        this.createdAt = createdAt;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getShortUrl() {
        return shortUrl;
    }
    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }
    public OffsetTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(OffsetTime createdAt) {
        this.createdAt = createdAt;
    }


    
}
