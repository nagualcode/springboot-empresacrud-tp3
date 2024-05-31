package br.infnet.empresacrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.infnet.empresacrud.repository.ArmazemRepository;
import br.infnet.empresacrud.model.Armazem;
import java.util.List;

@Service
public class ArmazemService {

    @Autowired
    private ArmazemRepository armazemRepository;

    public List<Armazem> findAll() {
        return armazemRepository.findAll();
    }

    public Armazem findById(Long id) {
        return armazemRepository.findById(id).orElse(null);
    }

    public Armazem save(Armazem armazem) {
        return armazemRepository.save(armazem);
    }

    public void deleteById(Long id) {
        armazemRepository.deleteById(id);
    }
}
