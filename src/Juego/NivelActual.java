package Juego;

import Personajes.Ladrillo;
import Personajes.Ralph;

public class NivelActual {
	private int num;
	private int tiempoNivel;
	private int frecuenciaRalphLanzarLadrillo;
	private int cantVentConDif;
	private int velCaeLadrillo;
	private int cantVentanasRotas;
	private int cantLadrillos;
	private static  NivelActual instanciaNivel=new NivelActual();
	
	public static NivelActual getInstanciaNivel() {
		return instanciaNivel;
	}
	
	private NivelActual(){
	}	
	
	public  void setNum(int numero) {	
		for(int i=0;i<numero-1;i++){	
			pasarDeNivel();			
		}
	}
	
	public  void setTiempoNivel(int tNivel) {
		tiempoNivel = tNivel;
	}
	public  void setFrecuenciaRalphLanzarLadrillo(int f) {
		frecuenciaRalphLanzarLadrillo = f;
	}
	public  void setCantVentConDif(int ventDif) {
		cantVentConDif = ventDif;
	}
	public  void setVelCaeLadrillo(int v) {
		velCaeLadrillo = v;
	}
	public  void setCantVentanasRotas(int cantVentRota) {
		cantVentanasRotas = cantVentRota;
	}	
	
	public  int getCantVentanasRotas() {
		return cantVentanasRotas;
	}
	public int getFrecuenciaRalphLanzarLadrillo() {
		return frecuenciaRalphLanzarLadrillo;
	}
	public int getVelCaeLadrillo() {
		return velCaeLadrillo;
	}
	public int getNum(){
		return num;
	}	
	public  int getTiempoNivel(){
		return tiempoNivel;
	}	
	/**
	 * Si se reparan todas las ventanas de la Seccion 3, se avanza de nivel.
	 * Se incrementan las ventanas dificiles, la velocidad de los ladrillos, las ventanas rotas y se disminuye el tiempo
	 * Se resetea los ladrillos que Ralph tiene disponibles
	 */
	public void pasarDeNivel(){
		aumentarNumNivel();
		disminuirTiempo();		
		incrementarfrecuenciaRalphLanzarLadrillo();
		incrementarVelCaeLadrillo();
		incrementarCantVentConDificultad();	
		incrementarCantVentanasRotas();
		Ralph.getInstanciaRalph().setLadrillosDisponibles(40);
		int cant=ArregloDePajaros.getInstancia().cantidadArreglo();
		for(int j=0;j<cant;j++){
			ArregloDePajaros.getInstancia().eliminarPajaro(0);
		}
		Ralph.resetearVariables();
	}	
	
	
	public int getCantLadrillos() {
		return cantLadrillos;
	}

	public void setCantLadrillos(int cantLadri) {
		cantLadrillos = cantLadri;
	}

	public  int getCantVentConDif() {
		return cantVentConDif;
	}
	private void aumentarNumNivel (){
		if (num<10)
			num++;
		else { 
			Juego.getInstanciaJuego().finDeJuego();
		}			
	}
	private void disminuirTiempo(){
		int aux=getTiempoNivel();
		aux=15*aux/100;
		tiempoNivel=tiempoNivel-aux;
	}
			
	private void incrementarfrecuenciaRalphLanzarLadrillo(){
		int aux=getFrecuenciaRalphLanzarLadrillo();
		aux=15*aux/100;
		frecuenciaRalphLanzarLadrillo=frecuenciaRalphLanzarLadrillo+aux;	
		Ralph.getInstanciaRalph().setFrecuenciaTirarLadrillos(frecuenciaRalphLanzarLadrillo);
	}	
	private void incrementarVelCaeLadrillo(){
		int aux=getVelCaeLadrillo();
		aux=15*aux/100;
		velCaeLadrillo=velCaeLadrillo+aux;	
		Ladrillo.setRapidezCaida(velCaeLadrillo);		
	}
	private void incrementarCantVentConDificultad(){
//		int aux=getCantVentanasRotas();
		int aux=getCantVentConDif();
		aux=15*aux/100;
		cantVentConDif=cantVentConDif+aux; //para acceder a esto se usa get
	}
	private void incrementarCantVentanasRotas(){

		int aux=getCantVentanasRotas();
		aux=15*aux/100;
		cantVentanasRotas=cantVentanasRotas+aux;
		Ralph.getInstanciaRalph().setCantVentQueRompe(cantVentanasRotas);

	}
}
