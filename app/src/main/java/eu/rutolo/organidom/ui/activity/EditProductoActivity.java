package eu.rutolo.organidom.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import eu.rutolo.organidom.Keys;
import eu.rutolo.organidom.R;
import eu.rutolo.organidom.data.dto.Producto;

public class EditProductoActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_producto);

		EditText iNombre = findViewById(R.id.iNombreProducto);
		EditText iCantNum = findViewById(R.id.iCantidadNumProd);
		EditText iCantTipo = findViewById(R.id.iCantidadTipoProd);

		final Button btnSave = findViewById(R.id.btnSaveProducto);
		btnSave.setOnClickListener(view -> {
			Intent i = new Intent();
			if (TextUtils.isEmpty(iNombre.getText())) {
				setResult(RESULT_CANCELED, i);
			} else {
				Producto p = new Producto(iNombre.getText().toString());
				p.setNumCantidad(Integer.parseInt(iCantNum.getText().toString()));
				p.setTipoCantidad(iCantTipo.getText().toString());

				i.putExtra(Keys.EXTRA_REPLY_PRODUCTO, p);
				setResult(RESULT_OK, i);
			}
			finish();
		});
	}
}