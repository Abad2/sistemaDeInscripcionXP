package vista;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.*;
import javax.swing.*;
/**
 * @author Gustavo
 * 
 */
public class VentanaUsuario extends JFrame{
	protected JPanel panelFondo, panel1, panel2, panel3, panel11, panel12, panel21, panel22;
	protected JLabel labelTitulo, labelPiePagina;
	protected JMenuBar menuBar;
	protected JMenu menuArchivo, menuAutor;
	protected JMenuItem itemSalir, itemCerrarSesion, itemAcerca;
	protected JScrollPane scrollVentana, scrollCategoria;
	protected Herramientas dimPan;
	protected Toolkit herraminetas = Toolkit.getDefaultToolkit();
	protected Image imagen;
	protected JLabel labelLogo;
	protected JButton btnRegistrar, btnCerrarSesion;
	/*
	 * CONTRUCTOR
	 * Inicializa los componentes principales de la ventana
	 * El parametro nombreVentana el el titulo en el marco de la ventana
	 * El parametro titulo sirve para poner el titulo principal en un frame
	 * El parametroarchivoIcono recibe el nombre del archivo que se mostrara en el icono de la ventana
	 */
	public VentanaUsuario(String nombreVentana, String titulo, String archivoIcono){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		dimPan = new Herramientas();
		
		imagen = herraminetas.getImage(dimPan.navegarPorProyecto(archivoIcono));
		setIconImage(imagen);
		
		//this.setDefaultCloseOperation(0);
		this.setTitle(nombreVentana);
		this.setBounds(0,0,dimPan.PenX(99), dimPan.PenY(90));
		this.setExtendedState(6);// 6 es para expandir la pantalla 
		this.setLocationRelativeTo(null);
		menuBar = new JMenuBar();
		menuBar.setBackground(Color.DARK_GRAY);
		this.setJMenuBar(menuBar);
		menuArchivo = new JMenu("Archivo");
		menuArchivo.setForeground(new Color(155, 191, 42));
		menuBar.add(menuArchivo);
		
		menuAutor = new JMenu("Créditos");
		menuAutor.setForeground(new Color(155, 191, 42));
		menuBar.add(menuAutor);
		
		itemCerrarSesion = new JMenuItem("Cerrar sesión");
		itemCerrarSesion.setForeground(new Color(155, 191, 42));
		itemCerrarSesion.setBackground(Color.DARK_GRAY);
		menuArchivo.add(itemCerrarSesion);
		
		itemSalir = new JMenuItem("Cerrar programa");
		itemSalir.setForeground(new Color(155, 191, 42));
		itemSalir.setBackground(Color.DARK_GRAY);
		menuArchivo.add(itemSalir);
		
		itemAcerca = new JMenuItem("Acerca de...");
		itemAcerca.setForeground(new Color(155, 191, 42));
		itemAcerca.setBackground(Color.DARK_GRAY);
		menuAutor.add(itemAcerca);
		
		scrollVentana = new JScrollPane();
		this.add(scrollVentana);
		
		panelFondo = new JPanel();
		panelFondo.setLayout(new BorderLayout());
		panelFondo.setBackground(new Color(118, 204, 245));
		panelFondo.setPreferredSize(new Dimension(dimPan.PenX(50), dimPan.PenY(50)));
		
		panel1 = new JPanel();
		panel1.setLayout(new GridLayout(1, 2, 10, 10));
		panel1.setBackground(Color.RED);
		panel2 = new JPanel();
		panel2.setBackground(Color.GRAY);
		panel3 = new JPanel();
		
		panelFondo.add(panel1, BorderLayout.NORTH);
		panelFondo.add(panel2, BorderLayout.CENTER);
		panelFondo.add(panel3, BorderLayout.SOUTH);
		panel2.setLayout(new GridLayout(1,2));
		
		panel11 = new JPanel();
		panel12 = new JPanel();
		panel21 = new JPanel();
		panel21.setLayout(new GridLayout(1, 5));
		panel22 = new JPanel();
		panel22.setLayout(new GridLayout(2, 2));
		panel12.setLayout(new FlowLayout());
		
		panel1.add(panel11);
		panel1.add(panel12);
		panel2.add(panel21, BorderLayout.WEST);
		panel2.add(panel22, BorderLayout.EAST);
		panel3.setLayout(new GridLayout(3, 1));
		panel11.setLayout(new GridLayout(1, 2));
		
		//panel12.add(new JLabel(""));
		//panel12.add(new JLabel(""));
		
		labelPiePagina = new JLabel("© Sistemas de información II - 2018");
		labelPiePagina.setForeground(new Color(138,145,141));
		labelPiePagina.setFont(new Font("Times New Roman", 1, dimPan.tamanioLetra(25)));
		labelPiePagina.setHorizontalAlignment(SwingConstants.CENTER);
		panel3.add(new JLabel(" "));
		panel3.add(labelPiePagina);
		//panel3.add(new JLabel(" "));
		scrollVentana.setViewportView(panelFondo);
		
		labelTitulo = new JLabel(titulo);
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setFont(new Font("Andale Mono", 1, dimPan.tamanioLetra(48)));
		labelTitulo.setForeground(Color.DARK_GRAY);
		panel11.add(labelTitulo);
		
		panel11.setOpaque(false);
		panel12.setOpaque(false);
		panel1.setBackground(new Color(155, 191, 42));
		panel3.setBackground(new Color(155, 191, 42));
		panel21.setBackground(Color.DARK_GRAY);
		panel22.setBackground(Color.DARK_GRAY);
		
		panel12.setLayout(new GridLayout(3, 6, 10,10));
		panel12.add(new JLabel(" "));
		panel12.add(new JLabel(" "));
		panel12.add(new JLabel(" "));
		panel12.add(new JLabel(" "));
		panel12.add(new JLabel(" "));
		panel12.add(new JLabel(" "));
		btnRegistrar = new JButton("");
		
		
		panel12.add(new JLabel(" "));
		panel12.add(new JLabel(" "));
		
		
		btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.setBackground(Color.ORANGE);
		panel12.add(btnCerrarSesion);
		panel12.add(btnRegistrar);
		
	}
	
	protected void mostrarAutores(){
		String texto = "DESARROLLADORES:"+
		
				"\n- Abasto Argote Gustavo"+
			
				"\n- Alvarado Llanos José Milton"+
			
				"\n- Ayma Marza Savina"+
				
				"\n- Pool Chavez Jonathan"+
				
				"\n- Ramos Maldonado Abad"+
				
				"\n- Sarmiento Cadima Sergio Daniel";
		
		ImageIcon icon = new ImageIcon("src/archivosmultimedia/creditos.png");
		JOptionPane.showMessageDialog(this, texto.toUpperCase(), "Créditos", JOptionPane.PLAIN_MESSAGE, icon);
	}
	protected boolean cerrarSesion(Frame ventana){
		ImageIcon icon = new ImageIcon("src/archivosmultimedia/exit.png");
        int input = JOptionPane.showConfirmDialog(ventana, 
                "Seguro de cerrar sesion?", "Confirmación", 
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, icon);
		if(input == 0){
			return true;
		}else {
			return false;
		}
	}
	
	protected boolean cerrarPrograma(Frame ventana){
		ImageIcon icon = new ImageIcon("src/archivosmultimedia/exit.jpg");
        int input = JOptionPane.showConfirmDialog(ventana, 
                "Seguro de querer cerrar el programa?", "Confirmación", 
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, icon);
        	
		if(input == 0){
			return true;
		}else {
			return false;
			
		}
	}
}
