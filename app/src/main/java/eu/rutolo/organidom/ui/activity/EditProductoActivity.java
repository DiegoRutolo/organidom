package eu.rutolo.organidom.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.concurrent.atomic.AtomicReference;

import eu.rutolo.organidom.Keys;
import eu.rutolo.organidom.R;
import eu.rutolo.organidom.data.dto.Producto;
import eu.rutolo.organidom.ui.viewmodel.ProductoViewModel;

public class EditProductoActivity extends AppCompatActivity {

	private ProductoViewModel productoViewModel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_producto);

		productoViewModel = new ViewModelProvider(this).get(ProductoViewModel.class);
		boolean nuevo = getIntent().getBooleanExtra(Keys.EXTRA_PRODUCTO_CREATE, true);
		AtomicReference<Producto> producto = new AtomicReference<>();
		if (!nuevo) {
			Producto p = (Producto) getIntent().getSerializableExtra(Keys.EXTRA_PRODUCTO);
			producto.set(p);
			productoViewModel.setProducto(producto.get());
		}

		final EditText iNombre = findViewById(R.id.iNombreProducto);
		final EditText iCantNum = findViewById(R.id.iCantidadNumProd);
		final EditText iCantTipo = findViewById(R.id.iCantidadTipoProd);
		final CheckBox iComprar = findViewById(R.id.iComprar);

		final ImageButton btnCancel = findViewById(R.id.btnCancel);
		btnCancel.setOnClickListener(view -> {
			finish();
		});

		final ImageButton btnDelete = findViewById(R.id.btnDeleteProducto);
		if (nuevo) {
			btnDelete.setEnabled(false);
			btnDelete.setBackgroundColor(getResources().getColor(R.color.btn_rojo_disabled));
		} else {
			btnDelete.setOnClickListener(view -> {
				productoViewModel.delete(producto.get());
				finish();
			});
		}

		final ImageButton btnSave = findViewById(R.id.btnSaveProducto);
		btnSave.setOnClickListener(view -> {
			if (TextUtils.isEmpty(iNombre.getText())) {
				Toast.makeText(getApplicationContext(), R.string.not_saved, Toast.LENGTH_SHORT).show();
			} else {
				if (nuevo) {
					producto.set(new Producto());
				}
				producto.get().setNombre(iNombre.getText().toString());
				producto.get().setNumCantidad(Integer.parseInt(iCantNum.getText().toString()));
				producto.get().setTipoCantidad(iCantTipo.getText().toString());
				producto.get().setComprar(iComprar.isChecked());

				if (nuevo) {
					productoViewModel.insert(producto.get());
				} else {
					productoViewModel.update(producto.get());
				}

				finish();
			}
		});

		if (!nuevo) {
			iNombre.setText(producto.get().getNombre());
			iCantNum.setText(Long.toString(producto.get().getNumCantidad()));
			iCantTipo.setText(producto.get().getTipoCantidad());
			iComprar.setChecked(producto.get().isComprar());
		}
	}
}