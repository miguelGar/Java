package com.inventario.inventario.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sku;
    private String nombre;
    private String categoria;
    private String subcategoria;
    private BigDecimal precioCompra;
    private BigDecimal precioVenta;
    private Integer cantidad;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getSku() {
        return sku;
    }
    public void setSku(String sku) {
        this.sku = sku;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public String getSubcategoria() {
        return subcategoria;
    }
    public void setSubcategoria(String subcategoria) {
        this.subcategoria = subcategoria;
    }
    public BigDecimal getPrecioCompra() {
        return precioCompra;
    }
    public void setPrecioCompra(BigDecimal precioCompra) {
        this.precioCompra = precioCompra;
    }
    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }
    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }
    public Integer getCantidad() {
        return cantidad;
    }
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    private String color;
    private String marca;
    private String descripcion;

}
