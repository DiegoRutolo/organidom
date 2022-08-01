package eu.rutolo.organidom;

public class Keys {

	// Activity request codes
	public static final int NEW_PRODUCTO_RC = 1;

	// TipoCantidad
	public static final String TC_NADA = "";
	public static final String TC_G = "g";
	public static final String TC_KG = "Kg";
	public static final String TC_UDS= "Uds.";
	public static final String TC_PAQ= "Paq.";

	// Mensajes de intent
	public static final String EXTRA_PRODUCTO = "eu.rutolo.organidom.PRODUCTO";
	public static final String EXTRA_PRODUCTO_CREATE = "eu.rutolo.organidom.PRODUCTO_CREATE";
	public static final String EXTRA_PRODUCTO_ID = "eu.rutolo.organidom.PRODUCTO_ID";

	// Mensajes de log
	public static final String LOG = "Organidom";
	public static final String LOG_DB = LOG + "_BaseDeDatos";
	public static final String LOG_UI = LOG + "_InterfazDeUsuario";
}
