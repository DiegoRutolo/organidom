package eu.rutolo.organidom.ui.recyclerview;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import eu.rutolo.organidom.data.dto.Producto;

public class ProductoListAdapter extends ListAdapter<Producto, ProductoViewHolder> {

	public ProductoListAdapter(@NonNull DiffUtil.ItemCallback<Producto> diffCallback) {
		super(diffCallback);
	}

	@NonNull
	@Override
	public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		return ProductoViewHolder.create(parent);
	}

	@Override
	public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {
		holder.bind(getItem(position));
	}

	public static class ProductoDiff extends DiffUtil.ItemCallback<Producto> {

		@Override
		public boolean areItemsTheSame(@NonNull Producto oldItem, @NonNull Producto newItem) {
			return oldItem == newItem;
		}

		@Override
		public boolean areContentsTheSame(@NonNull Producto oldItem, @NonNull Producto newItem) {
			return oldItem.getId() == newItem.getId();
		}
	}
}
