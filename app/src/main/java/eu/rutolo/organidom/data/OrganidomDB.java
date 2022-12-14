package eu.rutolo.organidom.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import eu.rutolo.organidom.data.dao.ProductoDao;
import eu.rutolo.organidom.data.dao.RecetaDao;
import eu.rutolo.organidom.data.dto.Producto;
import eu.rutolo.organidom.data.dto.Receta;

@Database(entities = {
		Producto.class,
		Receta.class
}, version = 2)
public abstract class OrganidomDB extends RoomDatabase {
	// Exponer DAOs
	public abstract ProductoDao productoDao();
	public abstract RecetaDao recetaDato();

	private static final int MAX_THREADS = 4;
	public static final ExecutorService dbWriteExecutor = Executors.newFixedThreadPool(MAX_THREADS);

	// Singleton
	private static volatile OrganidomDB INST;
	public static OrganidomDB getInstance(final Context ctx) {
		if (INST == null) {
			synchronized (OrganidomDB.class) {
				if (INST == null) {
					INST = Room.databaseBuilder(ctx.getApplicationContext(), OrganidomDB.class, "organidom_db")
							.build();
				}
			}
		}
		return INST;
	}

}
