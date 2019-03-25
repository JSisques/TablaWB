package Modelo;
import javax.swing.table.DefaultTableModel;

import Vista.Login;
import Vista.Tabla;

public class Modelo {
	private Tabla miVista;	
	private Login miLogin;
	private DefaultTableModel miTabla;
	
	public Modelo () {
		miTabla = new DefaultTableModel(
				new String[][] { { "Javier Fernández", "123456789" }, { "Santiago López", "987654321" }, },
				new String[] { "Nombre", "Teléfono" });
	}
	
	public void setVista(Tabla miVista) {
		this.miVista=miVista;
	}
	
	public void setLogin(Login miLogin) {
		this.miLogin=miLogin;
	}
	
	public DefaultTableModel getTabla () {
		return miTabla;
	}



}
