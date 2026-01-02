package com.inventario.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.inventario.inventario.model.Venta;

public interface VentaRepository extends JpaRepository<Venta, Long> {

}
