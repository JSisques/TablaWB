package Vista;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.Controlador;
import Modelo.Modelo;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login extends JFrame {
	private Controlador miControlador;
	private Modelo miModelo;
	
	private JPanel contentPane;
	private JTextField txtUsr;
	private JPasswordField txtPwd;
	private JLabel lblRes;
	private JButton btnEntrar;

	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(74, 80, 69, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setBounds(74, 122, 96, 14);
		contentPane.add(lblContrasea);
		
		txtUsr = new JTextField();
		txtUsr.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				enableBotones();
			}
		});
		txtUsr.setBounds(159, 77, 128, 20);
		contentPane.add(txtUsr);
		txtUsr.setColumns(10);
		
		txtPwd = new JPasswordField();
		txtPwd.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				enableBotones();
			}
		});
		txtPwd.setBounds(159, 119, 128, 20);
		contentPane.add(txtPwd);
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.setEnabled(false);
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				miControlador.Login();
			}
		});
		btnEntrar.setBounds(159, 168, 128, 23);
		contentPane.add(btnEntrar);
		
		lblRes = new JLabel("");
		lblRes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRes.setForeground(Color.RED);
		lblRes.setBounds(81, 210, 301, 20);
		contentPane.add(lblRes);
	}
	
	public void setModelo(Modelo miModelo) {
		this.miModelo=miModelo;
	}

	public void setControlador(Controlador miControlador) {
		this.miControlador=miControlador;
	}
	
	public String getUsr () {
		return txtUsr.getText();
	}
	
	public String getPwd () {
		return String.valueOf(txtPwd.getPassword());
	}

	public void actualizaLogin() {
		int intentos = miModelo.getResultadoLogin();
		// Usr & pwd correctos
		if (intentos == 0) 
			miControlador.cambiaLoginTabla ();
		else if (intentos < 3) {
			String txt = String.format("Datos incorrectos. Le quedan %s intentos", (3-intentos));
			lblRes.setText(txt);
		}
		else
			System.exit(0);
	}
	
	private void enableBotones() {
		// Condiciones del botón de ALTA
		if (!txtUsr.getText().equals("") && !String.valueOf(txtPwd.getPassword()).equals("")) 
			btnEntrar.setEnabled(true);
		 else 
			btnEntrar.setEnabled(false);
	}
	
}
