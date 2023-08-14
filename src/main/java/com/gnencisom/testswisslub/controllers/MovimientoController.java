package com.gnencisom.testswisslub.controllers;

import com.gnencisom.testswisslub.models.Movimiento;
import com.gnencisom.testswisslub.services.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {

    @Autowired
    private MovimientoService movimientoService;

    @GetMapping
    public List<Movimiento> getAllMovimientos() {
        return movimientoService.getAllMovimientos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movimiento> getMovimientoById(@PathVariable Long id) {
        Movimiento movimiento = movimientoService.getMovimientoById(id);
        if (movimiento != null) {
            return ResponseEntity.ok(movimiento);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/estado/{estado}")
    public List<Movimiento> getMovimientosByEstado(@PathVariable String estado) {
        return movimientoService.getMovimientosByEstado(estado);
    }

    @PostMapping
    public Movimiento createMovimiento(@RequestBody Movimiento movimiento) {
        return movimientoService.createMovimiento(movimiento);
    }

    @PostMapping("/crear-con-detalles")
    public ResponseEntity<String> createMovimientoWithDetalles(@RequestBody Movimiento movimiento) {
        Movimiento nuevoMovimiento = movimientoService.createMovimientoWithDetalles(movimiento);

        if (nuevoMovimiento != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Movimiento y detalles correctamente registrados");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al registrar el movimiento y detalles");
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Movimiento> updateMovimiento(@PathVariable Long id, @RequestBody Movimiento movimiento) {
        Movimiento updatedMovimiento = movimientoService.updateMovimiento(id, movimiento);
        if (updatedMovimiento != null) {
            return ResponseEntity.ok(updatedMovimiento);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovimiento(@PathVariable Long id) {
        movimientoService.deleteMovimiento(id);
        return ResponseEntity.noContent().build();
    }
}