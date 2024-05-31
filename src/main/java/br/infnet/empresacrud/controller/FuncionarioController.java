package br.infnet.empresacrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.infnet.empresacrud.model.Funcionario;
import br.infnet.empresacrud.service.FuncionarioService;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public List<Funcionario> getAllFuncionarios() {
        return funcionarioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> getFuncionarioById(@PathVariable Long id) {
        Funcionario funcionario = funcionarioService.findById(id);
        if (funcionario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(funcionario);
    }

    @PostMapping
    public Funcionario createFuncionario(@RequestBody Funcionario funcionario) {
        return funcionarioService.save(funcionario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> updateFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionarioDetails) {
        Funcionario funcionario = funcionarioService.findById(id);
        if (funcionario == null) {
            return ResponseEntity.notFound().build();
        }
        funcionario.setNome(funcionarioDetails.getNome());
        funcionario.setCargo(funcionarioDetails.getCargo());
        funcionario.setSalario(funcionarioDetails.getSalario());
        Funcionario updatedFuncionario = funcionarioService.save(funcionario);
        return ResponseEntity.ok(updatedFuncionario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFuncionario(@PathVariable Long id) {
        Funcionario funcionario = funcionarioService.findById(id);
        if (funcionario == null) {
            return ResponseEntity.notFound().build();
        }
        funcionarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
