package modelo;

import java.sql.*;

import javax.swing.JOptionPane;

public class ConeccionBDPostgres {
	private Connection con;
	private Statement st;
	private ResultSet rs;
	private String bd, nombreUsuario, password;

	public ConeccionBDPostgres() {
		con = null;
		st = null;
		rs = null;
		bd = "bdConferencia";
		nombreUsuario = "postgres";
		password = "admin";
		conectar();
	}

	private void conectar() {// Conecta con la base de datos
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + bd, nombreUsuario, password);
			System.out.println("Se conecto con exito");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("No se conecto con exito\n" + e);
		}
	}

	public ResultSet mostrarDatos(String nombreTabla, String [] elementos) {
		String datos = "";
		rs = null;
		for(int i = 0; i < elementos.length; i++){
			if(i< elementos.length -1){
				datos += elementos [i]+", ";
			}else{
				datos += elementos [i];
			}
		}
		try {
			st = con.createStatement();
			rs = st.executeQuery("select "+datos+" from " + nombreTabla);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet inicioSesion(String nombre, String pass){
		try{
			st = con.createStatement();
			rs = st.executeQuery("SELECT id_usuario, USUARIO, CLAVE, TIPO  FROM USUARIO WHERE USUARIO = '"+nombre+"' AND CLAVE = '"+pass+"';");
			System.out.println("Se hizo la consulta");
			return rs;
		}catch(Exception e){
			System.out.println("No se optenieron los datos de login de la BD");
			return rs;
		}
	}
	
	public boolean guargarDatosExpositor(String [] datos){//String nombre, String apPat, String apMat, String direccion, String telefono, String especial, String idadmin, String email){//egistro conferencista
		String query =  "insert into conferencista(nomconfe, apellidopatconfe, apellidomatconfe, dirconfe, "
				+ "telfconfe, especialidadconf, idadmin, email) values "
				+  "('"+datos [0]+"', '"+datos[1]+"', '"+datos[2]+"', '"+datos[3]+"', "+datos[4]+", '"+datos[5]+
				"', "+datos[6]+", '"+datos[7]+"');";
		System.out.println(query);
		try {
			st=con.createStatement();
			st.executeUpdate(query);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}
	public int cantidaFilas(String tabla){
		int cantidad = 0;
		try{
			st = con.createStatement();
			rs = st.executeQuery("select count(*) as numero from "+tabla);
			while(rs.next()){
				cantidad = Integer.parseInt(rs.getString("numero"));
			}
		}catch(Exception e){
		}
		System.out.println("Cantidad en BD: "+cantidad);
		return cantidad;
	}
	public boolean guardarEstudiante(String [] datos){
		String query =  "insert into estudiante(nombreestud, apellidopatestud, apellidomatestud, ciestud, "
				+ "curso, telefestud, email, idsecre) values "
				+  "('"+datos [0]+"', '"+datos[1]+"', '"+datos[2]+"', '"+datos[3]+"', '"+datos[4]+"', '"+datos[5]+
				"', '"+datos[6]+"', "+datos[7]+");";
				//+ "("+nombre+", "+apPat+", "+apMat+", "+direccion+", "+telefono+", "+especial+", "+idadmin+", "+email+");";
		try {
			st=con.createStatement();
			st.executeUpdate(query);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
		}
		
	}
}
