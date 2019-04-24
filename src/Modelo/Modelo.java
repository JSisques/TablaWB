package Modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

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

	private String selectPasswdUsuario = "SELECT PWD FROM HOSPITAL.USERS WHERE USR = ?";
	private String selectUsuarios = "SELECT * FROM HOSPITAL.USERS";

	// Atributos Base de datos
	private String baseDatos;
	private String usuarioDB;
	private String passwdDB;
	private String urlDB;
	private Connection conexion;

	// Atributos Fichero
	private Properties propiedades;
	private InputStream entrada;
	private OutputStream salida;
	private File fichero;

	public Modelo() {

		propiedades = new Properties();
		fichero = new File("./configuracion.ini");

		try {
			entrada = new FileInputStream(fichero);
			salida = new FileOutputStream(fichero, true);
			propiedades.load(entrada);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		baseDatos = propiedades.getProperty("baseDatos");
		usuarioDB = propiedades.getProperty("usuario");
		passwdDB = propiedades.getProperty("passwd");
		urlDB = propiedades.getProperty("url");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexion = DriverManager.getConnection(urlDB, usuarioDB, passwdDB);
			System.out.println("La conexion ha sido exitosa");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("La conexion ha fallado");
			e.printStackTrace();
		}
		intentos = 0;
		
	}

	private void tablaDB() {
		miTabla = new DefaultTableModel(new String[][] {}, new String[] { "Usuario", "Contraseña", "Rol" });

		String sql = selectUsuarios;
		try {
			PreparedStatement pstmt = conexion.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			String[] fila = new String[rs.getMetaData().getColumnCount()];
			while (rs.next()) {
				for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
					fila[i] = rs.getString(i + 1);
				}
				miTabla.addRow(fila);
			}

			miLogin.actualizaLogin();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void setVista(Tabla miVista) {
		this.miVista = miVista;
	}

	public void setLogin(Login miLogin) {
		this.miLogin = miLogin;
	}

	public DefaultTableModel getTabla() {
		return miTabla;
	}

	public void peticionLogin(String usr, String pwd) {
		String sql = selectPasswdUsuario;
		try {
			PreparedStatement pstmt = conexion.prepareStatement(sql);
			pstmt.setString(1, usr);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next() && rs.getString(1).equals(pwd)) {
				intentos = 0;
				tablaDB();
			} else {
				intentos++;
			}

			miLogin.actualizaLogin();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getResultadoLogin() {
		return intentos;
	}
}
