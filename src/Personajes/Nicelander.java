//METODO PONERPASTEL

package Personajes;

import java.util.Random;
import Ventana.Comun;
import Juego.Seccion;

public class Nicelander {

	private static boolean hayPastel;
	private static Nicelander instanciaNicelander=new Nicelander();
	
	private Nicelander(){
	}	
	
	public static Nicelander getInstanciaNicelander() {
		return instanciaNicelander;
	}

	public boolean isHayPastel() {
		return hayPastel;
	}
	/**
	 * Decide si pone un pastel en una ventana o no
	 */
	public void decidirPonerPastel(){
		if(!hayPastel){
			Random rnd = new Random();
			boolean r=rnd.nextBoolean();
			if(r){//Si el random dio true
				ponerPastel();
			}
		}
	}
	
	/**
	 * Coloca un pastel en una ventana comun que esté completamente rota
	 */
	private void ponerPastel(){
		Comun ventComun = new Comun();
		ventComun = Seccion.buscarVentanaComunYRota();
		if(ventComun!=null){//Si hay una ventana comun y rota
			hayPastel=true;
			ventComun.setConPastel(true);
			Pastel.setPosPastel(ventComun.getPosV());
			System.out.println("Se ha colocado un pastel en una ventana");
		}
	}
	public static void setHayPastel(boolean b){
		hayPastel=b;
	}

}
