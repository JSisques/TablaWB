package Vista;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controlador.Controlador;
import Modelo.Modelo;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Tabla extends JFrame {
	private Controlador miControlador;
	private Modelo miModelo;
	
	private JPanel contentPane;
	private JTable tableTlf;
	private JTextField txtNombre;
	private JTextField txtTlf;
	private JButton btnAlta;
	private JButton btnBaja;
	private JButton btnModificar;
	private DefaultTableModel miTabla;

	/**
	 * Create the frame.
	 */
	public Tabla() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				miTabla = miModelo.getTabla();
				tableTlf.setModel(miTabla);
			}
		});
		setTitle("Agenda Telefónica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 22, 384, 121);
		contentPane.add(scrollPane);

		tableTlf = new JTable();
		tableTlf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtNombre.setText((String) tableTlf.getValueAt(tableTlf.getSelectedRow(), 0));
				;
				txtTlf.setText((String) tableTlf.getValueAt(tableTlf.getSelectedRow(), 1));
				;
				enableBotones();
				btnAlta.setEnabled(false);
			}
		});
		scrollPane.setViewportView(tableTlf);



		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				enableBotones();
			}
		});
		txtNombre.setBounds(25, 154, 179, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		txtTlf = new JTextField();
		txtTlf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				enableBotones();
			}
		});
		txtTlf.setColumns(10);
		txtTlf.setBounds(214, 154, 195, 20);
		contentPane.add(txtTlf);

		btnAlta = new JButton("Alta");
		btnAlta.setEnabled(false);
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				miTabla.addRow(new String[] { txtNombre.getText(), txtTlf.getText() });
				;
				txtNombre.setText("");
				txtTlf.setText("");
				btnAlta.setEnabled(false);
			}
		});
		btnAlta.setBounds(29, 200, 89, 23);
		contentPane.add(btnAlta);

		btnBaja = new JButton("Baja");
		btnBaja.setEnabled(false);
		btnBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miTabla.removeRow(tableTlf.getSelectedRow());
				txtNombre.setText("");
				txtTlf.setText("");
				enableBotones();
			}
		});
		btnBaja.setBounds(169, 200, 89, 23);
		contentPane.add(btnBaja);

		btnModificar = new JButton("Modificar");
		btnModificar.setEnabled(false);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miTabla.setValueAt(txtNombre.getText(), tableTlf.getSelectedRow(), 0);
				miTabla.setValueAt(txtTlf.getText(), tableTlf.getSelectedRow(), 1);
				txtNombre.setText("");
				txtTlf.setText("");
				enableBotones();
			}
		});
		btnModificar.setBounds(320, 200, 89, 23);
		contentPane.add(btnModificar);
	}

	private void enableBotones() {
		// Condiciones del botón de ALTA
		if (!txtNombre.getText().equals("") && !txtTlf.getText().equals("")) {
			btnAlta.setEnabled(true);
			// Condiciones del botón de MODIFICAR
			if (tableTlf.getSelectedRowCount() == 1)
				btnModificar.setEnabled(true);
			else
				btnModificar.setEnabled(false);
		} else {
			btnAlta.setEnabled(false);
			btnModificar.setEnabled(false);
		}
		// Condiciones del botón de BAJA
		if (tableTlf.getSelectedRowCount() == 1) {
			btnBaja.setEnabled(true);
		} else {
			btnBaja.setEnabled(false);
		}

	}

	public void setModelo(Modelo miModelo) {
		this.miModelo=miModelo;
	}

	public void setControlador(Controlador miControlador) {
		this.miControlador=miControlador;
	}

}
