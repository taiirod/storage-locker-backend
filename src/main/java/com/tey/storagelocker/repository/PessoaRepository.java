package com.tey.storagelocker.repository;

import com.tey.storagelocker.model.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    Pessoa findByCpf(String cpf);

    Page<Pessoa> findAllByAtivo(boolean ativo, Pageable pageable);
}
