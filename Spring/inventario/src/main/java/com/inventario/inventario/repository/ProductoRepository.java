package com.inventario.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventario.inventario.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
