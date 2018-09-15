package Grafica;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Juego.Juego;
/**
 * Esta clase controla la ventana donde se muestran los 5 puntajes mas altos conseguidos
 */
public class VentanaTop5 extends JFrame{
	
	String[] titulos={"Posición","Jugador","Puntaje"};
	DefaultTableModel modelo = new DefaultTableModel (titulos,5);
	JTable topFive = new JTable();
	JButton aceptarTopFive=new JButton();
	
	public VentanaTop5(){
		
		Juego.getInstanciaJuego().cargarPuntajes();
		this.manejarModeloTabla();
		topFive.setModel(modelo);
		this.add(new JScrollPane(topFive));
		aceptarTopFive.addMouseListener(new AceptarAdapter());
		aceptarTopFive.setText("Aceptar");
		//this.add(aceptarTopFive);
		this.setSize(300, 141);
		this.setTitle("TOP 5");
		this.setVisible(true);
	
	}
	
	public void manejarModeloTabla(){		

		modelo=new DefaultTableModel (titulos,0);
		for (int j=0; j<Juego.getInstanciaJuego().getCantElementosEnLista();j++){
			Object[] o = {new Integer(j+1),Juego.getInstanciaJuego().getJugador(j).getNombreJugador(), new Integer(Juego.getInstanciaJuego().getJugador(j).getPuntos())};
			modelo.addRow(o);
		}
	}
	
	public class AceptarAdapter extends MouseAdapter{
		public void mouseClicked(MouseEvent c){
			setVisible(false);
		}
	}

}

