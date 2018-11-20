package controlador;

import java.sql.*;

import javax.swing.JOptionPane;

import modelo.ConeccionBDPostgres;
//import sun.security.validator.ValidatorException;
import vista.VentanaOrganizador;
import vista.VentanaPrincipal;
import vista.VentanaSecretario;

public class ValidacionDatos {
	private ConeccionBDPostgres con;
	public ValidacionDatos() {
		con = new ConeccionBDPostgres();
	}

	public String eliminarEspacio(String texto) {// Este metodo eliminar los
													// espacios
		String textoAuxiar = texto.trim();
		String textoFinal = "";
		int espacios = 0;

		for (int i = 0; i < textoAuxiar.length(); i++) {
			if (textoAuxiar.charAt(i) == ' ') {
				espacios++;
			} else
				espacios = 0;
			if (espacios <= 1) {
				textoFinal += textoAuxiar.charAt(i);
			}
		}

		return textoFinal;

	}

	public boolean validarAlfabeto(String textoAlfabetico) {
		boolean caracterValido = true;
		for (int i = 0; i < textoAlfabetico.length(); i++) {
			if (textoAlfabetico.charAt(i) == '~' || textoAlfabetico.charAt(i) == '´' || textoAlfabetico.charAt(i) == '0'
					|| textoAlfabetico.charAt(i) == '1' || textoAlfabetico.charAt(i) == '2'
					|| textoAlfabetico.charAt(i) == '3' || textoAlfabetico.charAt(i) == '4'
					|| textoAlfabetico.charAt(i) == '5' || textoAlfabetico.charAt(i) == '6'
					|| textoAlfabetico.charAt(i) == '7' || textoAlfabetico.charAt(i) == '8'
					|| textoAlfabetico.charAt(i) == '9' || textoAlfabetico.charAt(i) == '-'
					|| textoAlfabetico.charAt(i) == '_' || textoAlfabetico.charAt(i) == '='
					|| textoAlfabetico.charAt(i) == '*' || textoAlfabetico.charAt(i) == '&'
					|| textoAlfabetico.charAt(i) == '$' || textoAlfabetico.charAt(i) == '@'
					|| textoAlfabetico.charAt(i) == '!' || textoAlfabetico.charAt(i) == '¡'
					|| textoAlfabetico.charAt(i) == '+' || textoAlfabetico.charAt(i) == '/'
					|| textoAlfabetico.charAt(i) == '^' || textoAlfabetico.charAt(i) == '%'
					|| textoAlfabetico.charAt(i) == '(' || textoAlfabetico.charAt(i) == ')'
					|| textoAlfabetico.charAt(i) == '{' || textoAlfabetico.charAt(i) == '}'
					|| textoAlfabetico.charAt(i) == '[' || textoAlfabetico.charAt(i) == ']'
					|| textoAlfabetico.charAt(i) == '?' || textoAlfabetico.charAt(i) == '¿'
					|| textoAlfabetico.charAt(i) == '<' || textoAlfabetico.charAt(i) == '>'
					|| textoAlfabetico.charAt(i) == '#' || textoAlfabetico.charAt(i) == '-'
					|| textoAlfabetico.charAt(i) == '.' || textoAlfabetico.charAt(i) == ':'
					|| textoAlfabetico.charAt(i) == ';' || textoAlfabetico.charAt(i) == '"'
					|| textoAlfabetico.charAt(i) == '|' || textoAlfabetico.charAt(i) == ','
					|| textoAlfabetico.charAt(i) == ';'

			) {
				caracterValido = false;
				break;
			}
		}
		return caracterValido;
	}

