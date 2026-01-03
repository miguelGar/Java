package com.inventario.inventario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventario.inventario.dto.DetalleVentaDTO;
import com.inventario.inventario.model.VentaDetalle;
import com.inventario.inventario.repository.VentaDetalleRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api")
public class VentaDetalleController {

    @Autowired
    private VentaDetalleRepository ventaDetalleRepo;

    @GetMapping("/ventas-detalle/{id}")
    public ResponseEntity<List<DetalleVentaDTO>> getDetallesVenta(@PathVariable Long id) {
        List<DetalleVentaDTO> detalles = ventaDetalleRepo.findByVentaIdOrderByidAsc(id);
        return ResponseEntity.ok(detalles);
    }
    
    
}
