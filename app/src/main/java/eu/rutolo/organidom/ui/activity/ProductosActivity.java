package eu.rutolo.organidom.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Objects;

import eu.rutolo.organidom.Keys;
import eu.rutolo.organidom.R;
import eu.rutolo.organidom.data.dto.Producto;
import eu.rutolo.organidom.ui.recyclerview.ProductoListAdapter;
import eu.rutolo.organidom.ui.viewmodel.ProductosListViewModel;

public class ProductosActivity extends AppCompatActivity implements View.OnClickListener {

	private ProductosListViewModel productosListViewModel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_productos);

		RecyclerView rv = findViewById(R.id.rvProductos);
		final ProductoListAdapter adapter = new ProductoListAdapter(this);
		rv.setAdapter(adapter);
		rv.setLayoutManager(new LinearLayoutManager(this));
		registerForContextMenu(rv);

		productosListViewModel = new ViewModelProvider(this).get(ProductosListViewModel.class);
		productosListViewModel.getAllProductos().observe(this, adapter::submitList);

		FloatingActionButton fab = findViewById(R.id.btnAddProducto);
		fab.setOnClickListener(view -> {
			Intent i = new Intent(ProductosActivity.this, EditProductoActivity.class);
			i.putExtra(Keys.EXTRA_PRODUCTO_CREATE, true);
			startActivity(i);
		});
	}

	@Override
	public void onClick(View view) {
		TextView tvId = view.findViewById(R.id.tvIdProducto);
		Intent i = new Intent(ProductosActivity.this, EditProductoActivity.class);
		i.putExtra(Keys.EXTRA_PRODUCTO_CREATE, false);
		long idProd = Long.parseLong((String) tvId.getText());
		Producto prod = Objects.requireNonNull(productosListViewModel.getAllProductos().getValue()).parallelStream()
				.filter(p -> p.getId() == idProd)
				.findFirst().get();
		i.putExtra(Keys.EXTRA_PRODUCTO, prod);
		startActivity(i);
	}
}