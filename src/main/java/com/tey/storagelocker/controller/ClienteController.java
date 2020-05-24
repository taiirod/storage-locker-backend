package com.tey.storagelocker.controller;

import com.tey.storagelocker.model.Cliente;
import com.tey.storagelocker.repository.ClienteRepository;
import com.tey.storagelocker.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ClienteService clienteService;

    @GetMapping("/todos")
    public Page<Cliente> buscarTodas(Pageable pageable) {
        return clienteRepository.findAll(pageable);
    }

    @GetMapping("/ativos")
    public Page<Cliente> buscarTodasAtivas(Pageable pageable) {
        return clienteRepository.findAllByAtivo(true, pageable);
    }

    @GetMapping("/{idCliente}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long idCliente) {
        return ResponseEntity.ok(clienteRepository.getOne(idCliente));
    }

    @PostMapping("/novo")
    public ResponseEntity<?> nova(@RequestBody Cliente cliente) throws Exception {
        return clienteService.nova(cliente);
    }

    @PutMapping("/editar/{idCliente}")
    public ResponseEntity<?> editar(@PathVariable Long idCliente, @RequestBody Cliente cliente) {
        return clienteService.editar(idCliente, cliente);
    }

    @DeleteMapping("/alterar-status/{idCliente}")
    public ResponseEntity<Cliente> desativar(@PathVariable Long idCliente, @RequestBody boolean ativo) {
        Cliente p = clienteRepository.getOne(idCliente);
        p.setAtivo(ativo);
        return ResponseEntity.ok(clienteRepository.save(p));
    }

}
