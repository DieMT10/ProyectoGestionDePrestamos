package com.example.proyectogestiondeprestamos.basedatos;

import androidx.room.TypeConverter;
import java.util.Date;

public class Convertidores {
    @TypeConverter
    public static Date desdeTimestamp(Long valor) {
        return valor == null ? null : new Date(valor);
    }

    @TypeConverter
    public static Long fechaATimestamp(Date fecha) {
        return fecha == null ? null : fecha.getTime();
    }
}
