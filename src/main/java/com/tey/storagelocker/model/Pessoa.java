package com.tey.storagelocker.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pessoa {

    @Id
    private Integer id;
    private String nome;
    private String sobrenome;
    private String cpf;
    @Embedded
    private Endereco endereco;
    private String telefone;


}
