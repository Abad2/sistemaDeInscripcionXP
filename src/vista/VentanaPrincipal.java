package vista;

import javax.swing.*;
import controlador.ValidacionDatos;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame implements ActionListener{
	 
	private Herramientas dimPan= new Herramientas();
	private JButton botonAcceder;
	private JPanel panelFondo, panel1, panel2, panel3, panel4, panel5, panelSesion;
	private JLabel labelUno, labelHistoria, labelInformacion, labelUser, labelPass, labelPiePagina;
	private JPasswordField fieldPass;
	private JTextField fieldUser;
	
	private ValidacionDatos vd;
	
	private Toolkit herraminetas = Toolkit.getDefaultToolkit();
	 /* 
	  * Constructor
	  * 
	  */
	
	public VentanaPrincipal(){
		
		vd = new ValidacionDatos();
		this.setLayout(new BorderLayout());
		//this.setExtendedState(6);
		this.setSize(dimPan.PenX(75), dimPan.PenY(70));
		this.setLocationRelativeTo(null);
		this.setTitle("SISTEMA DE INFORMACION - CONFERENCIAS");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		JScrollPane scrollVentana = new JScrollPane();
		this.add(scrollVentana);
		
		panelFondo = new JPanel();
		panelFondo.setLayout(new BorderLayout());
		panelFondo.setPreferredSize(new Dimension(dimPan.PenX(60), dimPan.PenY(60)));
		scrollVentana.setViewportView(panelFondo);
		
		Image imagen = herraminetas.getImage(dimPan.navegarPorProyecto("icono.png"));
		setIconImage(imagen);
		
		labelUno = new JLabel("SISTEMA DE CONFERENCIAS");
		labelUno.setFont(new Font("Andale Mono", 1, dimPan.tamanioLetra(90)));
		labelUno.setForeground(Color.DARK_GRAY);
		
		panel1 =new JPanel();
		panel1.setBackground(new Color(155, 191, 42));
		panelFondo.add(panel1,BorderLayout.NORTH);
		panel1.add(labelUno);
	
		panel2 =new JPanel();
		panel2.setBackground(new Color(241, 228, 184));
		//panel2.setLayout(new BorderLayout());
		panelFondo.add(panel2, BorderLayout.WEST);
		
		panel3 =new JPanel();
		panel3.setBackground(Color.DARK_GRAY);
		panel3.setLayout(new BorderLayout());
		panelFondo.add(panel3, BorderLayout.CENTER);
		
		panel4 =new JPanel();
		panel4.setBackground(new Color(241, 228, 184));
		//panel4.setLayout(new BorderLayout());
		panelFondo.add(panel4, BorderLayout.EAST);
		
		panel5 =new JPanel();
		panel5.setBackground(new Color(155, 191, 42));
		panel5.setLayout(new GridLayout(5, 1));
		panelFondo.add(panel5, BorderLayout.SOUTH);
		
		ponerObjetos();
	}
	/**
	 * Este metodo dibuja los elementos en los paneles
	 */
	private void ponerObjetos(){
		String historia = "<html> <br><center>HISTORIA</center><br><br>Historia de la institución. "
				+ "<br><br>Los orígenes de la Casa del señor Velázquez"
				+ "<br>se remontan a comienzos del siglo XX. En el"
				+ "<br>año 1909 se abrió en Madrid una Escuela de Al-"
				+ "<br>tos Estudios Hispánicos, creación de la Uni-"
				+ "<br>versidad de Burdeos, destinada a acoger a jó-"
				+ "<br>venes investigadores franceses."
				+ "<br><br>Los orígenes de la Casa del señor Velázquez"
				+ "<br>se remontan a comienzos del siglo XX. En el"
				+ "<br>año 1909 se abrió en Madrid una Escuela de Al-"
				+ "<br>tos Estudios Hispánicos, creación de la Uni-"
				+ "<br>versidad de Burdeos, destinada a acoger a jó-"
				+ "<br>venes investigadores franceses."
				+ "</html>";
		labelHistoria = new JLabel(historia);
		labelHistoria.setFont(new Font("Andale Mono", 1, dimPan.tamanioLetra(25)));
		panel2.add(labelHistoria);
		
		String info = "<html><br><center>CURSOS DISPONIBLES</center><br><br>"
				+ "CURSO DE REDES: Este 10 de Octubre en gran curso<br>"
				+ "de redes cisco y mikrotik.<br>"
				+ "El costo será de 800 bolivianos para las personas<br>"
				+ "que se inscriban en la primera semana.<br>"
				+ "Expositor: Ing. Fulano Mendez<br>"
				+ "Lugar: Auditorio de ciencias y tecnología."
				+ "<br><br>CURSO DE LINUX: Este 25 de Octubre en gran curso<br>"
				+ "de linux basico y avanzado.<br>"
				+ "El costo será de 1000 bolivianos para las personas<br>"
				+ "que se inscriban en la primera semana.<br>"
				+ "Expositor: Ing. Fulano Mendez<br>"
				+ "Lugar: Auditorio de ciencias y tecnología.</html>";
		
		labelPiePagina = new JLabel("© Sistemas de información II - 2018");
		labelPiePagina.setHorizontalAlignment(SwingConstants.CENTER);
		panel5.add(new JLabel(""));
		panel5.add(new JLabel(""));
		panel5.add(labelPiePagina);
		
		labelInformacion = new JLabel(info);
		labelInformacion.setForeground(Color.DARK_GRAY);
		labelInformacion.setFont(new Font("Andale Mono", 1, dimPan.tamanioLetra(25)));
		panel4.add(labelInformacion);
		
		panelSesion = new JPanel();
		panelSesion.setOpaque(false);
		panelSesion.setLayout(new GridLayout(3, 5, 10, 10));
		
		fieldUser = new JTextField();
		labelUser = new JLabel("USUARIO");
		labelUser.setForeground(Color.WHITE);
		labelUser.setHorizontalAlignment(SwingConstants.CENTER);
		labelPass = new JLabel("CONTRASEÑA");
		labelPass.setHorizontalAlignment(SwingConstants.CENTER);
		labelPass.setForeground(Color.WHITE);
		fieldPass = new JPasswordField();
		botonAcceder = new JButton("ACCEDER");
		botonAcceder.setBackground(new Color(173, 255, 47));
		botonAcceder.addActionListener(this);
		
		fieldUser.setFont(new Font("Andale Mono", 1, dimPan.tamanioLetra(25)));
		fieldPass.setFont(new Font("Andale Mono", 1, dimPan.tamanioLetra(25)));
		botonAcceder.setFont(new Font("Andale Mono", 1, dimPan.tamanioLetra(25)));
		
		panelSesion.add(new JLabel(""));
		panelSesion.add(labelUser);
		panelSesion.add(labelPass);
		panelSesion.add(new JLabel(""));
		panelSesion.add(new JLabel(""));
		panelSesion.add(new JLabel(""));
		panelSesion.add(fieldUser);
		panelSesion.add(fieldPass);
		panelSesion.add(botonAcceder);
		panelSesion.add(new JLabel(""));
		panelSesion.add(new JLabel(""));
		panelSesion.add(new JLabel(""));
		panelSesion.add(new JLabel(""));
		panelSesion.add(new JLabel(""));
		panelSesion.add(new JLabel(""));
		
		panel3.add(panelSesion,BorderLayout.SOUTH);
		
		LabelImagen img = new LabelImagen(65, 65);
		panel3.add(img.labelImagen("inicio.png"), BorderLayout.NORTH);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String usuario = fieldUser.getText();
		char contrasenia [] = fieldPass.getPassword();
		String pass = "";
		for(int i = 0; i < contrasenia.length;i++){
			pass += contrasenia[i];
		}
		
		if(usuario.equals("")||pass.equals("")){
			JOptionPane.showMessageDialog(this, "Llena los dos campos", "Incompleto", JOptionPane.QUESTION_MESSAGE);
		}else {
			if(vd.acceder(usuario, pass)){
				this.dispose();
			}
		}
	}
}
	