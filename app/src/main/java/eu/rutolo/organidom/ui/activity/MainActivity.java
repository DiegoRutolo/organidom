package eu.rutolo.organidom.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import eu.rutolo.organidom.R;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button btnProductos = findViewById(R.id.btnProductos);
		btnProductos.setOnClickListener(view -> {
			Intent i = new Intent(this, ProductosActivity.class);
			startActivity(i);
		});
	}
}