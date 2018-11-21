package vista;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controlador.GestiionarArchivos;
public class PanelArchivo extends JPanel implements ActionListener{
	
	private DimensionesPantalla dimPan;
	private JPanel panelEncabezado;
	private JButton btnSubirArchivo, btnEliminarArchivo, btnEditarArchivo; 
	private String titulo;
	private DefaultTableModel tablaModel;
	private JTable tabla;
	private JScrollPane scroll;
	private GestiionarArchivos gs;
	
	public PanelArchivo(String titulo){
		
		this.titulo = titulo;
		this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(155, 191, 42)));
		dimPan = new DimensionesPantalla();
		//this.setBackground(Color.pink);
		this.setSize(dimPan.PenX(40), dimPan.PenY(60));
		this.setLayout(new BorderLayout());
		
		tablaModel = new DefaultTableModel();
		tabla = new JTable();
		scroll = new JScrollPane();
		
		panelEncabezado = new JPanel();
		panelEncabezado.setBackground(Color.DARK_GRAY);
		panelEncabezado.setLayout(new GridLayout(2, 4));
		
		this.add(panelEncabezado, BorderLayout.NORTH);
		
		botones();
		crearTabla();
		
	}
	
	private void botones(){
		JLabel labelTitulo = new JLabel(titulo);
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setForeground(Color.WHITE);
		btnSubirArchivo = new JButton("Subir");
		btnEliminarArchivo = new JButton("Eliminar");
		btnEditarArchivo = new JButton("Editar");
		
		btnSubirArchivo.setBackground(Color.GREEN);
		btnEliminarArchivo.setBackground(Color.RED);
		btnEditarArchivo.setBackground(Color.ORANGE);
		
		panelEncabezado.add(new JLabel(" "));
		panelEncabezado.add(labelTitulo);
		panelEncabezado.add(new JLabel(" "));
		panelEncabezado.add(btnSubirArchivo, BorderLayout.NORTH);
		panelEncabezado.add(btnEditarArchivo, BorderLayout.NORTH);
		panelEncabezado.add(btnEliminarArchivo, BorderLayout.NORTH);
		
		btnSubirArchivo.addActionListener(this);
		btnEliminarArchivo.addActionListener(this);
		btnEditarArchivo.addActionListener(this);
	}
	
	public void crearTabla(){
		
		//Ejemplo borrar
		ArrayList<String []> listaDeArchivosBD =new ArrayList<String []>();
		listaDeArchivosBD.add(new String [] {"1", "archivo 1", "12/09/2008","2008","no",
							"tipo 2", "pdf"});
		listaDeArchivosBD.add(new String [] {"2", "archivo 2", "12/09/2008","2017","si",
				"tipo 1", "docx"});
		listaDeArchivosBD.add(new String [] {"3", "archivo 3", "12/09/2008","2005","si",
				"tipo 1", "pdf"});
		
		listaDeArchivosBD.add(new String [] {"3", "archivo de consultas", "12/09/2008","2005","si",
				"tipo 5", "pdf"});
		//
		
		tablaModel.addColumn("ID");
		tablaModel.addColumn("NOMBRE");
		tablaModel.addColumn("CREACION");
		tablaModel.addColumn("PUESTO EN VIGENCIA");
		tablaModel.addColumn("VIGENCIA ACTUAL");
		tablaModel.addColumn("FORMATO");
		tablaModel.addColumn("EXTENSION");
		
		//Llenar tabla
		int indice = 0;
		while(indice < listaDeArchivosBD.size()){
			tablaModel.addRow(listaDeArchivosBD.get(indice));
			indice ++;
		}
		
		
		tabla.setModel(tablaModel);
		scroll.setViewportView(tabla);
		tabla.getColumnModel().getColumn(0).setPreferredWidth(dimPan.PenX(0.5F));
		this.add(scroll);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	


}
