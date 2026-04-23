package com.example.proyectogestiondeprestamos.adaptadores;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.proyectogestiondeprestamos.R;
import com.example.proyectogestiondeprestamos.entidades.Prestamo;
import com.example.proyectogestiondeprestamos.entidades.PrestamoConDetalles;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PrestamoActivoAdaptador extends RecyclerView.Adapter<PrestamoActivoAdaptador.ViewHolder> {
    private List<PrestamoConDetalles> prestamos = new ArrayList<>();
    private OnDevolverClickListener devolverListener;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_prestamo_activo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PrestamoConDetalles item = prestamos.get(position);
        holder.tvArticulo.setText(item.nombreArticulo);
        holder.tvPersona.setText(item.nombrePersona);
        holder.tvFechaPrestamo.setText(sdf.format(item.prestamo.getFechaPrestamo()));
        holder.tvFechaEstimada.setText(sdf.format(item.prestamo.getFechaDevolucionEstimada()));
        holder.btnDevolver.setOnClickListener(v -> {
            if (devolverListener != null) devolverListener.onDevolverClick(item.prestamo);
        });
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
        TextView tvArticulo, tvPersona, tvFechaPrestamo, tvFechaEstimada;
        Button btnDevolver;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvArticulo = itemView.findViewById(R.id.tv_articulo_prestamo);
            tvPersona = itemView.findViewById(R.id.tv_persona_prestamo);
            tvFechaPrestamo = itemView.findViewById(R.id.tv_fecha_prestamo);
            tvFechaEstimada = itemView.findViewById(R.id.tv_fecha_estimada);
            btnDevolver = itemView.findViewById(R.id.btn_devolver);
        }
    }

    public interface OnDevolverClickListener {
        void onDevolverClick(Prestamo prestamo);
    }
    public void setOnDevolverClickListener(OnDevolverClickListener listener) {
        this.devolverListener = listener;
    }
}
