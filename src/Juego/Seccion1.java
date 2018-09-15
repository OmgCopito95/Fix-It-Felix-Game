package Juego;

import java.util.Random;

import Ventana.*;


public class Seccion1 extends Seccion {
	/**
	 * Construye de forma aleatoria la matriz de la Seccion 1
	 */
	public void construirMatriz(){	//hace random los tipos de ventanas que va a haber en la seccion 1 de ese nivel
		int ventTotalesRotas=0;
		int ventanasRotas=NivelActual.getInstanciaNivel().getCantVentanasRotas();
		int cantPanelesCreadas=0;
		for(int col=0;col<5;col++){ //columnas		
			for(int fila=0;fila<3;fila++){ //filas
				Random r=new Random();
				if(col==2 && fila==2){  
					matriz[fila][col]=new VentanaCircularAbajo();
					cantPanelesCreadas+=4;
				}else{
					if(col==2 && fila==1){
						matriz[fila][col]=new VentanaCircularArriba();
						cantPanelesCreadas+=8;
					}else{
						matriz[fila][col]=new Comun();
						cantPanelesCreadas+=2;
					}				
				}	
					for(int b=0;b<matriz[fila][col].getCantidadDePaneles();b++){
						boolean g=r.nextBoolean();						
						int i=Seccion.getCantVentanasRotas();
						if((g==true || 38-cantPanelesCreadas <= ventTotalesRotas) && Seccion.getCantVentanasRotas()<ventanasRotas ){					
							matriz[fila][col].romper();
							ventTotalesRotas=Seccion.getCantVentanasRotas();
						}
					}							
						
				matriz[fila][col].getPosV().setPosX(col);
				matriz[fila][col].getPosV().setPosY(fila);	//guardo la posicion de la ventana					
				
			}
		}
	}
			
}

