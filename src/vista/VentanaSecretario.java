package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

//import com.sun.org.apache.xerces.internal.xs.ItemPSVI;

import modelo.ConeccionBDPostgres;

public final class VentanaSecretario extends VentanaUsuario implements ActionListener, Runnable {
	
	private JButton btnVerIncritos;
	private LabelImagen img;
	private PanelListas panelListaEstudiantes;
	private ConeccionBDPostgres con;
	private Thread hilo1;
	private byte segundos;
	
	public VentanaSecretario(String nombreVentana, String titulo, String archivoIcono) {
		super(nombreVentana, titulo, archivoIcono);
		// TODO Auto-generated constructor stub
		con = new ConeccionBDPostgres();
		panelListaEstudiantes = new PanelListas(con.mostrarDatos("estudiante", new String [] {
				"idestud", "nombreestud", "apellidopatestud", "apellidomatestud", "ciestud", "telefestud",
				"email", "curso"
		}));
		
		img = new LabelImagen(50, 50);
		panel21.add(img.labelImagen("cursos.jpg"));
		img.setX(15);
		img.setY(9.5F);
		panel11.add(img.labelImagen("cursos.png"));
		
		itemCerrarSesion.addActionListener(this);
		itemSalir.addActionListener(this);
		itemAcerca.addActionListener(this);
		
		panel22.setVisible(false);
		try {
			panel22.add(panelListaEstudiantes.listaEstudiantes("LISTA ESTUDIANTES"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		btnRegistrar.setText("INSCRIBIR");
		btnRegistrar.addActionListener(this);
		btnCerrarSesion.addActionListener(this);
		
		btnVerIncritos = new JButton("Ver Inscritos");
		btnVerIncritos.addActionListener(this);
		panel12.add(btnVerIncritos);
		
		panel12.add(new JLabel(" "));
		panel12.add(new JLabel(" "));
		
		panel12.add(new JLabel(" "));
		panel12.add(new JLabel(" "));
		panel12.add(new JLabel(" "));
		panel12.add(new JLabel(" "));
		panel12.add(new JLabel(" "));
		
		
		hilo1 = new Thread(this);
        hilo1.start();
        segundos = 0;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnRegistrar){
			new VentanaInscribirEstudiante(this, true).setVisible(true);;
		}else if(e.getSource()==itemCerrarSesion || e.getSource()==btnCerrarSesion){
			if(cerrarSesion(this)){
				VentanaPrincipal inicio = new VentanaPrincipal();
				inicio.setVisible(true);
				this.dispose();
				hilo1.stop();
			}
		}else if(e.getSource()==itemSalir){
			if(cerrarPrograma(this)){
				System.exit(0);
			}
		}else if(e.getSource()==itemAcerca){
			mostrarAutores();
		}else if(e.getSource()==btnVerIncritos){
			panel22.setVisible(true);
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
				 if(con.cantidaFilas("estudiante") != panelListaEstudiantes.numeroDeFilas()){
					 panelListaEstudiantes.actualizaTabla(con.mostrarDatos("estudiante", new String [] {
								"idestud", "nombreestud", "apellidopatestud", "apellidomatestud", "ciestud", "telefestud",
								"email", "curso"
						}));
				 }
				 
				 segundos = 0;
			 }
			segundos ++;
		}
	}
}
