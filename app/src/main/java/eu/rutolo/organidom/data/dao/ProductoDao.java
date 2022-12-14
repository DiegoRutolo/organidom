package eu.rutolo.organidom.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import eu.rutolo.organidom.data.dto.Producto;

@Dao
public interface ProductoDao {

	@Insert
	void insert(Producto producto);

	@Update
	void update(Producto producto);

	@Delete
	void delete(Producto producto);

	@Query("SELECT * FROM Producto")
	LiveData<List<Producto>> findAll();

}
