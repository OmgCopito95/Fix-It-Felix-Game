package Grafica;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.URL;


import javax.imageio.ImageIO;
import javax.swing.*;

import Controladores.ConfiguracionAdapter;
import Controladores.NivelAdapter;
import Controladores.QuieroJugarAdapter;
import Controladores.ReglasDelJuegoAdapter;
import Controladores.TopFiveAdapter;
/**
 * Esta clase controla la pantalla principal al abrir el juego
 *
 */
public class PantallaPrincipal {

	//private static final ImageIO ImageIO = null;
	JFrame framePantallaP=new JFrame();
	Image img3;
	
	static JFrame frameConfig=new JFrame();
	static JPanel inst=new JPanel();	
	
	JPanel imaIns= new JPanel();
	
	JPanel pantallaP=new JPanel();
	JPanel juegoP=new JPanel();		
	JPanel pantallaGanador=new JPanel();	
	JPanel panelBotones=new JPanel();
	
	static JPanel configuracion=new JPanel();	
	JLabel label=new JLabel("Nivel:");
	JPanel botonConf=new JPanel();
	static JComboBox<String> nivelList;
	Image img;	
	Graphics g;

	String valueNivel; //guarda el nivel que selecciono el jugador

	public static JFrame getFrameConfig(){
		return frameConfig;
	}
	
	public static JPanel getInst(){
		return inst;
	}
	
	public static JComboBox<String> getNivelList(){
		return nivelList;
	}
	
	public static JPanel getPanelConfig(){
		return configuracion;
	}
	
	public PantallaPrincipal(){		
		
		pantallaP.setLayout(new BorderLayout());			
		pantallaP.add(agregarBotones(panelBotones), BorderLayout.CENTER); //agrego los botones en el medio de la pantalla
		pantallaP.setBorder(BorderFactory.createEmptyBorder(-5, -5, -5, -5));
		
		botonConf.setLayout(new FlowLayout());
		botonConf.add(cargarBotonConImagen(g));		
		pantallaP.add(botonConf,BorderLayout.EAST);		
		botonConf.addMouseListener(new NivelAdapter());
		
		imaIns.setLayout(new BorderLayout());
		inst.setLayout(new BorderLayout());
		
		//configuracion.setLayout(new FlowLayout());
		configuracion.add(label);
		String[] nivelStrings = { "Nivel 1","Nivel 2","Nivel 3","Nivel 4","Nivel 5","Nivel 6","Nivel 7","Nivel 8","Nivel 9","Nivel 10"};
		nivelList = new JComboBox<String>(nivelStrings);
		configuracion.add(nivelList);			

		
		//background
		cargarImagenFondo(g);
		framePantallaP.add(pantallaP);		
		framePantallaP.setSize(700, 700);
		framePantallaP.setTitle("Fix It Felix Jr");
		
		
		framePantallaP.setLayout(new FlowLayout());
		framePantallaP.setResizable(true);
		framePantallaP.setLocationRelativeTo(null);
		framePantallaP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framePantallaP.setResizable(false);
		framePantallaP.setVisible(true);
	}		
	
	public JButton cargarBotonConImagen(Graphics g){
		String imgFileName="Imagenes/config_sprite.png";
		URL imgUrl = getClass().getClassLoader().getResource(imgFileName);
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgFileName);
		}else{
			try {
				img = ImageIO.read(imgUrl); // carga imagen en img
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		JButton b=new JButton();
		b.setIcon(new ImageIcon(img));
		b.addMouseListener(new ConfiguracionAdapter());
		return b;
	}		
	public JPanel agregarBotones(JPanel panel){
		
		JButton boton1=new JButton ("REGLAS DEL JUEGO");
		panel.add(boton1);
		boton1.addMouseListener(new ReglasDelJuegoAdapter());
		
		JButton boton2=new JButton ("¡QUIERO JUGAR!");
		boton2.addMouseListener(new QuieroJugarAdapter());
		panel.add(boton2);
		
		JButton boton3=new JButton ("TOP 5");
		panel.add(boton3);
		boton3.addMouseListener(new TopFiveAdapter());
		
		return panel;		
	}

	public void cargarImagenFondo(Graphics g){
		String imgFileName="Imagenes/fondo2.jpg";
		URL imgUrl = getClass().getClassLoader().getResource(imgFileName);
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgFileName);
		}else{
			try {
				ImageIcon icono = new ImageIcon(imgUrl);
				framePantallaP.setContentPane(new JLabel(icono));
			} catch (Exception ex) {				
				ex.printStackTrace();
			}
		}		
	}	

//	class MiPanel extends JPanel{
//		@Override
//			protected void paintComponent(Graphics g) {
//				//super.paintComponent(g);
//				cargarImagen(g);			
//			}	
//		}	
	
	public String getValueNivel() {
		return valueNivel;
	}
}
