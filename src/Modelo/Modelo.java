package Modelo;
import javax.swing.table.DefaultTableModel;

import Vista.Login;
import Vista.Tabla;

public class Modelo {
	private Tabla miVista;	
	private Login miLogin;
	private DefaultTableModel miTabla;
	private String usr;
	private String pwd;
	private int intentos;
	
	public Modelo () {
		miTabla = new DefaultTableModel(
				new String[][] { { "Javier Fernández", "123456789" }, { "Santiago López", "987654321" }, },
				new String[] { "Nombre", "Teléfono" });
		usr = "Pedro";
		pwd = "123";
		intentos=0;
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

	public void peticionLogin(String usr, String pwd) {
		if (this.usr.equals(usr) && this.pwd.equals(pwd))
			intentos=0;
		else 
			intentos++;
		
		miLogin.actualizaLogin();
	}

	public int getResultadoLogin() {
		return intentos;
	}
}
