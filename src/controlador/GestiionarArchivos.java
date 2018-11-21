package controlador;

import java.util.ArrayList;

public class GestiionarArchivos {
	
	ArrayList<String []> listaDeArchivosBD, listaFiltrada;
	
	public GestiionarArchivos(ArrayList<String []> listaDeArchivosBD){
		
		this.listaDeArchivosBD = new ArrayList<String []>();
		this.listaDeArchivosBD = listaDeArchivosBD;
		listaFiltrada = new ArrayList<String []>();
		
	}
	
	public void filtrarFormato(String formato){
		int indice = 0;
		if(!formato.equals("*")){
			while(indice < listaDeArchivosBD.size()){
			
				if((listaDeArchivosBD.get(indice)[5].equals(formato))){
					listaFiltrada.add(listaDeArchivosBD.get(indice));
				}
				indice ++;
			}
		}else listaFiltrada=listaDeArchivosBD;
	}
	
	public ArrayList<String []> verSolo(){
		
		return listaFiltrada;
		
	}
	

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		ArrayList<String []> listaDeArchivosBD =new ArrayList<String []>();
//		listaDeArchivosBD.add(new String [] {"1", "archivo 1", "12/09/2008","2008","no",
//							"tipo 2", "pdf"});
//		listaDeArchivosBD.add(new String [] {"2", "archivo 2", "12/09/2008","2017","si",
//				"tipo 1", "docx"});
//		listaDeArchivosBD.add(new String [] {"3", "archivo 3", "12/09/2008","2005","si",
//				"tipo 1", "pdf"});
//		
//		listaDeArchivosBD.add(new String [] {"3", "archivo de consultas", "12/09/2008","2005","si",
//				"tipo 5", "pdf"});
//		
//		GestiionarArchivos ls = new GestiionarArchivos(listaDeArchivosBD);
//		ls.filtrarFormato("*");
//		ArrayList<String []> listaObtenida = new ArrayList<String[]>();
//		listaObtenida = ls.verSolo();
//		int indice = 0;
//		while(indice <listaObtenida.size()){
//			System.out.println(listaObtenida.get(indice)[0]+" / "+listaObtenida.get(indice)[1]+" / "+listaObtenida.get(indice)[2]+" / "+
//					listaObtenida.get(indice)[3]+" / "+listaObtenida.get(indice)[4]+" / "+listaObtenida.get(indice)[5]+" / "+
//					listaObtenida.get(indice)[6]+"\n");
//			indice ++;
//		}
	}
}
