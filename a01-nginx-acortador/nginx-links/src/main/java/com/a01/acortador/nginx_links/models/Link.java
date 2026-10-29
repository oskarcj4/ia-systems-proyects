package com.a01.acortador.nginx_links.models;

import java.time.OffsetTime;


import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class Link {
    @Id 
    @Column(name = "id", updatable = false, nullable = false, length = 7)
    private String code;

    @Column(nullable = false, length = 2048, unique = true )
    private String url;
    
    @Column(name = "created_at", nullable = false, updatable = false)
    private OffsetTime createdAt;

    public Link() {
    }

    public Link(String code, String url, OffsetTime createdAt) {
        this.code = code;
        this.url = url;
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

    public OffsetTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetTime createdAt) {
        this.createdAt = createdAt;
    }
    
}
