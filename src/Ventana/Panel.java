package Ventana;


public class Panel {
	private EstadoVentana estado;
//	private int cantMartillazos;
	
//	public int getCantMartillazos() {
//		return cantMartillazos;
//	}
//	public void setCantMartillazos(int cantMartillazos) {
//		this.cantMartillazos = cantMartillazos;
//	}
	
	public EstadoVentana getEstado(){
		return estado;
	}
	
	public void setEstadoVentana(EstadoVentana e){//Pone el estado del Panel a RotoCompleto, MedioRoto o Sano.
		this.estado = e;
	}
	/**
	 * Chequea si el panel esta roto completamente o no
	 */
	public boolean estaRoto(){
		if (this.getEstado() == EstadoVentana.ROTOCOMPLETO)
			return true;
		else 
			return false;
	}
}

