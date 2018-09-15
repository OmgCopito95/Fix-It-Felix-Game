package Personajes;

import Juego.Seccion1;
import Personajes.EstadoFelix;
import Personajes.Pastel;
import Juego.Direcciones;
import Juego.Juego;
import Juego.Mapa;
import Juego.NivelActual;
import Juego.NivelDefault;
import Juego.Seccion;
import Ventana.Comun;
import Ventana.ConHojas;
import Ventana.Ventana;


public class Felix extends Personajes {
	
	private static Posicion posFelix=new Posicion();
	private EstadoFelix estado;
	private Direcciones ultimaDireccion;
	
	private static Felix instanciaFelix=new Felix();
	private Felix(){		
	}		
	public static Felix getInstanciaFelix() {
		return instanciaFelix;
	}
	/**
	 * Incrementa la posicion en X de Felix
	 */
	public static void incrementarPosX(){
		posFelix.setPosX(posFelix.getPosX()+50);
	}
	/**
	 * Disminuye la posicion en X de Felix
	 */
	public static void decrementarPosX(){
		posFelix.setPosX(posFelix.getPosX()-50);
	}
	/**
	 * Incrementa la posicion en Y de Felix
	 */
	public static void incrementarPosY(){
		posFelix.setPosY(posFelix.getPosY()+75);
	}
	/**
	 * Disminuye la posicion en X de Felix
	 */
	public static void decrementarPosY(){
		posFelix.setPosY(posFelix.getPosY()-75);
	}
	public EstadoFelix getEstado() {
		return estado; //Devuelve el estado (Normal o Inmunidad) en el que se encuentra Felix
	}

	public void setEstado(EstadoFelix estado) {
		this.estado = estado;
	}

	public Posicion getPosFelix(){
		return posFelix;	//Devuelve la posicion de Felix
	}
	
	public void setPosFelix(int x, int y){
		instanciaFelix.getPosFelix().setPosX(x);
		instanciaFelix.getPosFelix().setPosY(y);
	}
	/**
	 * Repara la ventana donde se encuentra Felix
	 */
	public void repararVentana(){
		Ventana ven = Mapa.buscarVentanaMasCercana(this.getPosFelix());	//Busca la ventana mas cercana a la posicion de Felix 
		if (ven != null)	//Si la ventana no está nula, se llama al método reparar 
			ven.reparar();			
	}
	
	/**
	 * Cambia el estado de Felix a Inmune
	 */
	public void activarPoder(){
		this.setEstado(EstadoFelix.INMUNIDAD);
		Pastel.usarPastel();
	}
	/**
	 * Si Felix es tocado por un Pajaro, reinicia el juego en la misma seccion con una vida menos
	 */
	public void resetFelixPajaro(){
		int v = Juego.getInstanciaJuego().getVidas();
		Juego.getInstanciaJuego().setVidas(v-1);
		if(Juego.getInstanciaJuego().getVidas()==0)
			Juego.getInstanciaJuego().finDeJuego();
		else{
			this.setPosFelix(posFelix.getPosX(), posFelix.getPosY());
		}
			this.setPosFelix(250, 250);
	}
	/**
	 * Si Felix es tocado por un Ladrillo, reinicia el juego en la seccion 1 con una vida menos
	 */
	public void resetFelixLadrillo(){
		int v = Juego.getInstanciaJuego().getVidas();
		Juego.getInstanciaJuego().setVidas(v-1);
		if(Juego.getInstanciaJuego().getVidas()==0)
			Juego.getInstanciaJuego().finDeJuego();
		else{		
			NivelDefault.getInstanciaDefault().valoresDelReset();
			Seccion.setNum(1);
			Seccion1 sec = new Seccion1();
			sec.construirMatriz();
		}
	}
	/**
	 * Mueve a Felix
	 * @param DERECHA, IZQUIERDA, ARRIBA, ABAJO
	 */
	@Override
	public void mover (Direcciones i) { 
		Posicion posicionSig=new Posicion();
		switch (i){
		case DERECHA:	//se corre a la derecha
			posicionSig.setPosX(posFelix.getPosX()+50);
			posicionSig.setPosY(posFelix.getPosY());
			if(Mapa.existe(posicionSig)==true){
				if(Seccion.getVentana(posicionSig)!=null)						
					if(Seccion.getVentana(posicionSig).puedePasar(i)){
						Ventana v=Seccion.getVentana(posFelix);
						if(v.esConHojas()==true){
							ConHojas vActual=(ConHojas) v;
							if(vActual.isAbierta()==false){
								incrementarPosX();
								ultimaDireccion=Direcciones.DERECHA;
							}
						}else{
							incrementarPosX();
							ultimaDireccion=Direcciones.DERECHA;
						}
					}				
			}
			break;
		case IZQUIERDA:

			posicionSig.setPosX(posFelix.getPosX()-49);
			posicionSig.setPosY(posFelix.getPosY());
			if(Mapa.existe(posicionSig)==true){
				if(Seccion.getVentana(posicionSig)!=null){
					if(Seccion.getVentana(posicionSig).puedePasar(i)){
						Ventana v=Seccion.getVentana(posFelix);
						if(v.esConHojas()==true){
							ConHojas vActual=(ConHojas) v;
							if(vActual.isAbierta()==false){
								decrementarPosX();
								ultimaDireccion=Direcciones.IZQUIERDA;
							}
						}else{
							decrementarPosX();
							ultimaDireccion=Direcciones.IZQUIERDA;
						}					
					}	
				}
			}
			ultimaDireccion=Direcciones.IZQUIERDA;
			break;
		case ARRIBA:	
			posicionSig.setPosX(posFelix.getPosX());
			posicionSig.setPosY(posFelix.getPosY()-75);
			if(Mapa.existe(posicionSig)==true){
				if(Seccion.getVentana(posicionSig)!=null){
					if(Seccion.getVentana(posicionSig).puedePasar(i)){
						Ventana v=Seccion.getVentana(posFelix);
						if(v.esComun()){
							Comun vActual=(Comun) v;
							if(vActual.isConMoldura()==false)
								decrementarPosY();
						}else 	
							decrementarPosY();
					}	
				}
			}
			break;
		case ABAJO:	
			posicionSig.setPosX(posFelix.getPosX());
			posicionSig.setPosY(posFelix.getPosY()+75);
			if(Mapa.existe(posicionSig)==true){
				if(Seccion.getVentana(posicionSig)!=null){
					if(Seccion.getVentana(posicionSig).puedePasar(i)){
						Ventana v=Seccion.getVentana(posFelix);
						if(v.esComun()){
							Comun vActual=(Comun) v;
							if(vActual.isConMacetero()==false)
								incrementarPosY();
						}else {
							incrementarPosY();
						}
					}
				}				
			}		
			break;
		}
	}
	
	public void felixSeMovio(Direcciones d){
		this.mover(d);		//en el mover tambien tengo que controlar que pasa si se cruza con algo en el camino
	}
	
	public Direcciones getUltimaDireccion() {
		return ultimaDireccion;
	}
	
}	

