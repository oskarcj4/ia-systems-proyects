package com.a00.laboratorio.comun.notasv1.services;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.a00.laboratorio.comun.notasv1.entities.Note;
import com.a00.laboratorio.comun.notasv1.entities.dto.NoteDTO;
import com.a00.laboratorio.comun.notasv1.repository.NoteRepository;


@Service 
public class ProductServiceImpl implements IProductService {
    private NoteRepository repository;
    public ProductServiceImpl(NoteRepository repository){
        this.repository= repository;
    }

    @Override
    @Transactional (readOnly= true)
    public Optional<Note> findById(UUID id) {
        return repository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Note> findAll() {
        return (List<Note>) repository.findAll();
    }

    @Override
    @Transactional 
    public Note create(NoteDTO noteRequest) {
        Note note= new Note(noteRequest.getTitle(), noteRequest.getBody());
        return repository.save(note);
    }

    @Override
    public Note update(NoteDTO noteRequest, UUID id) {
        // Pendiente
    }

    @Override
    public void delete(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
