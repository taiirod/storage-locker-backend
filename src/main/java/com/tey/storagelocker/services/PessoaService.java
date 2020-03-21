package com.tey.storagelocker.services;

import com.tey.storagelocker.model.Pessoa;
import com.tey.storagelocker.repository.PessoaRepository;
import com.tey.storagelocker.utils.ValidaCPF;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    ValidaCPF validaCPF;

    @Autowired
    PessoaRepository pessoaRepository;

    public ResponseEntity<Pessoa> nova (Pessoa pessoa) {
        if (validaCPF.isCPF(pessoa.getCpf())){
            if (pessoaRepository.findByCpf(pessoa.getCpf()) == null) {
                ResponseEntity.ok(pessoaRepository.save(pessoa));
            } else {
                System.out.println("CPF já cadastrado");
            }
        } else {
            System.out.println("CPF inválido");
        }
        return ResponseEntity.ok(pessoa);
    }


}
