package com.tey.storagelocker.repository;

import com.tey.storagelocker.model.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente findByCpf(String cpf);

    Page<Cliente> findAllByAtivo(boolean ativo, Pageable pageable);
}
