package com.example.proyectogestiondeprestamos.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.proyectogestiondeprestamos.R;
import com.example.proyectogestiondeprestamos.entidades.PrestamoConDetalles;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PrestamoHistorialAdaptador extends RecyclerView.Adapter<PrestamoHistorialAdaptador.ViewHolder> {
    private List<PrestamoConDetalles> prestamos = new ArrayList<>();
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_prestamo_historial, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PrestamoConDetalles item = prestamos.get(position);
        holder.tvArticulo.setText(item.nombreArticulo);
        holder.tvPersona.setText(item.nombrePersona);
        holder.tvFechaPrestamo.setText(sdf.format(item.prestamo.getFechaPrestamo()));
        holder.tvFechaEstimada.setText(sdf.format(item.prestamo.getFechaDevolucionEstimada()));
        holder.tvFechaReal.setText(sdf.format(item.prestamo.getFechaDevolucionReal()));
    }

    @Override
    public int getItemCount() {
        return prestamos.size();
    }

    public void setPrestamos(List<PrestamoConDetalles> prestamos) {
        this.prestamos = prestamos;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvArticulo, tvPersona, tvFechaPrestamo, tvFechaEstimada, tvFechaReal;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvArticulo = itemView.findViewById(R.id.tv_articulo_historial);
            tvPersona = itemView.findViewById(R.id.tv_persona_historial);
            tvFechaPrestamo = itemView.findViewById(R.id.tv_fecha_prestamo_historial);
            tvFechaEstimada = itemView.findViewById(R.id.tv_fecha_estimada_historial);
            tvFechaReal = itemView.findViewById(R.id.tv_fecha_real_historial);
        }
    }
}
