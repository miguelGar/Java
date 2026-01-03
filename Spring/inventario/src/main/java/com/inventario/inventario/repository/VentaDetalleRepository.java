package com.inventario.inventario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.inventario.inventario.dto.DetalleVentaDTO;
import com.inventario.inventario.model.VentaDetalle;

public interface VentaDetalleRepository extends JpaRepository<VentaDetalle, Long>{

    @Query("""
    SELECT new com.inventario.inventario.dto.DetalleVentaDTO(
        vd.id, 
        p.sku, 
        p.nombre, 
        vd.cantidad, 
        vd.precio, 
        vd.subtotal
    )
    FROM VentaDetalle vd
    JOIN vd.producto p
    WHERE vd.venta.id = :ventaId
    ORDER BY vd.id ASC
    """)
    List<DetalleVentaDTO> findByVentaIdOrderByidAsc(Long venta);

}
