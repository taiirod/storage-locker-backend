package com.tey.storagelocker.repository;

import com.tey.storagelocker.model.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    Pessoa findByCpf(String cpf);

    Page<Pessoa> findAllByAtivo(boolean ativo, Pageable pageable);
}
