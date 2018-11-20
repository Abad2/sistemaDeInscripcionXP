package vista;
import javax.swing.*;
import java.awt.Image;

public class LabelImagen {
	private float x, y;
	public LabelImagen(float x, float y){
		this.x = x;
		this.y = y;
	}
	protected JLabel labelImagen(String nombreArchivo){
		JLabel imagen = new JLabel();
		ImageIcon fondo, propiedadesFondo;
		Herramientas dimPan = new Herramientas();
		
		imagen = new JLabel();
		imagen.setSize(dimPan.PenX(x), dimPan.PenY(y));
        fondo = new ImageIcon(dimPan.navegarPorProyecto(nombreArchivo));
        propiedadesFondo = new ImageIcon(fondo.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_DEFAULT));
        imagen.setIcon(propiedadesFondo);
        imagen.setHorizontalAlignment(SwingConstants.CENTER);
		
		return imagen;
	}
	
	protected void setX(float x) {
		this.x = x;
	}
	
	protected void setY(float y) {
		this.y = y;
	}
	
}
