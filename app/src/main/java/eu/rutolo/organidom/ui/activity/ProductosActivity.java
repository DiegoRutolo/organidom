package eu.rutolo.organidom.ui.activity;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import eu.rutolo.organidom.Keys;
import eu.rutolo.organidom.R;
import eu.rutolo.organidom.data.dto.Producto;
import eu.rutolo.organidom.ui.recyclerview.ProductoListAdapter;
import eu.rutolo.organidom.ui.viewmodel.ProductoViewModel;

public class ProductosActivity extends AppCompatActivity {

	private ProductoViewModel productoViewModel;

	ActivityResultLauncher<Intent> crearProducto = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
		@Override
		public void onActivityResult(ActivityResult result) {
			if (result.getResultCode() == RESULT_OK) {
				assert result.getData() != null;
				Producto p = (Producto) result.getData().getSerializableExtra(Keys.EXTRA_REPLY_PRODUCTO);
				productoViewModel.insert(p);
			} else {
				Toast.makeText(getApplicationContext(), R.string.not_saved, Toast.LENGTH_SHORT).show();
			}
		}
	});

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_productos);

		RecyclerView rv = findViewById(R.id.rvProductos);
		final ProductoListAdapter adapter = new ProductoListAdapter(new ProductoListAdapter.ProductoDiff());
		rv.setAdapter(adapter);
		rv.setLayoutManager(new LinearLayoutManager(this));

		productoViewModel = new ViewModelProvider(this).get(ProductoViewModel.class);
		productoViewModel.getAllProductos().observe(this, adapter::submitList);

		FloatingActionButton fab = findViewById(R.id.btnAddProducto);
		fab.setOnClickListener(view -> {
			Intent i = new Intent(ProductosActivity.this, EditProductoActivity.class);
			crearProducto.launch(i);
		});
	}
}