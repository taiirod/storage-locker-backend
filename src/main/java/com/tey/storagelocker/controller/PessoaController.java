package com.tey.storagelocker.controller;

import com.tey.storagelocker.model.Pessoa;
import com.tey.storagelocker.repository.PessoaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    PessoaRepository pessoaRepository;

    @GetMapping("/todas")
    public List<Pessoa> todas() {
        return pessoaRepository.findAll();
    }

    @PostMapping("/novo")
    public ResponseEntity<Pessoa> novo (@RequestBody Pessoa pessoa) {
        return ResponseEntity.ok(pessoaRepository.save(pessoa));
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Pessoa> editar (@PathVariable Long id, @RequestBody Pessoa pessoa) {
        Pessoa pessoaDoBanco = pessoaRepository.getOne(id);
        BeanUtils.copyProperties(pessoa, pessoaDoBanco, "id");
        return ResponseEntity.ok(pessoaRepository.save(pessoaDoBanco));
    }

}
