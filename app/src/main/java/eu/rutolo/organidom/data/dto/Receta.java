package eu.rutolo.organidom.data.dto;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Calendar;

@Entity
public class Receta implements Serializable {
	@PrimaryKey(autoGenerate = true)
	private long id;
	private String nombre;
	private String imgPath;
	private int puntuacion;
//	private Calendar ultimaVez;
	private int veces;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

//	public Calendar getUltimaVez() {
//		return ultimaVez;
//	}
//
//	public void setUltimaVez(Calendar ultimaVez) {
//		this.ultimaVez = ultimaVez;
//	}

	public int getVeces() {
		return veces;
	}

	public void setVeces(int veces) {
		this.veces = veces;
	}

	@Override
	public String toString() {
		return "Receta{" +
				"id=" + id +
				", nombre='" + nombre + '\'' +
				'}';
	}
}
