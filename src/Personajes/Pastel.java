package Personajes;

import Ventana.Comun;
import Juego.Mapa;
import Personajes.Posicion;
import Ventana.Ventana;


public class Pastel {
	
	private static Posicion posPastel;
	private int duracionEnUso;
	private int duracionEnVentana;
	private static boolean usado;
	
	public static Posicion getPosPastel(){
		return posPastel;
	}

	public int getDuracionEnUso() {
		return duracionEnUso;
	}

	public void setDuracionEnUso(int duracionEnUso) {
		this.duracionEnUso = duracionEnUso;
	}

	public int getDuracionEnVentana() {
		return duracionEnVentana;
	}

	public void setDuracionEnVentana(int duracionEnVentana) {
		this.duracionEnVentana = duracionEnVentana;
	}

	public boolean isUsado() {
		return usado;
	}

	public static void setUsado(boolean u) {
		usado = u;
	}

	public static void setPosPastel(Posicion posPas) {
		posPastel = posPas;
	}

	/**
	 * Quita al pastel de la ventana en la que se encuentra
	 */
	public static void desaparecerPastel(){
			
		Posicion pos = getPosPastel();					//Guarda la posicion del pastel
		Ventana v = Mapa.buscarVentanaMasCercana(pos); 	//Busca la ventana en la que se encuentra el pastel
		if (v.esComun()){
			Comun c = (Comun)v;
			c.setConPastel(false);						//Saca el pastel de la ventana
		}
	}
	/**
	 * 
	 */
	public static void usarPastel(){
		setUsado(true);
		desaparecerPastel();
	}
	
	
}
