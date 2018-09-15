package Juego;

import java.util.*;

import Personajes.Pajaro;
/**
 * Arreglo que contiene los pajaros que se crean para poder manejarlos y dibujarlos
 * @author pc
 *
 */
public class ArregloDePajaros {

	List<Pajaro> arreglo = new ArrayList<Pajaro>();
	
	private static ArregloDePajaros instanciaArreglo = new ArregloDePajaros();
	
	public static ArregloDePajaros getInstancia(){
		return instanciaArreglo;
	}
	
	private ArregloDePajaros(){		
	}

	public int cantidadArreglo(){
		return arreglo.size();
	}
	/**
	 * Agrega un pajaro al arreglo
	 */
	public void agregar (Pajaro p){
		arreglo.add(p);
	}
	
	/**
	 * Devuelve el pajaro ubicado en la posicion del arreglo pasada como parametro 
	 */
	public Pajaro getPajaro(int pos){
		return arreglo.get(pos);
	}
	/**
	 * Elimina un pajaro del arreglo
	 */
	public void eliminarPajaro(int pos){
		arreglo.remove(pos);
	}
	
}
