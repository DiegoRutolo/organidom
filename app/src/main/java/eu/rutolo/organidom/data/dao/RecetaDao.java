package eu.rutolo.organidom.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import eu.rutolo.organidom.data.dto.Receta;

@Dao
public interface RecetaDao {

	@Insert
	void insert(Receta receta);

	@Update
	void update(Receta receta);

	@Delete
	void delete(Receta receta);

	@Query("SELECT * " +
			"FROM Receta r ")
	LiveData<List<Receta>> findAll();

}
