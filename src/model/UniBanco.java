package model;

import java.util.ArrayList;

public class UniBanco {
	
	int idSolicitud = 0;
	private ArrayList<Solicitud> listaSolicitudes = new ArrayList<>();
	private ArrayList<Amortizacion> listaAmortizacion = new ArrayList<>();

	public ArrayList<Solicitud> getListaSolicitudes() {
		return listaSolicitudes;
	}

	public void setListaSolicitudes(ArrayList<Solicitud> listaSolicitudes) {
		this.listaSolicitudes = listaSolicitudes;
	}

	public ArrayList<Amortizacion> getListaAmortizacion() {
		return listaAmortizacion;
	}

	public void setListaAmortizacion(ArrayList<Amortizacion> listaAmortizacion) {
		this.listaAmortizacion = listaAmortizacion;
	}

	public int getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(int idSolicitud) {
		this.idSolicitud = idSolicitud;
	}
	
	
}
