package eu.rutolo.organidom.ui.viewmodel;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import eu.rutolo.organidom.Keys;
import eu.rutolo.organidom.data.OrganidomDB;
import eu.rutolo.organidom.data.dao.ProductoDao;
import eu.rutolo.organidom.data.dto.Producto;

public class ProductoViewModel extends AndroidViewModel {

	private final ProductoDao productoDao;
	private Producto producto;

	public ProductoViewModel(@NonNull Application application) {
		super(application);
		OrganidomDB db = OrganidomDB.getInstance(application);
		productoDao = db.productoDao();
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto p) {
		this.producto = p;
	}

	public void insert(Producto p) {
		setProducto(p);
		insert();
	}

	public void insert() {
		OrganidomDB.dbWriteExecutor.execute(() -> {
			productoDao.insert(producto);
			Log.d(Keys.LOG_DB, "Insertado " + producto);
		});
	}

	public void update(Producto p) {
		setProducto(p);
		update();
	}

	public void update() {
		OrganidomDB.dbWriteExecutor.execute(() -> {
			productoDao.update(producto);
			Log.d(Keys.LOG_DB, "Actualizado " + producto);
		});
	}

	public void delete(Producto p) {
		setProducto(p);
		delete();
	}

	public void delete() {
		OrganidomDB.dbWriteExecutor.execute(() -> {
			productoDao.delete(producto);
			Log.d(Keys.LOG_DB, "Eliminado " + producto);
		});
	}

}
