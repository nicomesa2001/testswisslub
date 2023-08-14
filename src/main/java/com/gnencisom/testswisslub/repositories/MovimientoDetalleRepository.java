package com.gnencisom.testswisslub.repositories;

import com.gnencisom.testswisslub.models.Movimiento;
import com.gnencisom.testswisslub.models.MovimientoDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovimientoDetalleRepository extends JpaRepository<MovimientoDetalle, Long> {
    List<MovimientoDetalle> findByMovimientoId(Long movimientoId);
}