package com.tey.storagelocker.repository;

import com.tey.storagelocker.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    Pessoa findByCpf(String cpf);

    List<Pessoa> findAllByAtivo(Pageable pageable);
}
