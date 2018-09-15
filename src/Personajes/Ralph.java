package Personajes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Personajes.Ladrillo;
import Personajes.Ralph;
import Juego.Direcciones;
import Juego.Juego;
import Juego.NivelActual;
import Juego.Seccion;

public class Ralph extends Personajes{
	
	private  int ladrillosDisponibles;
	private Posicion posRalph=new Posicion();
	private int cantVentQueRompe;
	private int frecuenciaTirarLadrillos;
	private static Ralph instanciaRalph=new Ralph();
	private Direcciones direccion;
	private List<Ladrillo> ladrillosTirados = new ArrayList<Ladrillo>();
	private boolean ralphTiroLadrillo = false;
	private boolean ralphSeMovio = false;
	private static int s1=0,s2=0,s3=0;
	private int n=0;
	
	public boolean isRalphTiroLadrillo() {
		return ralphTiroLadrillo;
	}
	
	public int getCantLadrillosEnArreglo(){
		return ladrillosTirados.size();
	}
	
	public void incrementarPosX(){
		posRalph.setPosX(posRalph.getPosX()+25);
	}
	public void decrementarPosX(){
		posRalph.setPosX(posRalph.getPosX()-25);
	}	
	
	public int getLadrillosDisponibles() {
		return this.ladrillosDisponibles;
	}
	public static Ralph getInstanciaRalph() {
		return instanciaRalph;
	}	
	private Ralph(){		
	}
	/**
	 * Devuelve el ladrillo ubicado en la posicion pasada por parametro
	 * @param pos La posicion en el arreglo deseada
	 */
	public Ladrillo getLadrillo(int pos){
		return ladrillosTirados.get(pos);
	}
	public void setRalphSeMovio(boolean ralphSeMovio) {
		this.ralphSeMovio = ralphSeMovio;
	}
	public Direcciones getDireccion(){
		return direccion;
	}
	public boolean ralphSeMovio() {
		return ralphSeMovio;
	}
	public  void setLadrillosDisponibles(int numero) {
		ladrillosDisponibles =numero;
	}
	
	public Posicion getPosRalph(){
		return posRalph;
	}
	
	public void setPosRalph(int x, int y){
		posRalph.setPosX(x);
		posRalph.setPosY(y);	
	}
	/**
	 * Decide si Ralph lanza un ladrillo o no
	 * @return True, False
	 */
	public boolean decidirTirarLadrillo(){
		if ((n % 10)==0){
			if (n==10)
				n=0;
			return true;
		}
		else return false;
	}

	/**
	 * Lanza un ladrillo y lo agrega al arreglo de ladrillos
	 */
	public void tirarLadrillo(){
		Ladrillo l = new Ladrillo();
		Random r = new Random();
		int a=r.nextInt(3);
		int b=r.nextInt(2);
		int x=posRalph.getPosX();
		l.setPosLadrillo(x+a-b,posRalph.getPosY()+50);
		ladrillosDisponibles--;  //se le resta 1 a la cant de ladrillos disponibles
		ralphTiroLadrillo=true;
		ladrillosTirados.add(l);
	}
	
	public  int getCantVentQueRompe() {
		return cantVentQueRompe;
	}
	
	public  void setCantVentQueRompe(int cantVent) {
		cantVentQueRompe = cantVent;
	}
	
	public int getFrecuenciaTirarLadrillos() {
		return frecuenciaTirarLadrillos;
	}
	
	public void setFrecuenciaTirarLadrillos(int velTLadrillos) {
		this.frecuenciaTirarLadrillos = velTLadrillos;
	}
	/**
	 * Resetea las variables para controlar cuantos ladrillos se lanzan por seccion 
	 */
	public static void resetearVariables(){
		s1=0;
		s2=0;
		s3=0;
	}
	/**
	 * Mueve a Ralph en el eje X de forma aleatoria
	 */
	@Override
	public void mover(Direcciones i) { //Mueve a Ralph en el eje x
		Random r=new Random();
		int j=r.nextInt(2); //hace random entre 0 y 1 para saber si se mueve a la derecha o izq
		if(j==1 && 10<posRalph.getPosX()){ //j=1 se mueve a la izquierda
			decrementarPosX();	
			direccion=Direcciones.IZQUIERDA;
			
		}else
			if(j==0 && 235>posRalph.getPosX()){ //j=0 se mueve a la derecha
				incrementarPosX();				
				direccion=Direcciones.DERECHA;
			}
		ralphSeMovio=true;
		Ralph.getInstanciaRalph().aumentarNum();
	}
	/**
	 * Contiene todas las acciones posibles que puede ejecutar Ralph en un turno
	 */
	public void turno(){
		Ralph.getInstanciaRalph().mover(null);	//se mueve aleatoriamente
		if (Seccion.getNum()==1){
			if (this.getLadrillosDisponibles()>0 && this.decidirTirarLadrillo() && s1<13){
				this.tirarLadrillo();
				s1++;
			}
		}
		else if (Seccion.getNum()==2){
			if (Ralph.getInstanciaRalph().getLadrillosDisponibles()>0 && Ralph.getInstanciaRalph().decidirTirarLadrillo() && s2<13){
				Ralph.getInstanciaRalph().tirarLadrillo();
				s2++;
			}
		}
		else
			if (Ralph.getInstanciaRalph().getLadrillosDisponibles()>0 && Ralph.getInstanciaRalph().decidirTirarLadrillo() && s3<14){
				Ralph.getInstanciaRalph().tirarLadrillo();
				s3++;
			}
	}
	/**
	 * Elimina el ladrillo ubicado en la posicion pasada por parámetro del arreglo
	 * @param pos
	 */
	public void eliminarLadrillo(int pos) {
		this.ladrillosTirados.remove(pos);
	}
	
	public void aumentarNum(){
		n++;
	}

}
