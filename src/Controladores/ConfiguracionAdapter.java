package Controladores;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import Controladores.AceptarConfigAdapter;
import Grafica.PantallaPrincipal;
/**
 * Adapter del boton de Configuración de la pantalla principal
 *
 */
public class ConfiguracionAdapter extends MouseAdapter{
	JButton aceptarConfig=new JButton();
	JButton cancelar=new JButton();
	public void mouseClicked (MouseEvent c){					
		
		aceptarConfig.addMouseListener(new AceptarConfigAdapter());
		aceptarConfig.setText("Aceptar");		//boton de aceptar 			
		cancelar.addMouseListener(new CancelarConfigAdapter());
		cancelar.setText("Cancelar");			//boton de cancelar
		PantallaPrincipal.getFrameConfig().setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add(aceptarConfig);
		panel.add(cancelar);
		PantallaPrincipal.getFrameConfig().add(panel,BorderLayout.SOUTH);
		//PantallaPrincipal.getFrameConfig()..add(cancelar, BorderLayout.SOUTH);
		PantallaPrincipal.getFrameConfig().setResizable(true);
		PantallaPrincipal.getFrameConfig().setLocationRelativeTo(null);
		PantallaPrincipal.getFrameConfig().add(PantallaPrincipal.getPanelConfig());
		PantallaPrincipal.getFrameConfig().setSize(300, 120);
		PantallaPrincipal.getFrameConfig().setTitle("Configuración");
		PantallaPrincipal.getFrameConfig().setVisible(true);
	}
}	