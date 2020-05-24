package com.tey.storagelocker.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "storage_locker")
public class StorageLocker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double altura;
    private double largura;
    private double profundidade;

    @Column(name = "metro_quadrado")
    private double metroQuadrado;

    @Column(name = "data_inicio_reserva")
    private Date dataInicioReserva;

    @Column(name = "data_termino_reserva")
    private Date dataTerminoReserva;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    private boolean reservado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public double getProfundidade() {
        return profundidade;
    }

    public void setProfundidade(double profundidade) {
        this.profundidade = profundidade;
    }

    public double getMetroQuadrado() {
        return metroQuadrado;
    }

    public void setMetroQuadrado(double metroQuadrado) {
        this.metroQuadrado = metroQuadrado;
    }

    public Date getDataInicioReserva() {
        return dataInicioReserva;
    }

    public void setDataInicioReserva(Date dataInicioReserva) {
        this.dataInicioReserva = dataInicioReserva;
    }

    public Date getDataTerminoReserva() {
        return dataTerminoReserva;
    }

    public void setDataTerminoReserva(Date dataTerminoReserva) {
        this.dataTerminoReserva = dataTerminoReserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean isReservado() {
        return reservado;
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }
}
