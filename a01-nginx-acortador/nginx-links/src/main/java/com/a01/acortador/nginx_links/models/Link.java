package com.a01.acortador.nginx_links.models;

import java.time.OffsetTime;


import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class Link {
    @Id 
    @Column(name = "id", updatable = false, nullable = false, length = 7)
    private String id;

    @Column(nullable = false, length = 2048, unique = true )
    private String url;
    
    @Column(name = "created_at", nullable = false, updatable = false)
    private OffsetTime createdAt;

    public Link() {
    }

    public Link(String id, String url, OffsetTime createdAt) {
        this.id = id;
        this.url = url;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
