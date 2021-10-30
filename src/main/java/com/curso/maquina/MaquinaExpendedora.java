package com.curso.maquina;

public class MaquinaExpendedora {
	
	private double cajaCambios;
	private Refresco[] listaRefrescos; 
	private double cajaRecaudacion;
	private int totalVendido;
	
	
	public MaquinaExpendedora(Refresco[] refrescos, double cambiosIniciales) {
		this.cajaRecaudacion = 0;
		this.cajaCambios = cambiosIniciales;
		this.listaRefrescos = refrescos ;
	}
	
	public double vender(double dineroIng, int posicion){
		//validar datos entrada
		//PENDIENTE
		
		if (dineroIng < 0) {
			return -3;
		}

		//Comprobar existencias del refresco seleccionado               -1 AGOTADO
		if(this.listaRefrescos[posicion].existenciasRefresco() == 0) {
			return -1;
		}

		
		//Credito introducido insuficiente
		double devolucion = dineroIng - this.listaRefrescos[posicion].getPrecio();
		
		if(devolucion < 0 ) {
			return -2; 								//   2  CRÉDITO INSUFICIENTE
		}else if (devolucion > this.cajaCambios) {
			return -3; 								//   -3 CRÉDITO EXCESIVO
		}
			

		//Venta exitosa
		this.totalVendido ++;
		this.cajaRecaudacion += this.listaRefrescos[posicion].getPrecio();
		this.listaRefrescos[posicion].entregar(); //resta 1 al stock ref
		this.cajaCambios += this.listaRefrescos[posicion].getPrecio();
		return devolucion;
	}
	
	
	public void reponerRefresco(Refresco refresco, int posicion) {
		this.listaRefrescos[posicion] = refresco;
	}
	

	public double getCajaCambios() {
		return cajaCambios;
	}
	
	public void setCajaCambios(double cantidad) {
		this.cajaCambios = cantidad;
	}

	public double getCajaRecaudacion() {
		return cajaRecaudacion;
	}
	public int getTotalVendido() {
		return totalVendido;
	}
	
	public String informe() {
		return "Unidades vendidas: "+ totalVendido + "\n" + "Efectivo recaudado: " 
		+ cajaRecaudacion;
	}
}
