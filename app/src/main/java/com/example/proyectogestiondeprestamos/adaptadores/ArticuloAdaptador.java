package com.example.proyectogestiondeprestamos.adaptadores;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.proyectogestiondeprestamos.R;
import com.example.proyectogestiondeprestamos.entidades.Articulo;
import java.util.ArrayList;
import java.util.List;

public class ArticuloAdaptador extends RecyclerView.Adapter<ArticuloAdaptador.ViewHolder> {
    private List<Articulo> articulos = new ArrayList<>();
    private OnItemClickListener listener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_articulo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Articulo actual = articulos.get(position);
        holder.tvNombre.setText(actual.getNombre());
        holder.tvCategoria.setText(actual.getCategoria());
        holder.tvDescripcion.setText(actual.getDescripcion());
    }

    @Override
    public int getItemCount() {
        return articulos.size();
    }

    public void setArticulos(List<Articulo> articulos) {
        this.articulos = articulos;
        notifyDataSetChanged();
    }

    public Articulo getArticuloEnPosicion(int pos) {
        return articulos.get(pos);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombre, tvCategoria, tvDescripcion;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tv_nombre_articulo);
            tvCategoria = itemView.findViewById(R.id.tv_categoria_articulo);
            tvDescripcion = itemView.findViewById(R.id.tv_descripcion_articulo);
            itemView.setOnClickListener(v -> {
                int pos = getAdapterPosition();
                if (listener != null && pos != RecyclerView.NO_POSITION)
                    listener.onItemClick(articulos.get(pos));
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Articulo articulo);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
