package com.example.proyectogestiondeprestamos.viewmodels;


import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.proyectogestiondeprestamos.basedatos.BaseDeDatos;
import com.example.proyectogestiondeprestamos.entidades.Persona;
import java.util.List;

public class PersonaViewModel extends AndroidViewModel {
    private LiveData<List<Persona>> todasPersonas;
    private BaseDeDatos db;

    public PersonaViewModel(Application application) {
        super(application);
        db = BaseDeDatos.getInstancia(application);
        todasPersonas = db.personaDao().obtenerTodos();
    }

    public LiveData<List<Persona>> getTodasPersonas() {
        return todasPersonas;
    }

    public void insertar(Persona persona) {
        BaseDeDatos.executorEscritura.execute(() -> db.personaDao().insertar(persona));
    }

    public void actualizar(Persona persona) {
        BaseDeDatos.executorEscritura.execute(() -> db.personaDao().actualizar(persona));
    }

    public void eliminar(Persona persona) {
        BaseDeDatos.executorEscritura.execute(() -> db.personaDao().eliminar(persona));
    }
}
