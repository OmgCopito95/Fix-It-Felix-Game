package Grafica;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;



import javax.imageio.ImageIO;
import javax.swing.*;

import ControladorDelJuego.AdaptadorTecla;
import Juego.ArregloDePajaros;
import Juego.Direcciones;
import Juego.Mapa;
import Juego.Seccion;
import Personajes.Felix;
import Personajes.Nicelander;
import Personajes.Pastel;
import Personajes.Ralph;
import Ventana.Comun;
import Ventana.ConHojas;
import Ventana.EstadoVentana;
import Ventana.Ventana;

public class ComenzarAJugar extends JFrame{
	

//	private JTextField txtPuntos;
//	private JTextField txtVidas;

	
	//Variables
	private JPanel panel=new JPanel();
	private ImageIcon imgFondo;
	
//	Image imgEdifPrimeraSec,imgEdifSegundaSec,imgEdifTerceraSec;
//	Image imgVentanaComunSana,imgVentanaComunTodaRota;
	private Image ventanaComunMediaRotaArribaYRotaAbajo,ventanaComunMediaRota,ventanaComunRotaCompletaAbajo;
	private Image ventanaCerrada,ventanaAbierta,ventanaSanaConMoldura,ventanaSanaConMacetero,ventanaMediaRotaArribaYRotaAbajoConMoldura,	ventanaMediaRotaArribaYRotaAbajoConMacetero,ventanaMediaRotaConMoldura,
	ventanaMediaRotaConMacetero,ventanaMediaRotaAbajoConMoldura,	ventanaMediaRotaAbajoConMacetero,ventanaRotaConMoldura,ventanaRotaConMacetero;
	private Image ventanaComunMediaRotaAbajo,ventanaMediaRotaArriba,ventanaRotaArribaYMediaRotaAbajo,ventanaRotaCompletaArriba;
	private Image ventanaComunMediaRotaArriba;
	private Image ventanaRotaArribaYMediaRotaAbajoConMacetero;
	private Image ventanaRotaArribaYMediaRotaAbajoConMoldura;
	private Image ventanaRotaArribaYSanaAbajoConMacetero;
	private Image ventanaRotaArribaYSanaAbajoConMoldura;
	private Image ventanaMediaRotaArribaYSanaAbajoConMacetero;
	private Image ventanaMediaRotaArribaYSanaAbajoConMoldura;
	private Image ventanaSanaArribaYRotaAbajoConMoldura;
	private Image ventanaSanaArribaYRotaAbajoConMacetero;
	private Image ventanaComunRotaCompletaArribaYMediaRotaAbajo;
//	Image imgFelixIzqQuieto,imgFelixIzqMov;
	private Image imgLadrilloDer,imgLadrilloIzq;
	private Image imgRalphMovDerecha;
	private Image imgPastel;
	private Image imgPuertaSana,imgPuertaRota,imgBalconSano,imgBalconRoto;
	private BufferedImage imgEdifPrimeraSec,imgEdifSegundaSec,imgEdifTerceraSec;
	private BufferedImage imgVentanaComunSana,imgVentanaComunTodaRota;
	private BufferedImage imgFelixIzqQuieto,imgFelixDerQuieto,imgFelixIzqMov,imgFelixDerMov,imgFelixMartillazoIzq,imgFelixMartillazoDer;
	private Image imgVentBalconSana,imgVentBalconSemiRotaArriba,imgVentBalconSemiRotaAbajo,imgVentBalconRota;	
	private BufferedImage imgRalphQuieto,imgRalphMovDerecha1,imgRalphMovDerecha2,imgRalphMovIzquierda1,imgRalphMovIzquierda2;
	private BufferedImage imgRalphGolpeIzq, imgRalphGolpeDer;
	private BufferedImage imgPajaroDer1,imgPajaroDer2,imgPajaroIzq1,imgPajaroIzq2;
	
	private String imgEdificio,imgVentana;
	private String fondo;
	private String imgFelix;
	private String ladrillo;
	private String ralph;
	private String pastel;
	private String imgPajaro;
	
	private Graphics g;	
	private URL imgUrl;
	private int posXFelix,posYFelix; //para guardar la posicion de felix y saber donde tengo que dibujarlo
	private int posXRalph,posYRalph; //para guardar la posicin de ralph y saber donde lo tengo que pintar
	private int posXLadrillo,posYLadrillo;
	private int posXPajaro,posYPajaro;
	private static ComenzarAJugar instancia=new ComenzarAJugar();
	private ImageIcon imgFondoSinPasto,imgFondoConPasto;
	
	
	public static ComenzarAJugar getInstancia(){
		return instancia;
	}
	
	private ComenzarAJugar() {			
		panel.setLayout(new BorderLayout());
//		panel.setLayout(new FlowLayout());		
		cargarImagenes();	
		
		//depende en la seccion que estoy es lo que voy a hacer

		
		MiPanelPrimera edif1=new MiPanelPrimera();		
		this.add(edif1);
		
//		int numSeccion=Seccion.getNum();
//		switch (numSeccion){
//		case (1):	
		
//		Controlador.getInstanciaControlar().enviarNivel();
	
//		break;
//		case(2):
//			Seccion2y3 s2=new Seccion2y3();
//			s2.construirMatriz();
//			break;
//		case(3):
//			Seccion2y3 s3=new Seccion2y3();
//			s3.construirMatriz();
//		}		
			
		this.setResizable(false);
		this.setSize(350, 370);
		this.setTitle("Fix It Felix Jr");
		this.setVisible(true);
	}
//	public static void mostrarTiempo(){
//		int tiempo = NivelActual.getTiempoNivel();
//		timer.setText(""+tiempo);		
//		
//	}
	

