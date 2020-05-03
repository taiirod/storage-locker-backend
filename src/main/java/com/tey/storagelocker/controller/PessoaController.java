package com.tey.storagelocker.controller;

import com.tey.storagelocker.model.Pessoa;
import com.tey.storagelocker.repository.PessoaRepository;
import com.tey.storagelocker.services.PessoaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    PessoaService pessoaService;

    @GetMapping("/todas")
    public Page<Pessoa> buscarTodas(Pageable pageable) {
        return pessoaRepository.findAll(pageable);
    }

    @GetMapping("/ativos")
    public Page<Pessoa> buscarTodasAtivas (Pageable pageable) {
        return pessoaRepository.findAllByAtivo(true, pageable);
    }

    @PostMapping("/nova")
    public ResponseEntity<Pessoa> nova (@RequestBody Pessoa pessoa) {
        return pessoaService.nova(pessoa);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Pessoa> editar (@PathVariable Long id, @RequestBody Pessoa pessoa) {
        Pessoa pessoaDoBanco = pessoaRepository.getOne(id);
        BeanUtils.copyProperties(pessoa, pessoaDoBanco, "id");
        return ResponseEntity.ok(pessoaRepository.save(pessoaDoBanco));
    }

}
