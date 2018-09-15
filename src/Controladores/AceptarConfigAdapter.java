package Controladores;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import ControladorDelJuego.Controlador;
import Grafica.PantallaPrincipal;
/**
 * Adapter del boton aceptar de configuración
 *
 */
public class AceptarConfigAdapter extends MouseAdapter{
	String valueNivel;
	
	public void mouseClicked(MouseEvent c){
		valueNivel=PantallaPrincipal.getNivelList().getSelectedItem().toString();
		Controlador.getInstanciaControlar().setNivel(valueNivel);	
		PantallaPrincipal.getFrameConfig().setVisible(false);
	}

}