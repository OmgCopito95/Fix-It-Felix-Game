package Juego;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Timer;

import Grafica.FrameGanaJugador;
import Grafica.VentanaTop5;
import Juego.HighScore;
import Personajes.Felix;
import Personajes.Posicion;
import Personajes.Ralph;

public class Juego {

	private static int vidas;
	private int tiempo;
	private static Juego instancia = new Juego();
	private int scoreActual;
	private List<HighScore> mejoresPuntajes = new ArrayList<HighScore>();
	
	private Timer timer=new Timer(); //va a contar el tiempo
	
	public Timer getTimer() {
		return timer;
	}
	public void setTimer(Timer timer) {
		this.timer = timer;
	}
	/**
	 * Si Felix pierde las tres vidas, termina el juego
	 */
	public void finDeJuego(){
		Juego.getInstanciaJuego().getTimer().cancel();
		new FrameGanaJugador();		
		
	}
	/**
	 * Chequea si Felix choca con un pajaro o un ladrillo
	 */
	public boolean huboColision(){
		Posicion posFelix=Felix.getInstanciaFelix().getPosFelix();		
		for(int i=0;i<ArregloDePajaros.getInstancia().cantidadArreglo();i++){ //recorro todo el arreglo de pajaros para ver con cual choca
			Posicion posPajaro=ArregloDePajaros.getInstancia().getPajaro(i).getPos();
			
//			if(  (posPajaro.getPosX()+10<posFelix.getPosX()+10 || posPajaro.getPosX()+10 <posFelix.getPosX()-10)  && (posPajaro.getPosX()-10 > posFelix.getPosX()+10 || posPajaro.getPosX()-10 > posFelix.getPosX()-10) ) 
//				if((posPajaro.getPosY()+10<posFelix.getPosY()+10 || posPajaro.getPosY()+10 <posFelix.getPosY()-10)  && (posPajaro.getPosY()-10 > posFelix.getPosY()+10 || posPajaro.getPosY()-10 > posFelix.getPosY()-10)){					
					//se choco al pajaro
			if( (posPajaro.getPosX()<posFelix.getPosX()+34 && posFelix.getPosX()<posPajaro.getPosX()+34) || (posPajaro.getPosX()<posFelix.getPosX()+34 && posFelix.getPosX()<posPajaro.getPosX()+34) )
				if( (posPajaro.getPosY()-21<posFelix.getPosY() && posFelix.getPosY()<posPajaro.getPosY()+21) || (posPajaro.getPosY()<posFelix.getPosY()+52 && posFelix.getPosY()<posPajaro.getPosY()+21) ){
					System.out.println("choco contra un pajaro");
					Felix.getInstanciaFelix().resetFelixPajaro();	
					return true;
				}			
		}	
		for(int j=0;j<Ralph.getInstanciaRalph().getCantLadrillosEnArreglo();j++){
			Posicion posLadrillo=Ralph.getInstanciaRalph().getLadrillo(j).getPosLadrillo();
			if( (posLadrillo.getPosX()-20<posFelix.getPosX() && posFelix.getPosX()<posLadrillo.getPosX()+20) || (posLadrillo.getPosX()<posFelix.getPosX()+34 && posFelix.getPosX()+34<posLadrillo.getPosX()+20) )
				if( (posLadrillo.getPosY()-13<posFelix.getPosY() && posFelix.getPosY()<posLadrillo.getPosY()+15) || (posLadrillo.getPosY()<posFelix.getPosY()+52 && posFelix.getPosY()+52<posLadrillo.getPosY()+13) ){
					System.out.println("choco contra un ladrillo");
					Felix.getInstanciaFelix().resetFelixLadrillo();
					return true;
				}
		}
		return false;		
	}

	public static Juego getInstanciaJuego(){
		return instancia;
	}
	private Juego(){		
	}	
	
	public int getTiempo() {
		return tiempo;
	}
	public void setTiempo(int t) {
		tiempo = t;
	}
	public  int getScoreActual() {
		return scoreActual;
	}	
	
	public  void setScore(int score){
		scoreActual=score;
	}
	public  void aumentarScore(int p){
		scoreActual+=p;
	}	
	public  int getVidas() {
		return vidas;
	}	
	public  void setVidas(int v) {
		vidas = v;
	}	
	
	/**
	 * Guarda los puntajes altos en un archivo auxiliar
	 */
	public void guardarPuntajes(){
		
		ObjectOutputStream salida = null;
		try {
			salida = new ObjectOutputStream (new FileOutputStream("puntajes.txt"));
			salida.writeObject(mejoresPuntajes);
		}
		catch (IOException e){
			System.err.println("El archivo no existe");
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Lee los puntajes altos desde un archivo y los carga a la lista de
	 * mejores puntajes.
	 */
	public void cargarPuntajes(){
		
		ObjectInputStream entrada = null;
		try {
			entrada = new ObjectInputStream (new FileInputStream("puntajes.txt"));
			List<HighScore> listaAux = (List<HighScore>)entrada.readObject();
			mejoresPuntajes=listaAux;
		}
		catch (FileNotFoundException e){
			File archivo = new File("puntajes.txt");
		}
		catch (ClassNotFoundException e2){
			System.out.println("Clase no encontrada");
		}
		catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
	
	/**
	 * Agrega a un jugador a la lista de mejores puntajes
	 * @param jugador Objeto de tipo HighScore 
	 */
	public void newRecord(HighScore jugador){

		this.cargarPuntajes();
		mejoresPuntajes.add(jugador);
		Collections.sort(mejoresPuntajes);
		if (mejoresPuntajes.size()>5)
			mejoresPuntajes.remove(mejoresPuntajes.size()-1);
		this.guardarPuntajes();
		}
	
	/**
	 * @param pos Posicion en la lista
	 * @return Jugador ubicado en la posicion pos en la lista de puntajes altos
	 */
	public HighScore getJugador(int pos){
		HighScore jugador=new HighScore();
		jugador.setNombreJugador(mejoresPuntajes.get(pos).getNombreJugador());
		jugador.setPuntos(mejoresPuntajes.get(pos).getPuntos());	
		return jugador;
	}
	
	public int getCantElementosEnLista(){
		return mejoresPuntajes.size();
	}

}
