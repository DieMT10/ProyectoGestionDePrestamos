package com.example.proyectogestiondeprestamos.basedatos;



import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import com.example.proyectogestiondeprestamos.daos.ArticuloDao;
import com.example.proyectogestiondeprestamos.daos.PersonaDao;
import com.example.proyectogestiondeprestamos.daos.PrestamoDao;
import com.example.proyectogestiondeprestamos.entidades.Articulo;
import com.example.proyectogestiondeprestamos.entidades.Persona;
import com.example.proyectogestiondeprestamos.entidades.Prestamo;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Articulo.class, Persona.class, Prestamo.class}, version = 1, exportSchema = false)
@TypeConverters({Convertidores.class})
public abstract class BaseDeDatos extends RoomDatabase {
    public abstract ArticuloDao articuloDao();
    public abstract PersonaDao personaDao();
    public abstract PrestamoDao prestamoDao();

    private static volatile BaseDeDatos INSTANCIA;
    public static final ExecutorService executorEscritura = Executors.newFixedThreadPool(4);

    public static BaseDeDatos getInstancia(Context context) {
        if (INSTANCIA == null) {
            synchronized (BaseDeDatos.class) {
                if (INSTANCIA == null) {
                    INSTANCIA = Room.databaseBuilder(context.getApplicationContext(),
                                    BaseDeDatos.class, "gestor_prestamos.db")
                            .build();
                }
            }
        }
        return INSTANCIA;
    }
}
