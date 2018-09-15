package Controladores;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Grafica.PantallaPrincipal;
/**
 * Adapter del boton cancelar de configuracion
 *
 */
public class CancelarConfigAdapter extends MouseAdapter{

	public void mouseClicked(MouseEvent c ){
		PantallaPrincipal.getFrameConfig().setVisible(false);
	}

}	

