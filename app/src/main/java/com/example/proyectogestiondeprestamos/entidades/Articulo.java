package com.example.proyectogestiondeprestamos.entidades;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "articulos")
public class Articulo {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String nombre;
    private String descripcion;
    private String categoria;

    public Articulo(String nombre, String descripcion, String categoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
}