	public boolean validarCorreo(String correo) {// Este metodo verifica y
													// valida el
													// Correo electrÃ³nico
		String email = correo.trim();
		int puntos = 0, espacios = 0, arrobas = 0, caracteresEspeciales = 0;
		boolean inavilidarPorPosicion = true;
		for (int i = 0; i < email.length(); i++) {
			if (i == 0 || i == email.length() - 1) {// Controla de que no inicie
													// ni termine en . o @
				if (email.charAt(i) == '.' || email.charAt(i) == '@') {
					inavilidarPorPosicion = false;
					break;
				}
			}

			if (i < email.length() - 2 && (email.charAt(i) == '@' || email.charAt(i) == '.')) {
				// Controla que no exista @@ o ..
				if (email.charAt(i) == email.charAt(i + 1)) {
					inavilidarPorPosicion = false;
					break;
				}
			}

			if (email.charAt(i) == '.') {
				puntos++;
			} else if (email.charAt(i) == ' ') {
				espacios++;
			} else if (email.charAt(i) == '@') {
				arrobas++;
			} else if (email.charAt(i) == '´' || email.charAt(i) == '*' || email.charAt(i) == '~'
					|| email.charAt(i) == '<' || email.charAt(i) == '=' || email.charAt(i) == '>'
					|| email.charAt(i) == '&' || email.charAt(i) == '$' || email.charAt(i) == '^'
					|| email.charAt(i) == '}' || email.charAt(i) == '{' || email.charAt(i) == '+'
					|| email.charAt(i) == '‘' || email.charAt(i) == '#' || email.charAt(i) == '¿'
					|| email.charAt(i) == '?' || email.charAt(i) == '+' || email.charAt(i) == '['
					|| email.charAt(i) == ']' || email.charAt(i) == '(' || email.charAt(i) == ')'
					|| email.charAt(i) == '/' || email.charAt(i) == '"' || email.charAt(i) == '!'
					|| email.charAt(i) == '~' || email.charAt(i) == '¡' || email.charAt(i) == ';'
					|| email.charAt(i) == ',' || email.charAt(i) == ':' || email.charAt(i) == '%') {
				// Controla que no tenga caracteres especiales
				caracteresEspeciales++;
			}
		}

		if (puntos > 0 && espacios == 0 && arrobas == 1 && caracteresEspeciales == 0 && inavilidarPorPosicion) {

			return true;

		} else
			return false;
	}

