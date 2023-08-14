package com.gnencisom.testswisslub.repositories;

import com.gnencisom.testswisslub.models.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {
    List<Movimiento> findByEstado(String estado);

    @Override
    <S extends Movimiento> S save(S entity);
}
