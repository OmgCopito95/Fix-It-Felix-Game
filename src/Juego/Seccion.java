package Juego;

import Ventana.Comun;
import Personajes.Felix;
import Personajes.Posicion;
import Ventana.Ventana;

public abstract class Seccion {
	private static int num;
	static Ventana[][] matriz=new Ventana[3][5];
	private static  int cantVentanasRotas;

	
	public static Ventana[][] getMatriz() {
		return matriz;
	}

	public static int getNum() {
		return num;
	}
	public static void setNum(int num1) {
		num = num1;
	}
	
	public static int getCantVentanasRotas() {
		return cantVentanasRotas;
	}
	public static  void setCantVentanasRotas(int cantVent) {
		cantVentanasRotas = cantVent;
	}	
	public static void disminuirCantVentanasRotas(){	
		cantVentanasRotas--;
	}
	public static void aumentarCantVentanasRotas(){
		cantVentanasRotas++;
	}	
	public static void aumentarNumSeccion(){
		num++;
	}	
	public abstract void construirMatriz();	
	public static boolean puedePasarASigVent(int x, int y,Direcciones d){
		return matriz[x][y].puedePasar(d);		
	}
	
	/**
	 * Devuelve el panel en la posicion i,j de la matriz 
	 */
	public static Ventana getVentanaEnPos(int i,int j){
		return getMatriz()[i][j];
	}
	/**
	 * Devuelve la ventana 
	 */
	public static Ventana getVentana(Posicion pos){			//deberia usar pixeles y no posiciones de filas y columnas

		if(Seccion.getNum()==1){
			for (int j=0;j<3;j++){
				for (int i=0;i<5;i++){
					if ((49 + (50*i) < pos.getPosX() &&  pos.getPosX()< 49 + (50*(i+1))))
						if(28+ (75*j) < pos.getPosY() && pos.getPosY() < 28 + (75*(j+1)))
							return Seccion.getVentanaEnPos(j,i);
					}
			}
		}else if(Seccion.getNum()==2){
			for (int j=0;j<3;j++){
				for (int i=0;i<5;i++){
					if ((49 + (50*i) < pos.getPosX() &&  pos.getPosX()< 49 + (50*(i+1))))
						if(28+ (75*j) < pos.getPosY() && pos.getPosY() < 28 + (75*(j+1)))
							return Seccion.getVentanaEnPos(j,i);
				}
			}
		}else
			for (int j=0;j<3;j++){
				for (int i=0;i<5;i++){
					if ((49 + (50*i) < pos.getPosX() &&  pos.getPosX()< 49 + (50*(i+1))))
						if(97+ (75*j) < pos.getPosY() && pos.getPosY() < 97 + (75*(j+1)))
							return Seccion.getVentanaEnPos(j,i);
				}
			}

		return null;		
	}
	/**
	 * Busca una ventana comun que este completamente rota
	 */
	public static Comun buscarVentanaComunYRota(){
		for(int i=0;i<3;i++)
			for(int j=0;j<5;j++){
				if(matriz[i][j].esComun()){
					if(matriz[i][j].getPanel(0,0).estaRoto())
						return (Comun) matriz[i][j];
				}
			}
		return null;
	}
	/**
	 * Cambia de seccion al completar la anterior
	 */
	public static void pasarDeSeccion(){
		if(Seccion.getNum()==1){
			Seccion.aumentarNumSeccion();
			Seccion2y3 s=new Seccion2y3();				
			s.construirMatriz();
		}else{
			if(Seccion.getNum()==2){
				Seccion2y3 s3=new Seccion2y3();
				Seccion.aumentarNumSeccion();
				Felix.getInstanciaFelix().setPosFelix(250, 254); //posicion inicial de felix		
				s3.construirMatriz();
			}else{ //estoy en la secccion 3
				Seccion.setNum(1);
				Seccion1 s1=new Seccion1();
				Felix.getInstanciaFelix().setPosFelix(250, 250); //posicion inicial de felix		
				s1.construirMatriz();
			}		
		}
//	
	}
}
