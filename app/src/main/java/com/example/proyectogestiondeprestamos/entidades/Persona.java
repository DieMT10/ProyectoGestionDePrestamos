package com.example.proyectogestiondeprestamos.entidades;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "personas")
public class Persona {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String nombre;
    private String numeroContacto;

    public Persona(String nombre, String numeroContacto) {
        this.nombre = nombre;
        this.numeroContacto = numeroContacto;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getNumeroContacto() { return numeroContacto; }
    public void setNumeroContacto(String numeroContacto) { this.numeroContacto = numeroContacto; }
}
