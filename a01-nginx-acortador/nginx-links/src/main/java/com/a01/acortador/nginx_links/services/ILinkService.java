package com.a01.acortador.nginx_links.services;

import java.util.List;
import java.util.Optional;

import com.a01.acortador.nginx_links.models.Link;

public interface ILinkService {
    public List<Link> findAll();
    public Optional<Link> findByCode(String code);
    public Link insert(String link);
}
