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

	public void cambiaLoginTabla () {
		miLogin.setVisible(false);
		miVista.setVisible(true);
	}
	
	public void Login() {
		miModelo.peticionLogin(miLogin.getUsr(),miLogin.getPwd());
	}
}
