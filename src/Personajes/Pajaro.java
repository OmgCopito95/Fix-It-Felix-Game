package Personajes;

import java.util.Random;

import Juego.ArregloDePajaros;
import Juego.Direcciones;
import Juego.Mapa;


public class Pajaro extends Personajes{
	
	private Posicion posPajaro=new Posicion();
	private int velocidad;
	private boolean izquierda;
	private Direcciones ultimaDir;
		
	public Direcciones getUltimaDir() {
		return ultimaDir;
	}

	public boolean isIzquierda() {
		return izquierda;
	}
	/**
	 * Constructor del pajaro. Decide si comienza desde la derecha o la izquierda.
	 */
	public Pajaro(){
		Random r=new Random();
		boolean d=r.nextBoolean();
		if(d==true){//empieza yendo a la izquierda
			izquierda=true;
			posPajaro.setPosX(Mapa.getAncho());
			ultimaDir=Direcciones.IZQUIERDA;
		}else{
			izquierda=false;
			posPajaro.setPosX(0);
			ultimaDir=Direcciones.DERECHA;
		}
		if (ArregloDePajaros.getInstancia().cantidadArreglo()==0){
			posPajaro.setPosY(126);		
		}
		else if (ArregloDePajaros.getInstancia().cantidadArreglo()==1){
			posPajaro.setPosY(189);
		}
	}
	
	public Posicion getPos(){
		return posPajaro;
	}
	
	public void setPos(int x, int y){
		posPajaro.setPosX(x);
		posPajaro.setPosY(y);
	}
	
	public int getVelocidad(){
		return velocidad;
	}
	
	public void setVelocidad(int vel){
		this.velocidad = vel;
	}
	/**
	 * Incrementa la posicion en X del pajaro
	 */
	public void incrementarPosX(){
		posPajaro.setPosX(posPajaro.getPosX()+10);
	}
	/**
	 * Disminuye la posicion en X del pajaro
	 */
	public void decrementarPosX(){
		posPajaro.setPosX(posPajaro.getPosX()-10);
	}
	/**
	 * Mueve al pajaro en el eje X
	 */
	@Override
	public void mover(Direcciones i) {
		
		if(posPajaro.getPosX()>295){ //llego al borde
			izquierda=true;			
			ultimaDir=Direcciones.IZQUIERDA;
		}
		else
			if(posPajaro.getPosX()<0){
				izquierda=false;
				ultimaDir=Direcciones.DERECHA;
			}
		if(izquierda==true){
			decrementarPosX();
		}
		else{
			incrementarPosX();
		}
	}
	
}
