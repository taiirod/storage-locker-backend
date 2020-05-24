package com.tey.storagelocker.services;

import com.tey.storagelocker.model.Cliente;
import com.tey.storagelocker.repository.ClienteRepository;
import com.tey.storagelocker.repository.EnderecoRepository;
import com.tey.storagelocker.utils.ValidaCPF;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteService {

    @Autowired
    ValidaCPF validaCPF;

    @Autowired
    ClienteRepository pessoaRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @Transactional
    public ResponseEntity<?> nova(Cliente pessoa) throws Exception {
        ResponseEntity<?> responseEntity = verifiCpf(pessoa);
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            pessoa = pessoaRepository.save(pessoa);
            enderecoRepository.saveAll(pessoa.getEndereco());
            return ResponseEntity.ok(pessoa);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseEntity.getBody());
    }


    public ResponseEntity<?> editar(Long idCliente, Cliente pessoa) {
        Cliente pessoaSalva = pessoaRepository.getOne(idCliente);
        if (pessoaSalva.getId() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cliente não encontrada.");
        }
        BeanUtils.copyProperties(pessoa, pessoaSalva, "id", "cpf");
        return ResponseEntity.ok(pessoaRepository.save(pessoaSalva));

    }

    public ResponseEntity<?> verifiCpf(Cliente pessoa) throws Exception {
        if (!validaCPF.isCPF(pessoa.getCpf())) {
            throw new Exception("CPF Inválido.");
        } else if (!(pessoaRepository.findByCpf(pessoa.getCpf()) == null)) {
            throw new Exception("CPF já cadastrado.");
        }
        return ResponseEntity.ok().body(pessoa);
    }
}
