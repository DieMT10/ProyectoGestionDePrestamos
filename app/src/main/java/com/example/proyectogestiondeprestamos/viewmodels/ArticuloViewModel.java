package com.example.proyectogestiondeprestamos.viewmodels;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.proyectogestiondeprestamos.basedatos.BaseDeDatos;
import com.example.proyectogestiondeprestamos.entidades.Articulo;
import java.util.List;

public class ArticuloViewModel extends AndroidViewModel {
    private LiveData<List<Articulo>> todosArticulos;
    private BaseDeDatos db;

    public ArticuloViewModel(Application application) {
        super(application);
        db = BaseDeDatos.getInstancia(application);
        todosArticulos = db.articuloDao().obtenerTodos();
    }

    public LiveData<List<Articulo>> getTodosArticulos() {
        return todosArticulos;
    }

    public void insertar(Articulo articulo) {
        BaseDeDatos.executorEscritura.execute(() -> db.articuloDao().insertar(articulo));
    }

    public void actualizar(Articulo articulo) {
        BaseDeDatos.executorEscritura.execute(() -> db.articuloDao().actualizar(articulo));
    }

    public void eliminar(Articulo articulo) {
        BaseDeDatos.executorEscritura.execute(() -> db.articuloDao().eliminar(articulo));
    }
}