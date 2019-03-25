import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Tabla extends JFrame {

	private JPanel contentPane;
	private JTable tableTlf;
	private JTextField txtNombre;
	private JTextField txtTlf;
	private JButton btnAlta;
	private JButton btnBaja;
	private JButton btnModificar;
	private DefaultTableModel miModelo;

	/**
	 * Create the frame.
	 */
	public Tabla() {
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
		miModelo = new DefaultTableModel(
				new String[][] { { "Javier Fernández", "123456789" }, { "Santiago López", "987654321" }, },
				new String[] { "Nombre", "Teléfono" });
		tableTlf.setModel(miModelo);

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
				miModelo.addRow(new String[] { txtNombre.getText(), txtTlf.getText() });
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
				miModelo.removeRow(tableTlf.getSelectedRow());
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
				miModelo.setValueAt(txtNombre.getText(), tableTlf.getSelectedRow(), 0);
				miModelo.setValueAt(txtTlf.getText(), tableTlf.getSelectedRow(), 1);
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

}
