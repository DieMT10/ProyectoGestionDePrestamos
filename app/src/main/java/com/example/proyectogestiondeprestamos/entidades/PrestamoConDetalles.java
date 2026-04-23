package com.example.proyectogestiondeprestamos.entidades;

public class PrestamoConDetalles {
    public Prestamo prestamo;
    public String nombreArticulo;
    public String nombrePersona;

    public PrestamoConDetalles(Prestamo prestamo, String nombreArticulo, String nombrePersona) {
        this.prestamo = prestamo;
        this.nombreArticulo = nombreArticulo;
        this.nombrePersona = nombrePersona;
    }
}