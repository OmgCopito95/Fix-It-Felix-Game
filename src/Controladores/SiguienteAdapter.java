package Controladores;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import Excepciones.TooLongException;
import Excepciones.TooShortException;
import Grafica.FrameGanaJugador;
import Grafica.PantallaPrincipal;
import Grafica.VentanaTop5;
import Juego.HighScore;
import Juego.Juego;
/**
 * Adapter del Boton Siguiente de FrameGanaJugador
 * @author pc
 *
 */
public class SiguienteAdapter extends MouseAdapter {
	@Override
	public void mouseClicked(MouseEvent c) {				
		String nombre=FrameGanaJugador.getDisplay().getText(); //texto que esta en el FrameGanaJugador.getDisplay()
		nombre=nombre.replace(" ", "");
		HighScore jugador = new HighScore(); //Creo un nuevo jugador para agregar al Top 5
		try {
			nombreValido(nombre);
		}
		catch (TooShortException TS){
			FrameGanaJugador.getDisplay().setText("");
			JOptionPane.showMessageDialog(FrameGanaJugador.getFrameGanador(), "El nombre ingresado es muy corto");			
			return;
		}
		catch (TooLongException TL){
			JOptionPane.showMessageDialog(FrameGanaJugador.getFrameGanador(), "El nombre ingresado es muy largo, se truncó hasta los primeros 20 caracteres");
			nombre = nombre.substring(0, 20);
			TL.printStackTrace();
		}
		for (int i=0;i<Juego.getInstanciaJuego().getCantElementosEnLista();i++){
			if (Juego.getInstanciaJuego().getJugador(i).getNombreJugador().equals(nombre)){
				FrameGanaJugador.getDisplay().setText("");
				JOptionPane.showMessageDialog(FrameGanaJugador.getFrameGanador(), "Su nombre ya esta en la lista");
				return;
			}
		}		
		jugador.setNombreJugador(nombre);
		jugador.setPuntos(Juego.getInstanciaJuego().getScoreActual());
		Juego.getInstanciaJuego().newRecord(jugador); //Agrega al jugador al arreglo de puntajes altos
		FrameGanaJugador.getFrameGanador().setVisible(false);
		VentanaTop5 ventTop5 = new VentanaTop5();
		Juego.getInstanciaJuego().guardarPuntajes(); 

	}
	/**
	 * Chequea si el nombre pasado como parametro es valido
	 */
	public boolean nombreValido(String n) throws TooLongException, TooShortException{
		if (n.length()<2 || n == null){
			throw new TooShortException();
		}
		else if (n.length()>20){
			throw new TooLongException();
		}
		else
			return true;
	}
}