	public boolean acceder(String user, String pass) { // Controla acceso de
														// usuario
		boolean ocultar = false;
		String idBD = "";
		String userBD = "";
		String passBD = "";
		String tipoUsuario = "";
		ResultSet rs = con.inicioSesion(user, pass);
		try {
			while (rs.next()) {
				idBD = rs.getString("id_usuario");
				userBD = rs.getString("USUARIO");
				passBD = rs.getString("CLAVE");
				tipoUsuario = rs.getString("TIPO");
				System.out.println(
						"Leido desde la base de datos: " + idBD + " " + userBD + " " + passBD + " " + tipoUsuario);
			}
			if (userBD.equals(user) && passBD.equals(pass) && !tipoUsuario.equals("null")) {
				if (tipoUsuario.equals("ORGANIZA")) {// Si es organizador
					VentanaOrganizador organizador = new VentanaOrganizador("Organizador", "ORGANIZADOR DE EVENTOS",
							"icono.png");
					organizador.setVisible(true);
					ocultar = true;
				} else if (tipoUsuario.equals("SECRE")) {// Si es Secretario
					VentanaSecretario VentanaSecretario = new VentanaSecretario("Secreatrio", "CUENTA SECRETARIO",
							"icono.png");
					VentanaSecretario.setVisible(true);
					ocultar = true;
				} else {
					JOptionPane.showMessageDialog(null,
							"El rol del usuario ingresado no existe!\nConsulte con el administrador", "Sin rol",
							JOptionPane.ERROR_MESSAGE);
				}

			} else if (tipoUsuario.equals("null")) {
				JOptionPane.showMessageDialog(null,
						"No existe rol para el usuario ingresado!\nConsulte con el administrador", "Inconsistencia",
						JOptionPane.NO_OPTION);
			} else {
				JOptionPane.showMessageDialog(null,
						"Revise los campos!\nSi olvidó su contraseña\nconsulte con el administrador", "Inconsistencia",
						JOptionPane.QUESTION_MESSAGE);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error..................!");
			e.printStackTrace();
		}

		return ocultar;
	}

	public boolean validarTelefono(String telefono) {// Falta controlar celulares cantidad de digitos

		boolean autorizar;
		autorizar = true;
		if ((telefono.length() != 7 && telefono.length() != 8)
				|| (telefono.charAt(0) != '4' && telefono.charAt(0) != '2' && telefono.charAt(0) != '3'
						&& telefono.charAt(0) != '7' && telefono.charAt(0) != '6')) {
			autorizar = false;
			System.out.println("Ingreso al if");
		}
		int indice = 0;
		while (autorizar && indice < telefono.length()) {
			if (telefono.charAt(indice) != '0' && telefono.charAt(indice) != '1' && telefono.charAt(indice) != '2'
					&& telefono.charAt(indice) != '3' && telefono.charAt(indice) != '4'
					&& telefono.charAt(indice) != '5' && telefono.charAt(indice) != '6'
					&& telefono.charAt(indice) != '7' && telefono.charAt(indice) != '8'
					&& telefono.charAt(indice) != '9') {
				autorizar = false;
				break;
			}
			indice++;
		}

		return autorizar;
	}

	public boolean validarCI(String cI) {
		boolean autorizar = true;
		if (cI.length() != 7) {
			autorizar = false;
		} else {
			for (int i = 0; i < cI.length(); i++) {
				if (cI.charAt(i) != '1' && cI.charAt(i) != '2' && cI.charAt(i) != '3' && cI.charAt(i) != '4'
						&& cI.charAt(i) != '5' && cI.charAt(i) != '6' && cI.charAt(i) != '7' && cI.charAt(i) != '8'
						&& cI.charAt(i) != '9' && cI.charAt(i) != '0') {
					autorizar = false;
					break;
				}
			}
		}
		return autorizar;

	}

	public boolean autorizarGuardado(String nombre, String apP, String apM, String telf, String email,
			String especialidad) {

		if (validarAlfabeto(nombre) && validarAlfabeto(apP) && validarAlfabeto(apM) && validarTelefono(telf)
				&& validarCorreo(email) && !especialidad.equals(" ")) {
			System.out.println("true");
			return true;

		} else {
			System.out.println("false");
			return false;
		}
	}
	
	public boolean autorizarGuardado(String nombre, String apP, String apM, String cI, String telf, String email,
			String especialidad) {// SobreCarca con CI

		if (validarAlfabeto(nombre) && validarAlfabeto(apP) && validarAlfabeto(apM) && validarTelefono(telf)
				&& validarCorreo(email) && !especialidad.equals(" ") && validarCI(cI)) {
			return true;

		} else {
			return false;
		}
	}
	
	public boolean autorizarGuardado(String nombre, String apP, String apM, String cI, String telf, String email,
			String especialidad, String [] ciBD) {// SobreCarca con CI
			
			boolean noRepetido = true;
			for(int i = 0; i < ciBD.length; i++){
				if(cI.equals(ciBD[i])){
					System.out.println("Se tiene que es igual "+ciBD[i]+" "+cI);
					noRepetido = false;//Si repite
					break;
				}
			}
			System.out.println("noRepetido "+noRepetido);
			
			
		if (validarAlfabeto(nombre) && validarAlfabeto(apP) && validarAlfabeto(apM) && validarTelefono(telf)
				&& validarCorreo(email) && !especialidad.equals(" ") && validarCI(cI) && noRepetido) {
			return true;//new String [] {nombre, apP, apM, cI, telf, email, especialidad};

		} else {
			return false;
		}
	}
	
	public String [] listaCI(String[][] listaInscritos){
		String listaCI [] = new String [listaInscritos[0].length];
		for(int i = 0; i < listaInscritos[0].length;i++){
			listaCI [i] = listaInscritos[i][4];
		}
		return listaCI;
	}
	
}
