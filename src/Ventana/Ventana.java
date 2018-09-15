package Ventana;

import Ventana.Panel;
import Juego.Direcciones;
import Personajes.Posicion;

public abstract class Ventana {
	
	Panel[][] estadoVidrio;				//mirar esto!
	
	public Posicion posV = new Posicion();
	public abstract void reparar();
	public abstract boolean puedePasar(Direcciones i); //el donde segun el numero indica para donde ir. esta especificado en cada metodo
	public abstract void agregarDificultad();
	public abstract void romper();
	public abstract int getCantidadDePaneles();
	
	public Posicion getPosV() {
		return posV;
	}
	public void setPosV(Posicion posV) {
		this.posV = posV;
	}
	public boolean esComun(){
		return false;
	}
	public boolean esConHojas(){
		return false;
	}
	public abstract Panel getPanel(int x, int y);
}
