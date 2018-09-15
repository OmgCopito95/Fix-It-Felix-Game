//package Juego;
//
//public class HighScore {
//	private String nombreJugador;
//	private int puntos;
//	
//	public String getNombreJugador() {
//		return nombreJugador;
//	}
//	
//	public void setNombreJugador(String nombreJugador) {
//		this.nombreJugador = nombreJugador;
//	}
//	
//	public int getPuntos() {
//		return puntos;
//	}
//	
//	public void setPuntos(int puntos) {
//		this.puntos = this.puntos + puntos;
//	}
//	
//	
//}

package Juego;
/**
 * La clase HighScore genera un objeto que contiene el nombre del jugador y su puntaje
 */
import java.io.Serializable;

public class HighScore implements Serializable, Comparable<HighScore>{
	private String nombreJugador;
	private int puntos;

	public String getNombreJugador() {
		return nombreJugador;
	}
	public void setNombreJugador(String nombreJugador) {
		this.nombreJugador = nombreJugador;
	}
	
	public int getPuntos() {
		return puntos;
	}
	
	public void setPuntos(int puntos) {
		this.puntos = this.puntos + puntos;
	}
	
	public int compareTo(HighScore h){
		if (this.getPuntos() > h.getPuntos())
			return -1;
		else 
			if (this.getPuntos() < h.getPuntos())
				return 1;
			else 
				return 0;
	}
	
}
