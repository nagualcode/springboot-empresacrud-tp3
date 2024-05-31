package br.infnet.empresacrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.infnet.empresacrud.repository.FornecedorRepository;
import br.infnet.empresacrud.model.Fornecedor;
import java.util.List;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public List<Fornecedor> findAll() {
        return fornecedorRepository.findAll();
    }

    public Fornecedor findById(Long id) {
        return fornecedorRepository.findById(id).orElse(null);
    }

    public Fornecedor save(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    public void deleteById(Long id) {
        fornecedorRepository.deleteById(id);
    }
}
