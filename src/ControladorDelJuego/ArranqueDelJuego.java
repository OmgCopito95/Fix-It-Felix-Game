package ControladorDelJuego;

import java.util.TimerTask;

import Grafica.ComenzarAJugar;
import Juego.*;
import Personajes.Ladrillo;
import Personajes.Ralph;
/**
 * Hilo principal del juego
 *
 */
public class ArranqueDelJuego extends TimerTask {

	private int i=0; 

	@Override
	public void run() {	

		Ralph.getInstanciaRalph().turno();
		for (i = 0; i <Ralph.getInstanciaRalph().getCantLadrillosEnArreglo() ; i++) {
				Ralph.getInstanciaRalph().getLadrillo(i).mover(i);
		}
		
		if (Seccion.getCantVentanasRotas() == 0) { // pasa de seccion o de nivel
			if (NivelActual.getInstanciaNivel().getNum() < 10) {
				Controlador.getInstanciaControlar().controlarSeccion();
			}
		} else {
			if (Juego.getInstanciaJuego().getTiempo() == 0) {
				Controlador.getInstanciaControlar().controlarTiempo();
			}
		}						
		for (int pa=0;pa<ArregloDePajaros.getInstancia().cantidadArreglo();pa++){
			ArregloDePajaros.getInstancia().getPajaro(pa).mover(null);
		}
		
		ComenzarAJugar.getInstancia().repaint();
		Juego.getInstanciaJuego().huboColision();
	}

}