	public void cargarEdificio(Graphics g){
//		BufferedImage bi= new BufferedImage(350, 350, BufferedImage.TYPE_INT_RGB);
//		Graphics g=bi.getGraphics();
	
		
		Ventana[][] matrizVentana = new Ventana[3][5];
		matrizVentana=Seccion.getMatriz();
		switch (Seccion.getNum()) {
			case (1):
				g.drawImage(imgFondoConPasto.getImage(), 0, 0, null);		
				g.drawImage(imgEdifPrimeraSec, 10, 0,null);//pinto el edificio			
				for (int j=0; j<4; j++) { //filas
					for (int i=0; i<5; i++) {		//columnas
						if(j==0){
							g.drawImage(imgVentanaComunSana, 49 + i * 50, 22+ j * 75, null);						
						}
						else{
							boolean dibujoBalcon=false;
							boolean dibujoPuerta=false;
							if (i == 2){//dibuja  puerta o balcon
								if (j == 2){// dibuja balcon
									loop:
									for(int m=0;m<4;m++){
										for(int n=0;n<4;n++){											
												if(matrizVentana[j-1][i].getPanel(m,n).getEstado()==EstadoVentana.ROTOCOMPLETO || matrizVentana[j-1][i].getPanel(m,n).getEstado()==EstadoVentana.MEDIOROTO){
													g.drawImage(imgBalconRoto,38 + i * 50, 30 + j * 75,null);	
													dibujoBalcon=true;
													break loop;
												}													
										}
									}
									if(!dibujoBalcon){
									g.drawImage(imgBalconSano, 38 + i * 50, 30 + j * 75,null);										
									}
								}else {
									if (j == 3){
										loop:
											for(int m=0;m<2;m++){
												for(int n=0;n<2;n++){																							
													if(matrizVentana[j-1][i].getPanel(0,0).getEstado()==EstadoVentana.SANO){
														g.drawImage(imgPuertaSana, 38 + i * 50, 9 + j * 75,60,110,null);		
														dibujoPuerta=true;
														break loop;
													}													
												}
											}									
										if(!dibujoPuerta){
											g.drawImage(imgPuertaRota,38 + i * 50, 9 + j * 75,60,110,null);												
										}
									}//cierrra el if (j==3)
								} //cierra el else
							} 
							if((i==2 && (j!=2 && j!=3)) || i!=2 ){						
									switch (matrizVentana[j-1][i].getPanel(0,0).getEstado()) {
										case ROTOCOMPLETO:
											switch (matrizVentana[j - 1][i].getPanel(1, 0).getEstado()) {
												case ROTOCOMPLETO:
													g.drawImage(imgVentanaComunTodaRota, 49 + i * 50, 28 + j * 75,null);
													break;
												case MEDIOROTO:
													g.drawImage(ventanaRotaArribaYMediaRotaAbajo, 49 + i * 50, 28 + j * 75, null); //ventanaComunRotaCompletaArribaYMediaRotaAbajo
													break;
												case SANO:
													g.drawImage(ventanaRotaCompletaArriba, 49 + i * 50, 28 + j * 75,null); //ventanaComunRotaCompletaArriba
												break;
											}
										break;
										case MEDIOROTO:
											switch (matrizVentana[j - 1][i].getPanel(1,0).getEstado()) {
												case ROTOCOMPLETO:
													g.drawImage(ventanaComunMediaRotaArribaYRotaAbajo, 49 + i * 50,   28+j * 75,null);
													break;
												case MEDIOROTO:
													g.drawImage(ventanaComunMediaRota, 49 + i * 50, 28 + j * 75,null);
													break;
												case SANO:
													g.drawImage(ventanaComunMediaRotaArriba, 49 + i * 50, 28 + j * 75,null);
													break;
											}
										break;
										case SANO:
											switch (matrizVentana[j - 1][i].getPanel(1,0).getEstado()) {
												case ROTOCOMPLETO:
													g.drawImage(ventanaComunRotaCompletaAbajo, 49 + i * 50, 28 + j * 75,null);
													break;
												case MEDIOROTO:
													g.drawImage(ventanaComunMediaRotaAbajo, 49 + i * 50, 28 + j * 75,null);
													break;
												case SANO:
													g.drawImage(imgVentanaComunSana, 49+ i * 50, 28 + j * 75,null);
													break;
											}// cierra el switch1
										break;
									}// cierra el switch2
								}	// cierra el  if((i==2 && (j!=2 && j!=3)) || i!=2 )								
							}//cierra el else de (j==0) 
					} //segundo for
				} //primer for
				
				//tengo que pedir la posicion de felix  y de todos los personajes para tambien dibujarlos		
			
				pedirPosFelix(); 
				pedirPosRalph(); 
				if (Ralph.getInstanciaRalph().ralphSeMovio()==false){
					g.drawImage(imgRalphQuieto, posXRalph, posYRalph, null); //Si Ralph no se movio, se dibuja quieto
				}
				else {
					if (Ralph.getInstanciaRalph().getDireccion() == Direcciones.DERECHA){ //Ralph se mueve a la derecha
						
//						BufferedImage imgAuxRalph = imgEdifPrimeraSec.getSubimage(posXRalph-25, posYRalph, imgRalphMovDerecha1.getWidth(), imgRalphMovDerecha1.getHeight());
//						g.drawImage(imgRalphMovDerecha1, posXRalph-25, posYRalph, null);
//						try {
//							Thread.sleep(100);
//						}
//						catch (InterruptedException e) {
//							e.printStackTrace();
//						}
//						g.drawImage(imgAuxRalph, posXRalph-25, posYRalph,null);
//						g.drawImage(imgRalphMovDerecha2,posXRalph-10,posYRalph,null);
//						imgAuxRalph = imgEdifPrimeraSec.getSubimage(posXRalph-10, posYRalph, imgRalphMovDerecha2.getWidth(), imgRalphMovDerecha2.getHeight());
//						try {
//							Thread.sleep(100);
//						}
//						catch (InterruptedException e) {
//							e.printStackTrace();
//						}
//						g.drawImage(imgAuxRalph, posXRalph-15, posYRalph, null);
						g.drawImage(imgRalphQuieto, posXRalph, posYRalph, null);
					
					}			
					else {	//Ralph se mueve a la izquierda
//						BufferedImage imgAuxRalph = imgEdifPrimeraSec.getSubimage(posXRalph+25, posYRalph, imgRalphMovIzquierda1.getWidth(), imgRalphMovIzquierda1.getHeight());
//						g.drawImage(imgRalphMovIzquierda1, posXRalph+25, posYRalph, null);
//						try {
//							Thread.sleep(100);
//						}
//						catch (InterruptedException e) {
//							e.printStackTrace();
//						}
//						g.drawImage(imgAuxRalph, posXRalph+25, posYRalph, null);
//						g.drawImage(imgRalphMovIzquierda2,posXRalph+10,posYRalph,null);
//						imgAuxRalph = imgEdifPrimeraSec.getSubimage(posXRalph+10, posYRalph, imgRalphMovIzquierda2.getWidth(), imgRalphMovIzquierda2.getHeight());
//						try {
//							Thread.sleep(100);
//						}
//						catch (InterruptedException e) {
//							e.printStackTrace();
//						}
//						g.drawImage(imgAuxRalph, posXRalph+15, posYRalph, null);
						g.drawImage(imgRalphQuieto, posXRalph, posYRalph, null);
					} 
						
				}
						
				
				if (AdaptadorTecla.isSpacebarPressed()==false && AdaptadorTecla.isArrowPressed()==true){ //Chequea si se presiona una de las flechas
					if (Felix.getInstanciaFelix().getUltimaDireccion() == Direcciones.DERECHA){
//						BufferedImage imgAuxFelix = bi.getSubimage(posXFelix-15, posYFelix, imgFelixDerMov.getWidth(), imgFelixDerMov.getHeight());
//						g.drawImage(imgFelixDerMov, posXFelix-15, posYFelix, null);
//						try{
//							Thread.sleep(10);
//						}
//						catch (InterruptedException e){
//							e.printStackTrace();
//						}
//						g.drawImage(imgAuxFelix, posXFelix-15, posYFelix, imgFelixDerMov.getWidth(), imgFelixDerMov.getHeight(),null);
						g.drawImage(imgFelixDerQuieto, posXFelix, posYFelix, null);
					}
					else if (Felix.getInstanciaFelix().getUltimaDireccion() == Direcciones.IZQUIERDA){
//						BufferedImage imgAux = bi.getSubimage(posXFelix-imgFelixIzqMov.getWidth(), posYFelix, imgFelixIzqMov.getWidth(), imgFelixIzqMov.getHeight());
//						g.drawImage(imgFelixIzqMov, posXFelix-imgFelixIzqMov.getWidth(), posYFelix, null);
//						try{
//							Thread.sleep(100);
//						}
//						catch (InterruptedException e){
//							e.printStackTrace();
//						}
//						g.drawImage(imgAux, posXFelix-imgFelixIzqMov.getWidth(), posYFelix, imgFelixDerMov.getWidth(), imgFelixDerMov.getHeight(),null);
						g.drawImage(imgFelixIzqQuieto, posXFelix, posYFelix, null);
					}
				}
			else{//	 if (AdaptadorTecla.isSpacebarPressed()){ //Chequea si se presiono la barra espaciadora
//					if(Felix.getInstanciaFelix().getUltimaDireccion()==Direcciones.DERECHA){ 
//						BufferedImage imgAuxFelixMart = imgEdifPrimeraSec.getSubimage(posXFelix, posYFelix, imgVentanaComunSana.getWidth(), imgVentanaComunSana.getHeight());
//						g.drawImage(imgFelixMartillazoDer, posXFelix, posYFelix, null);
//						try {
//							Thread.sleep(100);
//						}
//						catch (InterruptedException e){
//							e.printStackTrace();
//						}
//						g.drawImage(imgAuxFelixMart, posXFelix, posYFelix, imgVentanaComunSana.getWidth(), imgVentanaComunSana.getHeight(),null);
//						g.drawImage(imgFelixDerQuieto, posXFelix, posYFelix, null);
//					}
//					else if(Felix.getInstanciaFelix().getUltimaDireccion()==Direcciones.IZQUIERDA){
//						BufferedImage imgAuxFelixMart = imgEdifPrimeraSec.getSubimage(posXFelix, posYFelix, imgVentanaComunSana.getWidth(), imgVentanaComunSana.getHeight());
//						g.drawImage(imgFelixMartillazoIzq, posXFelix, posYFelix, null);
//						try {
//							Thread.sleep(100);
//						}
//						catch (InterruptedException e){
//							e.printStackTrace();
//						}
//						g.drawImage(imgAuxFelixMart, posXFelix, posYFelix, imgVentanaComunSana.getWidth(), imgVentanaComunSana.getHeight(),null);
//						g.drawImage(imgFelixIzqQuieto, posXFelix, posYFelix, null);
//					}
//				}else{ //dibuja a felix en la posicion actual
					if(Felix.getInstanciaFelix().getUltimaDireccion()==Direcciones.DERECHA)						
						g.drawImage(imgFelixDerQuieto, posXFelix,posYFelix,null);					
					else
						g.drawImage(imgFelixIzqQuieto, posXFelix,posYFelix,null);						
				}
				
//				if (Ralph.getInstanciaRalph().isRalphTiroLadrillo()){
//					BufferedImage imgAuxRalphLad = imgEdifPrimeraSec.getSubimage(posXRalph, posYRalph, imgRalphQuieto.getWidth(), imgRalphQuieto.getHeight());
//					for (int i=0;i<2;i++){
//						g.drawImage(imgRalphGolpeDer,posXRalph,posYRalph,null);
//						try {
//							Thread.sleep(100);
//						}
//						catch (InterruptedException e){
//							e.printStackTrace();
//						}
////						g.drawImage(imgAuxRalphLad,posXRalph,posYRalph,null);
//						g.drawImage(imgRalphGolpeIzq,posXRalph,posYRalph,null);
//						try {
//							Thread.sleep(100);
//						}
//						catch (InterruptedException e){
//							e.printStackTrace();
//						}
//						g.drawImage(imgAuxRalphLad,posXRalph,posYRalph,null);				
//					}
//					g.drawImage(imgRalphQuieto, posXRalph, posYRalph, null);
//				}
				for (int i=0;i<Ralph.getInstanciaRalph().getCantLadrillosEnArreglo();i++){
//					g.drawImage(imgLadrilloDer,Ralph.getInstanciaRalph().getLadrillo(0).getPosLadrillo().getPosX(),Ralph.getInstanciaRalph().getLadrillo(0).getPosLadrillo().getPosY(),null);
				pedirPosLadrillo(i);
				g.drawImage(imgLadrilloDer,posXLadrillo,posYLadrillo,null);
				}
				if (Nicelander.getInstanciaNicelander().isHayPastel()){
					Ventana v = matrizVentana[Pastel.getPosPastel().getPosX()][Pastel.getPosPastel().getPosY()];
//					Ventana v = Mapa.buscarVentanaMasCercana(Pastel.getPosPastel());
					g.drawImage(imgPastel, v.getPosV().getPosX()+10,v.getPosV().getPosY()+25,null);
				}
				AdaptadorTecla.setPressedArrow(false);
				AdaptadorTecla.setPressedSpacebar(false);
				Ralph.getInstanciaRalph().setRalphSeMovio(false);
										
			break;
		case (2):
			g.drawImage(imgFondoSinPasto.getImage(), 0, 0, null);		
			g.drawImage(imgEdifSegundaSec, 10, 0, null);
			for (int j = 0; j < 4; j++) { // filas
				for (int i = 0; i < 5; i++) { // columnas
					if(j==0){
						g.drawImage(imgVentanaComunSana, 49 + i * 50, 22+ j * 75, null);						
					}else{
					if (matrizVentana[j-1][i].esComun() == true) {
						Comun ventanaComun = (Comun) matrizVentana[j-1][i];

						switch (matrizVentana[j-1][i].getPanel(0, 0).getEstado()) {
						case ROTOCOMPLETO:
							switch (matrizVentana[j-1][i].getPanel(1, 0)
									.getEstado()) {
							case ROTOCOMPLETO:
								if (ventanaComun.isConMacetero())
									g.drawImage(ventanaRotaConMacetero,
											49 + i * 50, 28 + j * 75, null);
								else if (ventanaComun.isConMoldura())
									g.drawImage(ventanaRotaConMoldura,
											49 + i * 50, 28 + j * 75, null);
								else
									g.drawImage(imgVentanaComunTodaRota,
											49 + i * 50, 28 + j * 75, null);
								break;
							case MEDIOROTO:
								if (ventanaComun.isConMacetero())
									g.drawImage(
											ventanaRotaArribaYMediaRotaAbajoConMacetero,
											49 + i * 50, 28 + j * 75, null);
								else if (ventanaComun.isConMoldura())
									g.drawImage(
											ventanaRotaArribaYMediaRotaAbajoConMoldura,
											49 + i * 50, 28 + j * 75, null);
								else
									g.drawImage(
											ventanaRotaArribaYMediaRotaAbajo,
											49 + i * 50, 28 + j * 75, null); // ventanaComunRotaCompletaArribaYMediaRotaAbajo
								break;
							case SANO:
								if (ventanaComun.isConMacetero())
									g.drawImage(
											ventanaRotaArribaYSanaAbajoConMacetero,
											49 + i * 50, 28 + j * 75, null);
								else if (ventanaComun.isConMoldura())
									g.drawImage(
											ventanaRotaArribaYSanaAbajoConMoldura,
											49 + i * 50, 28 + j * 75, null);
								else
									g.drawImage(ventanaRotaCompletaArriba,
											49 + i * 50, 28 + j * 75, null); // ventanaComunRotaCompletaArriba
								break;
							}
							break;
						case MEDIOROTO:
							switch (matrizVentana[j-1][i].getPanel(1, 0)
									.getEstado()) {
							case ROTOCOMPLETO:
								if (ventanaComun.isConMacetero())
									g.drawImage(
											ventanaMediaRotaArribaYRotaAbajoConMacetero,
											49 + i * 50, 28 + j * 75, null);
								else if (ventanaComun.isConMoldura())
									g.drawImage(
											ventanaMediaRotaArribaYRotaAbajoConMoldura,
											49 + i * 50, 28 + j * 75, null);
								else
									g.drawImage(
											ventanaComunMediaRotaArribaYRotaAbajo,
											49 + i * 50, 28 + j * 75, null);
								break;
							case MEDIOROTO:
								if (ventanaComun.isConMacetero())
									g.drawImage(ventanaMediaRotaConMacetero,
											49 + i * 50, 28 + j * 75, null);
								else if (ventanaComun.isConMoldura())
									g.drawImage(ventanaMediaRotaConMoldura,
											49 + i * 50, 28 + j * 75, null);
								else
									g.drawImage(ventanaComunMediaRota,
											49 + i * 50, 28 + j * 75, null);
								break;
							case SANO:
								if (ventanaComun.isConMacetero())
									g.drawImage(
											ventanaMediaRotaArribaYSanaAbajoConMacetero,
											49 + i * 50, 28 + j * 75, null);
								else if (ventanaComun.isConMoldura())
									g.drawImage(
											ventanaMediaRotaArribaYSanaAbajoConMoldura,
											49 + i * 50, 28 + j * 75, null);
								else
									g.drawImage(ventanaComunMediaRotaArriba,
											49 + i * 50, 28 + j * 75, null);
								break;
							}
							break;
						case SANO:
							switch (matrizVentana[j-1][i].getPanel(1, 0)
									.getEstado()) {
							case ROTOCOMPLETO:
								if (ventanaComun.isConMacetero())
									g.drawImage(
											ventanaSanaArribaYRotaAbajoConMacetero,
											49 + i * 50, 28 + j * 75, null);
								else if (ventanaComun.isConMoldura())
									g.drawImage(
											ventanaSanaArribaYRotaAbajoConMacetero,
											49 + i * 50, 28 + j * 75, null);
								else
									g.drawImage(ventanaComunRotaCompletaAbajo,
											49 + i * 50, 28 + j * 75, null);
								break;
							case MEDIOROTO:
								if (ventanaComun.isConMacetero())
									g.drawImage(
											ventanaMediaRotaAbajoConMacetero,
											49 + i * 50, 28 + j * 75, null);
								else if (ventanaComun.isConMoldura())
									g.drawImage(
											ventanaMediaRotaAbajoConMoldura,
											49 + i * 50, 28 + j * 75, null);
								else
									g.drawImage(ventanaComunMediaRotaAbajo,
											49 + i * 50, 28 + j * 75, null);
								break;
							case SANO:
								if (ventanaComun.isConMacetero())
									g.drawImage(ventanaSanaConMacetero,
											49 + i * 50, 28 + j * 75, null);
								else if (ventanaComun.isConMoldura())
									g.drawImage(ventanaSanaConMoldura,
											49 + i * 50, 28 + j * 75, null);
								else
									g.drawImage(imgVentanaComunSana,
											49 + i * 50, 28 + j * 75, null);
								break;
							}// cierra el switch1
							break;
						}// cierra el switch2
					} // cierra el if((i==2 && (j!=2 && j!=3)) || i!=2 )
					else {
						ConHojas ventanaConHoja = (ConHojas) matrizVentana[j-1][i];
						if (ventanaConHoja.isAbierta())
							g.drawImage(ventanaAbierta, 49 + i * 50,
									28 + j * 75, null);
						else
							g.drawImage(ventanaCerrada, 49 + i * 50,
									28 + j * 75, null);
					}//cierra el else j==0
				}// cierra el else de como es la ventana
			}// segundo for
		} // primer for
			pedirPosFelix(); 
			pedirPosRalph(); 
			if (Ralph.getInstanciaRalph().ralphSeMovio()==false){
				g.drawImage(imgRalphQuieto, posXRalph, posYRalph, null); //Si Ralph no se movio, se dibuja quieto
			}
			else {
				if (Ralph.getInstanciaRalph().getDireccion() == Direcciones.DERECHA){ //Ralph se mueve a la derecha
					g.drawImage(imgRalphQuieto, posXRalph, posYRalph, null);
				} 				
			}			
			if (AdaptadorTecla.isSpacebarPressed()==false && AdaptadorTecla.isArrowPressed()==true){ //Chequea si se presiona una de las flechas
				if (Felix.getInstanciaFelix().getUltimaDireccion() == Direcciones.DERECHA){
					g.drawImage(imgFelixDerQuieto, posXFelix, posYFelix, null);
				}
				else if (Felix.getInstanciaFelix().getUltimaDireccion() == Direcciones.IZQUIERDA){
					g.drawImage(imgFelixIzqQuieto, posXFelix, posYFelix, null);
				}
			}
		else{
				if(Felix.getInstanciaFelix().getUltimaDireccion()==Direcciones.DERECHA)						
					g.drawImage(imgFelixDerQuieto, posXFelix,posYFelix,null);					
				else
					g.drawImage(imgFelixIzqQuieto, posXFelix,posYFelix,null);						
			}			
			if (Ralph.getInstanciaRalph().isRalphTiroLadrillo()){
//				BufferedImage imgAuxRalphLad = imgEdifPrimeraSec.getSubimage(posXRalph, posYRalph, imgRalphQuieto.getWidth(), imgRalphQuieto.getHeight());
//				for (int i=0;i<2;i++){
//					g.drawImage(imgRalphGolpeDer,posXRalph,posYRalph,null);
//					try {
//						Thread.sleep(100);
//					}
//					catch (InterruptedException e){
//						e.printStackTrace();
//					}
//					g.drawImage(imgAuxRalphLad,posXRalph,posYRalph,null);
//					g.drawImage(imgRalphGolpeIzq,posXRalph,posYRalph,null);
//					try {
//						Thread.sleep(100);
//					}
//					catch (InterruptedException e){
//						e.printStackTrace();
//					}
//					g.drawImage(imgAuxRalphLad,posXRalph,posYRalph,null);				
//				}
				g.drawImage(imgRalphQuieto, posXRalph, posYRalph, null);
		}
			for (int i=0;i<Ralph.getInstanciaRalph().getCantLadrillosEnArreglo();i++){
				g.drawImage(imgLadrilloDer,Ralph.getInstanciaRalph().getLadrillo(i).getPosLadrillo().getPosX(),Ralph.getInstanciaRalph().getLadrillo(i).getPosLadrillo().getPosY(),null);
			}
			if (Nicelander.getInstanciaNicelander().isHayPastel()){
				Ventana v = Mapa.buscarVentanaMasCercana(Pastel.getPosPastel());
				g.drawImage(imgPastel, v.getPosV().getPosX(),v.getPosV().getPosY(),null);
			}
			for(int p=0;p<ArregloDePajaros.getInstancia().cantidadArreglo();p++){
				pedirPosPajaro(p);
				if(ArregloDePajaros.getInstancia().getPajaro(p).getUltimaDir()==Direcciones.DERECHA)
					g.drawImage(imgPajaroDer1,posXPajaro,posYPajaro,null);
				else
					g.drawImage(imgPajaroIzq1,posXPajaro,posYPajaro,null);
			}
			AdaptadorTecla.setPressedArrow(false);
			AdaptadorTecla.setPressedSpacebar(false);
			Ralph.getInstanciaRalph().setRalphSeMovio(false);
	
			break;
	
			case (3):
				g.drawImage(imgFondoSinPasto.getImage(), 0, 0, null);		
				g.drawImage(imgEdifTerceraSec, 10,0, null);
			for (int j=0; j<3; j++) { //filas
				for (int i=0; i<5; i++) {		//columnas
	
					if(matrizVentana[j][i].esComun()==true){
						Comun ventanaComun= (Comun)matrizVentana[j][i];
					
								switch (matrizVentana[j][i].getPanel(0,0).getEstado()) {
									case ROTOCOMPLETO:
										switch (matrizVentana[j][i].getPanel(1, 0).getEstado()) {
											case ROTOCOMPLETO:
												if (ventanaComun.isConMacetero())
													g.drawImage(ventanaRotaConMacetero, 49 + i * 50, 100 + j * 75,null);
												else	
													if (ventanaComun.isConMoldura())
														g.drawImage(ventanaRotaConMoldura,49 + i * 50, 100 + j * 75,null);
													else
												g.drawImage(imgVentanaComunTodaRota, 49 + i * 50, 100 + j * 75,null);
												break;
											case MEDIOROTO:
												if (ventanaComun.isConMacetero())
													g.drawImage(ventanaRotaArribaYMediaRotaAbajoConMacetero, 49 + i * 50, 100 + j * 75,null);
												else	
													if (ventanaComun.isConMoldura())
														g.drawImage(ventanaRotaArribaYMediaRotaAbajoConMoldura,49 + i * 50, 100 + j * 75,null);
													else
												g.drawImage(ventanaRotaArribaYMediaRotaAbajo, 49 + i * 50, 100 + j * 75, null); //ventanaComunRotaCompletaArribaYMediaRotaAbajo
												break;
											case SANO:
												if (ventanaComun.isConMacetero())
													g.drawImage(ventanaRotaArribaYSanaAbajoConMacetero, 49 + i * 50, 100 + j * 75,null);
												else	
													if (ventanaComun.isConMoldura())
														g.drawImage(ventanaRotaArribaYSanaAbajoConMoldura,49 + i * 50, 100 + j * 75,null);
													else
												g.drawImage(ventanaRotaCompletaArriba, 49 + i * 50, 100 + j * 75,null); //ventanaComunRotaCompletaArriba
											break;
										}
									break;
									case MEDIOROTO:
										switch (matrizVentana[j][i].getPanel(1,0).getEstado()) {
											case ROTOCOMPLETO:
												if (ventanaComun.isConMacetero())
													g.drawImage(ventanaMediaRotaArribaYRotaAbajoConMacetero, 49 + i * 50, 100 + j * 75,null);
												else	
													if (ventanaComun.isConMoldura())
														g.drawImage(ventanaMediaRotaArribaYRotaAbajoConMoldura,49 + i * 50, 100 + j * 75,null);
													else
												g.drawImage(ventanaComunMediaRotaArribaYRotaAbajo, 49 + i * 50,   100+j * 75,null);
												break;
											case MEDIOROTO:
												if (ventanaComun.isConMacetero())
													g.drawImage(ventanaMediaRotaConMacetero, 49 + i * 50, 100 + j * 75,null);
												else	
													if (ventanaComun.isConMoldura())
														g.drawImage(ventanaMediaRotaConMoldura,49 + i * 50, 100 + j * 75,null);
													else
												g.drawImage(ventanaComunMediaRota, 49 + i * 50, 100 + j * 75,null);
												break;
											case SANO:
												if (ventanaComun.isConMacetero())
													g.drawImage(ventanaMediaRotaArribaYSanaAbajoConMacetero, 49 + i * 50, 100 + j * 75,null);
												else	
													if (ventanaComun.isConMoldura())
														g.drawImage(ventanaMediaRotaArribaYSanaAbajoConMoldura,49 + i * 50, 100 + j * 75,null);
													else
												g.drawImage(ventanaComunMediaRotaArriba, 49 + i * 50, 100 + j * 75,null);
												break;
										}
									break;
									case SANO:
										switch (matrizVentana[j][i].getPanel(1,0).getEstado()) {
											case ROTOCOMPLETO:
												if (ventanaComun.isConMacetero())
													g.drawImage(ventanaSanaArribaYRotaAbajoConMacetero, 49 + i * 50, 100 + j * 75,null);
												else	
													if (ventanaComun.isConMoldura())
														g.drawImage(ventanaSanaArribaYRotaAbajoConMacetero,49 + i * 50, 100 + j * 75,null);
													else
												g.drawImage(ventanaComunRotaCompletaAbajo, 49 + i * 50, 100 + j * 75,null);
												break;
											case MEDIOROTO:
												if (ventanaComun.isConMacetero())
													g.drawImage(ventanaMediaRotaAbajoConMacetero, 49 + i * 50, 100 + j * 75,null);
												else	
													if (ventanaComun.isConMoldura())
														g.drawImage(ventanaMediaRotaAbajoConMoldura,49 + i * 50, 100 + j * 75,null);
													else
												g.drawImage(ventanaComunMediaRotaAbajo, 49 + i * 50, 100 + j * 75,null);
												break;
											case SANO:
												if (ventanaComun.isConMacetero())
													g.drawImage(ventanaSanaConMacetero, 49 + i * 50, 100 + j * 75,null);
												else	
													if (ventanaComun.isConMoldura())
														g.drawImage(ventanaSanaConMoldura,49 + i * 50, 100 + j * 75,null);
													else
												g.drawImage(imgVentanaComunSana, 49+ i * 50, 100 + j * 75,null);
												break;
										}// cierra el switch1
									break;
								}// cierra el switch2
							}	// cierra el  if((i==2 && (j!=2 && j!=3)) || i!=2 )		
					else{
						ConHojas ventanaConHoja= (ConHojas)matrizVentana[j][i];
					if(ventanaConHoja.isAbierta())
						g.drawImage(ventanaAbierta,49+ i * 50, 100 + j * 75,null);
						else
							g.drawImage(ventanaCerrada,49+ i * 50, 100 + j * 75,null);
					}//cierra el else de como es la ventana
				}//segundo for	
				} 	//primer for
			pedirPosFelix(); 
			pedirPosRalph(); 
			if (Ralph.getInstanciaRalph().ralphSeMovio()==false){
				g.drawImage(imgRalphQuieto, posXRalph, posYRalph, null); //Si Ralph no se movio, se dibuja quieto
			}
			else {
				if (Ralph.getInstanciaRalph().getDireccion() == Direcciones.DERECHA){ //Ralph se mueve a la derecha
					g.drawImage(imgRalphQuieto, posXRalph, posYRalph, null);
				} 				
			}			
			if (AdaptadorTecla.isSpacebarPressed()==false && AdaptadorTecla.isArrowPressed()==true){ //Chequea si se presiona una de las flechas
				if (Felix.getInstanciaFelix().getUltimaDireccion() == Direcciones.DERECHA){
					g.drawImage(imgFelixDerQuieto, posXFelix, posYFelix, null);
				}
				else if (Felix.getInstanciaFelix().getUltimaDireccion() == Direcciones.IZQUIERDA){
					g.drawImage(imgFelixIzqQuieto, posXFelix, posYFelix, null);
				}
			}
		else{
				if(Felix.getInstanciaFelix().getUltimaDireccion()==Direcciones.DERECHA)						
					g.drawImage(imgFelixDerQuieto, posXFelix,posYFelix,null);					
				else
					g.drawImage(imgFelixIzqQuieto, posXFelix,posYFelix,null);						
			}			
			if (Ralph.getInstanciaRalph().isRalphTiroLadrillo()){
//				BufferedImage imgAuxRalphLad = imgEdifPrimeraSec.getSubimage(posXRalph, posYRalph, imgRalphQuieto.getWidth(), imgRalphQuieto.getHeight());
//				for (int i=0;i<2;i++){
//					g.drawImage(imgRalphGolpeDer,posXRalph,posYRalph,null);
//					try {
//						Thread.sleep(100);
//					}
//					catch (InterruptedException e){
//						e.printStackTrace();
//					}
//					g.drawImage(imgAuxRalphLad,posXRalph,posYRalph,null);
//					g.drawImage(imgRalphGolpeIzq,posXRalph,posYRalph,null);
//					try {
//						Thread.sleep(100);
//					}
//					catch (InterruptedException e){
//						e.printStackTrace();
//					}
//					g.drawImage(imgAuxRalphLad,posXRalph,posYRalph,null);				
//				}
				g.drawImage(imgRalphQuieto, posXRalph, posYRalph, null);
		}
			for (int i=0;i<Ralph.getInstanciaRalph().getCantLadrillosEnArreglo();i++){
				g.drawImage(imgLadrilloDer,Ralph.getInstanciaRalph().getLadrillo(i).getPosLadrillo().getPosX(),Ralph.getInstanciaRalph().getLadrillo(i).getPosLadrillo().getPosY(),null);
			}
			if (Nicelander.getInstanciaNicelander().isHayPastel()){
				Ventana v = Mapa.buscarVentanaMasCercana(Pastel.getPosPastel());
				g.drawImage(imgPastel, v.getPosV().getPosX(),v.getPosV().getPosY(),null);
			}
			for(int p=0;p<ArregloDePajaros.getInstancia().cantidadArreglo();p++){
				pedirPosPajaro(p);
				if(ArregloDePajaros.getInstancia().getPajaro(p).getUltimaDir()==Direcciones.DERECHA)
					g.drawImage(imgPajaroDer1,posXPajaro,posYPajaro,null);
				else
					g.drawImage(imgPajaroIzq1,posXPajaro,posYPajaro,null);
			}
			AdaptadorTecla.setPressedArrow(false);
			AdaptadorTecla.setPressedSpacebar(false);
			Ralph.getInstanciaRalph().setRalphSeMovio(false);
			break;	
		}
//		gr.drawImage(bi, 1, 1, null);
			//tengo que pedir la posicion de felix  y de todos los personajes para tambien dibujarlos		

//			pedirPosFelix();
//			g.drawImage(imgFelixIzqQuieto,posXFelix, posYFelix, null); //245,250 es la pos inicial de felix
//			//g.drawImage(imgFelixIzqMov, 195,250,null);
//			pedirPosRalph();
//			g.drawImage(imgRalphQuieto, posXRalph,posYRalph, null);
//			//tengo que hacer algo para que parezca que se esta moviendo y que llegue a la pos donde se encuentra			
			
	}	
	
//	public class MiClase extends JPanel {
//		public void update(Graphics g) {
//			cargarEdificio(g);
//		}
//	}
	
