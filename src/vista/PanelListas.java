package vista;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

//import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

public class PanelListas {
	private JTable tablaExpositores, tabla;
	protected JPanel panelEncabezado;
	private JLabel labelTituloItem;
	private JScrollPane scroll;
	private Herramientas dimPan;
	private String[] filas;
	private ResultSet rs;
	DefaultTableModel tablaModel;

	public PanelListas(ResultSet rs) {
		this.rs = rs;
		dimPan = new Herramientas();
		tablaModel = new DefaultTableModel();
		tabla = new JTable();
		filas = new String[8];
		
		scroll = new JScrollPane();

		labelTituloItem = new JLabel();
		labelTituloItem.setBounds(0, 0, dimPan.PenX(50), dimPan.PenY(10));
		labelTituloItem.setForeground(Color.WHITE);
		labelTituloItem.setHorizontalAlignment(SwingConstants.CENTER);
		labelTituloItem.setFont(new Font("Andale Mono", 1, dimPan.tamanioLetra(50)));

		panelEncabezado = new JPanel();
		panelEncabezado.setLayout(new GridLayout(3, 1));
		panelEncabezado.setOpaque(false);
		panelEncabezado.setBounds(0, 0, dimPan.PenX(50), dimPan.PenY(10));
		panelEncabezado.add(new JLabel(" "));
		panelEncabezado.add(labelTituloItem);

	}

	protected JPanel panelLista(String titulo) throws SQLException {// Solo para
																	// la lista
		tablaModel.addColumn("ID");
		tablaModel.addColumn("NOMBRE");
		tablaModel.addColumn("AP. PATERNO");
		tablaModel.addColumn("AP. MATERNO");
		tablaModel.addColumn("ESPECIALIDAD");
		tablaModel.addColumn("DIRECCION");
		tablaModel.addColumn("E-MAIL");
		tablaModel.addColumn("TELEFONO");
		

		tabla.setModel(tablaModel);
		tabla.getColumnModel().getColumn(0).setPreferredWidth(dimPan.PenX(0.5F));
		
		while (rs.next()) { // Mejorar ojo
			filas[0] = (rs.getString(1));
			filas[1] = (rs.getString(2));
			filas[2] = (rs.getString(3));
			filas[3] = (rs.getString(4));
			filas[4] = (rs.getString(5));
			filas[5] = (rs.getString(6));
			filas[6] = (rs.getString(7));
			filas[7] = (rs.getString(8));
			tablaModel.addRow(filas);
		}
		tabla.setEnabled(false);
		scroll.setViewportView(tabla);

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setOpaque(false);

		panel.add(scroll, BorderLayout.CENTER);
		panel.add(new JLabel("      "), BorderLayout.SOUTH);
		panel.add(new JLabel("      "), BorderLayout.WEST);
		panel.add(new JLabel("      "), BorderLayout.EAST);
		panel.add(new JLabel("      "), BorderLayout.NORTH);
		
		panel.add(panelEncabezado, BorderLayout.NORTH);
		labelTituloItem.setText(titulo);
		
		panel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(155, 191, 42)));
		return panel;
	}
	
	public JPanel listaEstudiantes(String titulo) throws SQLException{
		
		tablaModel.addColumn("ID");
		tablaModel.addColumn("NOMBRE");
		tablaModel.addColumn("AP. PATERNO");
		tablaModel.addColumn("AP. MATERNO");
		tablaModel.addColumn("CI");
		tablaModel.addColumn("TELEFONO");
		tablaModel.addColumn("E-MAIL");
		tablaModel.addColumn("CURSO");

		tabla.setModel(tablaModel);
		tabla.getColumnModel().getColumn(0).setPreferredWidth(dimPan.PenX(0.5F));

		while (rs.next()) { // Mejorar ojo
			filas[0] = (rs.getString(1));
			filas[1] = (rs.getString(2));
			filas[2] = (rs.getString(3));
			filas[3] = (rs.getString(4));
			filas[4] = (rs.getString(5));
			filas[5] = (rs.getString(6));
			filas[6] = (rs.getString(7));
			filas[7] = (rs.getString(8));
			tablaModel.addRow(filas);
		}

		scroll.setViewportView(tabla);

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setOpaque(false);

		panel.add(scroll, BorderLayout.CENTER);
		panel.add(new JLabel("      "), BorderLayout.SOUTH);
		panel.add(new JLabel("      "), BorderLayout.WEST);
		panel.add(new JLabel("      "), BorderLayout.EAST);
		panel.add(new JLabel("      "), BorderLayout.NORTH);
		
		panel.add(panelEncabezado, BorderLayout.NORTH);
		labelTituloItem.setText(titulo);
		
		panel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(155, 191, 42)));
		return panel;
		
	}

	public void actualizaTabla(ResultSet rs) {
		//tablaModel = new DefaultTableModel();
			System.out.println(tablaModel.getRowCount());	
			while(tablaModel.getRowCount()>0){
				tablaModel.removeRow(0);
			}
			
		try {
			while (rs.next()) { // Mejorar ojo
				filas[0] = (rs.getString(1));
				filas[1] = (rs.getString(2));
				filas[2] = (rs.getString(3));
				filas[3] = (rs.getString(4));
				filas[4] = (rs.getString(5));
				filas[5] = (rs.getString(6));
				filas[6] = (rs.getString(7));
				filas[7] = (rs.getString(8));
				tablaModel.addRow(filas);
			}
			System.out.println("Filas actuales: "+tablaModel.getRowCount());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	protected int numeroDeFilas(){
		int numeroFilas;
		numeroFilas = tablaModel.getRowCount();
		System.out.println("Cantidad en tabla: " + tablaModel.getRowCount());
		return numeroFilas;
	}
	
}
