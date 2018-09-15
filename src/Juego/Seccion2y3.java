package Juego;

import java.util.Random;

import Personajes.Pajaro;
import Ventana.*;

public class Seccion2y3 extends Seccion{
	/**
	 * Construye de forma aleatoria la matriz de la seccion 2 o la seccion 3
	 */
	public void construirMatriz(){
		Random rnd = new Random();
		int ventTotalesRotas=0;
		int cantVentanasDificiles = NivelActual.getInstanciaNivel().getCantVentConDif();
		int ventanasRotas=NivelActual.getInstanciaNivel().getCantVentanasRotas();
		int cantPanelesCreados = 0;
		
		for (int i = 0; i < 5; i++) { // columnas
			for (int f = 0; f < 3; f++) { // filas
				boolean r = rnd.nextBoolean();
				if (r == true || cantVentanasDificiles == 0) { // agrego ventana comun
					matriz[f][i] = new Comun();
					cantPanelesCreados += 2;
					for (int k = 0; k < 2; k++) {
						boolean romper = rnd.nextBoolean();
						if ((romper == true || (30 - cantPanelesCreados) <= ventTotalesRotas) && Seccion.getCantVentanasRotas() < ventanasRotas) {
							matriz[f][i].romper();
							ventTotalesRotas=Seccion.getCantVentanasRotas();
						}
					}
					boolean conObstaculo = rnd.nextBoolean();
					if (conObstaculo == true && cantVentanasDificiles > 0) { // para saber si le agrego dificultad
						matriz[f][i].agregarDificultad();
						if (matriz[f][i].esComun())
							cantVentanasDificiles--;
					}
				} else {
					matriz[f][i] = new ConHojas();
					boolean o=rnd.nextBoolean();				
					if (o == true && cantVentanasDificiles > 0) { // abro la ventana
						matriz[f][i].agregarDificultad();						
					}					
					cantVentanasDificiles--;
				}				
				matriz[f][i].getPosV().setPosX(i);
				matriz[f][i].getPosV().setPosY(f);
			}//cierra el segundo for
		}//cierra el primer for 
		Pajaro pajaro = new Pajaro();
		ArregloDePajaros.getInstancia().agregar(pajaro);
	}//cierra el metodo
}//cierra la clase
