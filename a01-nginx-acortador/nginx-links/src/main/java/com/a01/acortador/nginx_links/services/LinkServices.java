package com.a01.acortador.nginx_links.services;

import java.util.List;
import java.util.Optional;

import com.a01.acortador.nginx_links.models.Link;
import com.a01.acortador.nginx_links.repository.LinkRepository;

public class LinkServices implements ILinkService{
    private final int MAX_ATTEMPS=5;
    private final LinkRepository repository;
    private  final LinkGenerator generator;
    public LinkServices(LinkRepository repository, LinkGenerator generator) {
        this.repository = repository;
        this.generator = generator;
    }

    @Override
    public List<Link> findAll() {
        try
        {
            return (List<Link>) repository.findAll();
        }
        catch(RuntimeException ex){
            throw new RuntimeException("Error al obtener los links");
        }
    }

    @Override
    public Optional<Link> findByCode(String code) {
        return repository.findByCode(code).orElseThrow(()-> new RuntimeException("No se encontro el link con el codigo: " + code));
    }

    @Override
    public Link insert(String url) {
       
        for(int i = 0; i< MAX_ATTEMPS; i++){
            String code = generator.next();
            Optional<Link> created = repository.insert(code, url);
            if(created.isPresent()){
                return created.get();
            }
        }


        throw new IllegalStateException("No se encontro un codigo libre en: " + MAX_ATTEMPS + " intentos.");
    }

    @Override
    public Link update(Link link, String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Link delete(String code) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
