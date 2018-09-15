package ControladorDelJuego;

import Grafica.PantallaPrincipal;
import Juego.*;

/**
 * La clase controlador maneja el juego
 *
 */
public class Controlador {
	private String nivel="Nivel 1";
	private static Controlador instanciaControlador=new Controlador();

	private Controlador(){
	}
	
	public static Controlador getInstanciaControlar() {
		return instanciaControlador;
	}	

	/**
	 * Controla que sucede al terminarse el tiempo del nivel
	 */
	public void controlarTiempo(){		
		if(Juego.getInstanciaJuego().getVidas()==1)	{
			System.out.println("Termino el juego");	
			Juego.getInstanciaJuego().finDeJuego();
		}else{
			Juego.getInstanciaJuego().setVidas(Juego.getInstanciaJuego().getVidas()-1);	
			System.out.println("Felix perdio una vida");
			Juego.getInstanciaJuego().setTiempo(120);
		}
	}	
	
	/**
	 * Controla que sucede al terminar una seccion
	 */
	public void controlarSeccion(){
		switch (Seccion.getNum()){
		case 1: //tengo que pasar de seccion 1 a la 2
				Seccion.pasarDeSeccion();
			break;
		case 2: //tengo que pasar de seccion 2 a la 3
				Seccion.pasarDeSeccion();
			break;
		case 3:
			NivelActual.getInstanciaNivel().pasarDeNivel();
			Seccion.pasarDeSeccion();
			break;
		}
	}	
	public void setNivel(String n){
		nivel=n;
	}	
	/**
	 * Chequea que nivel fue seleccionado en la configuracion antes de comenzar a jugar
	 */
	public void enviarNivel(){
		switch (nivel){
		case ("Nivel 1"):
			NivelActual.getInstanciaNivel().setNum(1);
			break;
		case ("Nivel 2"):
			NivelActual.getInstanciaNivel().setNum(2);
			break;
		case ("Nivel 3"):
			NivelActual.getInstanciaNivel().setNum(3);
			break;
		case ("Nivel 4"):
			NivelActual.getInstanciaNivel().setNum(4);
			break;
		case ("Nivel 5"):
			NivelActual.getInstanciaNivel().setNum(5);
			break;
		case ("Nivel 6"):
			NivelActual.getInstanciaNivel().setNum(6);
			break;
		case ("Nivel 7"):
			NivelActual.getInstanciaNivel().setNum(7);
			break;
		case ("Nivel 8"):
			NivelActual.getInstanciaNivel().setNum(8);
			break;
		case ("Nivel 9"):
			NivelActual.getInstanciaNivel().setNum(9);
			break;
		case ("Nivel 10"):
			NivelActual.getInstanciaNivel().setNum(10);
			break;
		}
	}
	
	public static void main(String[] args) {
		new PantallaPrincipal();	
	}
}


	

