package com.gnencisom.testswisslub.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "movimiento_detalle")
public class MovimientoDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "movimiento_id")
    @JsonBackReference
    private Movimiento movimiento;

    @Column(name = "item_codigo", length = 20)
    private String itemCodigo;

    @Column(name = "cantidad_enviada")
    private int cantidadEnviada;

    // Constructor, getters, setters, etc.

    public MovimientoDetalle() {
    }

    public MovimientoDetalle(Long id, Movimiento movimiento, String itemCodigo, int cantidadEnviada) {
        this.id = id;
        this.movimiento = movimiento;
        this.itemCodigo = itemCodigo;
        this.cantidadEnviada = cantidadEnviada;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Movimiento getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(Movimiento movimiento) {
        this.movimiento = movimiento;
    }

    public String getItemCodigo() {
        return itemCodigo;
    }

    public void setItemCodigo(String itemCodigo) {
        this.itemCodigo = itemCodigo;
    }

    public int getCantidadEnviada() {
        return cantidadEnviada;
    }

    public void setCantidadEnviada(int cantidadEnviada) {
        this.cantidadEnviada = cantidadEnviada;
    }
}
