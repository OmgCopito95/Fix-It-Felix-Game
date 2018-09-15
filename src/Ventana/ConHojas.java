package Ventana;

import Juego.Direcciones;
import Personajes.Posicion;


public class ConHojas extends Ventana{
//	private Posicion posVentana=new Posicion();
	private boolean abierta;
	Panel[][] estadoVConHojas=new Panel[2][1];
	
	public boolean isAbierta() {
		return abierta;
	}
	
	public ConHojas(){
		this.posV=new Posicion();
		for(int i=0;i<2;i++){
			this.estadoVConHojas[i][0]=new Panel();
			this.estadoVConHojas[i][0].setEstadoVentana(EstadoVentana.SANO);
		}
	}
	
	/**
	 * Chequea si Felix puede pasar a izquierda o derecha de la ventana
	 * @param DERECHA, IZQUIERDA
	 */
	@Override
	public boolean puedePasar(Direcciones d) {
		switch (d){
		case DERECHA: //derecha
			if (this.isAbierta()==true) //si esta abierta no puede pasar
				return false;
			else
				return true;
		case IZQUIERDA: //izquierda
			if (this.isAbierta()==true) //si esta abierta no puede pasar
				return false;
			else
				return true;
		case ARRIBA: //arriba
			return true;
		case ABAJO: //abajo
			return true;
		}
		return false;
	}
	/**
	 * Abre las hojas de la ventana
	 */
	@Override
	public void agregarDificultad() { //abre ventana
		this.abierta=true;
	}
	
	public void reparar(){
		//El metodo está vacío ya que las ventanas con hojas no pueden romperse.
	} 
	
	public void romper(){
		//El metodo esta vacío ya que las ventanas con hojas no pueden romperse.
	}
	
	public String tipo(){
		return "Con hojas";
	}
	
	public boolean esConHojas(){
		return true;
	}
	public Panel getPanel(int x, int y){
		return estadoVConHojas[x][y];		
	}

	@Override
	public int getCantidadDePaneles() {
		return 2 ;
	}
}
