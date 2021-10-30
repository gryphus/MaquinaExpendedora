package com.curso.maquina;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestMaquinaExpendedora {

	Refresco[] listaRefrescos = {new Refresco("Agua",1,10),
								new Refresco("Coca Cola",2,10),
								new Refresco("RedBull",2.9,10),
								new Refresco("Monster",3,10)
								};
	
	MaquinaExpendedora me;
	
	int  refrescoSeleccionado = 3;
	
	
	@Before
	public void before() {
		MaquinaExpendedora me = new MaquinaExpendedora(listaRefrescos,100);
	}
	
	@Test
	public void testVenderSinExistencias() {
		MaquinaExpendedora me = new MaquinaExpendedora(listaRefrescos,100);

		//Eliminar existencias de la bebida seleccionada
		listaRefrescos[refrescoSeleccionado].reponer(0);
		
		double resultado = me.vender(2,refrescoSeleccionado);
		
		if (resultado == -1) {
			fail("Error -1 no hay existencias del refresco seleccionado");
		}
	}
	
	
	//Vender con crédito ingresado insuficiente
	@Test
	public void testVenderCreditoInsuficiente() {
		double creditoIntroducido = 0.50;
		double cambios = 100;
		
		MaquinaExpendedora me = new MaquinaExpendedora(listaRefrescos,cambios);

		double resultadoMaquina = me.vender(creditoIntroducido,refrescoSeleccionado); //Introducimos 0.50 céntimos de ingreso en posición 1
		
		if (resultadoMaquina == -2) {
			fail("Error -3 CREDITO INGRESADO INSUFICIENTE");
		} 
	}
	
	
	//Vebder con crédito introducido excesivo
	
	@Test
	public void testVenderCreditoExcesivo() {
		double creditoIntroducido = 200;  //cambiar por 200 para fallo;
		
		MaquinaExpendedora me = new MaquinaExpendedora(listaRefrescos,10); //10 euros de cambio en el cajón de cambios
		
		double resultadoMaquina = me.vender(creditoIntroducido,refrescoSeleccionado);
		
		if (resultadoMaquina == -3) {
			fail("Error -3 CRÉDITO INGRESADO EXCESIVO");
		}
	}
	
	@Test
	public void ventaExito() {
				double ventasTotalesEsperadas= 1;
				double recaudacionEsperada = 80;

				MaquinaExpendedora me = new MaquinaExpendedora(listaRefrescos,200); //cambios 200

				if(recaudacionEsperada != me.getCajaRecaudacion()) {
					fail("Error la recaudación debe ser" +  recaudacionEsperada);
				}
				
				if(ventasTotalesEsperadas != me.getTotalVendido()) {
					fail("Error FALTAN UNIDADES POR VENDER");
				}
	}
}
