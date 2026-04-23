package com.example.proyectogestiondeprestamos.entidades;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.util.Date;

@Entity(tableName = "prestamos")
public class Prestamo {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private int articuloId;
    private int personaId;
    private Date fechaPrestamo;
    private Date fechaDevolucionEstimada;
    private Date fechaDevolucionReal; // null = activo

    public Prestamo(int articuloId, int personaId, Date fechaPrestamo, Date fechaDevolucionEstimada, Date fechaDevolucionReal) {
        this.articuloId = articuloId;
        this.personaId = personaId;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucionEstimada = fechaDevolucionEstimada;
        this.fechaDevolucionReal = fechaDevolucionReal;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getArticuloId() { return articuloId; }
    public void setArticuloId(int articuloId) { this.articuloId = articuloId; }
    public int getPersonaId() { return personaId; }
    public void setPersonaId(int personaId) { this.personaId = personaId; }
    public Date getFechaPrestamo() { return fechaPrestamo; }
    public void setFechaPrestamo(Date fechaPrestamo) { this.fechaPrestamo = fechaPrestamo; }
    public Date getFechaDevolucionEstimada() { return fechaDevolucionEstimada; }
    public void setFechaDevolucionEstimada(Date fechaDevolucionEstimada) { this.fechaDevolucionEstimada = fechaDevolucionEstimada; }
    public Date getFechaDevolucionReal() { return fechaDevolucionReal; }
    public void setFechaDevolucionReal(Date fechaDevolucionReal) { this.fechaDevolucionReal = fechaDevolucionReal; }
}
