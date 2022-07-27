package eu.rutolo.organidom.ui.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import eu.rutolo.organidom.data.OrganidomDB;
import eu.rutolo.organidom.data.dao.ProductoDao;
import eu.rutolo.organidom.data.dto.Producto;

public class ProductoViewModel extends AndroidViewModel {

	private ProductoDao productoDao;

	private final LiveData<List<Producto>> productos;

	public ProductoViewModel(@NonNull Application application) {
		super(application);
		OrganidomDB db = OrganidomDB.getInstance(application);
		productoDao = db.productoDao();
		productos = productoDao.findAll();
	}

	public LiveData<List<Producto>> getAllProductos() {
		return productos;
	}

	public void insert(Producto p) {
		OrganidomDB.dbWriteExecutor.execute(() -> {
			productoDao.insert(p);
			//TODO: loggear esto
		});
	}
}
