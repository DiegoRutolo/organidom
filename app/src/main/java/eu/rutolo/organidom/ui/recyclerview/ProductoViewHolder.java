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

	private final TextView tvId;
	private final TextView tvNombre;

	public ProductoViewHolder(@NonNull View itemView) {
		super(itemView);
		tvId = itemView.findViewById(R.id.tvIdProducto);
		tvNombre = itemView.findViewById(R.id.tvNombreProducto);
	}

	public void bind(Producto p, View.OnClickListener listener) {
		tvId.setText(Long.toString(p.getId()));
		tvNombre.setText(p.getNombre());
		itemView.setOnClickListener(listener);
	}

	static ProductoViewHolder create(ViewGroup parent) {
		View v = LayoutInflater.from(parent.getContext())
				.inflate(R.layout.producto_item, parent, false);
		return new ProductoViewHolder(v);
	}

}
