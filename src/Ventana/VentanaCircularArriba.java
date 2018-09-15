//MIRAR LO DE ESTADO DE VENTANA

package Ventana;

import java.util.Random;

import Ventana.EstadoVentana;
import Juego.Direcciones;
import Juego.Seccion;


public class VentanaCircularArriba extends Semicircular{
	private int CANTPANELESCIRAR;
	private Panel estadoVsemiAr[][]=new Panel[4][4];
//	private Posicion posBalcon=new Posicion();
	
	public VentanaCircularArriba(){
		for(int i=0;i<4;i++)
			for(int j=0;j<4;j++){
				estadoVsemiAr[i][j]=new Panel();
				estadoVsemiAr[i][j].setEstadoVentana(EstadoVentana.SANO);
			}
	}
	
	public int getCANTPANELESCIRAR() {
		return CANTPANELESCIRAR;
	}
	public void setCANTPANELESCIRAR(int cANTPANELESCIRAR) {
		CANTPANELESCIRAR = cANTPANELESCIRAR;
	}
	@Override
	public boolean puedePasar(Direcciones d) {
		switch (d){
		case DERECHA:	//derecha
			return true;		
		case IZQUIERDA: //izquierda
			return true;		
		case ABAJO:	//arriba
			return true;		
		case ARRIBA:	//abajo
			return false;
		}
		return false;
	}
	@Override
	public void agregarDificultad() {
		//no tienen dificultad
	}
	
	/**
	 * Repara la ventana y aumenta el puntaje
	 */
	public void reparar(){
		Loop:
			for (int i=3; i>=0;i--){														//Realiza dos for para chequear la ventana
				for (int j=0; j<4; j++){													//completa (2x2)
					if(estadoVsemiAr[i][j].getEstado() == EstadoVentana.ROTOCOMPLETO){		//Si el panel esta roto completo, 
						estadoVsemiAr[i][j].setEstadoVentana(EstadoVentana.MEDIOROTO);		//lo cambia al estado MedioRoto
						
						break Loop;
					} else
						if(estadoVsemiAr[i][j].getEstado() == EstadoVentana.MEDIOROTO){		//Si el panel está en estado medio roto
							estadoVsemiAr[i][j].setEstadoVentana(EstadoVentana.SANO);		//lo cambia a estado Sano,
							Seccion.disminuirCantVentanasRotas();
							if (i == 0 && j == 3){
								
//								if (Seccion.getCantVentanasRotas() == 0)
//									Juego.getInstanciaJuego().aumentarScore(500);										//aumenta el puntaje
//								else 
//									Juego.getInstanciaJuego().aumentarScore(100);								//y sale del Loop.
							}
							break Loop;														
						} else 
							if(estadoVsemiAr[i][j].getEstado() == EstadoVentana.SANO){		
								continue;
							}
				}
			}
	}
	/**
	 * Rompe la ventana de forma aleatoria
	 */
	public void romper(){		
		Random r = new Random();
		boolean cant=r.nextBoolean();
		loop: for (int i = 0; i < 4; i++) {
			    for (int j = 0; j < 4; j++) {
				    if (cant) { // Si cant es true, el estado pasa a MedioRoto, sino pasa a Roto.
					    if (this.getPanel(i, j).getEstado() == EstadoVentana.SANO) {
						     this.getPanel(i, j).setEstadoVentana(EstadoVentana.MEDIOROTO);
						     break loop;
					    }
				    } else {
					       if (this.getPanel(i, j).getEstado() == EstadoVentana.SANO) {
						        this.getPanel(i, j).setEstadoVentana(EstadoVentana.ROTOCOMPLETO);
						        break loop;
					       }
				     }
			     }
		       }
		Seccion.aumentarCantVentanasRotas();		
	}
	
	public String tipo(){
		return "Balcón";
	}

	public Panel getPanel(int x, int y){
		return estadoVsemiAr[x][y];
	}

	@Override
	public int getCantidadDePaneles() {
		return 8;
	}
}
