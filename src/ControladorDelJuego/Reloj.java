package ControladorDelJuego;

import java.util.Timer;
import java.util.TimerTask;

import Juego.Juego;
/**
 * Reloj que controla el tiempo del juego
 *
 */
public class Reloj extends TimerTask{

	public void run(){		
		if (Juego.getInstanciaJuego().getTiempo() > 0){			
			Juego.getInstanciaJuego().setTiempo(Juego.getInstanciaJuego().getTiempo()-1);
		}
	}
}
