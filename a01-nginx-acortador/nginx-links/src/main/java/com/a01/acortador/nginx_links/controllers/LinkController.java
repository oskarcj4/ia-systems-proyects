package com.a01.acortador.nginx_links.controllers;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.RequestMapping;

import com.a01.acortador.nginx_links.models.NewLink;
import com.a01.acortador.nginx_links.models.Link;
import com.a01.acortador.nginx_links.models.LinkView;
import com.a01.acortador.nginx_links.services.ILinkService;

import jakarta.validation.Valid;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@RequestMapping("/api/v1/links")
public class LinkController {
    private final ILinkService linkService;

    public LinkController(ILinkService linkService) {
        this.linkService = linkService;
    }


    @PostMapping
    public ResponseEntity<LinkView> postLink(@Valid @RequestBody NewLink entity) {
        LinkView view = view(linkService.insert(entity.getUrl()));
        return ResponseEntity.created(URI.create(view.getShortUrl())).body(view);
    }

    // Pendiente a implementar: GET /api/links/{code} para redirigir a la URL original y obtener link por codigo.
    @GetMapping("/{code}")
    public LinkView getLinkByCode(@PathVariable String code) {
        
        return view(find(code));
    }
 
    @GetMapping("/{code: [0-9A-Za-z]{7}}")
    public ResponseEntity<Void> redirect(@PathVariable String code) {
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(find(code).getUrl())).build();
    }
    
    private Link find(String code){
        return  linkService.findByCode(code).orElseThrow(() ->
            new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe el enlace" + code));
    }

    private static LinkView view(Link link){
        String shortUrl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{code}").buildAndExpand(link.getCode()).toUriString();
        return new LinkView(link.getCode(), link.getUrl(), shortUrl, link.getCreatedAt());
    }
}
