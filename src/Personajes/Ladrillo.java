package Personajes;

import java.util.Random;

import Juego.Mapa;
import Juego.Seccion;
import Ventana.Ventana;

public class Ladrillo {
	private Posicion posLadrillo= new Posicion();
	private static int rapidezCaida;
	
	public int getRapidezCaida() {
		return rapidezCaida;
	}
	/**
	 * Incrementa la posicion en Y del ladrillo
	 */
	public void incrementarPosY(){
		posLadrillo.setPosY(posLadrillo.getPosY()+75);
	}
	/**
	 * Disminuye la posicion en Y del ladrillo
	 */
	public void decrementarPosY(){
		posLadrillo.setPosY(posLadrillo.getPosY()-75);
	}
	public  static void setRapidezCaida(int r) {
		rapidezCaida = r;
	}
	
	public Posicion getPosLadrillo() {
		return posLadrillo;
	}
	
	public void setPosLadrillo(int x, int y){
		posLadrillo.setPosX(x);
		posLadrillo.setPosY(y);
	}
	
	/**
	 * Mueve el ladrillo en el eje Y
	 * @param Posicion en el arreglo de ladrillos
	 */
	public void mover(int i){

		Ralph.getInstanciaRalph().getLadrillo(i).getPosLadrillo().setPosY(Ralph.getInstanciaRalph().getLadrillo(i).getPosLadrillo().getPosY()+5);
		if (Ralph.getInstanciaRalph().getLadrillo(i).getPosLadrillo().getPosY()>340){
			Ralph.getInstanciaRalph().eliminarLadrillo(i);
		}			
	}
	/**
	 * Decide si el ladrillo romperá una ventana o no
	 */
	public void romperVentana(){
		Ventana ven = Mapa.buscarVentanaMasCercana(this.getPosLadrillo());
		Random rand=new Random();
		int r=rand.nextInt(2);
		if (r==1)
			ven.romper();	
	}
}
