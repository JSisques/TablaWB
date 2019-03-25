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

public class Login extends JFrame {
	private Controlador miControlador;
	private Modelo miModelo;
	
	private JPanel contentPane;
	private JTextField txtUsr;
	private JPasswordField txtPwd;

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
		txtUsr.setBounds(159, 77, 128, 20);
		contentPane.add(txtUsr);
		txtUsr.setColumns(10);
		
		txtPwd = new JPasswordField();
		txtPwd.setBounds(159, 119, 128, 20);
		contentPane.add(txtPwd);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				miControlador.Login();
			}
		});
		btnEntrar.setBounds(159, 168, 128, 23);
		contentPane.add(btnEntrar);
	}
	
	public void setModelo(Modelo miModelo) {
		this.miModelo=miModelo;
	}

	public void setControlador(Controlador miControlador) {
		this.miControlador=miControlador;
	}
}
