package es.ejemplo.android.litmind.adapter;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import es.ejemplo.android.litmind.R;
import es.ejemplo.android.litmind.model.Usuario;

/**
 * Adaptador para el RecyclerView de la lista de usuarios en el panel admin.
 * Cada item muestra el avatar (iniciales), nombre, email, rol y nivel.
 * Expone una interfaz para notificar clics de editar y eliminar.
 */
public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioAdapter.UsuarioViewHolder> {

    /** Interfaz que debe implementar la Activity para recibir los eventos */
    public interface OnUsuarioClickListener {
        void onEditarClick(Usuario usuario);
        void onEliminarClick(Usuario usuario);
    }

    private List<Usuario> usuarios = new ArrayList<>();
    private final OnUsuarioClickListener listener;

    public UsuarioAdapter(OnUsuarioClickListener listener) {
        this.listener = listener;
    }

    /** Actualiza la lista y notifica al RecyclerView para que redibuje */
    public void setUsuarios(List<Usuario> nuevos) {
        this.usuarios = nuevos;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_usuario, parent, false);
        return new UsuarioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioViewHolder holder, int position) {
        holder.bind(usuarios.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return usuarios.size();
    }

    // ---- ViewHolder ----

    public static class UsuarioViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvIniciales;
        private final TextView tvNombre;
        private final TextView tvEmail;
        private final TextView tvRol;
        private final TextView tvNivel;
        private final Button   btnEditar;
        private final Button   btnEliminar;

        public UsuarioViewHolder(@NonNull View itemView) {
            super(itemView);
            tvIniciales = itemView.findViewById(R.id.tvIniciales);
            tvNombre    = itemView.findViewById(R.id.tvNombreUsuario);
            tvEmail     = itemView.findViewById(R.id.tvEmailUsuario);
            tvRol       = itemView.findViewById(R.id.tvRolUsuario);
            tvNivel     = itemView.findViewById(R.id.tvNivelUsuario);
            btnEditar   = itemView.findViewById(R.id.btnEditarUsuario);
            btnEliminar = itemView.findViewById(R.id.btnEliminarUsuario);
        }

        /**
         * Rellena los campos del item con los datos del usuario.
         * Asigna colores distintos al badge según el rol.
         */
        public void bind(Usuario usuario, OnUsuarioClickListener listener) {
            tvIniciales.setText(usuario.getIniciales());
            tvNombre.setText(usuario.getNombre());
            tvEmail.setText(usuario.getEmail());
            tvRol.setText(usuario.getRolLabel());
            tvNivel.setText(usuario.getNivelLabel());

            // Color del badge de rol según el tipo
            int colorRol;
            switch (usuario.getRol()) {
                case DOCENTE: colorRol = Color.parseColor("#7C3AED"); break; // violeta
                case PADRE:   colorRol = Color.parseColor("#0369A1"); break; // azul
                default:      colorRol = Color.parseColor("#166534"); break; // verde (estudiante)
            }
            tvRol.setBackgroundTintList(ColorStateList.valueOf(colorRol));

            // Color del badge de nivel
            int colorNivel;
            switch (usuario.getNivel()) {
                case AVANZADO:   colorNivel = Color.parseColor("#B91C1C"); break; // rojo
                case INTERMEDIO: colorNivel = Color.parseColor("#92400E"); break; // naranja
                default:         colorNivel = Color.parseColor("#166534"); break; // verde
            }
            tvNivel.setBackgroundTintList(ColorStateList.valueOf(colorNivel));

            // Color de fondo del avatar (basado en el primer carácter del nombre)
            int colorAvatar = obtenerColorAvatar(usuario.getNombre());
            tvIniciales.setBackgroundTintList(ColorStateList.valueOf(colorAvatar));

            // Listeners de los botones
            btnEditar.setOnClickListener(v -> listener.onEditarClick(usuario));
            btnEliminar.setOnClickListener(v -> listener.onEliminarClick(usuario));
        }

        /**
         * Devuelve un color pastel para el avatar basado en el nombre.
         * Así cada usuario tiene siempre el mismo color.
         */
        private int obtenerColorAvatar(String nombre) {
            int[] colores = {
                    Color.parseColor("#C084FC"), // morado
                    Color.parseColor("#60A5FA"), // azul
                    Color.parseColor("#4ADE80"), // verde
                    Color.parseColor("#FB923C"), // naranja
                    Color.parseColor("#F472B6"), // rosa
                    Color.parseColor("#A78BFA"), // violeta claro
            };
            int indice = Math.abs(nombre.hashCode()) % colores.length;
            return colores[indice];
        }
    }
}
