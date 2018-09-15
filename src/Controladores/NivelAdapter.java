package Controladores;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Grafica.PantallaPrincipal;

public class NivelAdapter extends MouseAdapter{
	public void mouseClicked (MouseEvent c){
		 String i=(String)PantallaPrincipal.getNivelList().getSelectedItem();
		 System.out.println(i);
	}
}
