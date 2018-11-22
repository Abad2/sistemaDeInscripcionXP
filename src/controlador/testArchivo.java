package controlador;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testArchivo 
{
	GestiionarArchivos formatoArchivo;
	@Before
	public void Before()
	{
		formatoArchivo= new GestiionarArchivos(null);
		//listaDeArchivosBD);
	}
	@Test
	public void test ()
	
	{
		GestiionarArchivos formatoArchivo = new GestiionarArchivos(null);
		 formatoArchivo.filtrarFormato(null);
	}
}
//@Test
//public void formatoEspecifico() 
//{