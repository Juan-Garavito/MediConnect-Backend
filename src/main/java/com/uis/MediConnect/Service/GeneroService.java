package com.uis.MediConnect.Service;

import com.uis.MediConnect.Model.Genero;
import com.uis.MediConnect.Repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GeneroService implements IGeneroService {

    private final GeneroRepository generoRepository;

    @Autowired
    public GeneroService(GeneroRepository generoRepository) {
        this.generoRepository = generoRepository;
    }

    @Override
    public Genero buscarGeneroPorId(Integer idgenero) {
        return generoRepository.findById(idgenero).orElse(null);
    }
}
