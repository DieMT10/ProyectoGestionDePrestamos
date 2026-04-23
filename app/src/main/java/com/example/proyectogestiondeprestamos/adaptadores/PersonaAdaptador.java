package com.example.proyectogestiondeprestamos.adaptadores;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.proyectogestiondeprestamos.R;
import com.example.proyectogestiondeprestamos.entidades.Persona;
import java.util.ArrayList;
import java.util.List;

public class PersonaAdaptador extends RecyclerView.Adapter<PersonaAdaptador.ViewHolder> {
    private List<Persona> personas = new ArrayList<>();
    private OnEditarClickListener editarListener;
    private OnEliminarClickListener eliminarListener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_persona, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Persona actual = personas.get(position);
        holder.tvNombre.setText(actual.getNombre());
        holder.tvContacto.setText(actual.getNumeroContacto());
        holder.btnEditar.setOnClickListener(v -> {
            if (editarListener != null) editarListener.onEditarClick(actual);
        });
        holder.btnEliminar.setOnClickListener(v -> {
            if (eliminarListener != null) eliminarListener.onEliminarClick(actual);
        });
    }

    @Override
    public int getItemCount() {
        return personas.size();
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombre, tvContacto;
        Button btnEditar, btnEliminar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tv_nombre_persona);
            tvContacto = itemView.findViewById(R.id.tv_contacto_persona);
            btnEditar = itemView.findViewById(R.id.btn_editar_persona);
            btnEliminar = itemView.findViewById(R.id.btn_eliminar_persona);
        }
    }

    public interface OnEditarClickListener {
        void onEditarClick(Persona persona);
    }
    public interface OnEliminarClickListener {
        void onEliminarClick(Persona persona);
    }
    public void setOnEditarClickListener(OnEditarClickListener listener) { this.editarListener = listener; }
    public void setOnEliminarClickListener(OnEliminarClickListener listener) { this.eliminarListener = listener; }
}
