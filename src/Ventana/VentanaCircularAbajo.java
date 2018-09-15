package Ventana;

import java.util.Random;

import Ventana.EstadoVentana;
import Juego.Direcciones;
import Juego.Seccion;

public class VentanaCircularAbajo extends Semicircular{
	private int CANTPANELESCIRAB;
	private Panel estadoVsemiAb[][]=new Panel[2][2];
	
	public VentanaCircularAbajo(){
		for(int i=0;i<2;i++)
			for(int j=0;j<2;j++){
				estadoVsemiAb[i][j]=new Panel();
				estadoVsemiAb[i][j].setEstadoVentana(EstadoVentana.SANO);
			}
	}
	public int getCANTPANELESCIRAB() {
		return CANTPANELESCIRAB;
	}
	public void setCANTPANELESCIRAB(int cANTPANELESCIRAB) {
		CANTPANELESCIRAB = cANTPANELESCIRAB;
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
			//no tiene dificultad
	}
	/**
	 * Repara la ventana y aumenta el puntaje
	 */
	@Override
	public void reparar(){
		Loop:                          //Se declara una etiqueta para poder realizar un break
			for (int i=1; i>=0;i--){														//Realiza dos for para chequear la ventana
				for (int j=0; j<2; j++){													//completa (2x2)
					if(estadoVsemiAb[i][j].getEstado() == EstadoVentana.ROTOCOMPLETO){		//Si el panel esta roto completo, 
						estadoVsemiAb[i][j].setEstadoVentana(EstadoVentana.MEDIOROTO);		//lo cambia al estado MedioRoto
						break Loop;															//y sale del Loop
					} else
						if(estadoVsemiAb[i][j].getEstado() == EstadoVentana.MEDIOROTO){		//Si el panel está en estado medio roto
							estadoVsemiAb[i][j].setEstadoVentana(EstadoVentana.SANO);		//lo cambia a estado Sano,
							Seccion.disminuirCantVentanasRotas();
							if (i == 0 && j == 1){
								
//								if (Seccion.getCantVentanasRotas() == 0)
//									Juego.getInstanciaJuego().aumentarScore(500);										//aumenta el puntaje
//								else 
//									Juego.getInstanciaJuego().aumentarScore(100);								//y sale del Loop.
							}									
							break Loop;															
						} else 
							if(estadoVsemiAb[i][j].getEstado() == EstadoVentana.SANO){		
								continue;													//Si el panel esta sano, pasa el siguiente
							}
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
			loop: for (int i = 0; i < 2; i++) {
				    for (int j = 0; j < 2; j++) {
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

	
	public Panel getPanel(int x, int y){
		return estadoVsemiAb[x][y];
	}
@Override
public int getCantidadDePaneles() {	
	return 4;
}
}
