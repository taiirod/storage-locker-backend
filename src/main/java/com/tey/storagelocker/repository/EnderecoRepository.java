package com.tey.storagelocker.repository;

import com.tey.storagelocker.model.Endereco;
import com.tey.storagelocker.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}