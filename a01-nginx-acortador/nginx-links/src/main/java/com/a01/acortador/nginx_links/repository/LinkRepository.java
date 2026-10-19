package com.a01.acortador.nginx_links.repository;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.a01.acortador.nginx_links.models.Link;

public interface LinkRepository extends CrudRepository<Link, String>{

    @Query("SELECT * FROM Link WHERE code = :code")
    public Optional<Link> findByCode(String code);
    @Query ("INSERT INTO link(code, url) VALUES (:code, :url) ON CONFLICT DO NOTHING RETURNING code, url, created_at" )
    public Optional<Link> insert(String code, String url);
}
