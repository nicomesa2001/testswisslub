package com.gnencisom.testswisslub.services;

import com.gnencisom.testswisslub.models.Movimiento;
import com.gnencisom.testswisslub.models.MovimientoDetalle;
import com.gnencisom.testswisslub.repositories.MovimientoDetalleRepository;
import com.gnencisom.testswisslub.repositories.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimientoService {

    private final MovimientoRepository movimientoRepository;
    private final MovimientoDetalleRepository detalleRepository; // Agrega el repositorio de detalles

    @Autowired
    public MovimientoService(MovimientoRepository movimientoRepository, MovimientoDetalleRepository detalleRepository) {
        this.movimientoRepository = movimientoRepository;
        this.detalleRepository = detalleRepository;
    }

    public List<Movimiento> getAllMovimientos() {
        return movimientoRepository.findAll();
    }

    public Movimiento getMovimientoById(Long id) {
        return movimientoRepository.findById(id).orElse(null);
    }

    public List<Movimiento> getMovimientosByEstado(String estado) {
        return movimientoRepository.findByEstado(estado);
    }

    public Movimiento createMovimiento(Movimiento movimiento) {
        return movimientoRepository.save(movimiento);
    }

    public Movimiento createMovimientoWithDetalles(Movimiento movimiento) {
        List<MovimientoDetalle> detalles = movimiento.getDetalles();

        if (detalles != null && !detalles.isEmpty()) {
            // Asignar el movimiento a los detalles
            detalles.forEach(detalle -> detalle.setMovimiento(movimiento));
            movimiento.setDetalles(detalles);
        }

        Movimiento nuevoMovimiento = movimientoRepository.save(movimiento);

        // Guardar los detalles individualmente si son nuevos o actualizar si ya existen
        if (detalles != null && !detalles.isEmpty()) {
            for (MovimientoDetalle detalle : detalles) {
                detalle.setMovimiento(nuevoMovimiento);
                detalleRepository.save(detalle);
            }
        }

        return nuevoMovimiento;
    }



    public Movimiento updateMovimiento(Long id, Movimiento movimiento) {
        Movimiento existingMovimiento = movimientoRepository.findById(id).orElse(null);
        if (existingMovimiento != null) {
            existingMovimiento.setDescripcion(movimiento.getDescripcion());
            existingMovimiento.setBodegaOrigenCodigo(movimiento.getBodegaOrigenCodigo());
            return movimientoRepository.save(existingMovimiento);
        }
        return null;
    }

    public void deleteMovimiento(Long id) {
        movimientoRepository.deleteById(id);
    }
}