package eu.rutolo.organidom.ui.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import eu.rutolo.organidom.R;
import eu.rutolo.organidom.data.dto.Producto;

public class ProductoViewHolder extends RecyclerView.ViewHolder {

	private TextView tvNombre;

	public ProductoViewHolder(@NonNull View itemView) {
		super(itemView);
		tvNombre = itemView.findViewById(R.id.tvNombreProducto);
	}

	public void bind(Producto p) {
		tvNombre.setText(p.getNombre());
	}

	static ProductoViewHolder create(ViewGroup parent) {
		View v = LayoutInflater.from(parent.getContext())
				.inflate(R.layout.producto_item, parent, false);
		return new ProductoViewHolder(v);
	}
}
