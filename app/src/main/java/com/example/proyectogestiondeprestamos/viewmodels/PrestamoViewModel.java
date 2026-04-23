package com.example.proyectogestiondeprestamos.viewmodels;


import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.proyectogestiondeprestamos.basedatos.BaseDeDatos;
import com.example.proyectogestiondeprestamos.entidades.Prestamo;
import com.example.proyectogestiondeprestamos.entidades.PrestamoConDetalles;
import java.util.Date;
import java.util.List;

public class PrestamoViewModel extends AndroidViewModel {
    private BaseDeDatos db;
    private LiveData<List<PrestamoConDetalles>> prestamosActivos;
    private LiveData<List<PrestamoConDetalles>> historialPrestamos;

    public PrestamoViewModel(Application application) {
        super(application);
        db = BaseDeDatos.getInstancia(application);
        prestamosActivos = db.prestamoDao().obtenerActivosConDetalles();
        historialPrestamos = db.prestamoDao().obtenerHistorialConDetalles();
    }

    public LiveData<List<PrestamoConDetalles>> getPrestamosActivos() {
        return prestamosActivos;
    }

    public LiveData<List<PrestamoConDetalles>> getHistorialPrestamos() {
        return historialPrestamos;
    }

    public void insertar(Prestamo prestamo) {
        BaseDeDatos.executorEscritura.execute(() -> db.prestamoDao().insertar(prestamo));
    }

    public void actualizar(Prestamo prestamo) {
        BaseDeDatos.executorEscritura.execute(() -> db.prestamoDao().actualizar(prestamo));
    }

    public void devolverPrestamo(Prestamo prestamo, Date fechaDevolucion) {
        prestamo.setFechaDevolucionReal(fechaDevolucion);
        actualizar(prestamo);
    }

    public LiveData<Prestamo> getPrestamoActivoPorArticulo(int articuloId) {
        return db.prestamoDao().obtenerPrestamoActivoPorArticuloId(articuloId);
    }
}
