package Grafica;

import java.awt.*;
import java.awt.event.*;

import Controladores.SiguienteAdapter;
import Juego.*;

import javax.swing.*;
/**
 * Esta clase maneja la ventana para ingresar el nombre del jugador en caso de lograr un puntaje alto
 *
 */
public class FrameGanaJugador {
	
	static JFrame frameGanador=new JFrame();
	JPanel panelGanador=new JPanel();
	static JTextField display=new JTextField("",10);  //creo el display
	JLabel label=new JLabel("Ingrese su nombre:");
	JButton botonNext=new JButton("Next");
	String nombre;
	
	public FrameGanaJugador(){		
		panelGanador.setLayout(new BorderLayout());
		panelGanador.add(label,BorderLayout.NORTH);
		panelGanador.add(display,BorderLayout.CENTER);
		
		panelGanador.add(botonNext,BorderLayout.SOUTH); //agrego el boton
		botonNext.addMouseListener(new SiguienteAdapter());
		
		frameGanador.add(panelGanador);
		frameGanador.setVisible(true);
		frameGanador.setTitle("Ganador");
		frameGanador.setSize(200, 100);	
				
	}
	
	public static JFrame getFrameGanador(){
		return frameGanador;
	}
	
	public static JTextField getDisplay(){
		return display;
	}

}

