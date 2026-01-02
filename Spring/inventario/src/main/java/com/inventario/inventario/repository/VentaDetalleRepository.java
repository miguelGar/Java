package com.inventario.inventario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventario.inventario.model.VentaDetalle;

public interface VentaDetalleRepository extends JpaRepository<VentaDetalle, Long>{

    List<VentaDetalle> findByVentaIdOrderByidAsc(Long ventaId);

}
