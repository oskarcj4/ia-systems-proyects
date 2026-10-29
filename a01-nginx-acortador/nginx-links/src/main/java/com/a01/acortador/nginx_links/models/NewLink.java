package com.a01.acortador.nginx_links.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class NewLink{
    @NotBlank @Size (max = 2048) @Pattern (regexp = "https?://.*", message = "Invalid URL format") 
    String url;

    public NewLink(
            @NotBlank @Size(max = 2048) @Pattern(regexp = "https?://.*", message = "Invalid URL format") String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    

}
