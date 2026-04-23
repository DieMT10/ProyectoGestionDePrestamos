package com.example.proyectogestiondeprestamos.daos;


import androidx.lifecycle.LiveData;
import androidx.room.*;
import com.example.proyectogestiondeprestamos.entidades.Persona;
import java.util.List;

@Dao
public interface PersonaDao {
    @Insert
    void insertar(Persona persona);

    @Update
    void actualizar(Persona persona);

    @Delete
    void eliminar(Persona persona);

    @Query("SELECT * FROM personas ORDER BY nombre ASC")
    LiveData<List<Persona>> obtenerTodos();

    @Query("SELECT * FROM personas WHERE id = :id")
    LiveData<Persona> obtenerPorId(int id);
}
