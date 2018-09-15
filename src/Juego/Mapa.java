package Juego;

import Juego.Seccion;
import Personajes.Posicion;
import Ventana.Ventana;

public class Mapa {
	private static int ancho=450;
	private static int largo=325;
	
		
	public static int getAncho() {
		return ancho;
	}
	public static void setAncho(int a) {
		ancho = a;
	}
	public static int getLargo() {
		return largo;
	}
	public static void setLargo(int l) {
		largo = l;
	}
	/**
	 * Busca la ventana mas cercana a la posicion pasada como parametro
	 */
	public static Ventana buscarVentanaMasCercana(Posicion pos){
		
		int posMatrizY;
		int posMatrizX;
		int anchoVentanaPixels = 41;
		int altoVentanaPixels = 51;
		if(pos.getPosY()==100){
			posMatrizY = (pos.getPosY() / altoVentanaPixels)-1;
		}else{
			posMatrizY = (pos.getPosY() / altoVentanaPixels)-2;
		}
		if(pos.getPosX()<=200)
			posMatrizX = (pos.getPosX() / anchoVentanaPixels)-1;
		else
			posMatrizX = (pos.getPosX() / anchoVentanaPixels)-2;

		if(posMatrizY<0)
			posMatrizY=0;

		Ventana v = Seccion.getVentanaEnPos(posMatrizY,posMatrizX);
		return v;
	}
	/**
	 * Devuelve si la posicion pasada como parametro existe
	 */
	public static boolean existe(Posicion p){ //me fijo si no se va del mapa la posicion 
		if(p.getPosX()<(ancho-155) && p.getPosY()<largo && p.getPosX()>0 && p.getPosY()>0){			
			return true;
		}else
			return false;
	}
}
