package eu.rutolo.organidom;

import org.junit.Assert;
import org.junit.Test;

import eu.rutolo.organidom.data.dto.Producto;
import eu.rutolo.organidom.ui.recyclerview.ProductoListAdapter;

public class ProductoDiffTest {

	@Test
	public void sameItems() {
		ProductoListAdapter.ProductoDiff diff = new ProductoListAdapter.ProductoDiff();

		Producto p1 = new Producto("Patatas");
		p1.setId(1);
		p1.setNumCantidad(3);
		p1.setTipoCantidad("Kg");
		p1.setComprar(false);

		Producto p2 = new Producto("Patatas");
		p2.setId(1);
		p2.setNumCantidad(3);
		p2.setTipoCantidad("Kg");
		p2.setComprar(false);

		Producto p3 = new Producto("Zanahorias");
		p3.setId(2);
		p3.setNumCantidad(1);
		p3.setTipoCantidad("Kg");
		p3.setComprar(false);

		Assert.assertTrue("Son el mismo objeto", diff.areItemsTheSame(p1, p2));
		Assert.assertFalse("No son el mismo objeto", diff.areItemsTheSame(p1, p3));
	}

	@Test
	public void sameContent() {
		ProductoListAdapter.ProductoDiff diff = new ProductoListAdapter.ProductoDiff();

		Producto p1 = new Producto("Patatas");
		p1.setId(1);
		p1.setNumCantidad(3);
		p1.setTipoCantidad("Kg");
		p1.setComprar(false);

		Producto p2 = new Producto("Patatas");
		p2.setId(2);
		p2.setNumCantidad(3);
		p2.setTipoCantidad("Kg");
		p2.setComprar(false);

		Producto p3 = new Producto("Zanahorias");
		p3.setId(2);
		p3.setNumCantidad(1);
		p3.setTipoCantidad("Kg");
		p3.setComprar(false);

		Assert.assertTrue("El contenido es igual", diff.areContentsTheSame(p1, p2));
		Assert.assertFalse("El contenido es distinto", diff.areContentsTheSame(p1, p3));
	}
}
