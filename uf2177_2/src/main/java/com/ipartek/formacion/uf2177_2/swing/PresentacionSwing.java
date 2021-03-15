package com.ipartek.formacion.uf2177_2.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.ipartek.formacion.uf2177_2.accesodatos.Dao;
import com.ipartek.formacion.uf2177_2.accesodatos.EuromillonDaoJdbc;
import com.ipartek.formacion.uf2177_2.entidades.Euromillon;

public class PresentacionSwing {

	private Dao<Euromillon> dao = EuromillonDaoJdbc.getInstancia();

	private JFrame frame;
	private JTextField tNumeros;
	private JTextField tEstrellas;
	private JTextField tFecha;
	private JTable table;
	private JButton btnAceptar;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PresentacionSwing window = new PresentacionSwing();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private DefaultTableModel modelo;

	public PresentacionSwing() {
		initialize();

		modelo = new DefaultTableModel(new Object[][] {}, new String[] { "Id", "Numeros", "Estrellas", "Fecha" });

		table.setModel(modelo);

		cargarTabla();

	}

	private void cargarTabla() {
		modelo.setRowCount(0);

		modelo.addRow(new Object[] { "Id", "Numeros", "Estrellas", "Fecha" });

		for (Euromillon euromillon : dao.obtenerTodos()) {

			modelo.addRow(new Object[] { euromillon.getId(), euromillon.getNumeros(), euromillon.getEstrellas(),
					euromillon.getFecha() });
		}
	}

	private void btnAceptarClick() {
		Euromillon euromillon = new Euromillon(null, tNumeros.getText(), tEstrellas.getText(), tFecha.getText());

		dao.agregar(euromillon);

		cargarTabla();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 270);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel pFormulario = new JPanel();
		frame.getContentPane().add(pFormulario, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Numeros");
		pFormulario.add(lblNewLabel);

		tNumeros = new JTextField();
		pFormulario.add(tNumeros);
		tNumeros.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Estrellas");
		pFormulario.add(lblNewLabel_1);

		tEstrellas = new JTextField();
		tEstrellas.setText("");
		pFormulario.add(tEstrellas);
		tEstrellas.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Fecha");
		pFormulario.add(lblNewLabel_2);

		tFecha = new JTextField();
		pFormulario.add(tFecha);
		tFecha.setColumns(10);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAceptarClick();
			}
		});
		pFormulario.add(btnAceptar);

		table = new JTable();
		frame.getContentPane().add(table, BorderLayout.CENTER);
	}

}