	class MiPanelPrimera extends JPanel{
		@Override
			protected void paintComponent(Graphics g){
//				super.paintComponent(g);
//				this.setDoubleBuffered(true);
				cargarEdificio(g);	
		}
	}	
	public void pedirPosLadrillo(int i){
		posXLadrillo=Ralph.getInstanciaRalph().getLadrillo(i).getPosLadrillo().getPosX();
		posYLadrillo=Ralph.getInstanciaRalph().getLadrillo(i).getPosLadrillo().getPosY();
	}
	public void pedirPosFelix(){
		posXFelix=Felix.getInstanciaFelix().getPosFelix().getPosX();
		posYFelix=Felix.getInstanciaFelix().getPosFelix().getPosY();		
	}
	public void pedirPosRalph(){
		posXRalph=Ralph.getInstanciaRalph().getPosRalph().getPosX();
		posYRalph=Ralph.getInstanciaRalph().getPosRalph().getPosY();	
	}
	public void pedirPosPajaro(int i){
		posXPajaro=ArregloDePajaros.getInstancia().getPajaro(i).getPos().getPosX();
		posYPajaro=ArregloDePajaros.getInstancia().getPajaro(i).getPos().getPosY();
	}
	
	public void volverAPintar(){
		repaint();	//segun parece no hace falta saber en que seccion estoy porque al hacer el repaint directamente busca el paintComponent que se debe ejecutar
	}
	
