import javax.swing.table.DefaultTableModel;

public class Modelo {
	private Tabla miVista;	
	private DefaultTableModel miTabla;
	
	public Modelo () {
		miTabla = new DefaultTableModel(
				new String[][] { { "Javier Fernández", "123456789" }, { "Santiago López", "987654321" }, },
				new String[] { "Nombre", "Teléfono" });
	}
	
	public void setVista(Tabla miVista) {
		this.miVista=miVista;
	}
	
	public DefaultTableModel getTabla () {
		return miTabla;
	}
	

}
