package com.ari.group.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Id;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Getter
@Setter
@Entity
public class Producto extends PanacheEntityBase  {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long  ideProducto;
    public String descripcion;
    public Double precio;
    public Integer existencia;

}
