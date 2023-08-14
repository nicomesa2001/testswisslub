package com.gnencisom.testswisslub.controllers;

import com.gnencisom.testswisslub.models.MovimientoDetalle;
import com.gnencisom.testswisslub.services.MovimientoDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimiento-detalles")
public class MovimientoDetalleController {

    @Autowired
    private MovimientoDetalleService movimientoDetalleService;

    @GetMapping
    public List<MovimientoDetalle> getAllMovimientoDetalles() {
        return movimientoDetalleService.getAllMovimientoDetalles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovimientoDetalle> getMovimientoDetalleById(@PathVariable Long id) {
        MovimientoDetalle movimientoDetalle = movimientoDetalleService.getMovimientoDetalleById(id);
        if (movimientoDetalle != null) {
            return ResponseEntity.ok(movimientoDetalle);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/movimiento/{movimientoId}")
    public ResponseEntity<List<MovimientoDetalle>> getMovimientoDetalleByMovimientoId(@PathVariable Long movimientoId) {
        List<MovimientoDetalle> movimientoDetalles = movimientoDetalleService.getMovimientoDetalleByMovimientoId(movimientoId);
        if (!movimientoDetalles.isEmpty()) {
            return ResponseEntity.ok(movimientoDetalles);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public MovimientoDetalle createMovimientoDetalle(@RequestBody MovimientoDetalle movimientoDetalle) {
        return movimientoDetalleService.createMovimientoDetalle(movimientoDetalle);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovimientoDetalle> updateMovimientoDetalle(@PathVariable Long id, @RequestBody MovimientoDetalle movimientoDetalle) {
        MovimientoDetalle updatedMovimientoDetalle = movimientoDetalleService.updateMovimientoDetalle(id, movimientoDetalle);
        if (updatedMovimientoDetalle != null) {
            return ResponseEntity.ok(updatedMovimientoDetalle);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovimientoDetalle(@PathVariable Long id) {
        movimientoDetalleService.deleteMovimientoDetalle(id);
        return ResponseEntity.noContent().build();
    }
}
