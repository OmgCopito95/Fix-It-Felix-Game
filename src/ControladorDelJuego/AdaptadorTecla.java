package ControladorDelJuego;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import Grafica.ComenzarAJugar;
import Juego.Direcciones;

import Juego.Juego;
import Personajes.Felix;
/**
 * Adapter del teclado
 *
 */
public class AdaptadorTecla extends KeyAdapter{

//	JFrame frame=new JFrame(); //deberia estar relacionado con el frame principal donde se va a jugar el juego
	private static boolean pressedSpacebar=false;
	private static boolean pressedArrow=false;
//	private ComenzarAJugar j=new ComenzarAJugar();
	
	
	public void keyPressed(KeyEvent e) {
		
		int tecla = e.getKeyCode();
		switch (tecla){
		case KeyEvent.VK_DOWN:		
//			pressedArrow=true;
			Felix.getInstanciaFelix().felixSeMovio(Direcciones.ABAJO);	//llamo al metodo de felix se movio en la clase felix
			break;
			
		case KeyEvent.VK_UP:
//			pressedArrow=true;
			Felix.getInstanciaFelix().felixSeMovio(Direcciones.ARRIBA);
			break;
			
		case KeyEvent.VK_LEFT:
//			pressedArrow=true;
			Felix.getInstanciaFelix().felixSeMovio(Direcciones.IZQUIERDA);	
			break;
		
		case KeyEvent.VK_RIGHT:
//			pressedArrow=true;
			Felix.getInstanciaFelix().felixSeMovio(Direcciones.DERECHA);
			break;
			
		case KeyEvent.VK_SPACE:
 			pressedSpacebar=true;
			Felix.getInstanciaFelix().repararVentana();	
			break;
		}
	}
	
	public static boolean isSpacebarPressed(){
		if (pressedSpacebar)
			return true;
		else return false;
	}
	
	public static boolean isArrowPressed(){
		if (pressedArrow)
			return true;
		else return false;
	}

	public static void setPressedSpacebar(boolean pressedSpacebar) {
		AdaptadorTecla.pressedSpacebar = pressedSpacebar;
	}

	public static void setPressedArrow(boolean pressedArrow) {
		AdaptadorTecla.pressedArrow = pressedArrow;
	}

}