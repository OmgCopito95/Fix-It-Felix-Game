package Controladores;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;

import ControladorDelJuego.AdaptadorTecla;
import ControladorDelJuego.ArranqueDelJuego;
import ControladorDelJuego.Controlador;
import ControladorDelJuego.Reloj;
import Grafica.ComenzarAJugar;
import Juego.Juego;
import Juego.NivelDefault;
import Juego.Seccion;
import Juego.Seccion1;
/**
 * Adapter del boton Quiero Jugar de Pantalla Principal
 *
 */
public class QuieroJugarAdapter extends MouseAdapter{
	public void mouseClicked(MouseEvent c ){
		//new Controlador();			
//		ComenzarAJugar comenzarAJugar=new ComenzarAJugar();
		
		ArranqueDelJuego a=new ArranqueDelJuego();
		Reloj r=new Reloj();
		Juego.getInstanciaJuego().getTimer().scheduleAtFixedRate(a, 0, 200);
		Juego.getInstanciaJuego().getTimer().scheduleAtFixedRate(r, 0, 1000);
		
		NivelDefault.getInstanciaDefault().empezarAJugar();
		Controlador.getInstanciaControlar().enviarNivel();
		Seccion1 s1=new Seccion1();
		s1.construirMatriz();
		Seccion.setNum(1);
		ComenzarAJugar.getInstancia().addKeyListener(new AdaptadorTecla());	
	
	}
}