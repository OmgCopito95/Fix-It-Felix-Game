package Ventana;

import java.util.Random;

import Juego.Direcciones;
import Juego.Juego;
import Juego.Seccion;

public class Comun extends Ventana {
	private int CANTPANELESCOMUN;
	private boolean conPastel;
	private Panel estadoVComun[][]=new Panel[2][1];
	private boolean conMoldura;
	private boolean conMacetero;
	
	public Comun(){
		for(int i=0;i<2;i++){			
			estadoVComun[i][0]=new Panel();
			estadoVComun[i][0].setEstadoVentana(EstadoVentana.SANO);
		}
		this.conMacetero=false;
		this.conMoldura=false;
		this.conPastel=false;
	}
	
	public int getCANTPANELESCOMUN() {
		return CANTPANELESCOMUN;
	}
	
	public void setCANTPANELESCOMUN(int CANTP) {
		CANTPANELESCOMUN = CANTP;
	}
	
	public boolean isConPastel() {
		return conPastel;
	}
	
	public void setConPastel(boolean conPastel) {
		this.conPastel = conPastel;
	}	
	
	public boolean isConMoldura() {
		return conMoldura;
	}
	public void setConMoldura(boolean conMoldura) {
		this.conMoldura = conMoldura;
	}
	public boolean isConMacetero() {
		return conMacetero;
	}
	public void setConMacetero(boolean conMacetero) {
		this.conMacetero = conMacetero;
	}
	/**
	 * Chequea si Felix puede pasar en la direccion pasada como parámetro
	 * @param i DERECHA, IZQUIERDA, ARRIBA, ABAJO 
	 */
	@Override
	public boolean puedePasar(Direcciones i) {		
		switch (i){
		case DERECHA:	//derecha
			return true;		
		case IZQUIERDA: //izquierda
			return true;		
		case ABAJO:
			if(this.isConMoldura()==true) //si la ventana en que estoy tiene moldura 			
				return false;
	
			else 
				return true;		
		case ARRIBA:
			if(this.isConMacetero()==true)
				return false; // no puedo pasar
			else
				return true;
		}
		return false;
	}
	/**
	 * Agrega una moldura o macetero a una ventana comun de forma aleatoria
	 */
	@Override
	public void agregarDificultad() {
		Random r=new Random();
		boolean j=r.nextBoolean();
		if(j==true){
			this.conMoldura=true;
		}else
			this.conMacetero=true;		
	}
	/**
	 * Repara la ventana y aumenta el puntaje 
	 */
	@Override
	public void reparar(){
		
		if(estadoVComun[1][0].getEstado() == EstadoVentana.ROTOCOMPLETO){	//Chequea si el panel inferior esta roto completo,
			estadoVComun[1][0].setEstadoVentana(EstadoVentana.MEDIOROTO);	// si es así, cambia el estado a MedioRoto			
		}else 
			if(estadoVComun[1][0].getEstado() == EstadoVentana.MEDIOROTO){	//Chequea si el panel inferior esta medio roto,
				estadoVComun[1][0].setEstadoVentana(EstadoVentana.SANO);	// si es así, cambia el estado a Sano
				Seccion.disminuirCantVentanasRotas();						//y disminuye en uno a las ventanas rotas			
			}else{ 
				if (estadoVComun[1][0].getEstado() == EstadoVentana.SANO){
					if(estadoVComun[0][0].getEstado() == EstadoVentana.ROTOCOMPLETO){	//Chequea si el panel superior esta roto completo,
						estadoVComun[0][0].setEstadoVentana(EstadoVentana.MEDIOROTO);	//si es así, cambia el estado a MedioRoto
					}else{
						if(estadoVComun[0][0].getEstado() == EstadoVentana.MEDIOROTO){	//Chequea si el panel superior esta medio roto,
							estadoVComun[0][0].setEstadoVentana(EstadoVentana.SANO);	//si es así, cambia el estado a Sano
							Seccion.disminuirCantVentanasRotas();						//y disminuye en uno a las ventanas rotas		
							if (Seccion.getCantVentanasRotas() > 0)
								Juego.getInstanciaJuego().aumentarScore(100);
							else if (Seccion.getCantVentanasRotas() == 0)
								Juego.getInstanciaJuego().aumentarScore(500);
						}
					}
				}else {
					System.out.println("La ventana está sana"); //La ventana completa está sana y no necesita repararse,
				}
			}				
	}
	/**
	 * Rompe la ventana de forma aleatoria
	 */
	@Override
	public void romper(){
				
		Random r = new Random();
		boolean cant=r.nextBoolean();
		if (cant){ //Si cant es true, el estado pasa a MedioRoto, sino pasa a Roto.
			if(this.getPanel(0,0).getEstado()==EstadoVentana.SANO)
				this.getPanel(0,0).setEstadoVentana(EstadoVentana.MEDIOROTO);
			else if(this.getPanel(1,0).getEstado()==EstadoVentana.SANO)
				this.getPanel(1,0).setEstadoVentana(EstadoVentana.MEDIOROTO);
		}else{ 
			if(this.getPanel(0,0).getEstado()==EstadoVentana.SANO)
				this.getPanel(0,0).setEstadoVentana(EstadoVentana.ROTOCOMPLETO);
			else if(this.getPanel(1,0).getEstado()==EstadoVentana.SANO)
				this.getPanel(1,0).setEstadoVentana(EstadoVentana.ROTOCOMPLETO);
		}		
		Seccion.aumentarCantVentanasRotas();

		}
		
	public boolean esComun(){
		return true;
	}
	/**
	 * Devuelve el panel superior o inferior de una ventana
	 */
	public Panel getPanel(int x, int y){
		return estadoVComun[x][y];
	}

	@Override
	public int getCantidadDePaneles() {		
		return 2;
	}
}
