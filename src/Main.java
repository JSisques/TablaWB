
public class Main {
	public static void main(String[] args) {
		//Creación de los objetos
		Controlador miControlador = new Controlador ();
		Modelo miModelo = new Modelo ();
		Tabla miVista = new Tabla ();
		
		//Relaciones entre objetos
		miModelo.setVista(miVista);
		miControlador.setModelo(miModelo);
		miControlador.setVista(miVista);
		miVista.setModelo(miModelo);
		miVista.setControlador(miControlador);
		
		//Primera vista visible
		miVista.setVisible(true);
	}
}
