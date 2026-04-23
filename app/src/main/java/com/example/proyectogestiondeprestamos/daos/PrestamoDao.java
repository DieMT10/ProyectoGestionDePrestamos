package com.example.proyectogestiondeprestamos.daos;

import androidx.lifecycle.LiveData;
import androidx.room.*;
import com.example.proyectogestiondeprestamos.entidades.Prestamo;
import com.example.proyectogestiondeprestamos.entidades.PrestamoConDetalles;
import java.util.List;

@Dao
public interface PrestamoDao {
    @Insert
    void insertar(Prestamo prestamo);

    @Update
    void actualizar(Prestamo prestamo);

    @Delete
    void eliminar(Prestamo prestamo);

    @Query("SELECT * FROM prestamos WHERE fechaDevolucionReal IS NULL ORDER BY fechaPrestamo DESC")
    LiveData<List<Prestamo>> obtenerPrestamosActivos();

    @Query("SELECT * FROM prestamos WHERE fechaDevolucionReal IS NOT NULL ORDER BY fechaDevolucionReal DESC")
    LiveData<List<Prestamo>> obtenerHistorial();

    // Con detalles para mostrar en RecyclerView
    @Query("SELECT prestamos.*, articulos.nombre as nombreArticulo, personas.nombre as nombrePersona " +
            "FROM prestamos " +
            "INNER JOIN articulos ON prestamos.articuloId = articulos.id " +
            "INNER JOIN personas ON prestamos.personaId = personas.id " +
            "WHERE prestamos.fechaDevolucionReal IS NULL")
    LiveData<List<PrestamoConDetalles>> obtenerActivosConDetalles();

    @Query("SELECT prestamos.*, articulos.nombre as nombreArticulo, personas.nombre as nombrePersona " +
            "FROM prestamos " +
            "INNER JOIN articulos ON prestamos.articuloId = articulos.id " +
            "INNER JOIN personas ON prestamos.personaId = personas.id " +
            "WHERE prestamos.fechaDevolucionReal IS NOT NULL")
    LiveData<List<PrestamoConDetalles>> obtenerHistorialConDetalles();

    @Query("SELECT * FROM prestamos WHERE articuloId = :articuloId AND fechaDevolucionReal IS NULL")
    LiveData<Prestamo> obtenerPrestamoActivoPorArticuloId(int articuloId);
}
