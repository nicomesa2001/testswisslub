package com.gnencisom.testswisslub.services;

import com.gnencisom.testswisslub.models.MovimientoDetalle;
import com.gnencisom.testswisslub.repositories.MovimientoDetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimientoDetalleService {

    @Autowired
    private MovimientoDetalleRepository movimientoDetalleRepository;

    public List<MovimientoDetalle> getAllMovimientoDetalles() {
        return movimientoDetalleRepository.findAll();
    }

    public MovimientoDetalle getMovimientoDetalleById(Long id) {
        return movimientoDetalleRepository.findById(id).orElse(null);
    }

    public List<MovimientoDetalle> getMovimientoDetalleByMovimientoId(Long movimientoId) {
        return movimientoDetalleRepository.findByMovimientoId(movimientoId);
    }

    public MovimientoDetalle createMovimientoDetalle(MovimientoDetalle movimientoDetalle) {
        return movimientoDetalleRepository.save(movimientoDetalle);
    }

    public MovimientoDetalle updateMovimientoDetalle(Long id, MovimientoDetalle movimientoDetalle) {
        MovimientoDetalle existingMovimientoDetalle = movimientoDetalleRepository.findById(id).orElse(null);
        if (existingMovimientoDetalle != null) {
            existingMovimientoDetalle.setMovimiento(movimientoDetalle.getMovimiento());
            existingMovimientoDetalle.setItemCodigo(movimientoDetalle.getItemCodigo());
            existingMovimientoDetalle.setCantidadEnviada(movimientoDetalle.getCantidadEnviada());
            return movimientoDetalleRepository.save(existingMovimientoDetalle);
        }
        return null;
    }

    public void deleteMovimientoDetalle(Long id) {
        movimientoDetalleRepository.deleteById(id);
    }
}