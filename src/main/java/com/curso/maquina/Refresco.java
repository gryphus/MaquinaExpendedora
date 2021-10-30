package com.curso.maquina;

public class Refresco {
	
	private String tipo;
	private double precioUnidad;
	private int stock;
	
	
	public Refresco(String tipo, double precioUnidad, int stock) {
		super();
		this.tipo = tipo;
		this.precioUnidad = precioUnidad;
		this.stock= stock;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public double getPrecio() {
		return precioUnidad;
	}
	
	public int existenciasRefresco() {
		return this.stock;
	}
	
	public boolean entregar() {
		boolean res = false;
		if (this.existenciasRefresco() != 0) {
			this.stock --;
			res = true;
		}
		return res;
	}
	
	public void reponer(int cantidad) {
		this.stock = cantidad;
	}

	@Override
	public String toString() {
		return "Refresco [tipo=" + tipo + ", precioUnidad=" + precioUnidad + ", stock=" + stock + "]";
	}

}
