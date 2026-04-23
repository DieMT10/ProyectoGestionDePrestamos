package com.example.proyectogestiondeprestamos.daos;

import androidx.lifecycle.LiveData;
import androidx.room.*;
import com.example.proyectogestiondeprestamos.entidades.Articulo;
import java.util.List;

@Dao
public interface ArticuloDao {
    @Insert
    void insertar(Articulo articulo);

    @Update
    void actualizar(Articulo articulo);

    @Delete
    void eliminar(Articulo articulo);

    @Query("SELECT * FROM articulos ORDER BY nombre ASC")
    LiveData<List<Articulo>> obtenerTodos();

    @Query("SELECT * FROM articulos WHERE id = :id")
    LiveData<Articulo> obtenerPorId(int id);
}
