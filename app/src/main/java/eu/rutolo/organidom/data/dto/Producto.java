package eu.rutolo.organidom.data.dto;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Producto implements Serializable {

	@PrimaryKey(autoGenerate = true)
	private long id;

	private String nombre;
	private int numCantidad;
	private String tipoCantidad;
	private boolean comprar;

	public Producto(String nombre) {
		this.nombre = nombre;
	}

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

	public int getNumCantidad() {
		return numCantidad;
	}

	public void setNumCantidad(int numCantidad) {
		this.numCantidad = numCantidad;
	}

	public String getTipoCantidad() {
		return tipoCantidad;
	}

	public void setTipoCantidad(String tipoCantidad) {
		this.tipoCantidad = tipoCantidad;
	}

	public boolean isComprar() {
		return comprar;
	}

	public void setComprar(boolean comprar) {
		this.comprar = comprar;
	}

	@Override
	public String toString() {
		return "Producto{" +
				"id=" + id +
				", nombre='" + nombre + '\'' +
				'}';
	}
}
