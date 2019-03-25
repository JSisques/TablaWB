package Controlador;
import Modelo.Modelo;
import Vista.*;

public class Main {
	public static void main(String[] args) {
		//Creación de los objetos
		Controlador miControlador = new Controlador ();
		Modelo miModelo = new Modelo ();
		Tabla miVista = new Tabla ();
		Login miLogin = new Login ();
		
		//Relaciones entre objetos
		miModelo.setVista(miVista);
		miModelo.setLogin(miLogin);
		miControlador.setModelo(miModelo);
		miControlador.setVista(miVista);
		miControlador.setVista(miLogin);
		miVista.setModelo(miModelo);
		miVista.setControlador(miControlador);
		miLogin.setModelo(miModelo);
		miLogin.setControlador(miControlador);
		
		//Primera vista visible
		miLogin.setVisible(true);
	}
}
