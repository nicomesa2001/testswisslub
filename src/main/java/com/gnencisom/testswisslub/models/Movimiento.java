package com.gnencisom.testswisslub.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "movimiento")
public class Movimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_empresa")
    private Long idEmpresa;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "bodega_origen_codigo")
    private String bodegaOrigenCodigo;

    @Column(name = "bodega_destino_codigo")
    private String bodegaDestinoCodigo;

    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    @Column(name = "fecha_entrega")
    private Date fechaEntrega;

    @Column(name = "estado")
    private String estado;

    @OneToMany(mappedBy = "movimiento")
    private List<MovimientoDetalle> detalles = new ArrayList<>();

    // Constructors, getters, setters, etc.

    public Movimiento() {

    }

    public Movimiento(Long id, Long idEmpresa, String descripcion, String bodegaOrigenCodigo, String bodegaDestinoCodigo, Date fechaCreacion, Date fechaEntrega, String estado, List detalles) {
        this.id = id;
        this.idEmpresa = idEmpresa;
        this.descripcion = descripcion;
        this.bodegaOrigenCodigo = bodegaOrigenCodigo;
        this.bodegaDestinoCodigo = bodegaDestinoCodigo;
        this.fechaCreacion = fechaCreacion;
        this.fechaEntrega = fechaEntrega;
        this.estado = estado;
        this.detalles = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getBodegaOrigenCodigo() {
        return bodegaOrigenCodigo;
    }

    public void setBodegaOrigenCodigo(String bodegaOrigenCodigo) {
        this.bodegaOrigenCodigo = bodegaOrigenCodigo;
    }

    public String getBodegaDestinoCodigo() {
        return bodegaDestinoCodigo;
    }

    public void setBodegaDestinoCodigo(String bodegaDestinoCodigo) {
        this.bodegaDestinoCodigo = bodegaDestinoCodigo;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<MovimientoDetalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<MovimientoDetalle> detalles) {
        this.detalles = detalles;
    }
}