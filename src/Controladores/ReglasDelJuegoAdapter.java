package Controladores;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import Grafica.PantallaPrincipal;
/**
 * Adapter del boton reglas de Pantalla Principal
 *
 */
public class ReglasDelJuegoAdapter extends MouseAdapter{			//en clases aparte en un paquete aparte Controlador
	JFrame frameReglasDelJuego=new JFrame();
	Image img2;
	Graphics g;
	
	public void mouseClicked (MouseEvent c){
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setEditable(false);
		String docFileName="Documentos/Reglas.txt";
		URL docURL = getClass().getClassLoader().getResource(docFileName);
		
		if (docURL != null) {
		    try {
		        editorPane.setPage(docURL);
		    } catch (IOException e) {
		        System.err.println("URL erronea: " + docURL);
		    }
		} else {
		    System.err.println("No se encontro el archivo");
		}
		
		JScrollPane editorScrollPane = new JScrollPane(editorPane);
		PantallaPrincipal.getInst().add(editorScrollPane, BorderLayout.NORTH);
		
		img2=cargarImagen(g);													
		ImageIcon icon = new ImageIcon(img2); 			
		JLabel thumb = new JLabel(icon,JLabel.CENTER);
		PantallaPrincipal.getInst().add(thumb, BorderLayout.CENTER);					//cargo una imagen en el panel y la coloco en el centro de inst
		
		frameReglasDelJuego.add(PantallaPrincipal.getInst());			//agrego el panel inst al frame que aparece cuando se apreta el boton
		frameReglasDelJuego.setSize(800, 700);
		frameReglasDelJuego.setTitle("Reglas Del Juego");
		frameReglasDelJuego.setResizable(true);
		frameReglasDelJuego.setLocationRelativeTo(null);
		frameReglasDelJuego.setVisible(true);			
	}
	
	public Image cargarImagen(Graphics g){
		String imgFileName="Imagenes/instrucciones.png";
		URL imgUrl = getClass().getClassLoader().getResource(imgFileName);
		if (imgUrl == null) {
			System.err.println("No se encuentra el archivo:"+imgFileName);
		}else{
			try {
				img2 = ImageIO.read(imgUrl); // carga imagen en img
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return img2;
	}

}	