package com.a01.acortador.nginx_links.controllers;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.a01.acortador.nginx_links.models.NewLink;
import com.a01.acortador.nginx_links.models.Link;
import com.a01.acortador.nginx_links.services.ILinkService;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/links")
public class LinkController {
    private final ILinkService linkService;

    public LinkController(ILinkService linkService) {
        this.linkService = linkService;
    }


    @PostMapping
    public ResponseEntity<Link> postLink(@RequestBody NewLink entity) {
        Link link = linkService.insert(entity.url());
        return ResponseEntity.ok(link);
    }

    // Pendiente a implementar: GET /api/links/{code} para redirigir a la URL original y obtener link por codigo.
}
