package vista;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import modelo.ConeccionBDPostgres;
/**
*
* @author Gustavo
* 
*/
public final class VentanaOrganizador extends VentanaUsuario implements ActionListener, Runnable{
	
	private PanelListas listas;
	private LabelImagen img;
	private ConeccionBDPostgres con;
	private byte segundos;
	private Thread hilo1;
	private JButton btnVerExpositores, btnArchivo;
	private PanelArchivo panelarchivo;
	
	public VentanaOrganizador(String nombreVentana, String titulo, String archivoIcono){
		
		super(nombreVentana, titulo, archivoIcono);
		panelarchivo = new PanelArchivo();
		
		con = new ConeccionBDPostgres();
		
		btnVerExpositores = new JButton("VER EXPOSITORES");
		panel12.add(btnVerExpositores);
		
		btnArchivo = new JButton("ARCHIVO");
		panel12.add(btnArchivo);
		
		btnRegistrar.addActionListener(this);
		btnCerrarSesion.addActionListener(this);
		btnVerExpositores.addActionListener(this);
		btnArchivo.addActionListener(this);
		
		
		img = new LabelImagen(50, 50);
		panel21.add(img.labelImagen("fotoConferencia.png"));
		img.setX(15);
		img.setY(9.5F);
		panel11.add(img.labelImagen("cursos.png"));
		
		itemSalir.addActionListener(this);
		itemCerrarSesion.addActionListener(this);
		itemAcerca.addActionListener(this);
		
		panel22.setVisible(false);
		
		btnRegistrar.setText("NUEVO EXPOSITOR");
		
		mostrarListaExpositores();
		
		
		panel12.add(new JLabel(" "));
		panel12.add(new JLabel(" "));
		
		panel12.add(new JLabel(" "));
		panel12.add(new JLabel(" "));
		panel12.add(new JLabel(" "));
		panel12.add(new JLabel(" "));
		panel12.add(new JLabel(" "));
		
		
		hilo1 = new Thread(this);
        hilo1.start();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
				if(e.getSource()==itemSalir){
					if (cerrarPrograma(this)){
						hilo1.stop();
						System.exit(0);
					}
					
				}else if(e.getSource()==itemCerrarSesion || e.getSource()==btnCerrarSesion){
					if(cerrarSesion(this)){
						VentanaPrincipal inicio = new VentanaPrincipal();
						inicio.setVisible(true);
						this.dispose();
					}
					
				}else if(e.getSource()==btnRegistrar){
					new VentanaRegistroExpositores(this, true).setVisible(true);
				}else if(e.getSource()==itemAcerca){
					mostrarAutores();
				}else if(e.getSource() == btnVerExpositores){
						panel22.setVisible(true);
				}
	}
	
	protected void mostrarListaExpositores(){
		
		listas = new PanelListas(con.mostrarDatos("conferencista",
				new String[] {"idconfe","nomconfe", "apellidopatconfe", "apellidomatconfe", "especialidadconf", "dirconfe",
						"email", "telfconfe"}));
		try {
			panel22.add(listas.panelLista("LISTA DE EXPOSITORES"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(segundos <= 5){
			 try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 if(segundos==5){
				 if(con.cantidaFilas("conferencista") != listas.numeroDeFilas()){
					 listas.actualizaTabla(con.mostrarDatos("conferencista",
								new String[] {"idconfe","nomconfe", "apellidopatconfe", 
										"apellidomatconfe", "especialidadconf", "dirconfe",
										"email", "telfconfe"}));
				 }
				 
				 segundos = 0;
			 }
			segundos ++;
		}
	}
}
