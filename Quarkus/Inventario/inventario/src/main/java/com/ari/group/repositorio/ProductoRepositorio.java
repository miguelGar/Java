package com.ari.group.repositorio;

import jakarta.enterprise.context.ApplicationScoped;

import com.ari.group.modelo.Producto;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class ProductoRepositorio implements PanacheRepository<Producto> {
    // You can add custom methods here, Panache provides basic CRUD operations automatically.
}
