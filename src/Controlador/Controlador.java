package Controlador;
import Modelo.Modelo;
import Vista.Login;
import Vista.Tabla;

public class Controlador {
	private Modelo miModelo;
	private Tabla miVista;
	private Login miLogin;

	public void setModelo(Modelo miModelo) {
		this.miModelo=miModelo;
	}

	public void setVista(Login miLogin) {
		this.miLogin=miLogin;
	}
	
	public void setVista(Tabla miVista) {
		this.miVista=miVista;
	}

	public void Login() {
		miLogin.setVisible(false);
		miVista.setVisible(true);
	}
}
