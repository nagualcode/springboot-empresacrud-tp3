package br.infnet.empresacrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.infnet.empresacrud.model.Armazem;
import br.infnet.empresacrud.service.ArmazemService;

import java.util.List;

@RestController
@RequestMapping("/armazens")
public class ArmazemController {

    @Autowired
    private ArmazemService armazemService;

    @GetMapping
    public List<Armazem> getAllArmazens() {
        return armazemService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Armazem> getArmazemById(@PathVariable Long id) {
        Armazem armazem = armazemService.findById(id);
        if (armazem == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(armazem);
    }

    @PostMapping
    public Armazem createArmazem(@RequestBody Armazem armazem) {
        return armazemService.save(armazem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Armazem> updateArmazem(@PathVariable Long id, @RequestBody Armazem armazemDetails) {
        Armazem armazem = armazemService.findById(id);
        if (armazem == null) {
            return ResponseEntity.notFound().build();
        }
        armazem.setNome(armazemDetails.getNome());
        armazem.setLocalizacao(armazemDetails.getLocalizacao());
        armazem.setCapacidade(armazemDetails.getCapacidade());
        Armazem updatedArmazem = armazemService.save(armazem);
        return ResponseEntity.ok(updatedArmazem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArmazem(@PathVariable Long id) {
        Armazem armazem = armazemService.findById(id);
        if (armazem == null) {
            return ResponseEntity.notFound().build();
        }
        armazemService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
