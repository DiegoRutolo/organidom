package eu.rutolo.organidom.ui.recyclerview;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import eu.rutolo.organidom.data.dto.Producto;

public class ProductoListAdapter extends ListAdapter<Producto, ProductoViewHolder> {

	private final View.OnClickListener listener;

	public ProductoListAdapter(View.OnClickListener listener) {
		super(new ProductoDiff());
		this.listener = listener;
	}

	@NonNull
	@Override
	public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		return ProductoViewHolder.create(parent);
	}

	@Override
	public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {
		holder.bind(getItem(position), listener);
	}

	public static class ProductoDiff extends DiffUtil.ItemCallback<Producto> {

		@Override
		public boolean areItemsTheSame(@NonNull Producto oldItem, @NonNull Producto newItem) {
			return oldItem.getId() == newItem.getId();
		}

		@Override
		public boolean areContentsTheSame(@NonNull Producto oldItem, @NonNull Producto newItem) {
			boolean cambio = !oldItem.getNombre().contentEquals(newItem.getNombre());

			if (oldItem.getNumCantidad() != newItem.getNumCantidad())
				cambio = true;

			if (oldItem.isComprar() != newItem.isComprar())
				cambio = true;

			return !cambio;
		}
	}
}
