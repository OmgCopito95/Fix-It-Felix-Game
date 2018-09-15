package Controladores;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Grafica.VentanaTop5;
/**
 * Adapter del Boton Top 5 de Pantalla Principal
 *
 */
public class TopFiveAdapter extends MouseAdapter{
	public void mouseClicked (MouseEvent c){		
		VentanaTop5 vent = new VentanaTop5();
		
	}
}