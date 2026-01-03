package com.inventario.inventario.dto;

import java.math.BigDecimal;

public class DetalleVentaDTO {
    private Long detalleId;
    private String sku;
    private String nombre;
    private Integer cantidad;
    private BigDecimal precio;
    private BigDecimal subtotal;

       public DetalleVentaDTO(Long detalleId, String sku, String nombre, Integer cantidad, BigDecimal precio, BigDecimal subtotal) {
        this.detalleId = detalleId;
        this.sku = sku;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subtotal = subtotal;
    }

       public Long getDetalleId() {
           return detalleId;
       }

       public String getSku() {
           return sku;
       }

       public String getNombre() {
           return nombre;
       }

       public Integer getCantidad() {
           return cantidad;
       }

       public BigDecimal getPrecio() {
           return precio;
       }

       public BigDecimal getSubtotal() {
           return subtotal;
       }

    

}
