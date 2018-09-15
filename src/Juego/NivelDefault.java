package Juego;

import Personajes.Felix;
import Personajes.Ralph;
/**
 * Valores por default del juego
 *
 */
public class NivelDefault {
	private int CANTVENTQUEROMPERALPH=7;
	private int VELCAIDALADRILLO=10; //el ladrillo se mueve por pixeles
	private int CANTVENTANASCONDIFICULTAD=5;
	private int TIEMPO=120;
	private int FRECUENCIATIRARRALPHLADRILLO=2;
	private int PUNTOS=0;
	private int VIDAS=3;	
	private int NIVEL=1;	
	private int CANTLADRILLOS=40;

	
	private static NivelDefault instanciaDefault=new NivelDefault();
	private NivelDefault(){		
	}		
	public static NivelDefault getInstanciaDefault() {
		return instanciaDefault;
	}

	
	public int getCANTLADRILLOS() {
		return CANTLADRILLOS;
	}
	public int getNIVEL() {
		return NIVEL;
	}
	
	public void valoresDelReset(){
		Seccion.setCantVentanasRotas(0);
		Ralph.getInstanciaRalph().setLadrillosDisponibles(CANTLADRILLOS);
		Felix.getInstanciaFelix().setPosFelix(250, 250); //posicion inicial de felix					
	}
	

	public  void empezarAJugar(){	//setea todos los valores como al principio (nivel por default)
		NivelActual.getInstanciaNivel().setNum(NIVEL);
		Felix.getInstanciaFelix().setPosFelix(250, 250); //posicion inicial de felix						
		Ralph.getInstanciaRalph().setPosRalph(135, 6);					
		Ralph.getInstanciaRalph().setFrecuenciaTirarLadrillos(FRECUENCIATIRARRALPHLADRILLO);
		NivelActual.getInstanciaNivel().setCantVentConDif(CANTVENTANASCONDIFICULTAD);
		NivelActual.getInstanciaNivel().setVelCaeLadrillo(VELCAIDALADRILLO);
		NivelActual.getInstanciaNivel().setCantVentanasRotas(CANTVENTQUEROMPERALPH);
		Juego.getInstanciaJuego().setTiempo(TIEMPO);
		Juego.getInstanciaJuego().setVidas(VIDAS);
		Juego.getInstanciaJuego().setScore(PUNTOS);
		Ralph.getInstanciaRalph().setLadrillosDisponibles(CANTLADRILLOS);
	}
	

	public int getCANTVENTQUEROMPERALPH() {
		return CANTVENTQUEROMPERALPH;
	}

	public int getVelCaidaLadrillo() {
		return VELCAIDALADRILLO;
	}

	public int getCantVentanasConDificultad() {
		return CANTVENTANASCONDIFICULTAD;
	}

	public int getTiempo() {
		return TIEMPO;
	}

	public int getFrecuenciaTirarRalphLadrillo() {
		return FRECUENCIATIRARRALPHLADRILLO;
	}

	public int getPuntos() {
		return PUNTOS;
	}
	public int getVidas() {
		return VIDAS;
	}

}
