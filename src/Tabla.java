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

public class Tabla extends JFrame {

	private JPanel contentPane;
	private JTable TableTlf;
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
		
		TableTlf = new JTable();
		scrollPane.setViewportView(TableTlf);
		miModelo = new DefaultTableModel(
				new String[][] {
					{"Javier Fernández", "123456789"},
					{"Santiago López", "987654321"},
				},
				new String[] {
					"Nombre", "Teléfono"
				}
			);
		TableTlf.setModel(miModelo);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(25, 154, 179, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtTlf = new JTextField();
		txtTlf.setColumns(10);
		txtTlf.setBounds(214, 154, 195, 20);
		contentPane.add(txtTlf);
		
		btnAlta = new JButton("Alta");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				miModelo.addRow(new String [] {txtNombre.getText(),txtTlf.getText()});;
			}
		});
		btnAlta.setBounds(29, 200, 89, 23);
		contentPane.add(btnAlta);
		
		btnBaja = new JButton("Baja");
		btnBaja.setBounds(169, 200, 89, 23);
		contentPane.add(btnBaja);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(320, 200, 89, 23);
		contentPane.add(btnModificar);
	}
}
