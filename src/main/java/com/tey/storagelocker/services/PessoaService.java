package com.tey.storagelocker.services;

import com.tey.storagelocker.model.Pessoa;
import com.tey.storagelocker.repository.PessoaRepository;
import com.tey.storagelocker.utils.ValidaCPF;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
                return new ResponseEntity("CPF já cadastrado", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity("CPF Inválido", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(pessoa);
    }


}
