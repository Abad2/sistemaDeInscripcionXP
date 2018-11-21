package vista;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;
public class PanelArchivo extends JPanel implements ActionListener{
	
	private DimensionesPantalla dimPan;
	private JPanel panelEncabezado;
	private JButton btnSubirArchivo, btnEliminarArchivo, btnEditarArchivo; 
	private String titulo;
	public PanelArchivo(String titulo){
		this.titulo = titulo;
		this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(155, 191, 42)));
		dimPan = new DimensionesPantalla();
		this.setBackground(Color.DARK_GRAY);
		this.setSize(dimPan.PenX(40), dimPan.PenY(60));
		this.setLayout(new BorderLayout());
		
		panelEncabezado = new JPanel();
		panelEncabezado.setBackground(Color.DARK_GRAY);
		panelEncabezado.setLayout(new GridLayout(2, 4));
		
		this.add(panelEncabezado, BorderLayout.NORTH);
		
		botones();
		
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

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	


}