	public void cargarImagenes(){
		imgFondoConPasto = new ImageIcon(this.getClass().getClassLoader().getResource("Imagenes/fondoNegro.jpg"));	
		imgFondoSinPasto = new ImageIcon(this.getClass().getClassLoader().getResource("Imagenes/fondoNegroSinPasto.png"));	
		//slice100_@_mac.png
		//ventanaMediaRotaArribaYSanaAbajoConMacetero
		
		imgVentana="Imagenes/Nueva carpeta/ventanas con obstaculos/slice109_@_mac.png";
		imgUrl = getClass().getClassLoader().getResource(imgVentana);		
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgVentana);
		}else{
			try {
				ventanaMediaRotaArribaYSanaAbajoConMacetero = ImageIO.read(imgUrl); // carga imagen en img				
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}	
		
		//ventanaMediaRotaArribaYSanaAbajoConMoldura
		imgVentana="Imagenes/Nueva carpeta/ventanas con obstaculos/slice109_@.png";
		imgUrl = getClass().getClassLoader().getResource(imgVentana);		
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgVentana);
		}else{
			try {
				ventanaMediaRotaArribaYSanaAbajoConMoldura = ImageIO.read(imgUrl); // carga imagen en img				
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}	
		
		//ventanaRotaArribaYMediaRotaAbajoConMacetero
		imgVentana="Imagenes/Nueva carpeta/ventanas con obstaculos/slice114_@_mac.png";
		imgUrl = getClass().getClassLoader().getResource(imgVentana);		
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgVentana);
		}else{
			try {
				ventanaRotaArribaYMediaRotaAbajoConMacetero = ImageIO.read(imgUrl); // carga imagen en img				
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}	
		imgFelix="Imagenes/Nueva carpeta/felix/slice67_67.png"; //Revisar si es la imagen correcta 
		imgUrl = getClass().getClassLoader().getResource(imgFelix);		
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgFelix);
		}else{
			try {
				imgFelixDerMov = ImageIO.read(imgUrl); // carga imagen en img				
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	
		
		//ventanaRotaArribaYMediaRotaAbajoConMoldura
		
		imgVentana="Imagenes/Nueva carpeta/ventanas con obstaculos/slice114_@_m.png";
		imgUrl = getClass().getClassLoader().getResource(imgVentana);		
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgVentana);
		}else{
			try {
				ventanaRotaArribaYMediaRotaAbajoConMoldura = ImageIO.read(imgUrl); // carga imagen en img				
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}	
		
		//ventanaRotaArribaYSanaAbajoConMacetero
		
		imgVentana="Imagenes/Nueva carpeta/ventanas con obstaculos/slice112_@_mac.png";
		imgUrl = getClass().getClassLoader().getResource(imgVentana);		
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgVentana);
		}else{
			try {
				ventanaRotaArribaYSanaAbajoConMacetero = ImageIO.read(imgUrl); // carga imagen en img				
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}	
		
		//cargo imagen ralph moviendose a la derecha
		
		ralph="Imagenes/Nueva carpeta/ralph/slice147_@.png";
		imgUrl = getClass().getClassLoader().getResource(ralph);		
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+ralph);
		}else{
			try {
				imgRalphMovDerecha1 = ImageIO.read(imgUrl); // carga imagen en img				
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		ralph="Imagenes/Nueva carpeta/ralph/slice164_@.png";
		imgUrl = getClass().getClassLoader().getResource(ralph);		
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+ralph);
		}else{
			try {
				imgRalphGolpeIzq = ImageIO.read(imgUrl); // carga imagen en img				
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		pastel = "Imagenes/Nueva carpeta/pastel/slice12_12.png";
		imgUrl = getClass().getClassLoader().getResource(imgVentana);		
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgVentana);
		}else{
			try {
				imgPastel = ImageIO.read(imgUrl); // carga imagen en img
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		
		imgFelix= "Imagenes/Nueva carpeta/felix/slice84_84.png";
		imgUrl = getClass().getClassLoader().getResource(imgVentana);		
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgVentana);
		}else{
			try {
				imgFelixMartillazoDer = ImageIO.read(imgUrl); // carga imagen en img
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		imgFelix= "Imagenes/Nueva carpeta/felix/slice111_@.png";
		imgUrl = getClass().getClassLoader().getResource(imgVentana);		
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgVentana);
		}else{
			try {
				imgFelixMartillazoIzq = ImageIO.read(imgUrl); // carga imagen en img
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		
		//ventanaRotaArribaYSanaAbajoConMoldura
		
		imgVentana="Imagenes/Nueva carpeta/ventanas con obstaculos/slice112_@.png";
		imgUrl = getClass().getClassLoader().getResource(imgVentana);		
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgVentana);
		}else{
			try {
				ventanaRotaArribaYSanaAbajoConMoldura = ImageIO.read(imgUrl); // carga imagen en img				
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}	
		ralph="Imagenes/Nueva carpeta/ralph/slice147_@.png";
		imgUrl = getClass().getClassLoader().getResource(ralph);		
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+ralph);
		}else{
			try {
				imgRalphMovIzquierda1 = ImageIO.read(imgUrl); // carga imagen en img				
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		ralph="Imagenes/Nueva carpeta/ralph/slice148_@.png";
		imgUrl = getClass().getClassLoader().getResource(ralph);		
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+ralph);
		}else{
			try {
				imgRalphMovIzquierda2 = ImageIO.read(imgUrl); // carga imagen en img				
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		
		//ventanaSanaArribaYRotaAbajoConMacetero
		imgVentana="Imagenes/Nueva carpeta/ventanas con obstaculos/slice113_@_mac.png";
		imgUrl = getClass().getClassLoader().getResource(imgVentana);		
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgVentana);
		}else{
			try {
				ventanaSanaArribaYRotaAbajoConMacetero = ImageIO.read(imgUrl); // carga imagen en img				
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		ralph="Imagenes/Nueva carpeta/ralph/slice166_@.png";
		imgUrl = getClass().getClassLoader().getResource(ralph);		
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+ralph);
		}else{
			try {
				imgRalphGolpeDer = ImageIO.read(imgUrl); // carga imagen en img				
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		//ventanaSanaArribaYRotaAbajoConMoldura
		imgVentana="Imagenes/Nueva carpeta/ventanas con obstaculos/slice113_@_m.png";
		imgUrl = getClass().getClassLoader().getResource(imgVentana);		
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgVentana);
		}else{
			try {
				ventanaSanaArribaYRotaAbajoConMoldura = ImageIO.read(imgUrl); // carga imagen en img				
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		ralph="Imagenes/Nueva carpeta/ralph/slice148_@.png";
		imgUrl = getClass().getClassLoader().getResource(ralph);		
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+ralph);
		}else{
			try {
				imgRalphMovDerecha2 = ImageIO.read(imgUrl); // carga imagen en img				
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		//fondo negro
		

		//cargo imagenes de ventanas circulares 
		
		//cargo imagen de puerta sana
		imgVentana="Imagenes/Nueva carpeta/semicirculares/slice600_@.png";
		imgUrl = getClass().getClassLoader().getResource(imgVentana);		
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgVentana);
		}else{
			try {
				imgPuertaSana = ImageIO.read(imgUrl); // carga imagen en img				
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}	
		
		//cargo imagen de puerta semi rota arriba
		
		imgVentana="Imagenes/Nueva carpeta/semicirculares/slice601_@.png";
		imgUrl = getClass().getClassLoader().getResource(imgVentana);		
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgVentana);
		}else{
			try {
				imgPuertaRota = ImageIO.read(imgUrl); // carga imagen en img				
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}	
		
		//ventanaComunRotaCompletaAbajo
		imgVentana="Imagenes/Nueva carpeta/ventanas_y_panel sin obstaculos/slice113_@.png";
		imgUrl = getClass().getClassLoader().getResource(imgVentana);		
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgVentana);
		}else{
			try {
				ventanaComunRotaCompletaAbajo = ImageIO.read(imgUrl); // carga imagen en img				
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}	
		
		
		
		
//		imgVentana="Imagenes/Nueva carpeta/ventanas_y_panel sin obstaculos/ventanaRotaArribaYMediaRotaAbajo.png";
//		imgUrl = getClass().getClassLoader().getResource(imgVentana);		
//		if (imgUrl == null) {
//			System.err.println("No se encuentra el archivo:"+imgVentana);
//		}else{
//			try {
//				ventanaComunRotaCompletaArribaYMediaRotaAbajo = ImageIO.read(imgUrl); // carga imagen en img				
//			} catch (IOException ex) {
//				ex.printStackTrace();
//			}
//		}	
		
//		ventanaComunMediaRotaArriba
		imgVentana="Imagenes/Nueva carpeta/ventanas_y_panel sin obstaculos/slice101_@.png";
		imgUrl = getClass().getClassLoader().getResource(imgVentana);		
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgVentana);
		}else{
			try {
				ventanaComunMediaRotaArriba = ImageIO.read(imgUrl); // carga imagen en img				
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}	
		
		
//		ventanaComunRotaCompletaArribaYMediaRotaAbajo
//		imgVentana="Imagenes/Nueva carpeta/ventanas_y_panel sin obstaculos/ventanaRotaArribaYMediaRotaAbajo.png";
//		imgUrl = getClass().getClassLoader().getResource(imgVentana);		
//		if (imgUrl == null) {
//			System.err.println("No se encuentra el archivo:"+imgVentana);
//		}else{
//			try {
//				ventanaComunRotaCompletaArribaYMediaRotaAbajo = ImageIO.read(imgUrl); // carga imagen en img				
//			} catch (IOException ex) {
//				ex.printStackTrace();
//			}
//		}	
		
//		imgBalconSano
		imgVentana="Imagenes/Nueva carpeta/semicirculares/slice602_@.png";
		imgUrl = getClass().getClassLoader().getResource(imgVentana);		
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgVentana);
		}else{
			try {
				imgBalconSano = ImageIO.read(imgUrl); // carga imagen en img				
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		imgFelix="Imagenes/Nueva carpeta/felix/slice78_78.png";
		imgUrl = getClass().getClassLoader().getResource(imgFelix);		
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgFelix);
		}else{
			try {
				imgFelixDerQuieto = ImageIO.read(imgUrl); // carga imagen en img				
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		//cargo imagenes de Ralph
		
		//cargo imagen ralph quieto
		ralph="Imagenes/Nueva carpeta/ralph/slice146_@.png";
		imgUrl = getClass().getClassLoader().getResource(ralph);		
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+ralph);
		}else{
			try {
				imgRalphQuieto = ImageIO.read(imgUrl); // carga imagen en img				
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}	
		
		//cargo imagen ralph moviendose a la derecha
		
		ralph="Imagenes/Nueva carpeta/ralph/slice147_@.png";
		imgUrl = getClass().getClassLoader().getResource(ralph);		
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+ralph);
		}else{
			try {
				imgRalphMovDerecha = ImageIO.read(imgUrl); // carga imagen en img				
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		
		
		
		
		
		//cargo imagenes de los ladrillos
		
		//cargo imagen del ladrillo
		ladrillo="Imagenes/Nueva carpeta/rocas/slice10_10.png";
		imgUrl = getClass().getClassLoader().getResource(ladrillo);		
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+ladrillo);
		}else{
			try {
				imgLadrilloDer = ImageIO.read(imgUrl); // carga imagen en img				
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}	
		
		//cargo la otra imagen del ladrillo
		ladrillo="Imagenes/Nueva carpeta/rocas/slice11_11.png";
		imgUrl = getClass().getClassLoader().getResource(ladrillo);		
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+ladrillo);
		}else{
			try {
				imgLadrilloIzq = ImageIO.read(imgUrl); // carga imagen en img				
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}			
		
		//cargo imagenes del edificio
		
		//cargo imagen del edificio de la primera seccion para que constantemente no tenga que volver a cargarla siempre que voy a repintar
		imgEdificio="Imagenes/Nueva carpeta/edificio/edificio_150_seccion1.png";
		imgUrl = getClass().getClassLoader().getResource(imgEdificio);		
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgEdificio);
		}else{
			try {
				imgEdifPrimeraSec = ImageIO.read(imgUrl); // carga imagen en img				
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}	
		//cargo imagen del edificio de la segunda seccion.
		imgEdificio="Imagenes/Nueva carpeta/edificio/edificio_150_seccion2.png";
		imgUrl = getClass().getClassLoader().getResource(imgEdificio);		
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgEdificio);
		}else{
			try {
				imgEdifSegundaSec = ImageIO.read(imgUrl); // carga imagen en img				
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		//cargo imagen del edificio de la tercera seccion.
		String imgEdificio="Imagenes/Nueva carpeta/edificio/edificio_150_seccion3.png";
		URL imgUrl = getClass().getClassLoader().getResource(imgEdificio);		
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgEdificio);
		}else{
			try {
				imgEdifTerceraSec = ImageIO.read(imgUrl); // carga imagen en img				
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}	
		
		//Cargo imagenes de ventanas 
		
		//ventanaComunMediaRotaAbajo
		
		imgVentana="Imagenes/Nueva carpeta/ventanas_y_panel sin obstaculos/slice24_24.png";
		imgUrl = getClass().getClassLoader().getResource(imgVentana);		
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgVentana);
		}else{
			try {
				ventanaComunMediaRotaAbajo = ImageIO.read(imgUrl); // carga imagen en img
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}	
		
		//cargo imagen ventana ventanaComunMediaRotaArribaYRotaAbajo
		
		imgVentana="Imagenes/Nueva carpeta/ventanas_y_panel sin obstaculos/slice104_@.png";
		imgUrl = getClass().getClassLoader().getResource(imgVentana);		
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgVentana);
		}else{
			try {
				ventanaComunMediaRotaArribaYRotaAbajo = ImageIO.read(imgUrl); // carga imagen en img
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}	
		
		//cargo imagen ventna ventanaComunMediaRota
		
		imgVentana="Imagenes/Nueva carpeta/ventanas_y_panel sin obstaculos/slice102_@.png";
		imgUrl = getClass().getClassLoader().getResource(imgVentana);		
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgVentana);
		}else{
			try {
				ventanaComunMediaRota = ImageIO.read(imgUrl); // carga imagen en img
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		//cargo imagen de la ventana normal sana
		
		imgVentana="Imagenes/Nueva carpeta/ventanas_y_panel sin obstaculos/slice100_@.png";
		imgUrl = getClass().getClassLoader().getResource(imgVentana);		
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgVentana);
		}else{
			try {
				imgVentanaComunSana = ImageIO.read(imgUrl); // carga imagen en img
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		//cargo imagen de ventana comun toda rota
		
		imgVentana = "Imagenes/Nueva carpeta/ventanas_y_panel sin obstaculos/slice103_@.png";
		imgUrl = getClass().getClassLoader().getResource(imgVentana);		
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgVentana);
		}else{
			try {
				imgVentanaComunTodaRota = ImageIO.read(imgUrl); // carga imagen en img
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		//ventana cerrada
		
		imgVentana = "Imagenes/Nueva carpeta/ventanas_y_panel sin obstaculos/slice105_@.png";
		imgUrl = getClass().getClassLoader().getResource(imgVentana);		
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgVentana);
		}else{
			try {
				ventanaCerrada = ImageIO.read(imgUrl); // carga imagen en img
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		//cargo imagen ventana abierta
		
		imgVentana = "Imagenes/Nueva carpeta/ventanas_y_panel sin obstaculos/slice106_@.png";
		imgUrl = getClass().getClassLoader().getResource(imgVentana);		
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgVentana);
		}else{
			try {
				ventanaAbierta = ImageIO.read(imgUrl); // carga imagen en img
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		//cargo imagen ventana rota con macetero
		
		imgVentana = "Imagenes/Nueva carpeta/ventanas con obstaculos/slice103_@_mac.png";
		imgUrl = getClass().getClassLoader().getResource(imgVentana);		
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgVentana);
		}else{
			try {
				ventanaRotaConMacetero = ImageIO.read(imgUrl); // carga imagen en img
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
//		ventanaRotaConMoldura
		imgVentana = "Imagenes/Nueva carpeta/ventanas con obstaculos/slice103_@.png";
		imgUrl = getClass().getClassLoader().getResource(imgVentana);		
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgVentana);
		}else{
			try {
				ventanaRotaConMoldura = ImageIO.read(imgUrl); // carga imagen en img
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		
		
//		ventanaMediaRotaAbajoConMacetero
		imgVentana = "Imagenes/Nueva carpeta/ventanas con obstaculos/ventana media rota abajo con macetero.png";
		imgUrl = getClass().getClassLoader().getResource(imgVentana);		
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgVentana);
		}else{
			try {
				ventanaMediaRotaAbajoConMacetero = ImageIO.read(imgUrl); // carga imagen en img
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
//		ventanaMediaRotaAbajoConMoldura
		imgVentana = "Imagenes/Nueva carpeta/ventanas con obstaculos/ventana media rota abajo con moldura.png";
		imgUrl = getClass().getClassLoader().getResource(imgVentana);		
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgVentana);
		}else{
			try {
				ventanaMediaRotaAbajoConMoldura = ImageIO.read(imgUrl); // carga imagen en img
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
//		ventanaMediaRotaConMacetero
		imgVentana = "Imagenes/Nueva carpeta/ventanas con obstaculos/slice101_@_mac.png";
		imgUrl = getClass().getClassLoader().getResource(imgVentana);		
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgVentana);
		}else{
			try {
				ventanaMediaRotaConMacetero = ImageIO.read(imgUrl); // carga imagen en img
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
//		ventanaMediaRotaConMoldura
		imgVentana = "Imagenes/Nueva carpeta/ventanas con obstaculos/slice101_@.png";
		imgUrl = getClass().getClassLoader().getResource(imgVentana);		
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgVentana);
		}else{
			try {
				ventanaMediaRotaConMoldura = ImageIO.read(imgUrl); // carga imagen en img
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
//		ventanaMediaRotaArribaYRotaAbajoConMacetero
		imgVentana = "Imagenes/Nueva carpeta/ventanas con obstaculos/slice104_@_mac.png";
		imgUrl = getClass().getClassLoader().getResource(imgVentana);		
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgVentana);
		}else{
			try {
				ventanaMediaRotaArribaYRotaAbajoConMacetero = ImageIO.read(imgUrl); // carga imagen en img
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		imgVentana = "Imagenes/Nueva carpeta/ventanas con obstaculos/slice104_@.png";
		imgUrl = getClass().getClassLoader().getResource(imgVentana);		
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgVentana);
		}else{
			try {
				ventanaMediaRotaArribaYRotaAbajoConMoldura = ImageIO.read(imgUrl); // carga imagen en img
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		imgVentana = "Imagenes/Nueva carpeta/ventanas con obstaculos/slice100_@_mac.png";
		imgUrl = getClass().getClassLoader().getResource(imgVentana);		
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgVentana);
		}else{
			try {
				ventanaSanaConMacetero = ImageIO.read(imgUrl); // carga imagen en img
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		imgVentana = "Imagenes/Nueva carpeta/ventanas con obstaculos/slice100_@.png";
		imgUrl = getClass().getClassLoader().getResource(imgVentana);		
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgVentana);
		}else{
			try {
				ventanaSanaConMoldura = ImageIO.read(imgUrl); // carga imagen en img
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		imgVentana = "Imagenes/Nueva carpeta/ventanas_y_panel sin obstaculos/ventanaMediaRotaArriba.png";
		imgUrl = getClass().getClassLoader().getResource(imgVentana);		
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgVentana);
		}else{
			try {
				ventanaMediaRotaArriba = ImageIO.read(imgUrl); // carga imagen en img
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		imgVentana = "Imagenes/Nueva carpeta/ventanas_y_panel sin obstaculos/ventanaRotaArribaYMediaRotaAbajo.png";
		imgUrl = getClass().getClassLoader().getResource(imgVentana);		
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgVentana);
		}else{
			try {
				ventanaRotaArribaYMediaRotaAbajo = ImageIO.read(imgUrl); // carga imagen en img
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		
		imgVentana = "Imagenes/Nueva carpeta/ventanas_y_panel sin obstaculos/ventanaRotaCompletaArriba.png";
		imgUrl = getClass().getClassLoader().getResource(imgVentana);		
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgVentana);
		}else{
			try {
				ventanaRotaCompletaArriba = ImageIO.read(imgUrl); // carga imagen en img
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
	
		
		
		//Cargo imagenes de felix
		
		//cargo imagen de felix quieto mirando a la izquierda
		imgFelix="Imagenes/Nueva carpeta/felix/slice108_@.png";
		imgUrl = getClass().getClassLoader().getResource(imgFelix);		
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgFelix);
		}else{
			try {
				imgFelixIzqQuieto = ImageIO.read(imgUrl); // carga imagen en img				
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}	
		
		//cargo imagen felix moviendose a la izquierda con martillo
		imgFelix="Imagenes/Nueva carpeta/felix/slice107_@.png";
		imgUrl = getClass().getClassLoader().getResource(imgFelix);		
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgFelix);
		}else{
			try {
				imgFelixIzqMov = ImageIO.read(imgUrl); // carga imagen en img				
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}	
		
		imgVentana="Imagenes/Nueva carpeta/semicirculares/slice603_@.png";
		imgUrl = getClass().getClassLoader().getResource(imgVentana);		
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgVentana);
		}else{
			try {
				imgBalconRoto = ImageIO.read(imgUrl); // carga imagen en img				
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		imgPajaro="Imagenes/Nueva carpeta/pajaro/slice08_08.png";
		imgUrl = getClass().getClassLoader().getResource(imgPajaro);		
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgPajaro);
		}else{
			try {
				imgPajaroDer1 = ImageIO.read(imgUrl); // carga imagen en img				
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		imgPajaro="Imagenes/Nueva carpeta/pajaro/slice41_41.png";
		imgUrl = getClass().getClassLoader().getResource(imgPajaro);		
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgPajaro);
		}else{
			try {
				imgPajaroIzq1 = ImageIO.read(imgUrl); // carga imagen en img				
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}

